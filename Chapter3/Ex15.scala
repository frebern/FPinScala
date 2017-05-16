package Chapter3

object Ex15 {
	def flatten[A](lists:List[List[A]]):List[A] =
		List.foldLeft(lists,Nil:List[A])((acc,list)=>List.append(acc,list))

	def main(args: Array[String]): Unit =
		println(flatten(List(List(1,2,3),List(4,5,6),List(7,8))))
}
