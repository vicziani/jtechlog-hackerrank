package simplearraysum;

import hackerrank.HackerrankRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Scanner;

public class SimpleArraySumTest {

    @Rule
    public final HackerrankRule hackerrankRule = new HackerrankRule();

    @Test
    public void test() {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] ar = new int[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = input.nextInt();
        }

        int result = new SimpleArraySum().simpleArraySum(n, ar);

        System.out.println(result);
    }
}
