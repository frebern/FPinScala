package Chapter3

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

	//Ex25
	def size[A](tree: Tree[A]):Int = tree match {
		case Leaf(_) => 1
		case Branch(l,r) => 1 + size(l) + size(r)
	}

	//Ex26
	def maximum(tree: Tree[Int]):Int = tree match {
		case Leaf(v) => v
		case Branch(l, r) => maximum(l) max maximum(r)
	}

	//Ex27
	def depth[A](tree: Tree[A]):Int = tree match {
		case Leaf(_) => 1
		case Branch(l, r) => 1 + (depth(l) max depth(r))
	}

	//Ex28
	def map[A, B](tree: Tree[A])(f:A=>B):Tree[B] = tree match {
		case Leaf(v) => Leaf(f(v))
		case Branch(l, r) => Branch(map(l)(f), map(r)(f))
	}

	//Ex29
	def fold[A, B](tree: Tree[A])(f:A=>B)(g:(B, B)=>B):B = tree match {
		case Leaf(v) => f(v)
		case Branch(l, r) => g(fold(l)(f)(g), fold(r)(f)(g))
	}

	def sizeWithFold[A](tree: Tree[A]):Int = fold(tree)(_=>1)((l,r)=>(l+r)+1)
	def maximumWithFold(tree: Tree[Int]):Int = fold(tree)(v=>v)(_ max _)
	def depthWithFold[A](tree: Tree[A]):Int = fold(tree)(_=>1)((l,r)=>(l max r) + 1)
	def mapWithFold[A, B](tree: Tree[A])(f:A=>B):Tree[B] = fold(tree)(v=>Leaf(f(v)):Tree[B])(Branch(_,_))

	def main(args: Array[String]): Unit = {
		val tree = Branch(Leaf(1),Branch(Branch(Leaf(2),Leaf(3)),Branch(Leaf(4),Leaf(5))))
		println("Size\t\t: "+size(tree))
		println("Maximum\t\t: "+maximum(tree))
		println("Depth\t\t: "+depth(tree))
		println("Map\t\t\t: "+map(tree)(_*2))
		println("Size(Fold)\t: "+sizeWithFold(tree))
		println("Maximum(Fold): "+maximumWithFold(tree))
		println("Depth(Fold)\t: "+depthWithFold(tree))
		println("Map(Fold)\t: "+mapWithFold(tree)(_*2))
	}

}
