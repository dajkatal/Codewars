package DecimalToFactorial;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String fact = dec2FactString(1234567890);
        long dec = factString2Dec("14F9122694751231010");
        System.out.println(fact);
        System.out.println(dec);
    }

    public static String dec2FactString(long nb) {

        ArrayList<String> numbers = new ArrayList<>();

        long changingNumber = nb;

        for (int i = 1; i <= 100; i++){
            long remainder = changingNumber % i;
            changingNumber = (changingNumber - remainder)/i;
            if (remainder >= 10) {
                String letters = "ABCDEFGHIJKLNMOPQRSTUVWXYZ";

                float indexF = remainder - 10;
                int index = (int)indexF;

                String remainderInt = "" + letters.charAt(index);

                numbers.add(remainderInt);

            }
            else {
                numbers.add(Long.toString(remainder));
            }

            if (changingNumber == 0) {
                break;
            }
        }
        Collections.reverse(numbers);

        return String.join("", numbers);

    }
    public static long factString2Dec(String str) {

        //str = str.replaceAll("[^0-9]", "");

        int[] radix = new int[str.length()];



        for (int i = 0; i < str.length(); i++) {

            radix[i] = str.length() - i - 1;
        }


        char[] strList = str.toCharArray();
        long finalResult = 0;
        for (int i = 0; i < strList.length; i++) {
            int x = 0;
            if (Character.isLetter(strList[i])) {
                String letters = "ABCDEFGHIJKLNMOPQRSTUVWXYZ";

                x = 10 + letters.indexOf(strList[i]);
            }
            else {
                x = strList[i] - '0';
            }
            long answer = x * fact(radix[i]);
            finalResult += answer;
        }

        return finalResult;

    }

    static long fact(int n) {

        if (n == 1 | n == 0) {
            return 1;
        }

        return n * fact(n - 1);

    }


}
