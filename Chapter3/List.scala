package Chapter3

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

	def dropWhile[A](l:List[A])(f:A=>Boolean): List[A] = l match {
		case Nil => Nil
		case Cons(h, t) =>
			if(f(h)) dropWhile(t)(f)
			else l
	}

	def sum(is: List[Int]): Int = is match {
		case Nil => 0
		case Cons(x, xs) => x + sum(xs)
	}

	def product(ds: List[Double]): Double = ds match {
		case Nil => 1.0
		case Cons(0.0, _) => 0.0
		case Cons(x, xs) => x * product(xs)
	}

	def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
		case Nil => z
		case Cons(x, xs) => f(x, foldRight(xs, z)(f))
	}

	def foldLeft[A, B](as: List[A], z: B)(f: (B, A)=>B): B = as match {
		case Nil => z
		case Cons(h, t) => foldLeft(t, f(z, h))(f)
	}

	def sum2(ds: List[Int]) = foldRight(ds, 0)(_ + _)

	def product2(ds: List[Double]) = foldRight(ds, 1.0)(_ * _)

	def reverse[A](list:List[A]):List[A] = foldLeft(list,Nil:List[A])((acc, item)=>Cons(item, acc))

	def append[A](l1:List[A], l2:List[A]):List[A] = foldRight(l1,l2)(Cons(_,_))

	def flatten[A](lists:List[List[A]]):List[A] =
		foldLeft(lists,Nil:List[A])((acc,list)=>append(acc,list))

	def map[A, B](as:List[A])(f:A=>B):List[B] =
		foldRight(as, Nil:List[B])((item,acc)=>Cons(f(item),acc))

	def filter[A](as:List[A])(f:A=>Boolean):List[A] =
		foldRight(as, Nil:List[A])((item,acc)=>if(f(item)) Cons(item, acc) else acc)

	def flatMap[A, B](as:List[A])(f:A=>List[B]):List[B] = List.flatten[B](List.map(as)(f))

	def zipWith[A, B, C](l1:List[A],l2:List[B])(f:(A,B)=>C):List[C] = l1 match {
		case Nil => Nil
		case Cons(h1, t1) => l2 match {
			case Nil => Nil
			case Cons(h2, t2) => Cons(f(h1, h2), zipWith(t1, t2)(f))
		}
	}

	def apply[A](as: A*): List[A] =
		if(as.isEmpty) Nil
		else Cons(as.head, apply(as.tail: _*))

}
