package betweentwosets;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BetweenPartsTest {

    private Solution s = new Solution();

    @Test
    public void primeFactorization() {
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(2, 2);
        expected.put(5, 1);
        assertThat(s.primeFactorization(20), equalTo(expected));
    }

    @Test
    public void lcm() {
        int i = 47311;
        int j = 60401;
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(17, 2);
        expected.put(19, 1);
        expected.put(23, 1);
        expected.put(11, 2);
        assertThat(s.lastCommonMultiple(
                s.primeFactorization(i),
                s.primeFactorization(j)), equalTo(expected));
    }

    @Test
    public void gcd() {
        int i = 32;
        int j = 96;
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(2, 5);
        assertThat(s.greatestCommonDivisor(
                s.primeFactorization(i),
                s.primeFactorization(j)

        ), equalTo(expected));
    }

    @Test
    public void div() {
        int i = 100;
        int j = 20;
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(5, 1);
        expected.put(2, 0);
        assertThat(s.div(s.primeFactorization(i), s.primeFactorization(j)).get(), equalTo(expected));
    }

}
