
/*
 * 
link: 
https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/

2020-8-3 at 11:13 pm

剑指 Offer 03. 数组中重复的数字
难度
简单

135

找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 
 

限制：

2 <= n <= 100000


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

class Solution {
    //11.13pm-
    public int findRepeatNumber(int[] nums) {
        if(nums==null||nums.length==0) return -1;
        for(int i=0;i<nums.length;i++){
            // System.out.println(nums[i]+" "+nums[nums[i]]);     //易忘一个case  nums[i]==i的case
            if(nums[i]!=i&&nums[nums[i]]!=nums[i]){
                swap(nums,i,nums[i]);
            }else if(nums[i]!=i){
                return nums[i];
            }
        }
        return -1;
    }
    public void swap(int[] nums, int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}






















