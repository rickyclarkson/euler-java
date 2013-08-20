/*
Using names.txt, a 46K text file containing over
five-thousand first names, begin by sorting it into
alphabetical order. Then working out the
alphabetical value for each name, multiply this
value by its alphabetical position in the list to
obtain a name score.

For example, when the list is sorted into
alphabetical order, COLIN, which is worth
3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the
list. So, COLIN would obtain a score of 938 x 53 =
49714.
*/

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class TwentyTwo {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("names.txt")));
    String line = reader.readLine();
    String[] split = line.split(",");
    for (int a = 0; a < split.length; a++) {
      split[a] = split[a].substring(1, split[a].length() - 1);
    }
    Arrays.sort(split);
    int sum = 0;
    for (int a = 0; a < split.length; a++)
      sum += (a + 1) * sumDigits(split[a]);
    System.out.println(sum);
  }

  static int sumDigits(String s) {
    int sum = 0;
    for (char c: s.toCharArray())
      sum += c - 'A' + 1;
    return sum;
  }
}
