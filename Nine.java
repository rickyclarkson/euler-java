/*
A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
*/

class Nine {
  public static void main(String[] args) {
    for (int a = 1; a < 1000; a++)
      for (int b = a; b < 1000; b++) {
        int squares = a * a + b * b;
	int root = (int)Math.sqrt(squares);
	if (root * root == squares && a + b + root == 1000)
	  System.out.println(a * b * root);
      }
  }
}
