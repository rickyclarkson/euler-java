abstract class Num<T> {
  static final Num<Long> longNum = new Num<Long>() {
    public Long zero() {
      return 0L;
    }

    public Long increment(Long t) {
      return t + 1;
    }

    public Long fromInt(int x) {
      return (long)x;
    }

    public Long sqrt(Long t) {
      return (long)Math.sqrt(t);
    }

    public Long add(Long a, Long b) {
      return a + b;
    }

    public Long min(Long a, Long b) {
      return Math.min(a, b);
    }

    public boolean lessThan(Long a, Long b) {
      return a < b;
    }

    public Long modulo(Long a, Long b) {
      return a % b;
    }

    public boolean eq(Long a, Long b) {
      return a.equals(b);
    }
  };

  abstract T zero();
  abstract T increment(T t);
  abstract T fromInt(int x);
  abstract T sqrt(T t);
  abstract T add(T a, T b);
  abstract T min(T a, T b);
  abstract boolean lessThan(T a, T b);
  abstract T modulo(T a, T b);
  abstract boolean eq(T a, T b);
}
