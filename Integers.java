class Integers {
  static final F<Integer, Boolean> lessThan(final int x) {
    return new F<Integer, Boolean>() {
      public Boolean f(Integer y) {
        return y < x;
      }
    };
  }
}
