package Chapter3

object Ex22 {
	def zipAdd(l1:List[Int],l2:List[Int]):List[Int] = l1 match {
		case Nil => Nil
		case Cons(h1, t1) => l2 match {
			case Nil => Nil
			case Cons(h2, t2) => Cons(h1 + h2, zipAdd(t1, t2))
		}
	}

	def main(args: Array[String]): Unit =
		println(zipAdd(List(1,2,3),List(4,5,6)))
}
