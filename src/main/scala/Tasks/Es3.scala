package Tasks

object Es3 extends App:

  //a
  val parity: Int => String = _ match
    case n if n % 2 == 0 => "Even"
    case _ => "Odd"

  println(parity(3))


  def parityWithDef(x:Int): String = x match
    case x if x % 2 == 0 => "Even"
    case _ => "Odd"

  println(parityWithDef(2))

  //b
  val empty: String => Boolean = _ == ""

  def neg(x: String => Boolean): (String => Boolean) =
    (e: String) => !x(e)

  val notEmpty = neg(empty)
  println(notEmpty("Prova"))
  println(notEmpty("foo") && !notEmpty(""))

  //c
  def neg2[A](x:A=>Boolean): (A=>Boolean) =
    (e:A) => !x(e)
