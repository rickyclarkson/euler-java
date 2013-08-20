import java.math.BigInteger;

class Factorial {
  static BigInteger fac(BigInteger x) {
    return x.compareTo(new BigInteger("2")) < 0 ? x : x.multiply(fac(x.subtract(new BigInteger("1"))));
  }
}
