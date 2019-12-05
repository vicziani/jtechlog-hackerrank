package migratorybirds;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MigratoryBirds {
    public int migratoryBirds(int n, int[] ar) {
        return Arrays.stream(ar).mapToObj(Integer::valueOf).collect(
                Collectors.toMap( i -> i,
                        i -> new AtomicInteger(1),
                        (i,  j) -> new AtomicInteger(i.get() + j.get()),
                        () -> new TreeMap<>()
                )).entrySet().stream().max(Comparator.comparing(e -> e.getValue().get()))
                .get().getKey();
    }
}
