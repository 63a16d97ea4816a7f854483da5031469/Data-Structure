/*
 * 
 * 
https://leetcode.com/problems/number-of-1-bits/
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
    }
}


 * 
 * Accepted.
 */
public class NumberOf1Bits {

	public static void main(String args[]){
		NumberOf1Bits bit=new NumberOf1Bits();
		System.out.println(bit.hammingWeight(123));
	}
	
	public int hammingWeight(int n){
	
	String nstr=Integer.toBinaryString(n);
	int count=0;
	for(int i=0;i<nstr.length();i++){
		if(nstr.charAt(i)=='1'){
			count++;
		}
	}
		
	return count;
	
	}
}






























