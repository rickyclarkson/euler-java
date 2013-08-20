import java.util.Arrays;

class TwentyFour {
  public static void main(String[] args) {
    int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(findPermutation(1000000, a));
  }

  static <T, U> Result<T> permutations(List<U> a, Visitor<T, U> visitor) {
    if (visitor.isDone())
      return visitor.result();
    visitor.visit(a);
    List<U> b = new ArrayList<U>(a);
    if (a.size() < 2)
      throw null;
    if (a.size() == 2) {
      U u = 

    if (a.length < 2)
      throw null;
    if (a.length == 2) {
      int[] b = new int[2];
      b[0] = a[1];
      b[1] = a[0];
      if (index == 1)
        return index;
      
      System.arraycopy(a, 0, b, 0, b.length);
      
}
