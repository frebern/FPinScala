package Chapter3

object Ex20 {
	def flatMap[A, B](as:List[A])(f:A=>List[B]):List[B] = List.flatten[B](List.map(as)(f))

	def main(args: Array[String]): Unit = {
		println("map: "+List.map(List(1, 2, 3))(i=>List(i,i)))
		println("flatMap: "+flatMap(List(1, 2, 3))(i => List(i, i)))
	}
}
