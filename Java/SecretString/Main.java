package SecretString;

import javax.management.RuntimeErrorException;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        char[][] triplets = {
                {'g','a','s'},
                {'o','g','s'},
                {'c','n','t'},
                {'c','o','n'},
                {'a','t','s'},
                {'g','r','t'},
                {'r','t','s'},
                {'c','r','a'},
                {'g','a','t'},
                {'n','g','s'},
                {'o','a','s'}
        };

        System.out.println(recoverSecret(triplets));

    }

    public static String recoverSecret(char[][] triplets) {
        HashMap<String, ArrayList<ArrayList<String>>> dependancyMap = new HashMap<>();


        for (char[] triplet: triplets) {
            for (int i = 0; i < triplet.length; i++) {
                String lowerBound = "none";
                String upperBound = "none";

                try { lowerBound = String.valueOf(triplet[i-1]); } catch (Exception e) { }
                try { upperBound = String.valueOf(triplet[i+1]); } catch (Exception e) { }

                if (dependancyMap.get(String.valueOf(triplet[i])) == null) {
                    ArrayList<ArrayList<String>> toBeAdded = formVariable(lowerBound, upperBound);
                    dependancyMap.put(String.valueOf(triplet[i]), toBeAdded);
                }
                else {

                    ArrayList<String> boundsHigh = dependancyMap.get(String.valueOf(triplet[i])).get(1), boundsLow = dependancyMap.get(String.valueOf(triplet[i])).get(0);;
                    if (!dependancyMap.get(String.valueOf(triplet[i])).get(0).contains(lowerBound) & !lowerBound.equals("none")) {
                        boundsLow.add(lowerBound);

                    }
                    if (!dependancyMap.get(String.valueOf(triplet[i])).get(1).contains(upperBound) & !upperBound.equals("none")) {
                        boundsHigh.add(upperBound);
                    }

                    ArrayList<ArrayList<String>> toBeAdded = new ArrayList<>();
                    toBeAdded.add(boundsLow);
                    toBeAdded.add(boundsHigh);

                    dependancyMap.put(String.valueOf(triplet[i]), toBeAdded);
                }

            }
        }
        System.out.println(dependancyMap);

        String finalString = "";

        for (Map.Entry<String, ArrayList<ArrayList<String>>> bounds: dependancyMap.entrySet()) {
            String key = bounds.getKey();
            ArrayList<ArrayList<String>> value = bounds.getValue();
            if (value.get(0).size() == 0) {
                finalString = nextLetter(key, dependancyMap, key);
            }
        }



        return finalString;

    }

    public static ArrayList<ArrayList<String>> formVariable(String lowerBound, String upperBound) {

        ArrayList<ArrayList<String>> toBeAdded = new ArrayList<>();
        String[] lowerBounds, upperBounds;
        if (!lowerBound.equals("none")) lowerBounds = new String[] {lowerBound};
        else lowerBounds = new String[] {};

        if (!upperBound.equals("none")) upperBounds = new String[] {upperBound};
        else upperBounds = new String[] {};

        ArrayList<String> bottom = new ArrayList<String>(Arrays.asList(lowerBounds));
        ArrayList<String> top = new ArrayList<String>(Arrays.asList(upperBounds));

        toBeAdded.add(bottom);
        toBeAdded.add(top);
        return toBeAdded;

    }

    public static String nextLetter(String key, HashMap<String, ArrayList<ArrayList<String>>> dependancyMap, String finalString) {
        if (finalString.length() == dependancyMap.size()) {
            return finalString;
        }

        ArrayList<String> lowerbound = dependancyMap.get(key).get(0);
        ArrayList<String> upperbound = dependancyMap.get(key).get(1);

        int[] averages = new int[upperbound.size()];
        int biggestAvg = -1;
        String biggerLetter = "None";

        for (int i = 0; i< upperbound.size(); i++) {
            try {
                int iterations = 0;

                for (String averageAdd: dependancyMap.get(upperbound.get(i)).get(0)) {
                    if (finalString.indexOf(averageAdd) != -1) {
                        averages[i] += finalString.indexOf(averageAdd);
                        iterations += 1;
                    }
                    else {
                        throw new RuntimeException("There is a -1");
                    }
                }
                averages[i] /= iterations;

                if (averages[i] > biggestAvg) {
                    biggerLetter = upperbound.get(i);
                    biggestAvg = averages[i];
                }
            }
            catch (Exception e) { averages[i] = -1; }
        }
        finalString += biggerLetter;




        return nextLetter(biggerLetter, dependancyMap, finalString);

    }

}
