/*
https://leetcode.com/problems/valid-parentheses/
Valid Parentheses My Submissions Question

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Subscribe to see which companies asked this question

public class Solution {
    public boolean isValid(String s) {
        
    }
}

 * 
 * 
 */

import java.util.*;

public class ValidParentheses {

	public static void main(String args[]){
		ValidParentheses v=new ValidParentheses();
		System.out.println(v.isValid("["));
	}
	
	
	/*
	 * Accepted.
	 * 
	 */
	
	public boolean isValid(String s){
		
		Stack<String> s1=new Stack<String>();
		Stack<String> s2=new Stack<String>();
		
		for(int i=0;i<s.length();i++){
			char tmpc=s.charAt(i);
			s1.push(tmpc+"");
		}
			
		while(!s1.isEmpty()){
			
			if(s2.isEmpty()){
				s2.push(s1.pop());
			}else{
				if(isMatch(s1.peek(),s2.peek())) {
					s1.pop();
					s2.pop();
				}else{
					s2.push(s1.pop());
				}
			}
			
		}
		
		if(!s2.isEmpty()) return false;
		
		return true;
	}
	
	public boolean isMatch(String s1,String s2){
		
		if( (s1.equals("{")&&s2.equals("}"))|| (s1.equals("}")&&s2.equals("{")) ){
			return true;
		}
		
		if( (s1.equals("[")&&s2.equals("]"))|| (s1.equals("]")&&s2.equals("[")) ){
			return true;
		}
		
		if( (s1.equals("(")&&s2.equals(")"))|| (s1.equals(")")&&s2.equals("(")) ){
			return true;
		}
		
		return false;
	}
	
	
	
}
