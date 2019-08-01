package SquareSum;

public class Main {

    public static void main(String[] args) {
        System.out.println(squareSum(new int[]{1,2,2}));
    }

    public static int squareSum(int[] n)
    {
        int finalOutput = 0;
        for (int number : n){
            finalOutput += Math.pow(number, 2);
        }

        return finalOutput;
    }

}
