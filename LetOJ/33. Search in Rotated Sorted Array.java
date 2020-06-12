
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


// 分析：如果直接遍历数组进行查找，那么时间复杂度O(n)。显然面试官是不会满意这样的答案的。其实这道题是二分查找的变体，因为数组进行了旋转，所以当我们切取一半的时候可能会出现误区，所以我们要做进一步的判断。具体来说，假设数组是nums，每次左边缘为low，右边缘为high，还有中间位置是mid。在每次迭代中，分三种情况：
// （1）如果target==nums[mid]，那么mid就是我们要的结果，直接返回；
// （2）如果nums[low]<=nums[mid]，那么说明从low到mid一定是有序的，那么我们只需要判断target是不是在low到mid之间，如果是则把右边缘移到mid-1，否则target就在另一半，即把左边缘移到mid+1。
// （3）如果nums[low]>nums[mid]，那么说明从mid到high一定是有序的，那么我们只需要判断target是不是在mid到high之间，如果是则把左边缘移到mid+1，否则就target在另一半，即把右边缘移到mid-1。
// ————————————————
// 版权声明：本文为CSDN博主「北邮张博」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/Irving_zhang/article/details/78192831


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





















