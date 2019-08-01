package SumOfTwoIntegers;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args){
        System.out.println(add(-14,-16));
    }

    public static int add(int x, int y){
        BigInteger num1 = BigInteger.valueOf(x);
        BigInteger num2 = BigInteger.valueOf(y);
        int finalNum = num1.add(num2).intValue();

        return finalNum;
    }

}
