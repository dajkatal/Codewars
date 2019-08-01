package DoubleCola;

//NOT COMPLETED


import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        WhoIsNext(names, 11);
    }

    public static void WhoIsNext(String[] names, int n)
    {

        //ArrayList<String> manipulatedTurns = new ArrayList<>();
        //ArrayList<String> lessManipulatedTurns = new ArrayList<>();
        HashMap<Integer, Integer> positions = new HashMap<>();
        int toUse = (int)Math.round(((double)n/names.length - n/names.length)*5);
        int toMultiplyBy = (int) Math.ceil(n/names.length);
        System.out.println(toUse);
        System.out.println(toMultiplyBy);
        int startingPosition = 0;

        for (int position = 0; position < names.length; position++) {
            if (position + 1 > toUse) {
                positions.put(position, startingPosition);
                startingPosition += toMultiplyBy;
            }
            else {
                positions.put(position, startingPosition);
                startingPosition += toMultiplyBy+1;
            }
        }



        System.out.println(positions);
    }
}
