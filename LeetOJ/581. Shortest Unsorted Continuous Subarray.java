
/*
 * 
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/


581. Shortest Unsorted Continuous Subarray
Easy

2267

116

Add to List

Share
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:

Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:

Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.


12 April 2020 at 12.10pm-12.30pm


对题目易错地方进行总结:
刚开始使用一个for循环，使用i和j，一个从前一个从后，没想清楚，这两个不能同时跳++和--
后来调整后，发现有一个test case是有相等数字反序的情况（这个题目的note部分有讲，但是没看到）

再后来，考虑，没有空间限制，所以使用一个已经排序的数组，作为参照，一前，一后，处理一些特殊case，就解决了

对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :
就是想算法问题，不能白瞎的想，要有主线。


 * 
 */




class Solution {
    //12.10pm-12.30pm
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length==0||nums.length==1) return 0;
        int[] arr=nums.clone();
        Arrays.sort(arr);
        
        int left=-1;
        int right=-1;
        
       for(int i=0;i<nums.length;i++){
           if(arr[i]!=nums[i]&&left==-1){
               left=i;
           }
       }
        
       for(int j=nums.length-1;j>=0;j--){
           if(arr[j]!=nums[j]&&left!=-1&&right==-1){
               right=j;
           }
       }
        if(left==-1&&right==-1) return 0;
        if(right==-1) right=nums.length-1;
        
      int count=0;
      for(int i=left;i<=right;i++){
          count++;
      }
        
        return count;
    }
}


题解做法：

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int i = 0, j = -1, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int l = 0, r = nums.length-1; r >= 0; l++, r--){
            max = Math.max(max, nums[l]);
            if (nums[l] != max) j = l;

            min = Math.min(min, nums[r]);
            if (nums[r] != min) i = r;
        }

        return (j - i + 1);
    }
}



刚开始的错误做法:
class Solution {
    //12.10pm-
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length==0||nums.length==1) return 0;
        int left=nums.length-1;
        int right=0;
        
        for(int i=0,j=nums.length-1;i<nums.length-1&&j>0&&i<j;){
            if(nums[i]>nums[i+1]&&i<left){
                left=i;
            }else{
                i++;
            }
            
            if(nums[j]<=nums[j-1]&&j>right){
                right=j;
            }else{
                j--;
            }
        }
        int count=0;
        for(int i=left;left<right&&i<=right;i++){
            count++;
        }
        
        return count;
    }
}


题解中，相同思路的另一个写法（相对与错误思路的正确写法）：
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = 0, r = nums.length - 1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        while (l < r && nums[l] <= nums[l+1]) l++;

        if (l == r) return 0;

        while (nums[r] >= nums[r-1]) r--;

        for (int k = l; k <= r; k++){
            max = Math.max(max, nums[k]);
            min = Math.min(min, nums[k]);
        }

        while (l >= 0 && min < nums[l]) l--;
        while (r <= nums.length-1 && max > nums[r]) r++;

        return r-l-1;

    }
}







