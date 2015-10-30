/*

https://leetcode.com/problems/power-of-two/

Given an integer, write a function to determine if it is a power of two.

public class Solution {
    public boolean isPowerOfTwo(int n) {
        
    }
}

 * 
 */
public class PowerOfTwo {

	public static void main(String args[]){
		
		for(int i=1073741821;i<1999999999;i++)
			System.out.println(i+" "+isPowerOfTwo4(i));
		
	}
	
	
	
	/*
	 * 
	 * Suppose int is overflow
	 * 
	 * Changed it to long.
	 * 
	 * 
	 * Accepted.
	 * 
	 */
	  public static boolean isPowerOfTwo4(int n) {
	    	
//			long startTime = System.currentTimeMillis();	
			
	    	if(n==0) return false;
	    	if(n==1) return true;
	    	
	    	long curr=1;
	    	long prev=1;
	    	while(true){
	    		prev=curr;
//	    		curr=curr*2;
	    		curr=curr<<1;
	    		
	    		if(curr==n) {
//	        		long endTime   = System.currentTimeMillis();
//	        		
//	        		long totalTime = endTime - startTime;
//	        		System.out.println("running time(second):"+totalTime/1000);
	    			return true;

	    		}
	    		if(prev<n&&curr>n) {
//	    		long endTime   = System.currentTimeMillis();
//	    		
//	    		long totalTime = endTime - startTime;
//	    		System.out.println("running time(second):"+totalTime/1000);
	    		return false;
	    		}

	    	}
	    	

	    
	    }
	
	
	
	
	
	
	
	
	/*
	 * 
	 * Use >>
	 * 
<<      :     左移运算符，num << 1,相当于num乘以2

>>      :     右移运算符，num >> 1,相当于num除以2
	 * 
	 */
	
	
	/*
Submission Result: Time Limit Exceeded More Details 

Last executed input:
1073741825


So maybe it is because the int is overflow. Change it to long.
	 * 
	 */
	
    public static boolean isPowerOfTwo3(int n) {
    	
//		long startTime = System.currentTimeMillis();	
		
    	if(n==0) return false;
    	if(n==1) return true;
    	
    	int curr=1;
    	int prev=1;
    	while(true){
    		prev=curr;
//    		curr=curr*2;
    		curr=curr<<1;
    		
    		if(curr==n) {
//        		long endTime   = System.currentTimeMillis();
//        		
//        		long totalTime = endTime - startTime;
//        		System.out.println("running time(second):"+totalTime/1000);
    			return true;

    		}
    		if(prev<n&&curr>n) {
//    		long endTime   = System.currentTimeMillis();
//    		
//    		long totalTime = endTime - startTime;
//    		System.out.println("running time(second):"+totalTime/1000);
    		return false;
    		}

    	}
    	

    
    }
	
	
	
	
	/*
	 * come up with another idea:
	 * 
	 * it is just like a search, use loop to see when could we find the same number,
	 * or find one smaller number and another bigger number compared with the input number.

Status: Time Limit Exceeded
Submitted: 0 minutes ago
Last executed input:
1073741825
	 * 
	 */
	
    public static boolean isPowerOfTwo2(int n) {
    	
		long startTime = System.currentTimeMillis();	
		
    	if(n==0) return false;
    	if(n==1) return true;
    	
    	int curr=1;
    	int prev=1;
    	while(true){
    		prev=curr;
    		curr=curr*2;
    		
    		if(curr==n) {
        		long endTime   = System.currentTimeMillis();
        		
        		long totalTime = endTime - startTime;
        		System.out.println("running time(second):"+totalTime/1000);
    			return true;

    		}
    		if(prev<n&&curr>n) {
    		long endTime   = System.currentTimeMillis();
    		
    		long totalTime = endTime - startTime;
    		System.out.println("running time(second):"+totalTime/1000);
    		return false;
    		}

    	}
    	

    
    }
	
	
	/*
	 * 
print out:
0 false
1 false
2 true
3 false
4 true
5 false
6 false
7 false
8 true
9 false
10 true
11 false
12 false
13 false
14 false
15 false
16 true
17 false
18 true
19 false
20 true
21 false
22 true
23 false
24 false
25 false
26 false
27 false
28 false
29 false
30 false
31 false


	 * 
	 * 
	 */
    public static boolean isPowerOfTwo(int n) {
        if(n%2!=0) return false;
    	if(n==0) return false;
    	if(n==1) return true;
    	int m=0;
    	while(true){
    		m=n%2;
    		n=n/2;

    		if(n==0&&m!=0) return false;
    		if(n==1&&m==0) return true;
    		
    	}
    	
 
    }
	
	
}
