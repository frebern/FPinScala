package Chapter3

object Ex14 {
	def append[A](l1:List[A], l2:List[A]):List[A] = List.foldRight(l1,l2)(Cons(_,_))
	def main(args: Array[String]): Unit = println(append(List(1,2,3),List(4,5,6)))
}
