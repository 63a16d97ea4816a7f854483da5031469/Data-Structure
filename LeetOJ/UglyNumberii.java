/*
 * 
 
https://leetcode.com/problems/ugly-number-ii/

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

public class Solution {
    public int nthUglyNumber(int n) {
        
    }
}

 
13.11.2015 8.11pm 
 
 * 
 */

public class UglyNumberii {
	
	public static void main(String args[]){
		UglyNumberii i=new UglyNumberii();
		System.out.println(i.nthUglyNumber(459));
	}
	
	
	/*
	 * Reference to http://www.geeksforgeeks.org/ugly-numbers/
	 * 
	 * METHOD 2 (Use Dynamic Programming) Here is a time efficient solution with
	 * O(n) extra space. The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10,
	 * 12, 15, … because every number can only be divided by 2, 3, 5, one way to
	 * look at the sequence is to split the sequence to three groups as below:
	 * (1) 1×2, 2×2, 3×2, 4×2, 5×2, … 
	 * (2) 1×3, 2×3, 3×3, 4×3, 5×3, … 
	 * (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
	 * 
	 * We can find that every subsequence is the ugly-sequence itself (1, 2, 3,
	 * 4, 5, …) multiply 2, 3, 5. Then we use similar merge method as merge
	 * sort, to get every ugly number from the three subsequence. Every step we
	 * choose the smallest one, and move one step after.
	 */
	
	
	
	
	
	
	
	
	
	
	/*
	 * 
	 * Submission Result: Time Limit Exceeded More Details
	 * 
	 * Last executed input: 459
	 * 
	 * This method is not time efficient as it checks for all integers until
	 * ugly number count becomes n, but space complexity of this method is O(1)
	 * Reference to http://www.geeksforgeeks.org/ugly-numbers/
	 * 
	 */

	public int getMaxN(int n, int m) {

		int result = 1;
		while (n % m == 0) {
			n /= m;
			result *= m;
		}
		return result;

	}

	public boolean isUgly(int n) {

		if (n < 2)
			return n == 1;

		n /= getMaxN(n, 2);
		n /= getMaxN(n, 3);
		n /= getMaxN(n, 5);

		if (n == 1)
			return true;

		return false;

	}

	public int nthUglyNumber(int n) {
		int count = 0;
		int i = 0;
		while (count < n) {
			i++;
			if (isUgly(i))
				count++;
		}
		return i;
	}
}
