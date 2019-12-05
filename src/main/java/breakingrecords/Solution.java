package breakingrecords;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Solution {

    public int[] getRecord(int[] scores) {
        return Arrays.stream(scores).mapToObj((i) -> i).collect(new Stat()).toArray();
    }

    private class Stat implements Collector<Integer, Stat, Stat> {
        private int maxRecord = Integer.MIN_VALUE;

        private int minRecord = Integer.MAX_VALUE;

        private int maxCounter = -1;

        private int minCounter = -1;

        private void add(Integer i) {
            if (maxRecord < i) {
                maxRecord = i;
                maxCounter++;
            }
            if (minRecord > i) {
                minRecord = i;
                minCounter++;
            }
        }

        private Stat add(Stat another) {
            Stat result = new Stat();
            result.maxRecord = Math.max(maxRecord, another.maxRecord);
            result.minRecord = Math.min(minRecord, another.minRecord);
            result.minCounter = minCounter + another.minCounter;
            result.maxCounter = maxCounter + another.maxCounter;
            return result;
        }

        private int[] toArray() {
            return new int[]{maxCounter, minCounter};
        }

        @Override
        public Supplier<Stat> supplier() {
            return () -> new Stat();
        }

        @Override
        public BiConsumer<Stat, Integer> accumulator() {
            return Stat::add;
        }

        @Override
        public BinaryOperator<Stat> combiner() {
            return Stat::add;
        }

        @Override
        public Function<Stat, Stat> finisher() {
            return null;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return new HashSet<>(Arrays.asList(Characteristics.CONCURRENT, Characteristics.UNORDERED, Characteristics.IDENTITY_FINISH));
        }

        @Override
        public String toString() {
            return "Stat{" +
                    "maxRecord=" + maxRecord +
                    ", minRecord=" + minRecord +
                    ", maxCounter=" + maxCounter +
                    ", minCounter=" + minCounter +
                    '}';
        }
    }
}
