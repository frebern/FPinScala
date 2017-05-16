package Chapter3

object Ex1 {
	val x = List(1,2,3,4,5) match {
		case Cons(x, Cons(2, Cons(4,_))) => x                 // Match Error
		case Nil => 42                                        // Match Error
		case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y   // First Match
		case Cons(h, t) => h + List.sum(t)                    // Second Match
		case _ => 101                                         // Third Match
	}
	def main(args: Array[String]): Unit = println(x)
}
