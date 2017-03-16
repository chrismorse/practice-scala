import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source

object ScalaTutorial{

	def main(args: Array[String]){
		
		var i = 0;

		/*
		// while	
		while(i <= 10) {
			println(i);
			i += 1;
		}
		println("--------------------------------")

		// do while
		i = 0;
		do {
			println(i)
			i += 1 
		} while (i <= 20)
		println("--------------------------------")


		// for loops
		i = 0;
		for (i <- 1 to 10)
			println(i);
		println("--------------------------------")
		

		val randLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
		for(i <- 0 until randLetters.length) 
			println(randLetters(i))

		println("--------------------------------")

		
		val aList = List(1,2,3,4,5)

		for (i <- aList) {
			println(i)
		}

		println("--------------------------------")



		var evenList = for {i <- 1 to 20
			if (i % 2) == 0
		} yield i

		for (i <- evenList)
			println(i)


		println("--------------------------------")


		for (i <- 1 to 5; j <- 6 to 10) {
			// like a nested for loop...
			println("i : " + i);
			println("j : " + j);

		}


		println("--------------------------------")







	// functions - return a value

	// def funcName (param1:dataType, param2:dataType) : returnType = {
	//		body
	//		return valueToReturn
	//}


	def getSum(num1:Int, num2:Int) : Int = {
		num1 + num2   //dont need to return a val.. will grab latest
	} 

	println("5 + 4 = " + getSum(5,4))


	// procedures - don't return a value
	def sayHi() : Unit = {
		println("Hi, how are you?")
	}

	sayHi()


	// variable # of arguments
	def getSumVariableArgs(args : Int*) : Int = {
		var sum : Int = 0
		for (num <- args) {
			sum += num
		}
		sum

	}
	println("sum " + getSumVariableArgs(1,2,3,4,5))


	// recursion
	def factorial (arg1:Int) : Int = {
		if (arg1 == 1)
			arg1
		else 
			arg1 * factorial (arg1 - 1)
	}

	println("factorial " + factorial(4))

	





	// Arrays

	val favNums = new Array[Int](20)
	val friends = Array("Bob", "Tom")

	friends(0) = "Sue"

	println("Best friends " + friends(0))

	val friends2 = ArrayBuffer[String]()  //size can change
	friends2.insert(0, "Phil")

	friends2 += "Mark"

	friends2 ++= Array("Bill", "Kevin")  //add multiple 
	friends2.insert(1, "Mike", "Sally", "Sam") 

	for (j <- 0 to (favNums.length - 1)) {
		favNums(j) = j
	}

	favNums.foreach(println)
	println("--------------------------------")

	// conditionals
	var favNums2 = for(num <- favNums if num % 2 == 0) yield num

	favNums2.foreach(println)
	println("--------------------------------")


	// multi variable Arrays
	var multTable = Array.ofDim[Int](10,10)

	for (i <- 0 to 9) {
		for (j <- 0 to 9) {
			multTable(i)(j) = i * j
		}

	}

	for (i <- 0 to 9) {
		for (j <- 0 to 9) {
			printf("%d : %d = %d\n",i,j,multTable(i)(j))
		}

	}
	println("--------------------------------")



	// other stuff with Array

	println("Sum : " + favNums.sum)

	val sortedNums = favNums.sortWith(_>_)   //desending

	println(sortedNums.deep.mkString(", "))
	println("--------------------------------")




	// Maps - a collection type storke key/value pairs

	// this is immutable
	val employees = Map("Manager" -> "Bob Smith", 
		"Secretary" -> "Sue Brown")

	if (employees.contains("Manager"))
		printf("Manager : %s\n", employees("Manager"))


	//mutable exaple
	val customers = collection.mutable.Map(100 -> "Paul Smith",
		101 -> "Sally Smith")

	printf("Cust 1 : %s\n", customers(100))
	customers(100) = "Tom Marks"
	customers(102) = "Megan Swift"

	for ((k,v) <- customers)
		printf("%d : %s\n", k, v)



	println("--------------------------------")

	// Tuples - hold values of numerous different types
	//			normally immutable

	var tupleMarge = (103, "Marge Simpson", 10.25)

	printf("%s owes us $%.2f\n", tupleMarge._2, tupleMarge._3)		

	//iterate
	tupleMarge.productIterator.foreach{i => println(i)}

	// to string
	println(tupleMarge.toString())

	println("--------------------------------")







	// Classes

	// see below for defintion. (outside of main)

	val rover = new Animal
	rover.setName("Rover")
	rover.setSound("Woof")
	printf("%s says %s\n", rover.getName, rover.getSound)

	val whiskers = new Animal("Whiskers", "Meow")
	println(s"${whiskers.getName} with id ${whiskers.id} says ${whiskers.sound}")
	println(whiskers.toString)

	val spike = new Dog("Spike", "Woof", "Grrrr")
	spike.setName("Spike1")
	println(spike.toString)


	// abstract class example
	val fang = new Wolf("Fang")
	fang.moveSpeed = 36.0
	println(fang.move)


	

	// Traits example
	val superman = new Superhero("Superman")
	println(superman.fly)
	println(superman.hitByBullet)
	println(superman.ricochet(2500))


	*/


	// higher order functions

	// functions can be passed just like any other variable
	val log10Func = log10 _ 		//underscore - we mean the function log10
	println(log10Func(1000))


	List(1000.0, 10000.0).map(log10Func).foreach(println)


	// closure - function that depends on a variable declared outside that function
	val divisorVal = 5

	val divisor5 = (num : Double) => num / divisorVal

	println("5 / 5 = " + divisor5(5.0))















	} // end of main


	// classes outside of main
	class Animal(var name: String, var sound: String) {
		this.setName(name)  //primary / default constructor

		// there are no static names / variables in scala
		val id = Animal.newIdNum	//see companion object below

		def getName() : String = name
		def getSound() : String = sound

		def setName(name : String) {
			//we can protect data
			if (!(name.matches(".*\\d+.*")))	// if it does not contain a decimal... regular expression! 
				this.name = name
			else
				this.name = "No Name"
		}

		def setSound(sound : String) {
			this.sound = sound
		}

		// define other contstructors
		def this(name : String) {
			this("No Name", "No Sound")
			this.setName(name)			
		}

		def this() {
			this("No Name", "No Sound")
		}

		// can also override methods
		override def toString() : String = {
			return "%s with the id %d says %s".format(this.name, this.id, this.sound)
		}
	}

	// companion object for class.   static class variables and functions
	object Animal {
		private var idNumber = 0
		private def newIdNum = {idNumber += 1; idNumber}
	}

	//inheritence
	class Dog(name: String, sound: String, growl: String) extends Animal(name,sound){
		def this(name: String, sound: String) {
			this("No Name", sound, "No Growl")
			this.setName(name)
		}	

		def this(name:String) {
			this("No Name", "No Sound", "No Growl")
		}

		def this() {
			this("No Name", "No Sound", "No Growl")
		}

		override def toString() : String = {
			return "%s with the id %d says %s or %s".format(this.name, this.id, this.sound, this.growl)
		}
	}


	// abstract class
	abstract class Mammal(val name : String) {
		var moveSpeed : Double

		def move : String
	}

	class Wolf(name: String) extends Mammal(name) {
		var moveSpeed = 35.0

		def move = "The wolf %s runs %.2f mph".format(this.name, this.moveSpeed)
	}



	// Traits - a class can extend more than one
	trait Flyable {
		def fly : String
	}	

	trait BulletProof {
		def hitByBullet : String

		// also define concrete classes
		def ricochet(startSpeed : Double) : String = {
			return "The bullet is going to ricochet at a speed of %.1f ft/sec".format(startSpeed * .75)
		}

	}

	class Superhero(val name: String) extends Flyable with BulletProof {
		def fly = "%s flys through the air".format(this.name)
		def hitByBullet = "The bullet bounces off of %s".format(this.name)
	}



} // end of ScalaTutorial






























