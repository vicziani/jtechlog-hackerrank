package comparethetriplets;

import java.util.Arrays;

public class CompareTheTriplets {

    public int[] solve(int a0, int a1, int a2, int b0, int b1, int b2) {
        int[][] points = {{a0, b0}, {a1, b1}, {a2, b2}};

         return Arrays.stream(points).collect(
                () -> new int[2], // Supplier, létrehoz egy üres eredményt, Alice és Bob pontjaival
                (int[] a, int[] b) -> {
                    if (b[0] > b[1]) {
                        a[0]++;
                    } else if (b[0] < b[1]) {
                        a[1]++;
                    }
                }, // Accumulator, mely az eredmény értékét növeli attól függően, hogy a második paraméterben Alice-nak vagy Bobnak van-e több pontja
                // Első, melyet módosítani kell
                (int[] a, int[] b) -> {
                    b[0] += a[0];
                    b[1] += a[1];
                } // Combiner, mely a két eredményt összeadja, a második, melyet módosítani kell
        );
    }

}
