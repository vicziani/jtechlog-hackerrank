package divisiblesumpairs;

import hackerrank.HackerrankRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Scanner;

public class SolutionTest {

    @Rule
    public final HackerrankRule hackerrankRule = new HackerrankRule();

    @Test
    public void test() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = new Solution().divisibleSumPairs(n, k, ar);
        System.out.println(result);
    }

}
