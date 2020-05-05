
/*
 * 
https://leetcode.com/problems/search-a-2d-matrix-ii/

240. Search a 2D Matrix II
Medium

2746

73

Add to List

Share
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.

5 May 2020 at 10.11pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



class Solution {
    //9.44pm-10.09pm
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;  //[]
        if(matrix.length==1 && matrix[0].length==0){ // [[]]
           return false;
        }
        for(int i=0;i<matrix.length;i++){
           int index= binarySearch(matrix[i],target);
            if(index!=-1) return true;
        }
        return false;
    }
    int binarySearch(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
}

















