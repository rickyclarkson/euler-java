/*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

   3
  7 4
 2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

                         75
                        95 64
                      17 47 82
                     18 35 87 10
                   20 04 82 47 65
                 19 01 23 75 03 34
                88 02 77 73 07 63 67
              99 65 04 28 06 16 70 92
            41 41 26 56 83 40 80 70 33
          41 48 72 33 47 32 37 16 94 29
        53 71 44 65 25 43 91 52 97 51 14
      70 11 33 28 77 73 17 78 39 68 17 57
    91 71 52 38 17 14 91 43 58 50 27 29 48
  63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
*/

import java.util.Arrays;
import java.util.List;

class Eighteen {
  static final F<String, Integer> parseInt = new F<String, Integer>() {
    public Integer f(String s) {
      return Integer.parseInt(s);
    }
  };

  static final F<String, Boolean> nonEmptyString = new F<String, Boolean>() {
    public Boolean f(String s) {
      return !s.isEmpty();
    }
  };
  
  static final String[] strings = {
    "   3",
    "  7 4",
    " 2 4 6",
    "8 5 9 3"
  };

  static final int[][] sparse = new int[][] {
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 95, 0, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 0, 47, 0, 82, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 0, 35, 0, 87, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 4, 0, 82, 0, 47, 0, 65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 0, 1, 0, 23, 0, 75, 0, 3, 0, 34, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 0, 88, 0, 2, 0, 77, 0, 73, 0, 7, 0, 63, 0, 67, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 99, 0, 65, 0, 4, 0, 28, 0, 6, 0, 16, 0, 70, 0, 92, 0, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 0, 0, 41, 0, 41, 0, 26, 0, 56, 0, 83, 0, 40, 0, 80, 0, 70, 0, 33, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 0, 41, 0, 48, 0, 72, 0, 33, 0, 47, 0, 32, 0, 37, 0, 16, 0, 94, 0, 29, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 53, 0, 71, 0, 44, 0, 65, 0, 25, 0, 43, 0, 91, 0, 52, 0, 97, 0, 51, 0, 14, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 70, 0, 11, 0, 33, 0, 28, 0, 77, 0, 73, 0, 17, 0, 78, 0, 39, 0, 68, 0, 17, 0, 57, 0, 0, 0, 0 },
    { 0, 0, 91, 0, 71, 0, 52, 0, 38, 0, 17, 0, 14, 0, 91, 0, 43, 0, 58, 0, 50, 0, 27, 0, 29, 0, 48, 0, 0, 0 },
    { 0, 63, 0, 66, 0, 4, 0, 68, 0, 89, 0, 53, 0, 67, 0, 30, 0, 73, 0, 16, 0, 69, 0, 87, 0, 40, 0, 31, 0, 0 },
    { 4, 0, 62, 0, 98, 0, 27, 0, 23, 0, 9, 0, 70, 0, 98, 0, 73, 0, 93, 0, 38, 0, 53, 0, 60, 0, 4, 0, 23, 0 },
  };

  static final int[][] bests = bests(sparse);

  public static void main(String[] args) {
    for (int a: bests[0])
      if (a != 0)
        System.out.println(a);
  }

  static int[][] stringsToSparse(String[] strings) {
    int[][] result = new int[strings.length][strings[strings.length - 1].length()];
    for (int a = 0; a < strings.length; a++)
      for (int b = 0; b < strings[a].length(); b++)
        if (strings[a].charAt(b) != ' ')
	  result[a][b] = strings[a].charAt(b) - '0';
    return result;
  }

  static int[][] bests(int[][] sparse) {
    int[][] bests = new int[sparse.length][sparse[0].length];
    bests[sparse.length - 1] = sparse[sparse.length - 1];
    for (int a = sparse.length - 2; a >= 0; a--)
      for (int b = 0; b < sparse[0].length; b++)
        if (sparse[a][b] != 0)
	  bests[a][b] = sparse[a][b] + Math.max(bests[a + 1][b + 1], bests[a + 1][b - 1]);
      
    return bests;
  }
}
