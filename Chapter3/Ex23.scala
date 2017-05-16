package Chapter3

object Ex23 {
	def zipWith[A, B, C](l1:List[A],l2:List[B])(f:(A,B)=>C):List[C] = l1 match {
		case Nil => Nil
		case Cons(h1, t1) => l2 match {
			case Nil => Nil
			case Cons(h2, t2) => Cons(f(h1, h2), zipWith(t1, t2)(f))
		}
	}

	def main(args: Array[String]): Unit =
		println(zipWith(List("a","b","c"),List(1,2,3))((_,_)))
}
