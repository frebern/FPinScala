package Chapter2

object Ex1 {

  def fibonacci(n: Int): BigInt = {
    def go(n: Int, fibNum1: BigInt, fibNum2: BigInt): BigInt =
      if(n<=1)  fibNum1
      else  go(n-1, fibNum2, fibNum1+fibNum2)
    go(n, 0, 1)
  }

  def main(args: Array[String]): Unit = {
    (1 to 10).foreach(i=>println("fib("+i+"): "+fibonacci(i)))
    println(fibonacci(100000))
  }

}
