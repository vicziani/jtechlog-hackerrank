package grading;

import java.util.Arrays;

public class Solution {
    public int[] solve(int[] grades) {
        return Arrays.stream(grades).map(Solution::round).toArray();
    }

    private static int round(int i) {
        if (i < 38) {
            return i;
        }
        else {
//            int next = ((i / 5) + 1) * 5;
//            if ((next - i) < 3) {
//                return next;
//            }
//            else {
//                return i;
//            }
            return (i % 5 < 3) ? i : ((i / 5) + 1) * 5;
        }
    }
}
