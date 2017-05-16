package Chapter3

object Ex2 {
	def tail[A](l:List[A]): List[A] = l match {
		case Nil => Nil
		case Cons(_, t) => t
	}
	def main(args: Array[String]): Unit = {
		println(tail(List(1,2,3,4,5)))
		println(tail(Nil))
	}
}
