package Chapter3

object Ex17 {
	def mapToString(list:List[Double]):List[String] =
		List.foldRight(list, Nil:List[String])((item, acc)=>Cons(item.toString,acc))

	def main(args: Array[String]): Unit = println(mapToString(List(1.0, 2.0, 3.0)))
}
