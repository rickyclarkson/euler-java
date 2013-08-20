import java.math.BigInteger;

class Monoid<T> {
  public final T zero;
  public final F<T, F<T, T>> sum;

  public Monoid(T zero, F<T, F<T, T>> sum) {
    this.zero = zero;
    this.sum = sum;
  }

  public static final Monoid<Integer> intPlus = new Monoid<Integer>(0, new F<Integer, F<Integer, Integer>>() {
    public F<Integer, Integer> f(final Integer x) {
      return new F<Integer, Integer>() {
        public Integer f(Integer y) {
	  return x + y;
	}
      };
    }
  });

  public static final Monoid<BigInteger> bigIntegerPlus = new Monoid<BigInteger>(new BigInteger("0"), new F<BigInteger, F<BigInteger, BigInteger>>() {
    public F<BigInteger, BigInteger> f(final BigInteger x) {
      return new F<BigInteger, BigInteger>() {
        public BigInteger f(BigInteger y) {
	  return x.add(y);
	}
      };
    }
  });

  public static final Monoid<Long> longPlus = new Monoid<Long>(0L, new F<Long, F<Long, Long>>() {
    public F<Long, Long> f(final Long x) {
      return new F<Long, Long>() {
        public Long f(Long y) {
	  return x + y;
	}
      };
    }
  });
}
