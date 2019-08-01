package TimeFormatter;

import java.text.MessageFormat;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        System.out.println(formatDuration(132030240));
    }

    public static String formatDuration(int seconds) {

        String finalOutput = "";

        int[] output = new int[7];

        String[] outputMap = {"years", "months", "weeks", "days", "hours", "minutes", "seconds"};

        if (seconds / 31536000 > 0) {
            int toRemove = (int) Math.floor(seconds / 31536000);
            //if (toRemove >= 4) {
            //    seconds += (Math.floor(toRemove/4)) * 86400;
            //}
            seconds -= toRemove * 31536000;
            output[0] = toRemove;

        }


        if (seconds / 86400 > 0) {
            int toRemove = (int) Math.floor(seconds / 86400);

            seconds -= toRemove * 86400;
            output[3] = toRemove;

        }

        //System.out.println(seconds);

        if (seconds / 3600 > 0) {
            int toRemove = (int) Math.floor(seconds / 3600);

            seconds -= toRemove * 60 * 60;
            output[4] = toRemove;

        }

        if (seconds / 60 > 0) {
            int toRemove = (int) Math.floor(seconds / 60);

            seconds -= toRemove * 60;

            output[5] = toRemove;

        }

        output[6] = seconds;

        for(int i = 0; i < output.length; i++) {
            if (output[i] != 0) {
                String suffix;
                if (output[i] > 1){
                    suffix = outputMap[i];
                }
                else {
                    suffix = outputMap[i].substring(0, outputMap[i].length() - 1);
                }



                if (i != 6) {
                    boolean moreLeft = false;

                    for (int b = i+1; b < output.length; b++) {
                        if (output[b] != 0) {
                            moreLeft = true;
                            break;
                        }
                    }

                    if (moreLeft){
                        finalOutput += MessageFormat.format("{0} {1}, ", output[i], suffix);
                    }
                    else if (finalOutput.length() > 0){
                        finalOutput = finalOutput.substring(0, finalOutput.length()-2) + " ";
                        finalOutput += MessageFormat.format("and {0} {1}", output[i], suffix);
                    }
                    else {
                        finalOutput += MessageFormat.format("{0} {1}", output[i], suffix);
                    }
                }
                else {
                    if (finalOutput.length() > 0) {
                        finalOutput = finalOutput.substring(0, finalOutput.length()-2) + " ";
                        finalOutput += MessageFormat.format("and {0} {1}", output[i], suffix);
                    }
                    else {
                        finalOutput += MessageFormat.format("{0} {1}", output[i], suffix);
                    }
                }
            }
        }

        if (finalOutput.length() == 0){
            finalOutput = "now";
        }

        return finalOutput;

    }

}


/*

int[] output = new int[6];
seconds = 62011;

int length = (int)Math.floor(Math.log10(seconds)) + 1;

While (length > 1):
    if (seconds/60/60/24/7/4/12 > 0){
        int toRemove = Math.floor(seconds/60/60/24/7/4/12);

    }



126,144,000
5,875,200
79,200
2,220
20



*/