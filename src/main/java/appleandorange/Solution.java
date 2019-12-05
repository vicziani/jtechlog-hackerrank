package appleandorange;

import java.util.Arrays;

public class Solution {
    public long[] count(int s, int t, int a, int b, int[] apple, int[] orange) {
        return new long[] {
                count(s, t, a, apple),
                count(s, t, b, orange)
        };

    }

    public long count(int s, int t, int base, int[] fruits) {
        return Arrays.stream(fruits).filter((i) -> between(base + i, s, t)).count();
    }

    public static boolean between(int i, int start, int end) {
        return start <= i && i <= end;
    }


}
