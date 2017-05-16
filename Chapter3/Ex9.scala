package Chapter3

object Ex9 {
	def length[A](as: List[A]): Int = List.foldRight[A, Int](as, 0)((_, acc)=>acc + 1)

	def main(args: Array[String]): Unit = {
		println(length(Nil))
		println(length(List(1,2,3)))
	}
}
