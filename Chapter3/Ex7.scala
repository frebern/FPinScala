package Chapter3

import Chapter3.List.foldRight

object Ex7 {

	val list = Cons(1.0, Cons(2.0, Cons(0.0, Cons(3.0, Nil))))
	def product3(ds: List[Double]) = foldRight(ds, 1.0)((a, b)=>{println(a);a * b})
	def main(args: Array[String]): Unit = product3(list)

	/* Result
	*  3.0
	*  0.0
	*  2.0
	*  1.0
	*  이는 0.0를 만났을 때, 바로 반환하는 로직이 없기 때문이다.
	*  위 product3를 패턴 매칭으로 구현하면
	*/
	def product(ds: List[Double]): Double = ds match {
		case Nil => 0.0
		// case Cons(0.0, _) => 0.0
		case Cons(h, t) => h * product(t)
	}
	/* 위와 같으며, 여기서 0.0을 만날시 바로 반환하는 로직이 두번째 줄이다.
	 * 이러한 평가 단축 로직은 product에 국한된 것이므로,
	 * 당연히 foldRight를 썼을 때 재귀가 멈추거나 하지는 않는다.
	 */
}
