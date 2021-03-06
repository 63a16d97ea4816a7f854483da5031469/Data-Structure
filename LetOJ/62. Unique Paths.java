
/*
 * 
https://leetcode.com/problems/unique-paths/

62. Unique Paths
Medium

2579

182

Add to List

Share
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

 

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28
 

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.

4 April 2020 at //11.07pm-11.20pm 搜索耗时太长，超时。
 * 
 */


动态规划走法：
class Solution {
    //11.07pm-11.20pm 搜索耗时太长，超时。
    //DFS 搜索

    //动态规划： dp[i][j]表示走到i和j坐标不同的走法数
    // dp[i][j]=dp[i-1][j]+dp[i][j-1]; 这个方程可以倒着想，在任意i，j那个坐标，只有从其 左侧走过来，和 其 上侧走过来 两种
    
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        if(m==1 || n==1) return 1;
        
        int[][] dp=new int[m][n];
        
        //只有一行
        for(int i=1;i<n;i++){
            dp[0][i]=1;
        }
        
        //只有一列
        for(int i=1;i<m;i++){
            dp[i][0]=1;
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
  
        return dp[m-1][n-1];
    }
}







class Solution {
    //11.07pm-11.20pm 搜索耗时太长，超时。
    //DFS 搜索
    int count=0;
    public int uniquePaths(int m, int n) {
        
        if(m==1 && n==1) return 1;
        
        int[][] grid=new int[m][n];
        grid[m-1][n-1]=1000;
     
        dfs(grid,new boolean[m][n],0,0);
        
        return count;
        
    }
    
    
    boolean dfs(int[][] grid, boolean[][] used, int x, int y){
        
        if(grid[x][y]==1000){
            return true;
        }
        
        //向右
        
        if(x+1<grid.length && !used[x+1][y]){
            //mark
            used[x+1][y]=true;
            if(dfs(grid, used, x+1,y)){
                count++;
            }
            
            //恢复mark
            used[x+1][y]=false;
        }
        
        
        //向下
        if(y+1<grid[0].length &&!used[x][y+1]){
            //mark
            used[x][y+1]=true;
            if(dfs(grid,used,x,y+1)){
                count++;
            }

            used[x][y+1]=false;
        }
        
        return false;
    }
    
}
















