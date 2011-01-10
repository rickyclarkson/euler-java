object E6 extends Application {
  var sum = 0
  var squares = 0
  for (x <- 1 to 100) {
    sum += x
    squares += x * x
  }
  println(sum * sum - squares)
}
