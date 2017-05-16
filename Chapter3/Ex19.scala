package Chapter3

object Ex19 {
	def filter[A](as:List[A])(f:A=>Boolean):List[A] =
		List.foldRight(as, Nil:List[A])((item,acc)=>if(f(item)) Cons(item, acc) else acc)

	def main(args: Array[String]): Unit = println("Even: "+filter(List(1,2,3,4,5,6))(_%2==0))
}
