package Chapter3

object Ex10 {

	def foldLeft[A, B](as: List[A], z: B)(f: (B, A)=>B): B = as match {
		case Nil => z
		case Cons(h, t) => foldLeft(t, f(z, h))(f)
	}

	//Test
	def main(args: Array[String]): Unit = {

		def listN(list:List[Int], n:Int):List[Int] = if(n == 0) list else listN(Cons(1,list), n-1)
		val bigList = listN(Nil, 1234567)
		val rightOverflowTest = List.foldRight[Int, Int](bigList, 0)(_+_) // Overflow
		val leftOverflowTest = foldLeft[Int, Int](bigList, 0)(_+_) // Not Overflow

		println(rightOverflowTest)
		println(leftOverflowTest)

	}

}
