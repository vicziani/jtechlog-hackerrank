package betweentwosets;

import hackerrank.HackerrankRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Scanner;

public class BetweenTwoSetsTest {

    @Rule
    public HackerrankRule hackerrankRule = new HackerrankRule();

    @Test
    public void testSolution() {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            for(int a_i = 0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int[] b = new int[m];
            for(int b_i = 0; b_i < m; b_i++){
                b[b_i] = in.nextInt();
            }
            int total = new Solution2().getTotalX(a, b);
            System.out.println(total);
            in.close();
    }
}
