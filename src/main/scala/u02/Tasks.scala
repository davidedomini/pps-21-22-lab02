package u02

object Tasks extends App:

  val parity: Int => String = _ match
    case n if n % 2 == 0 => "Even"
    case _ => "Odd"

  println(parity(3))


  def parityWithDef(x:Int): String = x match
    case x if x % 2 == 0 => "Even"
    case _ => "Odd"

  println(parityWithDef(2))

  val empty: String => Boolean = _ == ""
  def neg(x: String => Boolean): (String => Boolean) =
    (e: String) => !x(e)
  val notEmpty = neg(empty)
  println(notEmpty("Prova"))
  println(notEmpty("foo") && !notEmpty(""))


  def neg2[A](x:A=>Boolean): (A=>Boolean) =
    (e:A) => !x(e)

  //Currying

  def f(x:Int, y:Int, z:Int): Boolean =
     x <= y && y<=z

  def f1(x:Int)(y:Int)(z:Int):Boolean =
     x <= y && y <= z

  val f2: (Int, Int, Int) => Boolean = (x,y,z) => x<=y && y<=z

  val f3: Int => Int => Int => Boolean = x => y => z => x<=y && y<=z

  //Compose
  def compose(f: Int => Int, g: Int => Int): Int => Int =
    x => f(g(x))


  def composeGen[A <: Double, B <: Double, C <: Double](f: B => C , g: A => B): A => C =
    e => f(g(e))


  //Recursion

  def fib(n: Int): Int = n match
    case 0 => 0
    case 1 => 1
    case _ => fib(n-1) + fib(n-2)
  //The implementation above isn't a tail recursion

  //Here we have a tail recursive implementation, we can check that it is eeffectively tail with the annotation below
  def fibTail(n: Int): Int =
    @annotation.tailrec
    def _fib(n: Int, prev: Int, current: Int): Int = n match
      case 0 => current
      case _ => _fib(n-1, prev + current, prev)

    _fib(n,1,0)


  //Part 4

  enum Shape:
    case Rectangle(basis: Int, height: Int)
    case Circle(radius: Int)
    case Square(side: Int)


  def perimeter(shape: Shape): Double = shape match
    case Shape.Rectangle(b: Int, h: Int) => 2*b + 2*h
    case Shape.Circle(r: Int) => 2 * 3.14 * r
    case Shape.Square(s: Int) => 4 * s

  def area(shape: Shape): Double = shape match
    case Shape.Rectangle(b: Int, h: Int) => b * h
    case Shape.Circle(r: Int) => 3.14 * r * r
    case Shape.Square(s: Int) => s * s

  //part 5

