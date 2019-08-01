package ExponentiationBySquaring;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {


        System.out.println(pow(new BigInteger("922252522525621"), 521));

    }

    public static BigInteger pow(BigInteger base, int exponent) {
        BigInteger result = BigInteger.ONE;

        while (exponent > 0) {
            if (exponent%2 == 1) {
                result = result.multiply(base);
            }
            exponent >>= 1;
            base = base.multiply(base);
        }

        return result;

    }

}
