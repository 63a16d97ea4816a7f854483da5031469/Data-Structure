//https://leetcode.com/problems/single-number/

/*
 * 
 Given an array of integers, every element appears twice except for one.
 Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. 
 Could you implement it without using extra memory?

public class Solution {
    public int singleNumber(int[] nums) {
        
    }
}

 * 
 */

import java.util.*;
public class SingleNumber {
	public static void main(String args[]){
		int[] nums={1,1,2,2,5,6,6};
		System.out.println(singleNumber(nums));
	}
	
	
	/*
	 * 2(a+b+c+d...+n)-(a+a+b+b+c+d+d....+n+n)=c
	 * 
	 * c is that single number
	 * 
	 * Accepted.
	 * 
	 */
	
    public static int singleNumber(int[] nums) {
        
    	int result=0;
    	int doubleSumResult=0;
    	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    	for(int tmp:nums){
    		if(map.get(tmp)==null){
    			doubleSumResult+=tmp*2;
    			map.put(tmp, 1);
    		}
    		result+=tmp;
    	}
    	result=doubleSumResult-result;
    	
    	return result;
    }
	
}
