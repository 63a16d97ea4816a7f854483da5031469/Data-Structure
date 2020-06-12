
/*
 * 
https://leetcode.com/problems/squares-of-a-sorted-array/

977. Squares of a Sorted Array
Easy

902

74

Add to List

Share
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

 * 
 */



class Solution {
    //10.22pm-10.27pm
    public int[] sortedSquares(int[] A) {
        PriorityQueue pq=new PriorityQueue();
        
        for(int i=0;i<A.length;i++){
            pq.add(A[i]*A[i]);
        }
        int[] arr=new int[A.length];
        int index=0;
        while(!pq.isEmpty()){
            arr[index++]=(int)pq.poll();
        }
        return arr;
    }
}




















