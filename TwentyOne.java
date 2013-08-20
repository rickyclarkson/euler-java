/*
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
*/

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TwentyOne {
  public static void main(String[] args) {
    int sum = 0;
    Set<Integer> amicableNumbers = new HashSet<Integer>();
    for (int a = 1; a < 10000; a++) {
      int da = d(a);
      if (da != a && d(da) == a && !amicableNumbers.contains(a) && !amicableNumbers.contains(da)) {
        sum += a;
	amicableNumbers.add(a);
	if (da < 10000) {
	  sum += da;
	  amicableNumbers.add(da);
	}
      }
    }
    System.out.println(sum);
  }

  static int d(int n) {
    List<Integer> factors = Primes.properDivisors(n);
    return Iterables.sum(Monoid.intPlus, factors);
  }
}
