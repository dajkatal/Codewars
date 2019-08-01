package GapInPrimes;

import java.text.MessageFormat;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(gap(8, 300, 400)));
    }

    public static long[] gap(int g, long m, long n) {
        int lastPrime = 0;
        for (int i = (int)m; i <= n; i++) {
            boolean isPrime = true;
            for(int divisor = 2; divisor <= i / 2; divisor++) {
                if (i % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                if (i - lastPrime == g) {
                    long[] primeDifference = {lastPrime, i};
                    return primeDifference;
                }
                lastPrime = i;
            }
        }
        return null;
    }

}
