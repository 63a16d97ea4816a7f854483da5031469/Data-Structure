
/*
 * 
link: 
https://leetcode-cn.com/problems/maximum-subarray/

2020-7-25 at 10:49 am

53. 最大子序和
难度
简单

2218

收藏

分享
切换为英文
关注
反馈
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    //10.47am-10.49am
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int max=nums[0];
        int tmpMax=0;
        for(int i=0;i<nums.length;i++){
            if(tmpMax>0){
                tmpMax=Math.max(tmpMax+nums[i],nums[i]);
            }else{
                tmpMax=nums[i];
            }
            max=Math.max(max,tmpMax);
        }
            return max;
    }
}




















