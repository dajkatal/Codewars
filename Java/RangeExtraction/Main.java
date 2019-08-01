package RangeExtraction;

import java.text.MessageFormat;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(rangeExtraction(new int[] {-34, -33, -30, -29, -26, -24, -21, -19, -17, -16, -15, -14, -11, -8, -6, -4, -2, -1, 0}));
    }

    public static String rangeExtraction(int[] arr) {
        String finalOutput = "";
        int startingRange = -1000;
        int endingRange = -2000;
        int prevNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            if (startingRange == -1000) {
                startingRange = number;
                prevNumber = number;
                continue;
            }

            if (number - prevNumber == 1 & number != arr[arr.length - 1]) {
                endingRange = number;
                prevNumber = number;
                continue;
            }

            else {
                if (endingRange != -2000 | number == arr[arr.length - 1] & endingRange != -2000) {

                    if (number == arr[arr.length - 1] & number - endingRange == 1) {
                        endingRange = number;
                    }

                    if (endingRange - startingRange == 1) {

                        finalOutput += MessageFormat.format("{0},{1},", Integer.toString(startingRange), Integer.toString(endingRange));
                        if (number - endingRange > 1 & number == arr[arr.length - 1]){
                            finalOutput += MessageFormat.format("{0},", Integer.toString(number));
                        }
                    }

                    else {
                        if (number == arr[arr.length - 1] & number - endingRange == 1) {
                            endingRange = number;
                        }

                        finalOutput += MessageFormat.format("{0}-{1},", Integer.toString(startingRange), Integer.toString(endingRange));
                        if (number == arr[arr.length - 1] & number - endingRange > 1) {
                            startingRange = number;
                            finalOutput += MessageFormat.format("{0},", Integer.toString(startingRange));
                        }
                    }

                }
                else {
                    finalOutput += MessageFormat.format("{0},", Integer.toString(startingRange));
                    if (number == arr[arr.length - 1]) {
                        finalOutput += MessageFormat.format("{0},", Integer.toString(number));
                    }
                }
                startingRange = number;
                prevNumber = number;
                endingRange = -2000;
            }


        }
        return (finalOutput.substring(0, finalOutput.length() - 1));
    }

}
