import java.util.HashMap;

/*
 * 
https://leetcode.com/problems/happy-number/

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process:
 Starting with any positive integer,
 replace the number by the sum of the squares of its digits, 
 and repeat the process until the number equals 1 (where it will stay), 
 or it loops endlessly in a cycle which does not include 1. 
 Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

define m,n means Math.pow(m,n)


Math.pow(1,2) + Math.pow(9,2) = 82
8,2 + 2,2 = 68
6,2 + 8,2 = 100
1,2 + 0,2 + 0,2 = 1


public class Solution {
    public boolean isHappy(int n) {
        
    }
}

 */


/*
 * 
1 0
1,1

analysis:
 Starting with any positive integer,   0,1,2,3,4,5,6

 * 
 */

public class HappyNumber {
	
	public static void main(String args[]){
		 System.out.println(isHappy2(123));
	}
	
	
	
	/*
	 * According to previous test to improve the method
	 * 
	 * From previous test, we get to know that the first 
	 * number will be the head of loop number. So we save the first appeared number.
	 * 
	 * so the question becomes how could we detect the loop fast enough?
	 * 
	 * when will become endless loop?
	 * answer: if there are repeated numbers.
	 * 
	 * Do you remember something? ---> Yes, it becomes how to detect the repeated numbers.
	 * 
	 * --->HashMap
	 * 
	 * 
	 * Accepted:
	 * 
	 */
	public static boolean isHappy2(int n){
		
		if(n==1) return true;
		if(n==0) return false;
		
		HashMap map=new HashMap();
		
		int firstN=getN2(n);
		map.put(firstN, 1);
 
		while(true){
			if(firstN!=1){
//				System.out.println(firstN);
			firstN=getN2(firstN);
			if(map.get(firstN)!=null) return false;
			map.put(firstN, 1);
			
			}else{
				return true;
			}
		}
		
		
	}
	
	
	public static int getN2(int n){
		
		if(n==1) return 1;
		if(n==0) return 0;
		
		int sum=0;
		
		// get each digital of the number and do the sum;
		while(n/10!=0){
			sum+=Math.pow(n%10, 2);
			n=n/10;
		}
		
		sum+=Math.pow(n, 2);
		
		return sum;
	}
	
	
	
	
	/*
	 * implement the stupid method first to see the law
	 * 
	 * Use 123 to try:  print out:
37
58
89
145
42
20
4
16
37
58
89
145
42
20
4
16
37
58
89
145
42
20

get to know that there are loops in the non-happy number.
It gives us some idea to mark when should terminate the loop.
	 * 
	 * 
	 */
	public static boolean isHappy(int n){
		
		if(n==1) return true;
		if(n==0) return false;
		
		int firstN=getN(n);
		
		while(true){
			if(firstN!=1){
				System.out.println(firstN);
			firstN=getN(firstN);
			}else{
				return true;
			}
		}
		
		
	}
	
	
	public static int getN(int n){
		
		if(n==1) return 1;
		if(n==0) return 0;
		
		int sum=0;
		
		// get each digital of the number and do the sum;
		while(n/10!=0){
			sum+=Math.pow(n%10, 2);
			n=n/10;
		}
		
		sum+=Math.pow(n, 2);
		
		return sum;
	}
	
	
}
