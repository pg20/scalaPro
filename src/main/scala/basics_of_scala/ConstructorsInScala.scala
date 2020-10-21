package basics_of_scala


//Constructors are used to initializing the object’s state. Like methods, a constructor also contains a collection of statements(i.e. instructions) that are executed at the time of Object creation.
//Scala supports two types of constructors:
//
//Primary Constructor
//Auxiliary Constructor
//When our Scala program contains only one constructor, then that constructor is known as a primary constructor. The primary constructor and the class share the same body, means we need not to create a constructor explicitly.
//Syntax:
//
//class class_name(Parameter_list){
//  // Statements...
//}
//Important points:

class ConstructorsInScala {

  //creates a default primary constructor
  def display(): Unit = {
     println("I am default constructor with no parameters to declare")
  }

}

class PrimaryConstructorsInScala(name: String, constructor_type: String) {

  def display(): Unit = {
    println(s"name $name type $constructor_type")
  }

}

object Main {

   def main(args: Array[String]) = {

     val constructorsInScala: ConstructorsInScala = new ConstructorsInScala
     constructorsInScala.display()
     val primaryConstructorsInScala: PrimaryConstructorsInScala = new PrimaryConstructorsInScala("Pramiti", "Primary")
     primaryConstructorsInScala.display()

   }

}

//If the parameters in the constructor parameter-list are declared using var, then the value of the fields may change. And Scala also generates getter and setter methods for that field.
//If the parameters in the constructor parameter-list are declared using val, then the value of the fields cannot change. And Scala also generates a getter method for that field.
//If the parameters in the constructor parameter-list are declared without using val or var, then the visibility of the field is very restricted. And Scala does not generate any getter and setter methods for that field.
//If the parameters in the constructor parameter-list are declared using private val or var, then it prevents from generating any getter and setter methods for that field. So, these fields can be accessed by the members of that class.
//In Scala, only a primary constructor is allowed to invoke a superclass constructor.
//In Scala, we are allowed to make a primary constructor private by using a private keyword in between the class name and the constructor parameter-list.


//Declaring constructor private with default and primary constructor
class Vehicle private {
  def display() : Unit = {
     println("I am private. I don't talk much")
  }
}

class Vehicle1 private(name:String) {

  def display() : Unit = {
    println(s"name: $name")
  }
}

object VehicleAcsess {

  def main(args: Array[String]) = {
        //val vehicle: Vehicle = new Vehicle
        //val vehicle: Vehicle = new Vehicle1

  }

}

//Auxiliary Constructor
//In a Scala program, the constructors other than the primary constructor are known as auxiliary constructors. we are allowed to create any number of auxiliary constructors in our program, but a program contains only one primary constructor.
//Syntax:
//
//def this(......)
//Important points:
//
//In a single program, we are allowed to create multiple auxiliary constructors, but they have different signatures or parameter-lists.
//Every auxiliary constructor must call one of the previously defined constructors.
//The invoke constructor may be a primary or another auxiliary constructor that comes textually before the calling constructor.
//The first statement of the auxiliary constructor must contain the constructor call using this.

class VehicleAuxilliary(name: String, vehicle_type: String) {

  var licence_number: Int = 0
  def display() : Unit = {
      println(s"$name  $vehicle_type $licence_number")
  }

  def this(name: String, vehicle_type: String, number:Int){
      this(name, vehicle_type)
      this.licence_number = number
  }
}

class VehicleOnlyAuxilliary {

  var licence_number: Int = 0
  var name: String = _
  var vehicle_type: String = _

  def display() : Unit = {
    println(s"$name  $vehicle_type $licence_number")
  }

  def this(name: String, vehicle_type: String, number:Int) {
    this()
    this.name = name
    this.vehicle_type = vehicle_type
    this.licence_number = number
  }
}

object TestAuxilliary {

  def main(args: Array[String]) = {
        val vehicleAuxilliary: VehicleAuxilliary =  new VehicleAuxilliary("Pramiti", "Ferrai")
        vehicleAuxilliary.display()
        val vehicleOnlyAuxilliary: VehicleOnlyAuxilliary = new VehicleOnlyAuxilliary
        vehicleOnlyAuxilliary.display()
        val vehicleOnlyAuxilliary1: VehicleOnlyAuxilliary = new VehicleOnlyAuxilliary("Pramiti", "Ferrai", 1)
        vehicleOnlyAuxilliary1.display()
  }
}