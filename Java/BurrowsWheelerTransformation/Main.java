package BurrowsWheelerTransformation;

import com.sun.jdi.ArrayReference;

import java.text.MessageFormat;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        encode("bananabar");
        System.out.println(decode("nnbbraaaa", 4));

    }



    public static void encode(String s) {
        ArrayList<String> matrix = new ArrayList<>();
        for (int i = 1; i <= s.length(); i ++) {
            String manipulatedPart = "", normalPart = "";
            try { manipulatedPart = s.substring(s.length() - i + 1); } catch (Exception e) { }
            try { normalPart = s.substring(0, s.length() - i + 1); } catch (Exception e) { }
            matrix.add(manipulatedPart + normalPart);
        }
        Collections.sort(matrix);

        String finalEncoding = "";
        int originalIndex = -1;

        for (String letters : matrix) {
            if (letters.equals(s)) {
                originalIndex = matrix.indexOf(letters);
            }
            finalEncoding += letters.charAt(letters.length() - 1);

        }


        char[] sorted = finalEncoding.toCharArray();
        Arrays.sort(sorted);

    }

    public static String[] splitCorrectly(String s, String original) {
        String[] output = new String[original.length()];

        int iList = 0;

        for (int i = 0; i < original.length(); i++) {
            try {
                int indexOfNextLetter = s.indexOf(original.charAt(i + 1), iList + 1);

                output[i] = s.substring(iList, indexOfNextLetter);

                iList = indexOfNextLetter;
            }
            catch (Exception e) {
                output[i] = s.substring(iList);
                break;
            }

        }

        return output;
    }


    public static valueHolder noDuplicates(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        String finalString = "";
        String UniqueCharacters = "";

        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == null) {
                finalString += s.charAt(i) + "1";
                count.put(s.charAt(i), 1);
                UniqueCharacters += s.charAt(i);
            }
            else {
                finalString += MessageFormat.format("{0}{1}{2}", s.charAt(i), String.valueOf((count.get(s.charAt(i)).intValue() + 1)).length(), (count.get(s.charAt(i)).intValue() + 1));
                count.put(s.charAt(i), count.get(s.charAt(i)) + 1);
            }
        }

        valueHolder output = new valueHolder();
        output.count = count;
        output.finalString = finalString;
        output.uniqueCharacters = UniqueCharacters;

        return (output);
    }

    static class valueHolder {
        String finalString;
        HashMap<Character, Integer> count;
        String uniqueCharacters;
    }

    public static String decode(String s, int n) {

        if (s.equals("")) {
            return "";
        }
        valueHolder noDupesOutput = noDuplicates(s);
        String sProcessed = noDupesOutput.finalString;
        String[] givenS = splitCorrectly(sProcessed, s);
        String[] orderedS = splitCorrectly(sProcessed, s);
        Arrays.sort(orderedS);


        String[][] doubles = new String[givenS.length-1][];
        String[] finalCharacters = new String[2];

        int manipulatedN = n;
        int iList = 0;
        for (int i = 0; i < givenS.length - 1; i++) {
            if (i != manipulatedN) {
                doubles[i] = new String[]{givenS[iList], orderedS[iList]};
                iList += 1;
            }
            else {
                finalCharacters[0] = orderedS[i];
                finalCharacters[1] = givenS[i];
                i -= 1;
                iList += 1;
                manipulatedN = -2;
            }
        }


        String output = recoverSecret(doubles);
        output = output.replaceAll("[0-9]+", "");
        return output;

    }


    public static String recoverSecret(String[][] triplets) {
        HashMap<String, ArrayList<ArrayList<String>>> dependancyMap = new HashMap<>();


        for (String[] triplet: triplets) {
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

        ArrayList<String> lowerbound = dependancyMap.get(key).get(0);
        ArrayList<String> upperbound = dependancyMap.get(key).get(1);

        if (upperbound.size() == 0) {
            return finalString;
        }


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
