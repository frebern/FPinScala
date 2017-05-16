package Chapter3

object Ex24 {
	def hasSubsequence[A](sup:List[A], sub:List[A]):Boolean = {
		def size(list:List[A]):Int = List.foldLeft(list,0)((acc,_)=>acc+1)
		(sup, sub) match {
			case (_, Nil) => true
			case (Cons(_, t1), Cons(h2, _)) if(size(sup)>=size(sub))=> {
				// i1 == i2로 zip한 후, 전부 true면 true로, 아니면 false로 reduce
				// 맞으면 true, 아니면 다음 첫 원소가 같을 때까지 sup를 슬라이딩 후 재귀호출
				if(List.foldLeft(List.zipWith(sup, sub)(_ == _), true)(_ && _)) true
				else hasSubsequence(List.dropWhile(t1)(_!=h2), sub)
			}
			case _ => false
		}
	}

	def main(args: Array[String]): Unit = {
		val sup = List(1,2,3,4)
		println("Tests:")
		println(hasSubsequence(sup,List(1,2)))
		println(hasSubsequence(sup,List(2,3)))
		println(hasSubsequence(sup,List(2,4))) // false
		println(hasSubsequence(sup,List(4)))
		println(hasSubsequence(sup,Nil))
		println(hasSubsequence(sup,List(1,2,3,4)))
		println(hasSubsequence(sup,List(1,2,3,4,5))) // false
		println(hasSubsequence(sup,List(2,3,4,5))) // false
		println(hasSubsequence(sup,List(5,7))) // false
	}
}
