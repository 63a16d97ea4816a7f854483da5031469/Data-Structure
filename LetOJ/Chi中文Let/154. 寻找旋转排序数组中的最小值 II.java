
/*
 * 
link: 
https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/

2020-8-12 at 8:44 am

154. 寻找旋转排序数组中的最小值 II
难度
困难

163

收藏

分享
切换为英文
关注
反馈
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

注意数组中可能存在重复的元素。

示例 1：

输入: [1,3,5]
输出: 1
示例 2：

输入: [2,2,2,0,1]
输出: 0
说明：

这道题是 寻找旋转排序数组中的最小值 的延伸题目。
允许重复会影响算法的时间复杂度吗？会如何影响，为什么？

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    //8.41am-8.43am
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=nums.length/2;i++){
            min=Math.min(min,nums[i]);
            min=Math.min(min,nums[nums.length-1-i]);
        }
        return min;
    }
}




















