object E2 extends Application {
  jorge()
  var prev = 1
  var curr = 2
  var evens = curr
  while (curr < 4000000) {
    val tmp = prev
    prev = curr
    curr = prev + tmp;
    if (curr % 2 == 0)
      evens += curr
  }
  println(evens)
  def jorge() {
    lazy val fib: Stream[Int] = Stream.cons(0, Stream.cons(1, fib.zip(fib.tail).map(p => p._1 + p._2)))
    println(fib.filter(_ % 2 == 0).takeWhile(_ <= 4000000).sum)
  }
}  
