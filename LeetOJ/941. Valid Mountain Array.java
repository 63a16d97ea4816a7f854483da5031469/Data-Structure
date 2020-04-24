
/*
 * 
https://leetcode.com/problems/valid-mountain-array/

941. Valid Mountain Array
Easy
310
64
Add to List

Share
Given an array A of integers, return true if and only if it is a valid mountain array.

Recall that A is a mountain array if and only if:

A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]

Example 1:

Input: [2,1]
Output: false
Example 2:

Input: [3,5,5]
Output: false
Example 3:

Input: [0,3,2,1]
Output: true

Note:

0 <= A.length <= 10000
0 <= A[i] <= 10000 

12 April 2020 at 8:33: pm

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

 * 
 */

class Solution {
    //10.05pm-10.21pm
    public boolean validMountainArray(int[] A) {
        // edge case
        if(A.length<3) return false;
        //从左侧到递增，层右侧递减
        for(int i=1;i<A.length-1;i++){
            //暴力模拟破解
            boolean left=true;
            boolean right=true;
            //左侧递增
            for(int j=0;j<i;j++){
                 // System.out.println(A[j]+" "+A[j+1]);
                if(A[j]>=A[j+1]){
                     left=false; 
                }
            }
            for(int k=i;k<A.length-1;k++){
                if(A[k]<=A[k+1]){
                    right=false;
                }
            }
            // System.out.println(left+" "+right);
            if(left&&right) return true;
        }
        return false;
    }
}



















