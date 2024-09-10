class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator Cannot be Zero")

  private val g = gcd(n.abs, d.abs)
  val numerator: Int = n / g
  val denominator: Int = d / g

  def this(n: Int) = this(n, 1)

  def +(that: Rational): Rational =
    new Rational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator
    )

  def -(that: Rational): Rational =
    new Rational(
      numerator * that.denominator - that.numerator * denominator,
      denominator * that.denominator
    )

  override def toString: String = s"$numerator/$denominator"

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}

@main
def main(): Unit = {

  // x = 3/4, y = 5/8, z = 2/7
  val x = new Rational(3, 4)
  val y = new Rational(5, 8)
  val z = new Rational(2, 7)

  val result = (x + y) - (z)

  println(s"x + y - z =  $result")
}
