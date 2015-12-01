/*
https://leetcode.com/problems/maximum-subarray/

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

public class Solution {
    public int maxSubArray(int[] nums) {
        
    }
}


http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

 * 
 */
public class MaximumSubarray {

	
	
	public static void main(String args[]){
		MaximumSubarray s=new MaximumSubarray();
		int[] nums={-2};
		System.out.println(s.maxSubArray3(nums));
//		s.findMaxSubArrayIncludingIndex(nums);
	}
	
	
	
	
	/*
	 * https://en.wikipedia.org/wiki/Maximum_subarray_problem
	 * Accepted. 
	 */
	
    public int maxSubArray3(int[] nums) {
        int max_ending_here=nums[0];
        int max_so_far=nums[0];
        
        for(int i=1;i<nums.length;i++){
            max_ending_here=Math.max(nums[i], max_ending_here+nums[i]);
            max_so_far=Math.max(max_so_far,max_ending_here);
        }
        
        return max_so_far;
    }
	
	
	
	
//    public int[] findMaxSubArrayIncludingIndex(int[] nums){
//        
//        int max_ending_here=nums[0];
//        int max_so_far=nums[0];
//        int prevMaxSoFar=nums[0];
//        int prevMaxEndingHere=nums[0];
//        
//        for(int i=0;i<nums.length;i++){
//        	
//        	prevMaxSoFar=max_so_far;
//        	prevMaxEndingHere=max_ending_here;
//        
//            max_ending_here=Math.max(nums[i], max_ending_here+nums[i]);
//            max_so_far=Math.max(max_so_far,max_ending_here);
//            
////            if(prevMaxSoFar!=max_ending_here){
////            	System.out.print(nums[i]+" ");
////            }
//            
////            if(max_so_far!=prevMaxEndingHere){
////            	System.out.print(nums[i]+" ");
////            }
//        }
//        
//        return new int[2];
////        return max_so_far;
//    }
//	
	
	
	
	
	
	
	
	/*
	 * 
	Consider to use "greedy" to speed up.
(1)Find the minimum number in the array may help us to speed up the whole method. --> cannot.
(2)Could we reuse the previous results to speed up?
(3)Could recursion speed up the method?
	
	 * 
	 */
	
    public int maxSubArray2(int[] nums) {
    	
    	//set max to be the minimum number
    	int max=(int) -Math.pow(2, 31);
    	
    	for(int i=0;i<nums.length;i++){
    		int currSum=nums[i];
    		for(int j=i+1;j<nums.length;j++){
    			currSum+=nums[j];
    			if(currSum>max) {
    				max=currSum;
    			}
    		}
    	}
    	
    	return max;
    }
	
	
	
	/*
	 * Using the stupid way to implement it:
	 * 
	 * Loop from the first index, p=currIndex;
	 * 
	 * then loop after this currIndex, every time when we add one element, we need to compare the current sum with maxSum,  if the new sum is larger, record it as largest sum. 
	 * than current sum, then replace it.  until to be the end of array. 
	 * Move the p to next Index.
	 * 
	 * 
	 */
	
	
/*
 * 
Status: Time Limit Exceeded
Submitted: 0 minutes ago
Last executed input:
[-32,-54,-36,62,20,76,-1,-86,-13,38,-58,-77,17,38,-17,43,32,-88,-19,-70,95,0,-64,75,15,-87,-26,69,-95,-6......]

Consider to use "greedy" to speed up.

 * 
 * 
 * 	
 */
	
    public int maxSubArray(int[] nums) {
    	
    	//set max to be the minimum number
    	int max=(int) -Math.pow(2, 31);
    	
    	for(int i=0;i<nums.length;i++){
    		int currSum=nums[i];
    		for(int j=i+1;j<nums.length;j++){
    			currSum+=nums[j];
    			if(currSum>max) {
    				max=currSum;
    			}
    		}
    	}
    	
    	return max;
    }
 
}
















