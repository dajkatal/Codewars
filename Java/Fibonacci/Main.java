package Fibonacci;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        System.out.println(fib(14));
    }

    public static BigInteger fib(int nInt) {
        BigInteger n = BigInteger.valueOf(nInt);
        BigInteger a = BigInteger.ZERO, b = BigInteger.ONE, c;

        if (n.equals(0)) {
            return a;
        }

        for (int i = 2; i<=n.intValue(); i++) {
            c = a.add(b);
            a = b;
            b = c;
        }

        return b;

    }

}
