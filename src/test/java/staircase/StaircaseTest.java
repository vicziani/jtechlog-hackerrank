package staircase;

import hackerrank.HackerrankRule;
import org.junit.Rule;
import org.junit.Test;

public class StaircaseTest {

    @Rule
    public final HackerrankRule hackerrankRule = new HackerrankRule();

    @Test
    public void test() {
        new Solution().drawStaircase();
    }
}
