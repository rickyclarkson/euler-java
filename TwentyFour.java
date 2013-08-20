import com.google.common.collect.Collections2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class TwentyFour {
  public static void main(String[] args) {
    Iterator<List<Character>> p = Collections2.orderedPermutations(
        Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'))
        .iterator();

    for (int a = 0; a < 1000000 - 1; a++)
      p.next();
    System.out.println(p.next());
  }
}
