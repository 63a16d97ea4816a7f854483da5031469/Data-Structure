
/*
 * 
https://leetcode.com/problems/house-robber/

198. House Robber
Easy

4061

124

Add to List

Share
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:
这是一道之前做过类似的题目，就是dp的思想，有点像理发师接客，要合理构造dp

从这道题目学到了什么，哪些地方需要提升? :
，有点像理发师接客，要合理构造dp，多做题，多总结，才是王道



 * 
 */

AC:

class Solution {
    //7.05pm-7.14pm
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        
        int[] dp=new int[nums.length+1];
        
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<=nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        
        return dp[nums.length];
    }
}




















