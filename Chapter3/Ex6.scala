package Chapter3

object Ex6 {
	def init[A](l: List[A]): List[A] = l match {
		case Nil => Nil
		case Cons(_, Nil) => Nil
		case Cons(h, t) => Cons(h, init(t))
	}

	def main(args: Array[String]): Unit = {
		val list = List(1,2,3,4,5)
		val list2 = List(1)
		val nil = Nil
		println(list)
		println(init(list))
		println(list2)
		println(init(list2))
		println(nil)
		println(init(nil))
	}
}
