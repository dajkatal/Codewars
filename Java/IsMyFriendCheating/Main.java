package IsMyFriendCheating;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(removNb(26).get(0)));
        System.out.println(Arrays.toString(removNb(26).get(1)));
        System.out.println(Arrays.toString(removNb(26).get(2)));

    }

    public static ArrayList<long[]> removNb(long n) {
        ArrayList<long[]> finalValues = new ArrayList<>();
        long sum = n*(n+1)/2;
        for (double a = 1; a <= n; a++){
            double b = (sum - a)/(1 + a);
            if (b - (int)b == 0 & b <= n){ finalValues.add(new long[] {(int)a, (int)b}); }
        }
        return finalValues;



    }

}




/*

1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26

sum = n(n+1)/2;


Loop over the numbers from 1 to n. (i):
    index = (int)(n/2);
    if ( i * index > sum - i - index ):




15 * 26 == 351 - 26 - 15 == 315
a *  b  == 351 - b  - a  == 315



ab == 351 - a - b

a + ab = 351 - b

a(1+b) = 351 - b

a = (351 - b)/(1+b)


ab == 351 - a - b

ab + b == 351 - a

b(1+a) == 351 - a

b == (351 - a)/(1 + a)







*/

