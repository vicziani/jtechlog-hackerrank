package timeconversion;

import hackerrank.HackerrankRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Scanner;

public class TimeConversionTest {

    @Rule
    public final HackerrankRule hackerrankRule = new HackerrankRule();

    @Test
    public void test() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = new Solution().timeConversion(s);
        System.out.println(result);
    }
}
