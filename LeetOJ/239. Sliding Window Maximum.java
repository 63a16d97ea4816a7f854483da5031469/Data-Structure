
/*
 * 
https://leetcode.com/problems/sliding-window-maximum/


239. Sliding Window Maximum
Hard

2998

165

Add to List

Share
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Follow up:
Could you solve it in linear time?

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 

Constraints:

1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length

10 May 2020 at 11:47pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


// 最快解法：

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         if (nums.length == 0) {
             return new int[0];
         }
 
         int[] maxes = new int[nums.length - k + 1];
 
         int i, j;
         int maxPos = -1;
 
         for (i = 0; i <= nums.length - k; ++i) {
             // Ending index of the current window
             j = i + k - 1;
 
             // new element >= max of last window
             // that means new element is max in the two windows
             // here using >= to make maxPos stay in the windows for a longer time
             if (maxPos != -1 && nums[j] >= nums[maxPos]) {
                 maxPos = j;
                 maxes[i] = nums[maxPos];
             }
             // new element < max of last window
             // AND the max of last window is also in this window
             // => it means the max of the last window is still the max of this window
             else if (i <= maxPos) {
                 maxes[i] = nums[maxPos];
             }
             // new element < max of last window
             // AND the max of last window is not in this window
             // So we do not know which element is the max in this window, we have to scan the window to find it
             else {
                 int maxWindow = Integer.MIN_VALUE;
                 int maxPosWindow = 0;
                 for (int z = i; z <= j; ++z) {
                     if (nums[z] > maxWindow) {
                         maxPosWindow = z;
                         maxWindow = nums[z];
                     }
                 }
                 maxPos = maxPosWindow;
                 maxes[i] = nums[maxPos];
             }
         }
         return maxes;
     }
 }




// 动态规划:
// https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int n = nums.length;
      if (n * k == 0) return new int[0];
      if (k == 1) return nums;
  
      int [] left = new int[n];
      left[0] = nums[0];
      int [] right = new int[n];
      right[n - 1] = nums[n - 1];
      for (int i = 1; i < n; i++) {
        // from left to right
        if (i % k == 0) left[i] = nums[i];  // block_start
        else left[i] = Math.max(left[i - 1], nums[i]);
  
        // from right to left
        int j = n - i - 1;
        if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
        else right[j] = Math.max(right[j + 1], nums[j]);
      }
  
      int [] output = new int[n - k + 1];
      for (int i = 0; i < n - k + 1; i++)
        output[i] = Math.max(left[i + k - 1], right[i]);
  
      return output;
    }
  }
  
//   作者：LeetCode
//   链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
//   来源：力扣（LeetCode）
//   著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




class Solution {
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;
  
    public void clean_deque(int i, int k) {
      // remove indexes of elements not from sliding window
      if (!deq.isEmpty() && deq.getFirst() == i - k)
        deq.removeFirst();
  
      // remove from deq indexes of all elements 
      // which are smaller than current element nums[i]
      while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])   deq.removeLast();
    }
  
    public int[] maxSlidingWindow(int[] nums, int k) {
      int n = nums.length;
      if (n * k == 0) return new int[0];
      if (k == 1) return nums;
  
      // init deque and output
      this.nums = nums;
      int max_idx = 0;
      for (int i = 0; i < k; i++) {
        clean_deque(i, k);
        deq.addLast(i);
        // compute max in nums[:k]
        if (nums[i] > nums[max_idx]) max_idx = i;
      }
      int [] output = new int[n - k + 1];
      output[0] = nums[max_idx];
  
      // build output
      for (int i  = k; i < n; i++) {
        clean_deque(i, k);
        deq.addLast(i);
        output[i - k + 1] = nums[deq.getFirst()];
      }
      return output;
    }
  }
  
  // 作者：LeetCode
  // 链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
  // 来源：力扣（LeetCode）
  // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。










