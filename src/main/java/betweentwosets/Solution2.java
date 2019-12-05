package betweentwosets;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution2 {

    public int getTotalX(int[] a, int[] b) {
        int lcm = lastCommonMultiple(a);
        System.err.println(lcm);
        int gcd = greatestCommonDivisor(b);
        System.err.println(gcd);
        if (gcd % lcm != 0) {
            return 0;
        }
        int num = gcd / lcm;
        System.err.println(num);
        return (int) IntStream.rangeClosed(1, num).filter(i -> num % i == 0).count();
    }

    public int greatestCommonDivisor(int[] a) {
        return Arrays.stream(a).reduce(a[0], this::greatestCommonDivisor);
    }

    public int lastCommonMultiple(int[] b) {
        return Arrays.stream(b).reduce(b[0], this::lastCommonMultiple);
    }

    // lnko
    public int greatestCommonDivisor(int a, int b) {
        return Stream.iterate(new int[]{Math.max(a, b), Math.min(a, b)}, t -> new int[]{t[1], t[0] % t[1]})
                .filter(t -> t[1] == 0).findFirst().get()[0];
    }

    // lkkt
    public int lastCommonMultiple(int a, int b) {
        return a * b / greatestCommonDivisor(a, b);
    }

}