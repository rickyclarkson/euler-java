/*
Starting in the top left corner of a 2x2 grid, there are 6 routes (without backtracking) to the bottom right corner.

How many routes are there through a 20x20 grid?

0011
0101
0110
1001
1010
1011
*/

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Fifteen {
  public static void main(String[] args) {
    System.out.println(Factorial.fac(new BigInteger("40")).divide(Factorial.fac(new BigInteger("20")).pow(2)));
  }
}
