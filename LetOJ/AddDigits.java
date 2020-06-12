package ok;


/*
 * https://leetcode.com/problems/add-digits/
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
For example:
Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?

28 October 2015 at 12:30:06 pm
 * 
 */

public class AddDigits {
	public static void main(String args[]) {
		for (int i = 0; i < 1000; i++)
			System.out.println(i + "->" + getN(i));
	}

	
	/*
	 * 解题思考：
	 * 这个问题，一上来，需要做一些简单的动手写几个数试一试，
	 * 然后，觉得可能是有规律的，所以先使用最笨的方法（不考虑任何限制），
	 * 直接实现出来，打出来1000个可能，然后看规律。
	 * 
	 * 最后抽象出最简单的规律，直接用公式做出来结果。但是还是要考虑这个公式
	 * 是否适合一些情况，发现0和9n（n=1,2,3,4,5,6....）的情况比较特殊。
	 * 需要特殊考虑，其它的情况用n%9这个公式。
	 * 
	 */
	
	
	
	
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
