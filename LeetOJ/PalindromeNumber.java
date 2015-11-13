package ok;

/*
https://leetcode.com/problems/palindrome-number/


Determine whether an integer is a palindrome. Do this without extra space.

public class Solution {
    public boolean isPalindrome(int x) {
        
        
        
    }
}

12 November 2015 at 7:51:31 am

 * 
 * 
 */

public class PalindromeNumber {
	public static void main(String args[]){
		PalindromeNumber p=new PalindromeNumber();
		System.out.println(p.isPalindrome3(2147447412));
	}
	
	// reference to the link: http://blog.csdn.net/sgbfblog/article/details/7799244
	//As I do not know the meaning of the sentence: "Do this without extra space." ---> this means you cannot convert Integer to String. 
	//Does not mean you cannot use any other variable. It means you cannot use too much space to do it.
	
	
	//reverse the number to see whether it is equal to previous number;
	public boolean  isPalindrome3(int x) {
		int tmp=x;
		int reverse=0;
		
		while(tmp!=0){
			reverse=reverse*10+(tmp%10);
			tmp/=10;
		}
 
		
		return reverse==x;
	}
	
	
	
	
	
	public boolean  isPalindrome2(int x) {
		if(x<0) return false;
		
		int div=1;
		while(x/div>=10){
			div*=10;
		}
		
		while(x!=0){
			int l=x/div;
			int r=x%10;
			if(l!=r) return false;
			x=(x%div)/10;
			div/=100;
		}
 
		
		return true;
	}
	
	
	
	
	
	/*
Input:
-2147447412
Output:
true
Expected:
false

Reason: negative number should be non-Palindrome Number.  It is about the definition.

Accepted.


If you are thinking of converting the integer to string, note the restriction of using extra space.
	 * 
	 */
	public boolean  isPalindrome(int x) {
		System.out.println();
		
//		String str=Math.abs(x)+"";
		
		String str=x+"";
		for(int i=0;i<str.length()/2;i++){
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) return false;
		}
		
		
		return true;
	}
	
	
}
