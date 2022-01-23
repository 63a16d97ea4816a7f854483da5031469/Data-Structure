
/*
 * 
link: https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/

34. 在排序数组中查找元素的第一个和最后一个位置
难度
中等

1417

收藏

分享
切换为英文
关闭提醒
反馈
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：

你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 

示例 1：

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：

输入：nums = [], target = 0
输出：[-1,-1]
 

提示：

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums 是一个非递减数组
-109 <= target <= 109


2022-01-23 at 22:01
 

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0, r=nums.length-1;
        int leftFound=-1;
        int rightFound=-1;
        while(l<=nums.length-1){
            leftFound=search(nums,target,0,l);
            l++;
            if(leftFound!=-1) break;
        }
        while(r>=0){
            rightFound=search(nums,target,r,nums.length-1);
            r--;
            if(rightFound!=-1) break;
        }
        return new int[]{leftFound,rightFound};
    }
    public int search(int[] nums, int target, int start,int end){
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
}





















