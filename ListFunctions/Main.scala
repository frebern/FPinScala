package ListFunctions

object Main {

	def tails[A](list: List[A]): List[List[A]] = list match {
		case Nil => Nil
		case _::t => list::tails(t)
	}

	def subsets[A](list: List[A]): List[List[A]] = list match {
		case Nil => Nil
		case h::t => {
			val t_subsets = subsets(t)
			List(h)::t_subsets.map(h::_)++t_subsets
		}
	}

	def permutations[A](list: List[A]): List[List[A]] = {
		def removeOne[A](list: List[A], item: A): List[A] = {
			if(list contains item) list.filter(!item.equals(_))
			else list
		}
		if(list.isEmpty) List(Nil)
		else list.flatMap(i=>permutations(removeOne(list, i)).map(i::_))
	}

	def main(args: Array[String]): Unit = {
		val list = List(1,2,3)
		println("List: "+list)
		println("Tails: "+tails(list))
		println("Subsets: "+subsets(list))
		println("Permutations: "+permutations(list))
	}

}
