package PascalsTriangle;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pascal(6)));
    }

    public static int[] pascal(int depth) {
        int[][] values = new int[depth][];

        int[] finalValues = new int[depth];

        values[0] = new int[]{1};
        if (depth > 1) {
            values[1] = new int[]{1,1};
        }
        for (int i = 2; i < depth; i++){
            values[i] = new int[1 + i];
            values[i][0] = 1;
            values[i][i] = 1;
            for (int b = 0; b < values[i].length; b++){
                if (values[i][b] != 1) {
                    values[i][b] += values[i-1][b] + values[i-1][b-1];

                }
            }
            finalValues = values[i];
        }

        return finalValues;
    }

}
