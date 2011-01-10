object E3 extends Application {
  val target = 600851475143L

  def largestPrimeFactor(x: Long): Long = if (x < 4) x else {
    var y = Math.sqrt(x).toLong
    while (y > 0) {
      if (x % y == 0 && largestPrimeFactor(y) == 1)
        return y
      y -= 1
    }
    1  
  }
  println(largestPrimeFactor(target))
}  
