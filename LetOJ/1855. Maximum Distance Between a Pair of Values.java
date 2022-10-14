
/*
 * 

https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/

1855. Maximum Distance Between a Pair of Values
Medium

864

18

Add to List

Share
You are given two non-increasing 0-indexed integer arrays nums1​​​​​​ and nums2​​​​​​.

A pair of indices (i, j), where 0 <= i < nums1.length and 0 <= j < nums2.length, is valid if both i <= j and nums1[i] <= nums2[j]. The distance of the pair is j - i​​​​.

Return the maximum distance of any valid pair (i, j). If there are no valid pairs, return 0.

An array arr is non-increasing if arr[i-1] >= arr[i] for every 1 <= i < arr.length.

 

Example 1:

Input: nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
Output: 2
Explanation: The valid pairs are (0,0), (2,2), (2,3), (2,4), (3,3), (3,4), and (4,4).
The maximum distance is 2 with pair (2,4).
Example 2:

Input: nums1 = [2,2,2], nums2 = [10,10,1]
Output: 1
Explanation: The valid pairs are (0,0), (0,1), and (1,1).
The maximum distance is 1 with pair (0,1).
Example 3:

Input: nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
Output: 2
Explanation: The valid pairs are (2,2), (2,3), (2,4), (3,3), and (3,4).
The maximum distance is 2 with pair (2,4).
 

Constraints:

1 <= nums1.length, nums2.length <= 105
1 <= nums1[i], nums2[j] <= 105
Both nums1 and nums2 are non-increasing.

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



DATE: 2022-October-14
TIME: 20:56:39

时间：48分钟


 * 
 */




class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        return findMax(nums1,nums2);
    }
    
    public int findMax(int[] nums1, int[] nums2){
        int max=0;
        int i=0,j=1;
        while(i<=nums1.length-1&&j<=nums2.length-1){

            //满足第一个条件， i<=j,不满足就移动j，变大一些
            while(j<=nums2.length-1&&i>j){
                j++;
            }

            //满足第二个条件, nums[i]<=nums[j],不满足就移动i变小一些
            // drive i to meet the basic standard
            while(i<=j&&i<=nums1.length-1&&j<=nums2.length-1&&nums1[i]>nums2[j]){
                i++;
            }
            //满足第二个条件基础上，寻求j最大
            // drive j to its largest.
            while(i<=nums1.length-1&&j<=nums2.length-1&&nums1[i]<=nums2[j]){
                    max=Math.max(max,j-i);
                    j++;
            }
        }
        return max;
    }
}







class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
          int l=0;
          int r=l+1;
          int len1=nums1.length;
          int len2=nums2.length;
          int res=0;
          while(r<len2&&l<len1){
              if(nums2[r]>=nums1[l]){
                  r++;
              }else{
                  res=Math.max(res,r-l-1);
                  l++;
              }
          }
          res=Math.max(res,r-l-1);
          return res;
    }
}

作者：被太阳照亮的枫叶
链接：https://leetcode.cn/problems/maximum-distance-between-a-pair-of-values/solutions/1830943/shuang-zhi-zhen-by-zcandyyj-t0f5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。








