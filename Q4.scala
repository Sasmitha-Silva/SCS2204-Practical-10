class Account(var balance: Double) {

  def deposit(amount: Double): Unit = {
    if (amount > 0) balance += amount
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) balance -= amount
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      withdraw(amount)
      toAccount.deposit(amount)
    }
  }

  override def toString: String = f"Account Balance: $$${balance}%.2f"
}

class Bank(var accounts: List[Account]) {
  
  def negativeBalances: List[Account] = accounts.filter(_.balance < 0)

  def totalBalance: Double = accounts.map(_.balance).sum

  def applyInterest(): Unit = {
    accounts = accounts.map { account =>
      if (account.balance > 0) {
        account.deposit(account.balance * 0.05)
      } 
      if (account.balance < 0) {
        account.balance = account.balance * 1.1
      }
      account
    }
  }
}

@main
def main(): Unit = {
 
  val ac1 = new Account(1000.0)
  val ac2 = new Account(-200.0)
  val ac3 = new Account(500.0)
  val ac4 = new Account(-50.0)
  
  val bank = new Bank(List(ac1, ac2, ac3, ac4))

  println("Accounts With Negative Balances:")
  bank.negativeBalances.foreach(println)

  println(f"\nTotal Balance of All Accounts: $$${bank.totalBalance}%.2f")

  bank.applyInterest()
  println("\nFinal Balances After Applying Interest:")
  bank.accounts.foreach(println)
}
