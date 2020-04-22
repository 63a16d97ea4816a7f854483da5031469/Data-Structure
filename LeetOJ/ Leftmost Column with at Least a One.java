
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


Leftmost Column with at Least a One
(This problem is an interactive problem.)

A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.

 

Example 1:



Input: mat = [[0,0],[1,1]]
Output: 0
Example 2:



Input: mat = [[0,0],[0,1]]
Output: 1
Example 3:



Input: mat = [[0,0],[0,0]]
Output: -1
Example 4:



Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
Output: 1
 

Constraints:

1 <= mat.length, mat[i].length <= 100
mat[i][j] is either 0 or 1.
mat[i] is sorted in a non-decreasing way.
   Hide Hint #1  
1. (Binary Search) For each row do a binary search to find the leftmost one on that row and update the answer.
   Hide Hint #2  
2. (Optimal Approach) Imagine there is a pointer p(x, y) starting from top right corner. p can only move left or down. If the value at p is 0, move down. If the value at p is 1, move left. Try to figure out the correctness and time complexity of this algorithm.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    //9.18am-9.55am
    
    int leftmost=0;
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim=binaryMatrix.dimensions();
  
        int row=dim.get(0);
        int col=dim.get(1);
        
        leftmost=dim.get(0);
        
        //对任何一行，进行binarySearch，看是否找的到1，然后看是否是最左边的
        
        for(int i=0;i<row;i++){
            binarySearch(binaryMatrix,i,row,1);
        }
        
        if(leftmost==dim.get(0)){
            return -1;
        }
        
        return leftmost;
    }
    
    int binarySearch(BinaryMatrix mat,int x,int rowLength, int target){
        
        //y是在left 和 right之间选的
        int left=0;
        int right=rowLength;
         
        while(left<right){
            int mid=(left+right)/2;
            
            int midValue=mat.get(x,mid);
            
            if(target==midValue){
                right=mid;  //收缩右侧
            }else{
                left=mid+1;
            }
        }
        //updte the leftmost
        if(leftmost>left){
            leftmost=left;
        }
        return 1;
    }
    
    
}












/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    //9.18am-
    
    int leftmost=0;
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim=binaryMatrix.dimensions();
  
        int row=dim.get(0);
        int col=dim.get(1);
        
        leftmost=dim.get(0);
        
        //对任何一行，进行binarySearch，看是否找的到1，然后看是否是最左边的
        
        for(int i=0;i<row;i++){
            binarySearch(binaryMatrix,i,row,1);
        }
        
        if(leftmost==dim.get(0)){
            return -1;
        }
        
        return leftmost;
    }
    
    int binarySearch(BinaryMatrix mat,int x,int rowLength, int target){
        
        //y是在left 和 right之间选的
        int left=0;
        int right=rowLength-1;
         
        while(left<=right){
            int mid=(left+right)/2;
            
            int midValue=mat.get(x,mid);
            
            if(target==midValue){
                break;
            }else 
            if(target>midValue){
                left=mid+1;
            }else if(target<midValue){
                right=mid-1;
            }
        }
        //updte the leftmost
        if(leftmost>left){
            leftmost=left;
        }
        return 1;
    }
    
    
}





