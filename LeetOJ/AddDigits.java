
/*
 * https://leetcode.com/problems/add-digits/
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
For example:
Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?
 * 
 */

public class AddDigits {
	public static void main(String args[]) {
		for (int i = 0; i < 1000; i++)
			System.out.println(i + "->" + getN(i));
	}

	/*
	 * 
	 * You can see the below number's plus result, you will find that 9 numbers
	 * will have a loop.
	 * 
	 * But need to take care of 0, and 9, 18, 27, 36, 45..... These cases.
	 * 
			0 -> 0
			1 -> 1
			2 -> 2
			3 -> 3
			4 -> 4
			5 -> 5
			6 -> 6
			7 -> 7
			8 -> 8
			9 -> 9
			
			10 -> 1
			11 -> 2
			12 -> 3
			13 -> 4
			14 -> 5
			15 -> 6
			16 -> 7
			17 -> 8
			18 -> 9
			19 -> 10
			
			20 -> 2
			21 -> 3
			22 -> 4
			23 -> 5
			24 -> 6
			25 -> 7
			26 -> 8
			27 -> 9
			28 -> 10
			29 -> 11
	 * 
	 */

	public static int getN(int n) {
		// need to consider the special cases for 0 and 9n
		// (n=1,2,3,4,5,6,7,.....)
		if (n == 0)
			return 0;
		if (n % 9 == 0)
			return 9;

		return n % 9; // for normal case, just use n%9

	}

	/*
	 * 
	 * Accepted.
	 * 
	 * However, I used recursion.
	 * 
	 * 
	 * 
	 */

	// public static int getN(int n){
	// int result=0;
	// Integer nObj=(Integer)n;
	// String nstr=nObj.toString();
	//
	// int end=n%10;
	// int begin=n/10;
	//
	// Integer nafter=(Integer)begin;
	// if(nafter.toString().length()!=1){
	// begin=getN(begin);
	// }
	//
	// result=begin+end;
	//
	// while(result>=10){
	// result=getN(begin+end);
	// }
	//
	// return result;
	//
	// }

	/*
	 * First, I believe there is a law behind. So I used normal method to print
	 * out all the results without caring the algorithm optimization.
	 * 
	 * 
	 */

	// by using loop:
	// public static int getN(int n) {
	// int result = 0;
	// while (n != 0) {
	// System.out.println(n%10);
	// result+=n%10;
	// n=n/10;
	// }
	// System.out.println(n%10);
	// return result;
	// }

}
