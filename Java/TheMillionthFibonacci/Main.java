package TheMillionthFibonacci;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        BigInteger num = new BigInteger("0");

        System.out.println(fib(num));

    }

    public static BigInteger fib(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }
        BigInteger[] parentMatrix = matrixPow(new BigInteger[]{BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO}, n.intValue());
        BigInteger[] baseMatrix = new BigInteger[]{BigInteger.ONE, BigInteger.ZERO};
        return (parentMatrix[2].multiply(baseMatrix[0]));

    }

    public static BigInteger[] matrixMultiply(BigInteger[] matrix1, BigInteger[] matrix2) {
        return new BigInteger[] {
                matrix1[0].multiply(matrix2[0]).add(matrix1[1].multiply(matrix2[2])),
                matrix1[0].multiply(matrix2[1]).add(matrix1[1].multiply(matrix2[3])),
                matrix1[2].multiply(matrix2[0]).add(matrix1[3].multiply(matrix2[2])),
                matrix1[2].multiply(matrix2[1]).add(matrix1[3].multiply(matrix2[3]))
        };
    }

    public static BigInteger[] matrixPow(BigInteger[] matrix, int exponent) {
        BigInteger[] result;
        if (exponent < 0) {
            exponent = Math.abs(exponent);
            result = new BigInteger[]{BigInteger.ZERO, BigInteger.ONE, BigInteger.ONE, new BigInteger("-1")};
            matrix = result;
        }
        else {
            result = new BigInteger[]{BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO};
        }
        exponent -= 1;

        while (exponent > 0) {
            if (exponent%2 == 1) {
                result = matrixMultiply(result, matrix);
            }
            exponent >>= 1;
            matrix = matrixMultiply(matrix, matrix);
        }

        return result;

    }

}
