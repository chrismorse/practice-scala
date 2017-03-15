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

		*/
		

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

	}

}
