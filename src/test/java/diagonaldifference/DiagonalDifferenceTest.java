package diagonaldifference;

import hackerrank.HackerrankRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Scanner;

public class DiagonalDifferenceTest {

    @Rule
    public final HackerrankRule hackerrankRule = new HackerrankRule();

    @Test
    public void test() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        // Trükk, az első elem tartamazza, hogy ez hanyadik sor
        int[][] numbers = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                numbers[i][0] = i;
                numbers[i][j+1] = in.nextInt();
            }
        }

        System.out.println(new Solution().difference(numbers));
    }

}
