/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the new length.

public class Solution {
    public int removeDuplicates(int[] nums) {
        
    }
}


 */














//Given input array nums = [1,1,2],

import java.util.*;

public class RemoveDuplicatesfromSortedArray {

	public static void main(String args[]) {
		
//		int[] arr={1,1,2,3,4,5,5,2,4};
		int[] arr={1,1,2};
		System.out.println(removeDuplicates(arr));
		
		
		for(int tmp:arr){
			System.out.print(tmp+" ");
		}
		
		

	}

	
	/*
	 * Accepted.
	 * 
	 */
	public static int removeDuplicates(int[] nums) {
		
 
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		int prevIndex=0;
		
		for (int i=0;i<nums.length;i++) {

			// mark this value
			if (map.get(nums[i]) == null) {
				map.put(nums[i], "");
				nums[prevIndex]=nums[i];
				prevIndex++;
			}


		}

		return prevIndex;
	}

}











