package Chapter3

object Ex12 {
	def reverse[A](list:List[A]):List[A] =
		List.foldLeft(list,Nil:List[A])((acc, item)=>Cons(item, acc))
	def main(args: Array[String]): Unit = println(reverse(List(1,2,3)))
}
