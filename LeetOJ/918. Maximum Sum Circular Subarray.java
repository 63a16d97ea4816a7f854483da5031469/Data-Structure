
/*
 * 
https://leetcode.com/problems/maximum-sum-circular-subarray/


918. Maximum Sum Circular Subarray
Medium

725

34

Add to List

Share
Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)

 

Example 1:

Input: [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3
Example 2:

Input: [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
Example 3:

Input: [3,-1,2,-1]
Output: 4
Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
Example 4:

Input: [3,-2,2,-3]
Output: 3
Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
Example 5:

Input: [-2,-3,-1]
Output: -1
Explanation: Subarray [-1] has maximum sum -1
 

Note:

-30000 <= A[i] <= 30000
1 <= A.length <= 30000

15 May 2020 at 11:01 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





class Solution {
    public int maxSubarraySumCircular(int[] A) {
     // 第一种情况
     int sum=0; // 区间和
     int max=Integer.MIN_VALUE; // 最大区间和
     for(int n : A){ // 循环每一个数字
         // 如果当前数字加上sum还没有本身大，将当前数字设置为sum
         if(n>n+sum) sum=n;
         // 反之将当前数字累加至sum
         else sum+=n;
         // 更新全局最大sum
         max=Math.max(max,sum);
     }
     // 第二种情况
     sum=0; // 区间和
     int allSum=0; // 数组总和
     int min=Integer.MAX_VALUE; // 最小区间和
     for(int n : A){ // 循环每一个数字
         allSum+=n; // 累加数组总和
         // 如果当前数字加上sum还没有本身小，将当前数字设置为sum
         if(n<n+sum) sum=n;
         // 反之将当前数字累加至sum
         else sum+=n;
         // 更新全局最小sum
         min=Math.min(min,sum);
     }
     // 如果最小值等于数组总和（数组中全是负数），返回max
     if(min==allSum) return max;
     // 返回两种情况的最大值
     return Math.max(max, allSum-min);
     }
 }


















