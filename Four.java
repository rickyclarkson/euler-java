/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/

class Four {
  public static void main(String[] args) {
    System.out.println(largestPalindrome(3));
  }

  static int largestPalindrome(int digits) {
    int max = (int)Double.parseDouble("10E" + (digits - 1));
    int largest = 0;
    for (int a = 0; a < max; a++)
      for (int b = 0; b < max; b++)
        if (a * b > largest && palindromeTest(a * b))
	  largest = a * b;
    return largest;
  }

  static boolean palindromeTest(int number) {
    return Integer.toString(number).equals(new StringBuilder(Integer.toString(number)).reverse().toString());
  }
}
