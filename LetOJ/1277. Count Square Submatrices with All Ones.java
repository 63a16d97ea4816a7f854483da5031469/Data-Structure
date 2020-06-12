
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


1277. Count Square Submatrices with All Ones
Medium

615

15

Add to List

Share
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 

Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1



22 May 2020 at 12:33 am


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */






class Solution {
    Integer[][] memo; // 记忆数组
      public int countSquares(int[][] matrix) {
          memo=new Integer[matrix.length][matrix[0].length];
          int res=0; // 返回结果
          // 遍历所有点
          // 求出以每一点为顶点向右下方能画出的最大正方形边长
          for(int i=0;i<matrix.length;i++){
              for(int j=0;j<matrix[0].length;j++){
                  // 求和
                  res+=help(matrix,i,j);
              }
          }
          return res;
      }
      int help(int[][] matrix, int r, int c){
          // 如果记忆数组不为空，直接返回
          if(memo[r][c]!=null) return memo[r][c];
          // 如果当前点在下边或者右边时，返回当前值
          if(r==matrix.length-1||c==matrix[0].length-1){
              return matrix[r][c];
          }
          // 如果当前点为0，直接返回0
          if(matrix[r][c]==0) return 0;
          // 下方格子能画出的最大正方形边长
          int bottom = help(matrix, r+1,c);
          // 右方格子能画出的最大正方形边长
          int right = help(matrix, r,c+1);
          // 右下方格子能画出的最大正方形边长
          int bottomRight = help(matrix, r+1,c+1);
          // 三者的最小值加一为当前返回结果
          int res=Math.min(bottom,Math.min(right,bottomRight))+1;
          memo[r][c]=res; // 将结果存入记忆数组
          return res;
      }
  }

















