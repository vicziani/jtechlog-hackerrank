package plusminus;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.IntStream;

public class Solution {
    public void execute(int[] arr) {
        int[] sum = Arrays.stream(arr).collect(
                () -> new int[4], // Supplier, létrehoz egy üres eredményt
                (int[] result, int item) -> {
                    result[0]++; // 0. a számosság
                    if (item > 0) {
                        result[1]++; // 1. a pozitívak összege
                    }
                    else if (item < 0) {
                        result[2]++;
                    }
                    else {
                        result[3]++;
                    }
                },
                // Első, melyet módosítani kell
                (int[] a, int[] b) -> {
                    IntStream.range(0, a.length).forEach((i) -> b[i] += a[i]);
                });
                // Második, melyet módosítani kell
        Arrays.stream(sum).skip(1).forEach((i) -> System.out.printf(Locale.ENGLISH, "%.6f\n", i / (double) sum[0]));
    }
}
