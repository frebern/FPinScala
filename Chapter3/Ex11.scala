package Chapter3

object Ex11 {

	def sum(ds: List[Int]) = List.foldLeft(ds, 0)(_ + _)

	def product(ds: List[Double]) = List.foldLeft(ds, 1.0)(_ * _)

	def main(args: Array[String]): Unit = {
		println(sum(List(1, 2, 3, 4, 5)))
		println(product(List(1.0, 2.0, 3.0, 4.0, 5.0)))
	}

}
