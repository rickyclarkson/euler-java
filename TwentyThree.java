/*
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
*/

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TwentyThree {
  public static void main(String[] args) {
    List<Integer> lowAbundantNumbers = Iterables.toList(Primes.abundantNumbers(Primes.range(0, 28124)));

    int index = -1;
    Set<Integer> sumsOfTwo = new HashSet<Integer>();

    outer:
    for (int abundantOne: lowAbundantNumbers) {
      index++;
      for (int abundantTwo: lowAbundantNumbers.subList(index, lowAbundantNumbers.size()))
        if (abundantOne + abundantTwo < 28124)
	  sumsOfTwo.add(abundantOne + abundantTwo);
    }
   
    int sum = 0;
    for (int a = 0; a < 28124; a++)
      if (!sumsOfTwo.contains(a))
        sum += a;

    System.out.println(sum);
  }
}
