package Chapter3

object Ex13 {

	// foldRight를 사용하여 구현한 foldLeft이다.
	// foldLeft와 foldRight는 리스트 순회 방향의 차이밖에 없으므로 리스트를 뒤집어서 그대로 foldRight를 호출한다.
	// 이 경우, stack-unsafe한 List.foldRight를 사용하므로, foldLeft임에도 불구하고 stackoverflow의 위험이 있다.
	// 따라서 foldRight를 사용하여 foldLeft를 구현하는 것은 사실 불필요하다.
	def foldLeft_using_foldRight[A,B](as:List[A], z:B)(f:(B, A)=>B):B = {
		def reverse(list: List[A], z: List[A]): List[A] = list match {
			case Nil => z
			case Cons(h, t) => reverse(t, Cons(h, z))
		}
		List.foldRight(reverse(as, Nil), z)((item, acc) => f(acc, item))
	}

	// foldLeft를 사용하여 구현한 foldRight이다.
	// 위 함수와 같이 리스트를 뒤집어서 foldLeft를 호출한다.
	// 이 경우, foldLeft는 stack-safe하므로, 아래의 함수 역시 stack-safe하다.
	def foldRight_using_foldLeft[A,B](as:List[A], z:B)(f:(A, B)=>B):B = {
		def reverse[A](list:List[A]):List[A] = List.foldLeft(list,Nil:List[A])((acc, item)=>Cons(item, acc))
		List.foldLeft(reverse(as), z)((acc, item) => f(item, acc))
	}

	def main(args: Array[String]): Unit = {
		// 이전 연습문제에서 수행한 Overflow Test이다.
		def listN(list:List[Int],n:Int):List[Int] = if(n == 0) list else listN(Cons(1,list), n-1)
		val bigList = listN(Nil, 1234567)
		val test1 = foldLeft_using_foldRight[Int, Int](bigList, 0)(_+_) // Overflow!
		val test2 = foldRight_using_foldLeft[Int, Int](bigList, 0)(_+_) // Not Overflow
		println(test1)
		println(test2)
	}
}
