package birthdaycakecandles;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;

import hackerrank.HackerrankRule;


public class BirthdayCakeCandlesTest {
	
	@Rule
	public HackerrankRule hackerrankRule = new HackerrankRule();
	
	@Test
	public void test() {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = new Solution().birthdayCakeCandles(n, ar);
        System.out.println(result);
	}

}
