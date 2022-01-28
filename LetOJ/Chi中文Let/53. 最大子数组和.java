
/*
 * 
link: https://leetcode-cn.com/problems/maximum-subarray/

53. 最大子数组和
难度
简单

4281

收藏

分享
切换为英文
接收动态
反馈
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组 是数组中的一个连续部分。

 

示例 1：

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
示例 2：

输入：nums = [1]
输出：1
示例 3：

输入：nums = [5,4,-1,7,8]
输出：23
 

提示：

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 

进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。


2022-01-28 at 14:32
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]<nums[i]){
                sum=Math.max(sum,nums[i]);
            }else{
                sum+=nums[i];
            }
            max=Math.max(sum,max);
        }
        return max;
    }
}



















