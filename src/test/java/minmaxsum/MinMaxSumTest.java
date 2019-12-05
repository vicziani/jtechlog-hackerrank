package minmaxsum;

import hackerrank.HackerrankRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Scanner;

public class MinMaxSumTest {

    @Rule
    public HackerrankRule hackerrankRule = new HackerrankRule();

    @Test
    public void test() {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }

        new Solution().minmax(arr);
    }
}
