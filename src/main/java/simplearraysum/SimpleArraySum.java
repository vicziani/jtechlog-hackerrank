package simplearraysum;

import java.util.Arrays;

public class SimpleArraySum {

    public int simpleArraySum(int n, int[] ar) {
        return (int) Arrays.stream(ar).asDoubleStream().sum();
    }
}
