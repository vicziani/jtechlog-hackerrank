package betweentwosets;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BetweenParts2Test {

    @Test
    public void gcd() {
        int i = 32;
        int j = 96;
        assertThat(new Solution2().greatestCommonDivisor(i, j), equalTo(32));
    }

}
