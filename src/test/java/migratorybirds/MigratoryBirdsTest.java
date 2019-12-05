package migratorybirds;

import hackerrank.HackerrankRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Scanner;

public class MigratoryBirdsTest {

    @Rule
    public HackerrankRule hackerrankRule = new HackerrankRule();

    @Test
    public void testMigratoryBirds() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = new MigratoryBirds().migratoryBirds(n, ar);
        System.out.println(result);
    }
}
