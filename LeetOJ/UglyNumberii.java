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
		System.out.println(i.nthUglyNumber4(9));
	}

	
	
	
	
//As I reference to other people's code, I need to rewrite it by myself:
	
//--------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	public int nthUglyNumber4(int n){

		int i2=0,i3=0,i5=0;
		int[] ugly=new int[n];
		ugly[0]=1;

		int next_mutiple_of_2=2;
		int next_mutiple_of_3=3;
		int next_mutiple_of_5=5;
		int next_ugly_no=1;

		for(int i=1;i<n;i++){

		next_ugly_no=Math.min(next_mutiple_of_2,Math.min(next_mutiple_of_3,next_mutiple_of_5));

//		System.out.println(next_mutiple_of_2+" "+next_mutiple_of_3+" "+next_mutiple_of_5);
		
		ugly[i]=next_ugly_no;

		if(next_ugly_no==next_mutiple_of_2){
		    i2++;
		   next_mutiple_of_2=ugly[i2]*2;
		}

		if(next_ugly_no==next_mutiple_of_3){
		    i3++;
		    next_mutiple_of_3=ugly[i3]*3;
		}

		if(next_ugly_no==next_mutiple_of_5){
		    i5++;
		    next_mutiple_of_5=ugly[i5]*5;
		}


		}

		return next_ugly_no;

		}


	
	
	
	
	
	
	
	
	
//--------------------------------------------------------------------------------------------------------------------------------------------	
	
	

	
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
	 * 
	 * 
	 * Accepted.
	 * 
	 * 
	 */
 
	
	public int nthUglyNumber3(int n){
		int i2=0,i3=0,i5=0;
		int[] ugly=new int[n];
		ugly[0]=1;
		int next_mutiply_of_2=ugly[i2]*2;
		int next_mutiply_of_3=ugly[i3]*3;
		int next_mutiply_of_5=ugly[i5]*5;
		int next_ugly_no=1;
		for(int i=1;i<n;i++){
			next_ugly_no=Math.min(next_mutiply_of_5,Math.min(next_mutiply_of_2, next_mutiply_of_3));
 
			ugly[i]=next_ugly_no;
//			System.out.println(next_mutiply_of_2+" "+next_mutiply_of_3+" "+next_mutiply_of_5);
			
			if(next_ugly_no==next_mutiply_of_2){
				i2++;
				next_mutiply_of_2=ugly[i2]*2;

	
			}
			
			if(next_ugly_no==next_mutiply_of_3){
				i3++;
				next_mutiply_of_3=ugly[i3]*3;
	
			}
			
			if(next_ugly_no==next_mutiply_of_5){
				i5++;
				next_mutiply_of_5=ugly[i5]*5;

			}
			
//			System.out.print(next_ugly_no+"  ");
		}
		
		
		return next_ugly_no;
	}
	
	
	
	
	
	
	
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
