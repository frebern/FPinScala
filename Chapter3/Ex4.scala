package Chapter3

object Ex4 {

	def drop[A](l:List[A], n:Int): List[A] = l match {
		case Nil => Nil
		case Cons(_, t) =>
			if(n<=0) l
			else drop(t, n-1)
	}

	def main(args: Array[String]): Unit = {
		println(drop(List(1,2,3,4,5), 0))
		println(drop(Nil, 0))
		println(drop(List(1,2,3,4,5), 3))
		println(drop(Nil, 3))
		println(drop(List(1,2,3,4,5), 10))
	}

}
