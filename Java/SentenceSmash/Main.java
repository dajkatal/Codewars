package SentenceSmash;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(smash(new String[]{}));
    }

    public static String smash(String[] words) {
        return Arrays.toString(words).replaceAll("[^a-zA-Z]", " ").replace("  ", " ").trim();
    }

}
