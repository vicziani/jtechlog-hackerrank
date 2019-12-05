package birthdaycakecandles;

import java.util.Arrays;

public class Solution {

	public int birthdayCakeCandles(int n, int[] ar) {
		
		return Arrays.stream(ar).collect(
				() -> new int[2], // Supplier, létrehoz egy üres eredményt
                (int[] a, int b) -> {
                    if (a[0] < b) {
                    	a[0] = b;
                    	a[1] = 1;
                    }
                    else if (a[0] == b) {
                    	a[1]++;
                    }
                }, 
                // Első, melyet módosítani kell
                (int[] a, int[] b) -> {
                    if (b[0] < a[0]) {
                    	b[0] = a[0];
                    	b[1] = a[1];
                    }
                    else if (b[0] == a[0]) {
                    	b[1] += a[1];
                    }
                })[1]; // Combiner, mely a két eredményt összeadja, a második, melyet módosítani kell)
	}

}
