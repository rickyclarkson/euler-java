/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

class Five {
  public static void main(String[] args) {
    int a = 1;
    while (!allDivisible(a))
      a++;
    System.out.println(a);
  }

  static boolean allDivisible(int x) {
    for (int a = 1; a <= 20; a++)
      if (x % a != 0)
        return false;
    return true;
  }
}
