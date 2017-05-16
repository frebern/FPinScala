package Chapter3

object Ex8 {
	def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
		case Nil => z
		case Cons(x, xs) => f(x, foldRight(xs, z)(f))
	}
	val result = foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_))
	def main(args: Array[String]): Unit = println(result)
	/* Result
	 * Cons(1,Cons(2,Cons(3,Nil)))
	 * 위 결과를 보면, foldRight는 List(1,2,3)을 그대로 반환하고 있다.
	 * 이는 foldRight에서 as가 Nil일 때, z를 반환하는데 z는 Nil이므로 그대로 Nil을 반환하고,
	 * as가 Cons(x, xs)일 때, f(x, foldRight(xs, z)(f))를 반환하는데 f(_,_)는 Cons(_,_)를 반환하므로
	 * 결과적으로 Cons(x, foldRight(xs, z)(f))를 반환하게 되며, 이는 List의 정의와 정확히 일치하게 된다.
	 * 따라서, foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_))는 List(1,2,3)을 한번 순회한 후 그대로 반환하게 된다.
	 */
}
