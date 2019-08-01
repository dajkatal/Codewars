package TwoCubeSums;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        System.out.println(hasTwoCubeSums(0));
    }

    public static boolean hasTwoCubeSums(int n)
    {
        if (n != 0) {
            ArrayList<Integer> Values = new ArrayList<>();
            for (int i = 1; i < 100; i++){
                int x = (int)Math.round(Math.cbrt(n - Math.pow(i, 3)));
                if (Math.pow(x, 3) + Math.pow(i, 3) == n) {
                    if (!Values.contains(x)) {
                        Values.add(x);
                        Values.add(i);
                    }
                }
                if (Values.size() == 4){
                    return true;
                }
            }
        }

        return false;
    }
}

