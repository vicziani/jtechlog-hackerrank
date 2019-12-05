package change;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ChangeTest {

    @Test
    public void testSimpleCases() {
        Change change = new Change();
        List<Integer> denominations = Arrays.asList(1, 2, 5, 10);

        int input = 18;

        assertThat(change.changeRec(input, denominations), equalTo(expectedMap(10, 1, 5, 1, 2, 1, 1, 1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotSolvable() {
        Change change = new Change();
        List<Integer> denominations = Arrays.asList(2, 5);
        int input = 8;
        change.changeRec(input, denominations);
    }

    private Map<Integer, Integer> expectedMap(int... n) {
        Map<Integer, Integer> expected = new HashMap<>();
        for (int i = 0; i < n.length; i += 2) {
            expected.put(n[i], n[i + 1]);
        }
        return expected;
    }
}
