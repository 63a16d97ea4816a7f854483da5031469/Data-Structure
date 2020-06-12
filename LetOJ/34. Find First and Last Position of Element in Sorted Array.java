
/*
 * 
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

34. Find First and Last Position of Element in Sorted Array
Medium

2806

126

Add to List

Share
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]


*/


class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {
            findLeft(nums, target), findRight(nums, target)
        };
    }

    int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while (left<= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid]<target) {
                left = mid + 1;
            } else {
                if (nums[mid] == target) {
                    //相等的时候，不要理解返回，继续收缩边界
                    res = mid;
                }
                right = mid - 1;
            }
        }

        return res;
    }

    int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int res = -1;
        while (left<= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (nums[mid] == target) {
                    //相等的时候，不要理解返回，继续收缩边界
                    res = mid;
                }
                left = mid + 1;
            }
        }
        return res;
    }

}









