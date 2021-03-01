
/*
 * 
https://leetcode.com/problems/wiggle-sort-ii/

324. Wiggle Sort II
Medium

1303

645

Add to List

Share
Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

You may assume the input array always has a valid answer.

 

Example 1:

Input: nums = [1,5,1,1,6,4]
Output: [1,6,1,5,1,4]
Explanation: [1,4,1,5,1,6] is also accepted.
Example 2:

Input: nums = [1,3,2,2,3,1]
Output: [2,3,1,3,1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
0 <= nums[i] <= 5000
It is guaranteed that there will be an answer for the given input nums.
 

Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?

1 Mar 2021 at 23:09 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

解题思路

数组按照从小到大排序后，从中间切分,比如 123456 切分后123，456 穿插进行后142536符合题意
但是1223这种就不行了，但是穿插规则可以变一下，两部分逆序穿插，即2 3 1 2

作者：wang-xue-lei-2
链接：https://leetcode-cn.com/problems/wiggle-sort-ii/solution/3ms-99-xian-pai-xu-zai-chuan-cha-by-wang-o7pm/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


 * 
 */





class Solution {
    public void wiggleSort(int[] nums) {
          int[] help = nums.clone(); //不能写成int[] help = nums,排序后两个数组都改变
          Arrays.sort(help);
          int N = nums.length;
          //比如123456
          for (int i = 1; i < nums.length; i += 2) {
              nums[i] = help[--N]; //遍历完成后 x 6 x 5 x 4 
          }
          for (int i = 0; i < nums.length; i += 2) {
              nums[i] = help[--N]; //便利完成后 3 6 2 5 1 4
          }
      }
  }
  
//   作者：wang-xue-lei-2
//   链接：https://leetcode-cn.com/problems/wiggle-sort-ii/solution/3ms-99-xian-pai-xu-zai-chuan-cha-by-wang-o7pm/
//   来源：力扣（LeetCode）
//   著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


















