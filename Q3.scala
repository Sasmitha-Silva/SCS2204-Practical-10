class Account(var balance: Double) {

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $$${amount} Successfully! \n New Balance: $$${balance}")
    } else {
      println("Invalid Deposit Amount!")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $$${amount} Successfully! \n New Balance: $$${balance}")
    } else if (amount > balance) {
      println("Insufficient Funds!")
    } else {
      println("Invalid Withdraw Amount!")
    }
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      withdraw(amount)
      toAccount.deposit(amount)
      println(s"Transferred $$${amount} to Another Account. New Balance: $$${balance}")
    } else if (amount > balance) {
      println("Insufficient Funds!")
    } else {
      println("Invalid Transfer Amount!")
    }
  }

  def showBalance(): Unit = {
    println(s"Account Balance: $$${balance}")
  }
}

@main
def main(): Unit = {
  
  val account1 = new Account(10000.0)
  val account2 = new Account(2500.0)

  account1.showBalance() 
  account2.showBalance()  

  account1.deposit(1200.0)

  account1.withdraw(300.0)

  account1.transfer(1500.0, account2)

  account1.showBalance()  
  account2.showBalance() 
}
