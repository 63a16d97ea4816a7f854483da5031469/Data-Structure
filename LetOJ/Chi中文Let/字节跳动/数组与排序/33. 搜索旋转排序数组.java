
/*
 * 
link: 
https://leetcode-cn.com/problems/search-in-rotated-sorted-array/

2020-7-12 at 10:41 pm

33. 搜索旋转排序数组
难度
中等

822

收藏

分享
切换为英文
已关注
反馈
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




class Solution {
    //10.41pm-10.50pm
    public int search(int[] nums, int target) {
        //init.
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid=(left+right)/2;
            if(target==nums[mid]){
                return mid;
            }else if(nums[left]<=nums[mid]){ //这里容易错， 左边有序
                if(nums[left]<=target && target<=nums[mid]){ //这里容易错，并且target在里面
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(nums[mid]<=target && target<=nums[right]){//这里容易错，并且target在里面
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}



















