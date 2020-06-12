package ok;

/*
https://leetcode.com/problems/powx-n/

Implement pow(x, n).

public class Solution {
    public double myPow(double x, int n) {
        
    }
}

12 November 2015 at 9:12:23 pm

 * 
 * 
 */
public class PowXN {
/*
 31
 15
 7
 3
 1
 0
 * 
 */
	public static void main(String args[]){
		System.out.println(pow(2,31));
	}
	
/*
 * 
2. Recursive Method

Naturally, we next may think how to do it in O(logn). We have a relation that x^n = x^(n/2) * x^(n/2) * x^(n%2). By using this relation, a recursive solution can easily be written.

In this solution, we can handle cases that x < 0 and n < 0. This solution actually takes more time than the first solution(Naive Method). Why?
 * 	
 */
//	public static double pow(double x, int n) {
//	    if(n == 0) 
//	        return 1;
//	 
//	    if(n == 1) 
//	        return x;
//	 
//	    int half = n/2;
//	    int remainder = n%2; 
//	    
//	    System.out.println(x+" "+n+" ");
//	 /*
//	  * 
//2.0 31 
//2.0 15 
//2.0 7 
//2.0 3 
//2.0 3 
//2.0 7 
//2.0 3 
//2.0 3 
//2.0 15 
//2.0 7 
//2.0 3 
//2.0 3 
//2.0 7 
//2.0 3 
//2.0 3 
//2.147483648E9
//
//	  * 
//	  */
//	 
//	    if(n % 2 ==1 && x < 0 && n < 0)
//	        return - 1/(pow(-x, half) * pow(-x, half) * pow(-x, remainder));
//	    else if (n < 0)
//	        return 1/(pow(x, -half) * pow(x, -half) * pow(x, -remainder));
//	    else 
//	        return (pow(x, half) * pow(x, half) * pow(x, remainder));
//	}
	
	
	//reference to the link: http://www.programcreek.com/2012/12/leetcode-powx-n/
	//Accepted. Best solution!
	
	
	public static double power(double x, int n) {
		if (n == 0)
			return 1;
	 
		double v = power(x, n / 2);
//	 System.out.println(v+" "+n/2);
	 /*
1.0 0
2.0 1
8.0 3
128.0 7
32768.0 15
2.147483648E9 
	  */
		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
		}
	}
	 
	public static double pow(double x, int n) {
		if (n < 0) {
			return 1 / power(x, -n);
		} else {
			return power(x, n);
		}
	}
	
	

	
	
	
	/*
	 * 
	Time Limit Exceeded More Details 

Last executed input:
0.00001
2147483647

Time Limit Exceeded More Details 

Last executed input:
1.00000
2147483647

Time Limit Exceeded More Details 

Last executed input:
-1.00000
2147483647


Input:
0.44528
0
Output:
0.00000
Expected:
1.00000

	 * 
	 */
	public static double myPow(double x, int n){
		/*
		 * n>0
		 * n=0
		 * n<0
		 * 
		 * x>0
		 * x=0
		 * x<0
		 * 
		 * Naive Method
		 */
		
 		if((int)Math.abs(x)==0) return 0;
 		if((int)Math.abs(x)==1) return 1;
 		
		if (x == 0)
			return 0;
		if (n == 0)
			return 1;

		double result = 1;

		if (n > 0) {
			for (int i = 0; i < n; i++) {
				result *= x;
			}
		} else {

			if (n < 0) {
				for (int i = 0; i < Math.abs(n); i++) {
					result /= x;
				}
			}
		}
		
		return result;
	}
	
}
