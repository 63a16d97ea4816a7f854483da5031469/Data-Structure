/*
https://leetcode.com/problems/integer-to-roman/

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

public class Solution {
    public String intToRoman(int n) {
 
    }
}


 * 
 * 
 */
public class IntegerToRoman {
    public static void main(String args[]){
    	IntegerToRoman roman=new IntegerToRoman();
    	System.out.println(roman.intToRoman(3978));
    }
    
	/*
	 * 
	 * Accepted.
	 * 
	 * //Reference to the link: http://bangbingsyb.blogspot.sg/2014/11/leetcode-integer-to-roman.html
	 * 
	 */
    
    public String intToRoman(int n) {
    	String dict[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int val[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1}; 
		StringBuilder ret=new StringBuilder();
		for(int i=0;i<13;i++){
			if(n>=val[i]){
				int count=n/val[i];
				n%=val[i];
				for(int j=0;j<count;j++){
					 ret.append(dict[i]);
				}
			}
		}
		
		
		return ret.toString();
    }
    
    
}
