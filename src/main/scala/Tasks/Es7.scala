package Tasks

object Es7 extends App:

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
