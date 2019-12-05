package diagonaldifference;

import java.util.Arrays;

public class Solution {
    public int difference(int[][] numbers) {
        return Math.abs(Arrays.stream(Arrays.stream(numbers).collect(
                () -> new int[2], // Supplier, létrehoz egy üres eredményt, egyik és másik átlóval
                (int[] a, int[] b) -> {
                    int i = b[0];
                    int d1 = b[i + 1];
                    int d2 = b[b.length - i - 1];
                    a[0] += d1;
                    a[1] += -d2;
                },
                // Első, melyet módosítani kell
                (int[] a, int[] b) -> {
                    b[0] += a[0];
                    b[1] += a[1];
                } // Combiner, mely a két eredményt összeadja, a második, melyet módosítani kell
        )).sum());
    }
}
