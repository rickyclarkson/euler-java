import java.math.BigInteger;

class TwentyFive {
  public static void main(String[] args) {
    BigInteger nMinus2 = new BigInteger("1");
    BigInteger nMinus1 = new BigInteger("1");

    int a = 2;
    BigInteger n;
    do {
      a++;
      n = nMinus2.add(nMinus1);
      nMinus2 = nMinus1;
      nMinus1 = n;
    } while (n.toString().length() < 1000);

    System.out.println(a);
  }
}
