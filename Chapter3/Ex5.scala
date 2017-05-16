package Chapter3

object Ex5 {

	def dropWhile[A](l:List[A], f:A=>Boolean): List[A] = l match {
		case Nil => Nil
		case Cons(h, t) =>
			if(f(h)) dropWhile(t, f) else l
	}

	def main(args: Array[String]): Unit = {
		println(dropWhile(Nil, (i:Int) => i<3))
		println(dropWhile(List(1,2,3,4,5), (i:Int) => i<3))
		println(dropWhile(List(1,2,3,4,5), (i:Int) => i>3))
		println(dropWhile(List(1,2,3,4,5), (i:Int) => i==1))
		println(dropWhile(List(1,2,3,4,5), (i:Int) => i==100))
//		println(g(10)(20))
//		val f = Function.uncurried(g(_))
//		println(f(10,20))
//		val p = f(10, _:Int) //Partially Applied Function
//		println(p(20))
	}

	def g(a:Int):Int=>Int = (b:Int)=>a+b

}
