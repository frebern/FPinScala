package Chapter3

object Ex3 {

	def setHead[A](h:A, l:List[A]): List[A] = l match {
		case Nil => Cons(h, l)
		case Cons(_, t) => Cons(h, t)
	}

	def main(args: Array[String]): Unit = {
		println(setHead(100,List(1,2,3,4,5)))
		println(setHead(200,Nil))
	}

}
