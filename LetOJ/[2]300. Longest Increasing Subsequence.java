
/*
 * 
https://leetcode.com/problems/longest-increasing-subsequence/

300. Longest Increasing Subsequence
Medium

4476

104

Add to List

Share
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?

14 June 2020 at 12:01 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */










class Solution {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null | nums.length == 0)
            return 0;
        int n = nums.length, len = 0;
        int[] increasingSequence = new int[n];
        increasingSequence[len++] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > increasingSequence[len - 1])
                increasingSequence[len++] = nums[i];
            else {
                int position=Arrays.binarySearch(increasingSequence,0,len,nums[i]);
                System.out.println(position);
                if(position<0){
                    // returned -position-1
                    position=-(position+1);
                }
                
                increasingSequence[position]=nums[i];
                
                if(position==len){
                    len++;
                }
            }
        }
        return len;
    }
}













