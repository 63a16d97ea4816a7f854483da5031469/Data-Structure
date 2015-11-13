package ok;

/*
https://leetcode.com/problems/rotate-array/

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II

public class Solution {
    public void rotate(int[] nums, int k) {
        
    }
}
7 November 2015 at 8:53:16 pm
 * 
 */
public class RotateArray {
    
	public static void main(String args[]){
		
		
		int[] arr={1,2};
		rotate(arr,3);
		
	}
	
	/*
	 *    thinking in this way:
	 *    
	 *    if n=7 k=7 then the array will not change:
	 *    
	 *    if n=7 k=3 then 
	 *    
	 *    index start from 0,
	 *    for each single character, its (index+k)%7
	 *    
	 *    
	 * Accepted:
	 * 
	 */
	
	public static void rotate(int[] nums, int k) {
		
		int[] n=nums.clone();
		
		
		if(nums==null) return;
        
		for(int i=0;i<nums.length;i++){
			int tmp=n[i];
			
			nums[(i+k)%nums.length]=tmp;
 
 

		}
//		
//		for(int tmp:nums)
//			System.out.print(tmp+" ");
		
		
    }
    
    
    
}
