
/*
 * 
https://leetcode.com/problems/sort-an-array/


912. Sort an Array
Medium

349

228

Add to List

Share
Given an array of integers nums, sort the array in ascending order.

 

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
 

Constraints:

1 <= nums.length <= 50000
-50000 <= nums[i] <= 50000

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



// AC:
class Solution {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}




// AC:
class Solution {
	public int[] sortArray(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
		return nums;
	}
	void quickSort(int[] nums, int left, int right) {
		if (nums == null || nums.length == 0) return;
		if (left<right) {
			int selected = partion(nums, left, right);
			quickSort(nums, left, selected - 1);
			quickSort(nums, selected + 1, right);
		}
	}
	int partion(int[] nums, int start, int end) {
		int tmp = nums[start];
		while (start<end) {
			while (nums[end] >= tmp && start<end) end--;
			if (start<end) {
				nums[start++] = nums[end]; //把这个找到的end，放到前面
			}
			while (nums[start]<tmp && start<end) start++;
			if (start<end) {
				nums[end--] = nums[start]; //把这个找到的start，放到后面
			}
		}
		nums[start] = tmp;
		return start;
	}
}






class Solution {
	public int[] sortArray(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
		return nums;
	}
    public static void quickSort(int array[],int left,int right)
    {
        if(left>=right)
        {
            return;
        }
        int start=left;
        int end=right;
        int key=array[left];
        while(start<end)
        {
            while(start<end&&array[end]>=key)
            {
                end--;
            }
            array[start]=array[end];
            //从后往前找到第一个比key小的数与array[start]交换；
            while(start<end&&array[start]<=key)
            {
                start++;
            }
            array[end]=array[start];
            //从前往后找到第一个比key大的数与array[end]交换；
        }
        array[start]=key;
        //一趟快排之后已经将key的位置找到。
        quickSort(array,left,start-1);
        //对key左边的进行排序
        quickSort(array,start+1,right);
        //对key右边的进行排序
    }
}


