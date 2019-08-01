package BinomialExpansion;


public class Main {

    public static void main(String[] args) {
        System.out.println(expand("(10k+13)^10"));
    }

    public static String expand(String expr) {

        if (expr.indexOf(")") == -1) {
            return expr;
        }

        if (expr == "") {
            return "";
        }

        String[] numberSeparated = expr.split("[)]+");


        numberSeparated[0] = numberSeparated[0].replace("(", "");

        if (numberSeparated[0].indexOf("-", 1) != -1) {
            numberSeparated[0] = numberSeparated[0].substring(0, numberSeparated[0].indexOf("-", 1)) + "+" + numberSeparated[0].substring(numberSeparated[0].indexOf("-", 1));
        }

        numberSeparated[1] = numberSeparated[1].substring(1, numberSeparated[1].length());


        if (numberSeparated[1].equals("0")) {
            return "1";
        }
        else if (numberSeparated[1].equals("1")) {

            String answer = structureAnswer(numberSeparated[0].split("[+]+"), numberSeparated[0].split("[+]+")[0].charAt(numberSeparated[0].split("[+]+")[0].length()-1));

            if (answer.charAt(0) == '+') {
                answer = answer.substring(1);
            }

            return answer;
        }
        else {
            int[] coefficients = pascal(Integer.parseInt(numberSeparated[1]) + 1 );
            int power = Integer.parseInt(numberSeparated[1]);
            String[] numberSeparatedExpanded = numberSeparated[0].split("[+]+");
            char variable = numberSeparatedExpanded[0].charAt(numberSeparatedExpanded[0].length()-1);

            if (numberSeparatedExpanded[0].substring(0, numberSeparatedExpanded[0].indexOf(variable)).equals("-")) {
                numberSeparatedExpanded[0] = "-1" + numberSeparatedExpanded[0].substring(1);
            }
            else if (numberSeparatedExpanded[0].substring(0, numberSeparatedExpanded[0].indexOf(variable)).equals("")) {
                numberSeparatedExpanded[0] = "1" + numberSeparatedExpanded[0];
            }


            String unsimplifiedExpanded = "";

            for (int i = 1; i <= power + 1; i ++) {

                String aFinal = "";
                String bFinal = "";

                String a = numberSeparatedExpanded[0].substring(0, numberSeparatedExpanded[0].length()-1);
                int powerToUse = power - i + 1;
                if (a.length() > 0) {
                    String A = "";
                    if (!a.equals("-")) {
                        A = String.format("%f", Math.pow(Double.parseDouble(a), powerToUse)).substring(0, String.format("%f", Math.pow(Double.parseDouble(a), powerToUse)).indexOf("."));
                    }


                    if (powerToUse == 1) {
                        aFinal = A + numberSeparatedExpanded[0].charAt(numberSeparatedExpanded[0].length()-1) + "";
                    }
                    else {
                        aFinal = A + numberSeparatedExpanded[0].charAt(numberSeparatedExpanded[0].length()-1)+ "^" + powerToUse;
                    }
                }
                else {
                    if (powerToUse == 1) {
                        aFinal = numberSeparatedExpanded[0].charAt(numberSeparatedExpanded[0].length()-1)+ "";
                    }
                    else {
                        aFinal = numberSeparatedExpanded[0].charAt(numberSeparatedExpanded[0].length()-1)+ "^" + powerToUse;
                    }

                }

                bFinal = String.format("%f",Math.pow(Double.parseDouble(numberSeparatedExpanded[1]), i - 1)).substring(0, String.format("%f",Math.pow(Double.parseDouble(numberSeparatedExpanded[1]), i - 1)).indexOf("."));

                if (i == 1) {
                    bFinal = "";
                }

                if (bFinal == ""){
                    unsimplifiedExpanded += "+" + aFinal;
                }
                else {
                    String finalOutput = "";

                    finalOutput = Long.parseLong(aFinal.substring(0, aFinal.indexOf(variable))) * Long.parseLong(bFinal) + aFinal.substring(aFinal.indexOf(variable)) + "";

                    if (finalOutput.charAt(finalOutput.length()-1) == '0' & finalOutput.charAt(finalOutput.length()-2) == '^'){
                        finalOutput = finalOutput.substring(0, finalOutput.length()-3);
                    }
                    unsimplifiedExpanded += "+" + finalOutput;

                }

            }

            unsimplifiedExpanded = unsimplifiedExpanded.substring(1, unsimplifiedExpanded.length());


            String[] simplifiedExpanded = unsimplifiedExpanded.split("[+]+");



            for (int i = 0; i < simplifiedExpanded.length; i++) {
                if (simplifiedExpanded[i].indexOf(variable) != -1) {
                    String variablePart = simplifiedExpanded[i].substring(simplifiedExpanded[i].indexOf(variable));
                    long numberPart = Long.parseLong(simplifiedExpanded[i].substring(0, simplifiedExpanded[i].indexOf(variable))) * coefficients[i];
                    simplifiedExpanded[i] = numberPart + variablePart;
                }

                else {
                    simplifiedExpanded[i] = (Long.parseLong(simplifiedExpanded[i]) * coefficients[i]) + "";
                }

            }

            String answer = "";

            answer = structureAnswer(simplifiedExpanded, variable);

            if (answer.charAt(0) == '+') {
                answer = answer.substring(1);
            }


            if (answer.substring(0, 2).equals("-1")  & answer.charAt(2) == variable){
                answer = "-" + answer.substring(2);
            }
            else if (answer.substring(0, 1).equals("1")  & answer.charAt(1) == variable) {
                answer = answer.substring(1);
            }

            return answer;



        }


    }

    public static String structureAnswer(String[] simplifiedExpanded, char variable){
        String answer = "";
        for (String value: simplifiedExpanded) {
            if (value.indexOf(variable) != -1) {
                if (!value.substring(0, value.indexOf(variable)).equals("0") & !value.substring(0, value.indexOf(variable)).equals("-0")) {
                    if (value.charAt(0) == '-') {
                        answer += value;
                    } else {
                        answer += "+" + value;
                    }
                }
            }
            else {
                if (!value.equals("0") & !value.equals("-0")) {
                    if (value.charAt(0) == '-') {
                        answer += value;
                    } else {
                        answer += "+" + value;
                    }
                }
            }
        }

        return answer;
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
