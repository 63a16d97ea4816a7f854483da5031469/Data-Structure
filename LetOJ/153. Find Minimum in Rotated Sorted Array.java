
/*
 * 
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

153. Find Minimum in Rotated Sorted Array
Medium

3154

290

Add to List

Share
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums, return the minimum element of this array.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
 

Constraints:

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
All the integers of nums are unique.
nums is sorted and rotated between 1 and n times.

23 Feb 2021 at 20:16


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        // 如果不排除这种情况，[1,2]就会出错。
        if (nums[r] > nums[l]) return nums[l];
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            // 左边有序，排除左边
            if (nums[0] <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            } 
        }
        return nums[l];
    }
}

// 作者：bingo-77
// 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/java-er-fen-cha-zhao-by-bingo-77/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





class Solution {
    public int findMin(int[] nums) {
      // If the list has just one element then return that element.
      if (nums.length == 1) {
        return nums[0];
      }
      // initializing left and right pointers.
      int left = 0, right = nums.length - 1;
  
      // if the last element is greater than the first element then there is no rotation.
      // e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
      // Hence the smallest element is first element. A[0]
      if (nums[right] > nums[0]) {
        return nums[0];
      }
      while (right >= left) {
        // Find the mid element
        int mid = left + (right - left) / 2;
        // if the mid element is greater than its next element then mid+1 element is the smallest
        // This point would be the point of change. From higher to lower value.
        if (nums[mid] > nums[mid + 1]) {
          return nums[mid + 1];
        }
        // if the mid element is lesser than its previous element then mid element is the smallest
        if (nums[mid - 1] > nums[mid]) {
          return nums[mid];
        }
        // if the mid elements value is greater than the 0th element this means
        // the least value is still somewhere to the right as we are still dealing with elements
        // greater than nums[0]
        if (nums[mid] > nums[0]) {
          left = mid + 1;
        } else {
          // if nums[0] is greater than the mid value then this means the smallest value is somewhere to the left
          right = mid - 1;
        }
      }
      return -1;
    }
  }



// T o(logN)
// S o(1)




public int findMin(int[] nums) {
    //指针刚开始在第一个元素
    int needle = 0;
    //判断是否进行了旋转以及数组是否只有一个元素
    if(nums[nums.length-1] >= nums[0]){
        //未旋转或者只有一个元素那么直接返回第一个元素
        return nums[0];
    }else {
        //找到当前元素比下一个元素大的位置
        while (needle < nums.length - 1 && nums[needle] < nums[needle + 1]) {
            needle += 1;
        }
        return nums[needle+1];
    }
}

// 作者：danger-6
// 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/javayong-shi-ji-bai-100-by-danger-6-7j3r/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/yi-wen-dai-ni-gao-ding-er-fen-cha-zhao-j-00kj/



