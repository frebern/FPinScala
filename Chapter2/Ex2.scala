package Chapter2

object Ex2 {

	def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
		def loop(len: Int): Boolean = {
			if(len <= 0) true
			else if(ordered(as(len-1), as(len))) loop(len-1)
			else false
		}
		loop(as.length-1)
	}

	def main(args: Array[String]): Unit = {
		println(isSorted(Array(5,1,2,3,4), (x:Int, y:Int) => x <= y))
	}

}
