package Tasks


object Es8 extends App :

  enum Option[A]:
    case Some(a: A)
    case None() // here parens are needed because of genericity

  object Option:

    def isEmpty[A](opt: Option[A]): Boolean = opt match
      case None() => true
      case _ => false

    def orElse[A, B >: A](opt: Option[A], orElse: B): B = opt match
      case Some(a) => a
      case _ => orElse

    def flatMap[A, B](opt: Option[A])(f: A => Option[B]): Option[B] = opt match
      case Some(a) => f(a)
      case _ => None()

    def filter[A](opt: Option[A])(f: A => Boolean): Option[A] = opt match
      case Some(a: A) => if f(a) then Some(a) else None()
      case _ => None()

    def map[A](opt: Option[A])(f: A => Boolean): Option[Boolean] = opt match
      case Some(a: A) => Some(f(a))
      case _ => None()

    def map2[A](opt1: Option[A], opt2: Option[A])(f: (A,A) => A): Option[A] = opt1 match
      case Some(a: A) => opt2 match
        case Some(b: A) => Some(f(a, b))
        case _ => None()
      case _ => None()


  import Option.*

  val s1: Option[Int] = Some(1)
  val s2: Option[Int] = Some(2)
  val s3: Option[Int] = None()

  println(s1) // Some(1)
  println(orElse(s1, 0))
  println(orElse(s3, 0)) // 1,0
  println(flatMap(s1)(i => Some(i + 1))) // Some(2)
  println(flatMap(s1)(i => flatMap(s2)(j => Some(i + j)))) // Some(3)
  println(flatMap(s1)(i => flatMap(s3)(j => Some(i + j)))) // None

  println("FILTER")
  println(filter(Some(5))(_ > 2))// Some(5)
  println(filter(Some(5))(_ > 8)) // None
  println(filter(None[Int]())(_ > 2)) // None

  println("MAP")
  println(map(Some(5))(_ > 2))// Some(5)
  println(map(Some(5))(_ > 8)) // None
  println(map(None[Int]())(_ > 2)) // None

  println("MAP2")
  println( map2(Some(5), Some(3))( (x, y) => x + y ) )// Some(8)
  println( map2(Some(5), Some(3))( (x, y) => x * y ) )// Some(15)
  println( map2(Some(5), None[Int]())( (x, y) => x * y ) )// None