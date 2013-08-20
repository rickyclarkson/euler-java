/*
n! means n  (n  1)  ...  3  2  1

For example, 10! = 10  9  ...  3  2  1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
*/

import java.math.BigInteger;

class Twenty {
  public static void main(String[] args) {
    BigInteger factorial = Factorial.fac(new BigInteger("100"));
    System.out.println(Iterables.sum(Monoid.intPlus, Iterables.map(Arr.charArrayAsList(String.valueOf(factorial).toCharArray()), digitCharToInt)));
  }

  static final F<Character, Integer> digitCharToInt = new F<Character, Integer>() {
    public Integer f(Character c) {
      return c - '0';
    }
  };
}
