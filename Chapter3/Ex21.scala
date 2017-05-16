package Chapter3

object Ex21 {
	def filter[A](as:List[A])(f:A=>Boolean):List[A] =
		List.flatMap(as)(i=>if(f(i)) Cons(i,Nil) else Nil)

	def main(args: Array[String]): Unit =
		println("Even: "+filter(List(1,2,3,4,5,6))(_%2==0))
}
