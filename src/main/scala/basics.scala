object basics extends App {
  // println ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  println("Hello")
  println("Hello" + " " + "World")

  // Inmutable variables ///////////////////////////////////////////////////////////////////////////////////////////////
  val x = 3
  val y: Int = 3
  println("Vals x,y: ", x, y)

  // Mutable Variables//////////////////////////////////////////////////////////////////////////////////////////////////
  var z: Int = 4
  println("Variable z: ", z)

  //Blocks//////////////////////////////////////////////////////////////////////////////////////////////////////////////
  println({
    val x = 4 + 1
    x + 1
  })

  //Functions///////////////////////////////////////////////////////////////////////////////////////////////////////////
  (x: Int) => x + 1 // Anonymous functions (function with no names)

  val addOne = (x: Int) => x + 1 //Naming functions
  println(addOne(1))

  val Sum = (x: Int, y: Int) => x + y
  println(Sum(1, 2))

  //Methods (similar to functions but they are defined with "def")//////////////////////////////////////////////////////
  def add(x: Int, y: Int): Int = x + y

  println(add(100, 1))

  def addThenMultiply(x: Int, y: Int)(Multiplier: Int): Int = (x + y) * Multiplier
  println(addThenMultiply(1,2)(4))

  def noParameters: String = "no parameters"
  println(noParameters)

  def squareof (x: Int): Int = {
    x*x
  }
  println(squareof(2))

  //Classes/////////////////////////////////////////////////////////////////////////////////////////////////////////////
  class Greeter(suffix: String, preffix: String){
    def greet(name: String): Unit =
      println(suffix+name+preffix)
  }

  val greeter= new Greeter("Hello ","!")
  greeter.greet("Scala developer")

  //Case Classes////////////////////////////////////////////////////////////////////////////////////////////////////////
  case class Point(x:Int,y:Int) //inmutable classes by default and compared by value

  val point = Point(1,2) // The new in case classes are not necesssary
  val anotherpoint =  Point(1,2)
  val yetAnotherPoint = Point (2,2)

  if (point ==anotherpoint){
    println(point + " and " + anotherpoint + " are the same")
  }else{
    println(point + " and " + anotherpoint + " are not the same")
  }

  //Objects (single instaces of their own definitions, singleton of their own classes)//////////////////////////////////
  object IdFactory {
    private var counter=0
    def create(): Int ={
      counter+=1
      counter
    }
  }

  val firstId = IdFactory.create()
  println(firstId)
  val secondId = IdFactory.create()
  println(secondId)

  //Traits//////////////////////////////////////////////////////////////////////////////////////////////////////////////
  trait GreeterNoImplemented{
    def greet(name: String): Unit //method is declared but not implemented
    }

  trait GreeterImplemented{
    def greet(name: String): Unit ={ //Imlemented method
      println("Hello "+name+" !")
    }
  }

  class CustomizeGreeter (suffix: String, preffix: String) extends GreeterNoImplemented {
    override def greet(name: String): Unit = {
      println(suffix+name+preffix)
    }
  }

  val greeterthree = new CustomizeGreeter("Hello "," !")
  greeterthree.greet("Scala Developer")

  class DefaultGreeter extends GreeterImplemented //As the method is already implemented we do not have to 
                                        // overwrite it in the class

  val greetertwo = new DefaultGreeter()
  greetertwo.greet("Scala Developer")












}
