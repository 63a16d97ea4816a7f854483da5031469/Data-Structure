
/*
 * 
https://leetcode.com/problems/maximum-product-of-three-numbers/

628. Maximum Product of Three Numbers
Easy

933

329

Add to List

Share
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:

Input: [1,2,3]
Output: 6
 

Example 2:

Input: [1,2,3,4]
Output: 24
 

Note:

The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

12 April 2020 at 9.04pm-9.06pm 


对题目易错地方进行总结:
忘记看区间，没有处理负数。

对题目的实现思路进行几句话总结:

对数组进行排序。

最小的两个数，与最大的数，三个，取乘法
最大的最后三个，去乘法

然后结果必定会在上面两个之中。


从这道题目学到了什么，哪些地方需要提升? :

从数学逻辑角度出发，做题的速度会提升。
多做题，才能对相似的题目有思路。


 * 
 */



class Solution {
    //9.04pm-9.06pm
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int last=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int first=nums[0]*nums[1]*nums[nums.length-1];
        
        return Math.max(first, last);
    }
}




















