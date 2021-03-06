package `chapter 3`

// 3-08 Challenge - Interfaces - Starter

/*
Challenge 1:
  - Create an interface `Shape` that defines a property `area` of type Double.
  - Implement `Shape` with classes representing Square, Triangle, and Circle.
  - Add a circle, a square, and a triangle to an array.
  - Convert the array of shapes to an array of areas using map.

 **HINTS**
 - The area of a square = one of its sides squared
 - The area of a triangle = 0.5 multiplied by its base multiplied by its height
 - The area of a circle = pi multiplied by its radius squared
*/

interface Shape {
    val area: Double

}

class Square(side: Double) : Shape {
    override val area: Double = side * side
}

class Triangle(base: Double, height: Double) : Shape {
    override val area: Double = 0.5 * base * height
}

class Circle(radius: Double) : Shape {
    override val area: Double = kotlin.math.PI * radius * radius
}


fun main() {
    val square = Square(5.0)
    val triangle = Triangle(2.1, 5.6)
    val circle = Circle(2.5)

    val shapes = arrayOf(square, triangle, circle)
    val areas = shapes.map { shape -> shape.area }
    println(areas)

}