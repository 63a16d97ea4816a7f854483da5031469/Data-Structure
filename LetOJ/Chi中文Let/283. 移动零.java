
/*
 * 
link: https://leetcode-cn.com/problems/move-zeroes/

283. 移动零
难度
简单

1415

收藏

分享
切换为英文
接收动态
反馈
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作。

 

示例 1:

输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
示例 2:

输入: nums = [0]
输出: [0]
 

提示:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

进阶：你能尽量减少完成的操作次数吗？

2022-01-30 at 22:42


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public void moveZeroes(int[] nums) {
        // 0,0,1
        int i=0;
        int j=1;
        for(;i<nums.length&&j<nums.length;){
            if(nums[i]==0){
                //找到不为0的数
                while(j<nums.length&&nums[j]==0){
                    j++;
                }
                swap(nums,i,j);
            }else{
                while(i<nums.length&&nums[i]!=0){
                    i++;
                    j++;
                }
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        if(i>=nums.length||j>=nums.length)
        {
            return;
        }
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}





















