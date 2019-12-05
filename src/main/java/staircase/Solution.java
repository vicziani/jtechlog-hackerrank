package staircase;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public void drawStaircase() {
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        IntStream.range(0, max).mapToObj(i -> printStep(i, max)).forEach(System.out::println);
    }

    private static String printStep(int step, int max) {
        return IntStream.range(0, max).mapToObj(i -> i < max - step - 1 ? " " : "#").collect(Collectors.joining());
    }

}
