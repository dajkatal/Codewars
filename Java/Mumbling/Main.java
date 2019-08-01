package Mumbling;

public class Main {

    public static void main(String[] args) {
        System.out.println(accum("EquhxOswchE"));
    }

    public static String accum(String s) {


        int numberToMultiply = 1;
        String finalOutput = "";
        //for (char i : s.toCharArray()){
        for (int i = 0; i < s.length(); i++){
            for (int multiply = 0; multiply < numberToMultiply; multiply++) {
                if (multiply != 0) {
                    finalOutput += Character.toLowerCase(s.charAt(i));
                }
                else {
                    finalOutput += Character.toUpperCase(s.charAt(i));
                }
            }

            if (i != s.toCharArray().length - 1) {
                finalOutput += '-';
            }
            numberToMultiply += 1;
        }

        return finalOutput;

    }

}
