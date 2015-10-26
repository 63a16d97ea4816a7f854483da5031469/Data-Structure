
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
		for(int i=0;i<1000;i++)
		System.out.println(i+"->"+getN(i));
	}
	
	public static int getN(int n){
		int result=0;
		Integer nObj=(Integer)n;
		String nstr=nObj.toString();

		int end=n%10;
		int begin=n/10;
		
		Integer nafter=(Integer)begin;
		if(nafter.toString().length()!=1){
			begin=getN(begin);
		}
		
		result=begin+end;
		
		while(result>=10){
			result=getN(begin+end);
		}
		
	return result;

	}

// by using loop:
//	public static int getN(int n) {
//		int result = 0;
//		while (n != 0) {
//		System.out.println(n%10);
//			result+=n%10;
//			n=n/10;
//		}
//		System.out.println(n%10);
//		return result;
//	}

}
