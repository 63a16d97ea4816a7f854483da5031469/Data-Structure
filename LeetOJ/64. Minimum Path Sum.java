
/*
 * 
https://leetcode.com/problems/minimum-path-sum/


64. Minimum Path Sum
Medium

2563

54

Add to List

Share
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


class Solution {
    //11.54pm-12.10pm 自己写的
    public int minPathSum(int[][] grid) {
        
        if(grid.length==0 || grid[0].length==0) return 0;
        
        int[][] dp=new int[grid.length+1][grid[0].length+1];
        
        dp[0][0]=grid[0][0];
        
        //处理边界
        
        for(int i=1;i<grid.length;i++){
            // dp[i][0]=grid[i][0];
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int i=1;i<grid[0].length;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                //在最小的里面去选，只能走下面，或者右侧
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        
        return dp[grid.length-1][grid[0].length-1];
        
    }
}





class Solution {
    //11.54pm-12.10pm 自己写的
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length+1][grid.length+1];

        //这里写错了    int[][] dp=new int[grid.length+1][grid[0].length+1];  应该是grid[0]
        
        dp[0][0]=grid[0][0];
        
        //处理边界
        
        for(int i=1;i<grid.length;i++){
            // dp[i][0]=grid[i][0];
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int i=1;i<grid[0].length;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                //在最小的里面去选，只能走下面，或者右侧
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        
        return dp[grid.length-1][grid[0].length-1];
        
    }
}





自己写的，有错误:

class Solution {
    //11.54pm-12.10pm 自己写的
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length+1][grid.length+1];
        
        dp[0][0]=grid[0][0];
        
        //处理边界
        
        for(int i=0;i<grid.length;i++){
            dp[i][0]=grid[i][0];
        }
        for(int i=0;i<grid[0].length;i++){
            dp[0][i]=grid[0][i];
        }
        
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                dp[i][j]=Math.min(dp[i-1][j-1]+grid[i-1][j],dp[i-1][j-1]+grid[i][j-1]);
            }
        }
        
        return dp[grid.length-1][grid[0].length-1];
        
    }
}










