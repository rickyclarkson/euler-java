object E4 extends Application {
  var max = 0
  for (x <- 999 to (100, -1); y <- 999 to (100, -1))
    if ((x * y).toString == (x * y).toString.reverse)
      max = Math.max(max, x * y)

  println(max)
}
