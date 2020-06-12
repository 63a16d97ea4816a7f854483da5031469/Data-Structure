
/*
 * 
https://leetcode.com/problems/unique-paths-ii/

63. Unique Paths II
Medium

1401

218

Add to List

Share
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?



An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

4 April 2020 at 11:50 pm
 * 
 */





题解方法：

class Solution {
	//11.50pm - 12.12pm
	//12.21pm - 
	//还是使用动态规划，但是如果有石头，就不加那个在解法里
	    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] pathCount = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length && obstacleGrid[i][0] != 1; i++)
            pathCount[i][0] = 1;
        for (int j = 0; j < obstacleGrid[0].length && obstacleGrid[0][j] != 1; j++)
            pathCount[0][j] = 1;
        for (int i = 1; i < obstacleGrid.length; i++)
            for (int j = 1; j < obstacleGrid[0].length; j++)
                if (obstacleGrid[i][j] == 1) pathCount[i][j] = 0;
                else pathCount[i][j] = pathCount[i - 1][j] + pathCount[i][j - 1];
        return pathCount[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }


}


[[0,1,0,0,0],[1,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]]  
30 / 43 test cases passed.

面向测试用例编程，始终没过:

class Solution {
	//11.50pm - 12.12pm
	//12.21pm - 
	//还是使用动态规划，但是如果有石头，就不加那个在解法里
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		if (m == 0 || n == 0) return 0;

		if (obstacleGrid[m - 1][n - 1] == 1) return 0;
		if (obstacleGrid[0][0] == 1) return 0;

		if (m == 1) {

			for (int i = 0; i<n; i++) {
				if (obstacleGrid[0][i] == 1) {
					return 0;
				}
			}

		}

		if (n == 1) {

			for (int i = 0; i<m; i++) {
				if (obstacleGrid[i][0] == 1) {
					return 0;
				}
			}

			return 1;
		}

		boolean isblockx = true;
		boolean isblocky = true;

		for (int x = 0; x<m; x++) {
			isblocky = true;
			for (int y = 0; y<n; y++) {

				if (obstacleGrid[x][y] != 1) {
					isblocky = false;
				}

			}
			if (isblocky) {
				return 0;
			}

		}

		for (int x = 0; x<n; x++) {
			isblockx = true;
			for (int y = 0; y<m; y++) {

				if (obstacleGrid[y][x] != 1) {
					isblockx = false;
				}

			}

			if (isblockx) {
				return 0;
			}
		}

		int[][] dp = new int[m][n];

		//如果只有一行
		for (int x = 0; x<m; x++) {
			if (obstacleGrid[x][0] == 1) {
				for (int j = x; j<m; j++) {
					obstacleGrid[j][0] = 0;
				}
			} else {
				dp[x][0] = 1;
			}
		}

		for (int y = 0; y<n; y++) {
			if (obstacleGrid[0][y] == 1) {
				for (int j = y; j<n; j++) {
					obstacleGrid[0][j] = 0;
				}
			} else {
				dp[0][y] = 1;
			}
		}

		for (int i = 1; i<m; i++) {
			for (int j = 1; j<n; j++) {

				if (obstacleGrid[i][j] != 1) {

					if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1) {
						dp[i][j] = 0;
					} else if (obstacleGrid[i - 1][j] != 1 && obstacleGrid[i][j - 1] != 1) {
						dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
					} else if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] != 1) {
						dp[i][j] = dp[i][j - 1];
					} else if (obstacleGrid[i][j - 1] == 1 && obstacleGrid[i - 1][j] != 1) {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
		}

		System.out.println(Arrays.toString(dp));

		// return 1;
		return dp[m - 1][n - 1];
	}
}




 搜索超时

[[0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],[0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0],[1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,1],[0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0],[0,0,0,1,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0],[1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0],[0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0],[0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0],[0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0],[1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,1],[0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0],[0,1,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0],[0,1,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,1],[1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0],[0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,1,1,0,1,0,0,0,0,1,1],[0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,1],[1,1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1],[0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0]]

class Solution {
    //12.12pm-12.20pm
    //使用搜索
    int count=0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        
        if(m==0||n==0) return 0;
        
        if(obstacleGrid[m-1][n-1]==1 || obstacleGrid[0][0]==1) return 0;
        
        dfs(obstacleGrid, new boolean[m][n], 0,0);
        
       
        return count;
    }
    
    boolean dfs(int[][] grid, boolean[][] used, int x,int y){
        
        if(x==grid.length-1 && y==grid[0].length-1){
            //到达终点
            count++;
            return true;
        }
        
        if(x+1<grid.length && grid[x+1][y]!=1 && !used[x+1][y]){
            //mark
            used[x+1][y]=true;
            dfs(grid,used,x+1,y);
            used[x+1][y]=false;
        }
        
        if(y+1<grid[0].length && grid[x][y+1]!=1 && !used[x][y+1]){
            //mark
            used[x][y+1]=true;
            dfs(grid,used,x,y+1);
            used[x][y+1]=false;
        }
        
        return false;
    }
}


 错误解：abstract
 [[0,0],[1,1],[0,0]]

class Solution {
    //11.50pm - 12.12pm
    //还是使用动态规划，但是如果有石头，就不加那个在解法里
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        
        if(m==0||n==0) return 0;
        
        if(obstacleGrid[m-1][n-1]==1) return 0;
        if(obstacleGrid[0][0]==1) return 0;
        
        if(m==1) {
            
            for(int i=0;i<n;i++){
                if(obstacleGrid[0][i]==1){
                    return 0;
                }
            }
            
        }
        
        if(n==1){
            
            for(int i=0;i<m;i++){
                if(obstacleGrid[i][0]==1){
                    return 0;
                }
            }
          
            
            return 1;
        }
            
        
        int[][] dp=new int[m][n];
        

        
        //如果只有一行
        for(int x=0;x<m;x++){
            if(obstacleGrid[x][0]==1){
                for(int j=x;j<m;j++){
                    obstacleGrid[j][0]=0;
                }
            }else{
                dp[x][0]=1;
            }
        }
        
        for(int y=0;y<n;y++){
               if(obstacleGrid[0][y]==1){
                for(int j=y;j<n;j++){
                    obstacleGrid[0][j]=0;
                }
            }else{
                dp[0][y]=1;
            }
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                
                if(obstacleGrid[i-1][j]!=1 && obstacleGrid[i][j-1]!=1){
                      dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }else if(obstacleGrid[i-1][j]==1){
                      dp[i][j]=dp[i][j-1];
                }else if(obstacleGrid[i][j-1]==1){
                      dp[i][j]=dp[i-1][j];
                }     
            }
        }
        
        System.out.println(Arrays.toString(dp));
        
        // return 0;
        return dp[m-1][n-1];
    }
}



















