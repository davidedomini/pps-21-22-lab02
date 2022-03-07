package Tasks

object Es5 extends App:
  def compose(f: Int => Int, g: Int => Int): Int => Int =
    x => f(g(x))


  def composeGen[A <: Double, B <: Double, C <: Double](f: B => C , g: A => B): A => C =
    e => f(g(e))
