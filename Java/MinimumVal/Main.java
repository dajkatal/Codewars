package MinimumVal;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] inputValue = {4, 8, 1, 4, 7, 5, 2, 1, 5, 1, 8, 1 ,7, 1, 5, 9, 1, 2, 3, 4,5 ,6 ,7 ,8, 9};
        System.out.println(minValue(inputValue));
    }

    public static int minValue(int[] values){

        Arrays.sort(values);

        ArrayList<Integer> noDupes = new ArrayList<>();
        for (int i = 0; i < values.length; i++){
            int var = values[i];
            if (!noDupes.contains(var)) {
                noDupes.add(var);
            }
        }


        int finalValues = 0;


        for (int i = 0; i < noDupes.size(); i++) {
            finalValues += noDupes.get(i) * Math.pow(10, noDupes.size() - i - 1);
        }


        return finalValues;
    }


}
