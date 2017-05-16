package BinarySearchTree

sealed trait BST[+A]
case object Leaf extends BST[Nothing]
case class Branch[+A](item: A, left: BST[A], right: BST[A]) extends BST[A]

object BST{

	def insert[A](tree: BST[A], item: A)(implicit ord:Ordering[A]): BST[A] = {
		import ord.mkOrderingOps
		tree match {
			case Leaf => Branch(item, Leaf, Leaf)
			case Branch(i, l, r) => {
				if (item < i) Branch(i, insert(l, item), r)
				else Branch(i, l, insert(r, item))
			}
		}
	}

	def delete[A](tree: BST[A], item: A)(implicit ord:Ordering[A]): BST[A] = {

		import ord.mkOrderingOps
		def append[A](left: BST[A], right: BST[A]): BST[A] = left match {
			case Branch(a, b, Branch(c, d, e)) => Branch(a, b, append(Branch(c, d, e), right))
			case Branch(a, b, Leaf) => Branch(a, b, right)
			case Leaf => right
		}

		tree match {
			case Leaf => Leaf
			case Branch(i, l, r) => {
				if (item==i) append(l, r)
				else if (item < i) Branch(i, delete(l, item), r)
				else Branch(i, l, delete(r, item))
			}
		}
	}

	def find[A](tree: BST[A], item: A)(implicit ord: Ordering[A]): String = {
		import ord.mkOrderingOps
		tree match {
			case Leaf => "Not Found"
			case Branch(i, l, r) => {
				if (item == i) "Found"
				else find(if (item < i) l else r, item)
			}
		}
	}

	def main(args: Array[String]): Unit = {
		//insert 3 -> 1 -> 5 -> 4 -> 2 -> 7 -> 5
		val tree = insert(insert(insert(insert(insert(insert(insert(Leaf, 3), 1), 5), 4), 2), 7), 5)
		println("Tree: "+tree)
		println("Find 3: "+find(tree, 3)) // Found
		println("Find 5: "+find(tree, 5)) // Found
		println("Find 2: "+find(tree, 2)) // Found
		println("Find 6: "+find(tree, 6)) // Not Found
		val del1 = delete(tree, 3)
		println("Delete 3: "+del1)
		val del2 = delete(del1, 4)
		println("Delete 4: "+del2)
	}
}
