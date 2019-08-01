package ReversedStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        System.out.println(solution("Hello"));
    }

    public static String solution(String str) {
        return new StringBuilder(str).reverse().toString();
    }

}
