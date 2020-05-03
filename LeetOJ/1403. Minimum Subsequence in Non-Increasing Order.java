
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


1403. Minimum Subsequence in Non-Increasing Order
Easy

52

82

Add to List

Share
Given the array nums, obtain a subsequence of the array whose sum of elements is strictly greater than the sum of the non included elements in such subsequence. 

If there are multiple solutions, return the subsequence with minimum size and if there still exist multiple solutions, return the subsequence with the maximum total sum of all its elements. A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array. 

Note that the solution with the given constraints is guaranteed to be unique. Also return the answer sorted in non-increasing order.

 

Example 1:

Input: nums = [4,3,10,9,8]
Output: [10,9] 
Explanation: The subsequences [10,9] and [10,8] are minimal such that the sum of their elements is strictly greater than the sum of elements not included, however, the subsequence [10,9] has the maximum total sum of its elements. 
Example 2:

Input: nums = [4,4,7,6,7]
Output: [7,7,6] 
Explanation: The subsequence [7,7] has the sum of its elements equal to 14 which is not strictly greater than the sum of elements not included (14 = 4 + 4 + 6). Therefore, the subsequence [7,6,7] is the minimal satisfying the conditions. Note the subsequence has to returned in non-decreasing order.  
Example 3:

Input: nums = [6]
Output: [6]
 

Constraints:

1 <= nums.length <= 500
1 <= nums[i] <= 100

3 May 2020 at 8:23 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */






class Solution {
    //8.13pm-8.22pm
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<Integer>();
       
        for(int i=nums.length-1;i>=0;i--){
            int rightHalfSum=0;
            int leftHalfSum=0;
            
            for(int j=nums.length-1;j>=i;j--) rightHalfSum+=nums[j];
            
            for(int j=0;j<i;j++) leftHalfSum+=nums[j];
            
            if(rightHalfSum<=leftHalfSum){
                continue;
            }else{
                for(int j=nums.length-1;j>=i;j--){
                    list.add(nums[j]);
                }
                return list;
            }
        }
        return list;
    }
}

















