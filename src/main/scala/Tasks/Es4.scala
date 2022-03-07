package Tasks

object Es4 extends App:
  def f(x:Int, y:Int, z:Int): Boolean =
    x <= y && y<=z

  def f1(x:Int)(y:Int)(z:Int):Boolean =
    x <= y && y <= z

  val f2: (Int, Int, Int) => Boolean = (x,y,z) => x<=y && y<=z

  val f3: Int => Int => Int => Boolean = x => y => z => x<=y && y<=z
  
  