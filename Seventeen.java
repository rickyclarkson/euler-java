/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
*/

import java.util.HashMap;
import java.util.Map;

class Seventeen {
  public static void main(String[] args) {
    Map<Integer, String> map = new HashMap<Integer, String>();
    map.put(1, "one");
    map.put(2, "two");
    map.put(3, "three");
    map.put(4, "four");
    map.put(5, "five");
    map.put(6, "six");
    map.put(7, "seven");
    map.put(8, "eight");
    map.put(9, "nine");
    map.put(10, "ten");
    map.put(11, "eleven");
    map.put(12, "twelve");
    map.put(13, "thirteen");
    map.put(14, "fourteen");
    map.put(15, "fifteen");
    map.put(16, "sixteen");
    map.put(17, "seventeen");
    map.put(18, "eighteen");
    map.put(19, "nineteen");
    map.put(20, "twenty");
    for (int a = 21; a <= 29; a++)
      map.put(a, map.get(20) + map.get(a - 20));
    map.put(30, "thirty");
    map.put(40, "forty");
    map.put(50, "fifty");
    map.put(60, "sixty");
    map.put(70, "seventy");
    map.put(80, "eighty");
    map.put(90, "ninety");
    for (int a = 21; a <= 99; a++)
      if (!map.containsKey(a))
        map.put(a, map.get(a / 10 * 10) + map.get(a % 10));
    for (int a = 100; a <= 900; a += 100)
      map.put(a, map.get(a / 100) + "hundred");
    for (int a = 101; a <= 999; a++)
      if (!map.containsKey(a))
        map.put(a, map.get(a / 100 * 100) + "and" + map.get(a % 100));
    map.put(1000, "onethousand");

    System.out.println(Iterables.sum(Monoid.intPlus, Iterables.map(map.values(), new F<String, Integer>() {
      public Integer f(String s) {
        return s.length();
      }
    })));
  }
}
