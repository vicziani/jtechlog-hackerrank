package divisiblesumpairs;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int divisibleSumPairs(int n, int k, int[] ar) {
        /*int counter = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if (((ar[i] + ar[j]) % k) == 0) {
                    counter++;
                }
            }
        }
        return counter;*/

        return (int)IntStream
                .range(0, ar.length)
                // .peek(x -> System.err.println(x))
                .mapToObj(i -> IntStream.range(i + 1, ar.length).mapToObj((j) -> new int[]{i, j}))
                .flatMap(x -> x)
                // .peek(x -> System.err.println(Arrays.toString(x)))
                .filter(x -> (ar[x[0]] + ar[x[1]]) % k == 0 )
                .count()
        ;
    }
}
