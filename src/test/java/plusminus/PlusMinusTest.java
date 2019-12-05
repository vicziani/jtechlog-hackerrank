package plusminus;

import hackerrank.HackerrankRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PlusMinusTest {

    @Rule
    public HackerrankRule hackerrankRule = new HackerrankRule();

    @Test
    public void testSolution() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = IntStream.range(0, n)
                .map(i -> scanner.nextInt())
                .toArray();
        new Solution().execute(arr);
    }
    
}