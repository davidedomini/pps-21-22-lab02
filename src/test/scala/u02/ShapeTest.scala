package u02

import Tasks.Shape.*
import Tasks.perimeter
import Tasks.area
import org.junit.*
import org.junit.Assert.*

class ShapeTest:

  val rectangle = Rectangle(4,8)
  val circle = Circle(10)
  val square = Square(5)

  @Test def testPerimeter() =
    assertEquals(24, perimeter(rectangle), 0.1)
    assertEquals(62.8, perimeter(circle), 0.1)
    assertEquals(20, perimeter(square), 0.1)

  @Test def testArea() =
    assertEquals(32, area(rectangle), 0.1)
    assertEquals(314, area(circle), 0.1)
    assertEquals(25, area(square), 0.1)

