import java.util.ArrayList;
import java.util.List;

class Arr {
  static List<Character> charArrayAsList(char[] array) {
    List<Character> result = new ArrayList<Character>(array.length);
    for (char c: array)
      result.add(c);
    return result;
  }
}
