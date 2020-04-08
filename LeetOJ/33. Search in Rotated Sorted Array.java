
/*
 * 
https://leetcode.com/problems/search-in-rotated-sorted-array/


33. Search in Rotated Sorted Array
Medium

4030

412

Add to List

Share
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

8 April 2020 at 7.55pm-8.24pm
 * 
 */


class Solution {
    // 7.55pm-8.24pm
	public int search(int[] nums, int target) {
		return binarySearch(nums, target);
	}

	int binarySearch(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return mid;

				// nums[low]<=nums[mid] 则左侧一定是有序
			} else if (nums[low] <= nums[mid]) {
				//左侧有序的话，判断target是否左侧区间
				if (nums[low] <= target && target <= nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				// nums[low]>=nums[mid]   那么右侧有序
				//  右侧有序的话，需要判断target是否在右侧区间
				if (nums[mid] <= target && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}

		return - 1;
	}
}





















