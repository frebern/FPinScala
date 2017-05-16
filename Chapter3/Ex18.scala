package Chapter3

object Ex18 {
	def map[A, B](as:List[A])(f:A=>B):List[B] =
		List.foldRight(as, Nil:List[B])((item,acc)=>Cons(f(item),acc))

	def main(args: Array[String]): Unit = {
		println("addOne: "+map(List(1,2,3))(_+1))
		println("mapToString: "+map(List(1.0,2.0,3.0))(_.toString+"f"))
	}
}
