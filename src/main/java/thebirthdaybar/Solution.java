package thebirthdaybar;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
        public int solve(int n, int[] s, int d, int m){
            // d: sum
            // m: pieces
            return (int) IntStream
                    .range(0, s.length - m + 1)
                    .mapToObj((i) -> subarray(s, i, m))
                    .filter((a) -> sum(a) == d)
                    .count();
        }

    private int sum(int[] a) {
            return Arrays.stream(a).sum();
    }

    private int[] subarray(int[] s, int i, int m) {
            int[] e = new int[m];
            System.arraycopy(s, i, e, 0, m);
            return e;
    }


}
