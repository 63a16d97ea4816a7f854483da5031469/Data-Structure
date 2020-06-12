package ok;



/*
 * 
https://leetcode.com/problems/length-of-last-word/

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.

public class Solution {
    public int lengthOfLastWord(String s) {
        
    }
}

31 October 2015 at 8:55:43 pm

 * 
 */



public class LengthOfLastWord {
	
	
	public static void main(String args[]){
		System.out.println(lengthOfLastWord2(new String("    a aa")));
	}
	
	
	/*
	 * 
	 * Accepted.
	 * 
	 */
	
    public static int lengthOfLastWord2(String s) {
        
    	int result=0;
 
    	
    	String[] splitArr=s.split(" ");
    	
    	if(splitArr.length==0) return 0;
    	
    	result=splitArr[splitArr.length-1].length();
    	
    	return result;
    	
    }
    
	
	
    /*

    Runtime Error Message:
    Line 7: java.lang.ArrayIndexOutOfBoundsException: -1
    Last executed input:
    " "

    Reason: I did not consider very special cases.
     * 
     * 
     */
	
    public static int lengthOfLastWord(String s) {
    
    	int result=0;
    	
    	String[] splitArr=s.split(" ");
    	
    	result=splitArr[splitArr.length-1].length();
    	
    	return result;
    	
    }
    
    
    
}
