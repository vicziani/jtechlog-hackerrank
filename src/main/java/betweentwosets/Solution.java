package betweentwosets;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public int getTotalX(int[] a, int[] b) {

        Map<Integer, Integer> lcm = Arrays.stream(a)
                    .mapToObj(this::primeFactorization)
                    .reduce(this::lastCommonMultiple).get();

//        System.out.println("lcm: " + lcm);

        Map<Integer, Integer> gcd = Arrays.stream(b)
                .mapToObj(this::primeFactorization)
                .reduce(this::greatestCommonDivisor).get();
//        System.out.println("gcd: " + gcd);

        Optional<Map<Integer, Integer>> div = div(gcd, lcm);
        if (!div.isPresent()) {
            return 0;
        }
//        System.out.println("div: " + div);

        int ret = div.get().values().stream().mapToInt((x) ->  x + 1).reduce(1, (x, y) -> x * y);

//        System.out.println("ret: " + ret);

        return ret;
    }

    public Optional<Map<Integer, Integer>> div(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        if (b.isEmpty()) {
            return Optional.of(a);
        }
        try {
            Map<Integer, Integer> ret = Stream.of(a, b).map(Map::entrySet).flatMap(Collection::stream).collect(Collectors.toMap(
                    Map.Entry::getKey,
                    (entry) -> {
                        int aExponent = a.getOrDefault(entry.getKey(), 0);
                        int bExponent = b.getOrDefault(entry.getKey(), 0);
                        if (bExponent > aExponent) {
                            throw new IllegalArgumentException("Can not div");
                        }
                        return aExponent - bExponent;
                    },
                    (x, y) -> x

            ));
            return Optional.of(ret);
        }
        catch (IllegalArgumentException iae) {
            return Optional.empty();
        }
    }

    // lnko
    public Map<Integer, Integer> greatestCommonDivisor(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        Map<Integer, Integer> ret = a.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                (entry) -> Math.min(entry.getValue(), b.getOrDefault(entry.getKey(), 0))
        ));
//        System.out.printf("gcd(%s, %s) = %s\n", a.toString(), b.toString(), ret.toString());
        return ret;
    }

    // lkkt
    public Map<Integer, Integer> lastCommonMultiple(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        return Stream.of(a, b)
                .map(Map::entrySet)
                .flatMap(Collection::stream)
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                Integer::max

                        )
                );
    }

    public Map<Integer, Integer> primeFactorization(int n) {
        Map<Integer, Integer> ret = new HashMap<>();
        int i = n;
        while (i != 1) {
            int act = i;
            int factor = IntStream.range(2, (int) Math.round(Math.sqrt(act)) + 1)
                    .filter((k) -> act % k == 0)
                    .findFirst()
                    .orElse(act);
            ret.merge(factor, 1, (t, u) -> t + u);
            i /= factor;
        }
        return ret;
    }
}
