/*
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
*/

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Sixteen {
  public static void main(String[] args) {
    BigInteger two = new BigInteger("2");
    BigInteger raised = two.pow(1000);

    System.out.println(Iterables.sum(Monoid.intPlus, Iterables.map(Arr.charArrayAsList(raised.toString().toCharArray()), new F<Character, Integer>() {
      public Integer f(Character s) {
        return s - '0';
      }
    })));
  }

}
