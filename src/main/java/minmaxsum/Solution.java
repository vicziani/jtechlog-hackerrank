package minmaxsum;

import java.util.Arrays;
import java.util.LongSummaryStatistics;
//import java.util.stream.IntStream;



public class Solution {
    public void minmax(int[] arr) {
//        LongSummaryStatistics stat = IntStream.range(0, arr.length)
//                .mapToLong((i) -> IntStream.range(0, arr.length).filter((j) -> j != i).mapToLong((j) -> (long) arr[j]).sum()
//                ).summaryStatistics();
//        System.out.println(stat.getMin() + " " + stat.getMax());

        LongSummaryStatistics stat = Arrays.stream(arr).mapToLong((i) -> i).summaryStatistics();
        System.out.printf("%d %d", stat.getSum() - stat.getMax(), stat.getSum() - stat.getMin());
    }
}
