package Chapter3

object Ex16 {
	def addOne(list:List[Int]):List[Int] =
		List.foldRight(list, Nil:List[Int])((item, acc)=>Cons(item+1,acc))

	def main(args: Array[String]): Unit = println(addOne(List(1,2,3)))
}
