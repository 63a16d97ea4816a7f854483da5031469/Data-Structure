
/*
 * 
https://leetcode.com/problems/combination-sum-iv/

377. Combination Sum IV
Medium

1278

164

Add to List

Share
Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
 

Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.

31 May 2020 at 11:36 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


// This problem is similar to Coin Change. It's a typical dynamic programming problem.

class Solution {
    public int combinationSum4(int[] nums, int target) {
       if(nums==null || nums.length==0)
           return 0;

       int[] dp = new int[target+1];

       dp[0]=1;

       for(int i=0; i<=target; i++){
          for(int num: nums){
              if(i+num<=target){
                  dp[i+num]+=dp[i];
              }
          }
       }

       return dp[target];
   }
}



















