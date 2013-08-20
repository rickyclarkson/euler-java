/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
*/

class Seven {
  public static void main(String[] args) {
    System.out.println(get(10001, Primes.primes));
  }

  public static <T> T get(int index, Iterable<T> iterable) {
    int counter = 0;
    for (T t: iterable)
      if (counter++ == index)
        return t;
    throw new IllegalArgumentException();
  }
}
