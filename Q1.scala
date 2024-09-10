class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator Cannot be Zero")

  private val g = gcd(n.abs, d.abs)
  val numerator: Int = n / g
  val denominator: Int = d / g

  def this(n: Int) = this(n, 1)

  def neg: Rational = new Rational(-numerator, denominator)

  override def toString: String = s"$numerator/$denominator"

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}

@main
def main(): Unit = {

  val x = new Rational(3, 0)
  println(x.neg) 

}
