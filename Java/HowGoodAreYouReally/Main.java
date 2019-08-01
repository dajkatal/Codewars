package HowGoodAreYouReally;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println(betterThanAverage(new int[] {100, 40, 34, 57, 29, 72, 57, 88}, 75));
    }

    public static boolean betterThanAverage(int[] classPoints, int yourPoints) {
        return (yourPoints > IntStream.of(classPoints).sum()/classPoints.length);
    }

}
