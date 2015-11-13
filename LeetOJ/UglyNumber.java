package ok;

/*
 * 
https://leetcode.com/problems/ugly-number/

prime number 素数; 质数; 量数; 素数;质数;

Ugly Number
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.

public class Solution {
    public boolean isUgly(int num) {
        
    }
}

13 November 2015 at 8:17:37 pm

 * 
 */

//reference to the link: http://www.geeksforgeeks.org/ugly-numbers/
/*
 *  1,1,2,3,5,8,13
 * 
 */
public class UglyNumber {
	
	public static void main(String args[]) {
		UglyNumber un = new UglyNumber();
		int n = 100;
		for (int i = 1; i < n; i++)
			System.out.println(i + " " + un.isUgly(i));
	}
	
	
	//As you reference to other people's code, you need to rewrite the code:
//---------------------------------------------------------------------------------------------------
	

	public boolean isUgly3(int n){
		if(n<2) return n==1;     // if negative, should be the false;  if n==0, should be false;

		while(n%2==0){
			n/=2;
		}

		while(n%3==0){
			n/=3;
		}

		while(n%5==0){
			n/=5;
		}

		if(n==1) return true;

		return false;
	}
	
	
	
	
	
	
//---------------------------------------------------------------------------------------------------	
	
	
	
	
	
	//accepted:
	//https://leetcode.com/discuss/67158/simple-java-solution-with-neat-code
	
	public class Solution {
		  public boolean isUgly(int num) {
		    if(num<2) return num==1;
		    while(num%2==0){
		        num=num/2;
		    }
		    while(num%3==0){
		        num=num/3;
		    }
		    while(num%5==0){
		        num=num/5;
		    }
		    return num==1;
		}
		}
	
	
	
	/*
Time Limit Exceeded More Details 

Last executed input:
0
	 */
//------------------------------------------------------------------------------------------------------------
	public int getMaxN(int n, int m) {

		int result = 1;
		while (n % m == 0) {
			n /= m;
			result *= m;
		}

		return result;

	}

	public boolean isUgly(int n) {

		if (n == 1)
			return true;
		
		
		/*
		 * Accepted by using follow sentences:
		 	if (n == 1) return true;
			if (n==0) return false;
			if (n<0) return false;
		 * 
		 * 
		 */
		
		
		/*  should be:
		 * 
		 * 		if (n <2)
			return n==1;
			
			Need to consider the 0 case
		 * 
		 */

		n /= getMaxN(n, 2);
		n /= getMaxN(n, 3);
		n /= getMaxN(n, 5);

		if (n == 1)
			return true;

		return false;

	}

}
//------------------------------------------------------------------------------------------------------------















