/*
 * https://leetcode.com/problems/contains-duplicate-ii/
 * 
Given an array of integers and an integer k, find out whether there are 
two distinct indices i and j in the array such that nums[i] = nums[j] and 
the difference between i and j is at most k.

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
    }
}

 * 
 * 
 */
import java.util.*;
public class ContainsDuplicateII {

	
	
	
	/*
It means one duplicate numbers can appear more than two times.

As we scan the array from 0 to end.  We can replace the previous findings for the same number
as the distance will become bigger and bigger with the increasing s.

	 * 
	 * 
	 * Accepted.
	 * 
	 * 
	 */
	
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        for(int s=0;s<nums.length;s++){
        	if(map.get(nums[s])==null){
        	map.put(nums[s], s);
        	}else{
        		int i=map.get(nums[s]);
        		if(Math.abs(i-s)<=k) {return true;
        		}else{
        		  map.put(nums[s], s);
        		}
        	}
        	
        }
        
        return false;
    }
	
	/*
	 * 
Wrong Answer More Details 

Input:
[1,0,1,1]
1
Output:
false
Expected:
true

Reason: did not consider the [1,0,1,1] case. 
It means one duplicate numbers can appear more than two times.


	 * 
	 */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        for(int s=0;s<nums.length;s++){
        	if(map.get(nums[s])==null){
        	map.put(nums[s], s);
        	}else{
        		int i=map.get(nums[s]);
        		if(Math.abs(i-s)<=k) return true;
        	}
        	
        }
        
        return false;
    }
	
}
