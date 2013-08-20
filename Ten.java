/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
*/

class Ten {
  public static void main(String[] args) {
    System.out.println(Iterables.sum(Monoid.longPlus, Iterables.takeWhile(Iterables.drop(1, Primes.primes(Num.longNum)), new F<Long, Boolean>() {
      public Boolean f(Long x) {
        return x < 2000000;
      }
    })));
  }
}
