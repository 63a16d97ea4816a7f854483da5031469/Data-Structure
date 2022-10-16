
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


1594. Maximum Non Negative Product in a Matrix
Medium

639

31

Add to List

Share
You are given a m x n matrix grid. Initially, you are located at the top-left corner (0, 0), and in each step, you can only move right or down in the matrix.

Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right corner (m - 1, n - 1), find the path with the maximum non-negative product. The product of a path is the product of all integers in the grid cells visited along the path.

Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative, return -1.

Notice that the modulo is performed after getting the maximum product.

 

Example 1:


Input: grid = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]
Output: -1
Explanation: It is not possible to get non-negative product in the path from (0, 0) to (2, 2), so return -1.
Example 2:


Input: grid = [[1,-2,1],[1,-2,1],[3,-4,1]]
Output: 8
Explanation: Maximum non-negative product is shown (1 * 1 * -2 * -4 * 1 = 8).
Example 3:


Input: grid = [[1,3],[0,-4]]
Output: 0
Explanation: Maximum non-negative product is shown (1 * 0 * -4 = 0).


DATE: 2022-October-16
TIME: 14:51:17


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


class Solution {
    long max=Integer.MIN_VALUE;
    public int maxProductPath(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        dfs(grid,0,0,1);
        long mod = (int)1e9 + 7;
        return max<0?-1:(int)(max%(mod));
    }
    
    
    public void dfs(int[][] g,int x, int y, long r){
        if(x<0||y<0||x>=g.length||y>=g[0].length){
            return;
        }
        
        r*=g[x][y];
        if(x==g.length-1&&y==g[0].length-1){
            max=Math.max(max,r);
            return;
        }
        dfs(g,x+1,y,r);
        dfs(g,x,y+1,r);
    }
    
    
}



// 加入记忆化搜索：

class Solution {
    long max=Integer.MIN_VALUE;
    HashMap<int[],Long> map=new HashMap<>(); // 记忆化搜索
    public int maxProductPath(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        dfs(grid,0,0,1);
        long mod = (int)1e9 + 7;
        return max<0?-1:(int)(max%(mod));
    }
    
    
    public void dfs(int[][] g,int x, int y, long r){
        if(x<0||y<0||x>=g.length||y>=g[0].length){
            return;
        }
        
        if(map.get(new int[]{x,y})!=null){
            r=map.get(new int[]{x,y});
        }else{
            r*=g[x][y];
            map.put(new int[]{x,y},r);
        }
        
        if(x==g.length-1&&y==g[0].length-1){
            max=Math.max(max,r);
            return;
        }
        
      
        dfs(g,x+1,y,r);
        dfs(g,x,y+1,r);
    }
    
    
}








class Solution {
    public int maxProductPath(int[][] grid) {
        final int MOD = 1000000000 + 7;
        int m = grid.length, n = grid[0].length;
        long[][] maxgt = new long[m][n];
        long[][] minlt = new long[m][n];

        maxgt[0][0] = minlt[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            maxgt[0][i] = minlt[0][i] = maxgt[0][i - 1] * grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            maxgt[i][0] = minlt[i][0] = maxgt[i - 1][0] * grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] >= 0) {
                    maxgt[i][j] = Math.max(maxgt[i][j - 1], maxgt[i - 1][j]) * grid[i][j];
                    minlt[i][j] = Math.min(minlt[i][j - 1], minlt[i - 1][j]) * grid[i][j];
                } else {
                    maxgt[i][j] = Math.min(minlt[i][j - 1], minlt[i - 1][j]) * grid[i][j];
                    minlt[i][j] = Math.max(maxgt[i][j - 1], maxgt[i - 1][j]) * grid[i][j];
                }
            }
        }
        if (maxgt[m - 1][n - 1] < 0) {
            return -1;
        } else {
            return (int) (maxgt[m - 1][n - 1] % MOD);
        }
    }
}

// 作者：力扣官方题解
// 链接：https://leetcode.cn/problems/maximum-non-negative-product-in-a-matrix/solutions/440336/ju-zhen-de-zui-da-fei-fu-ji-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



//看了上面的解法后，修改的（当时我想到存两组值来解决后续+和-号不确定的问题，但是对于细节，没有考虑到）：

class Solution {
    public int maxProductPath(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        long[][] dp=new long[m][n]; // 处理正好情况下的另一组值
        long[][] dpmin=new long[m][n]; // 处理负号情况下的另一组值
        dp[0][0]=grid[0][0]; //  注意第一个dp的起始值
        
        int ci=grid[0][0];
        for(int i=1;i<m;i++){
            ci*=grid[i][0];
            dp[i][0]=ci;
            dpmin[i][0]=ci;
        }
        ci=grid[0][0];
        for(int j=1;j<n;j++){
            ci*=grid[0][j];
            dp[0][j]=ci;
            dpmin[0][j]=ci;
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(grid[i][j]>=0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])*grid[i][j];
                    dpmin[i][j]=Math.min(dpmin[i-1][j],dpmin[i][j-1])*grid[i][j];
                }else{
                    // -号的情况，要取反
                    dp[i][j]=Math.min(dpmin[i-1][j],dpmin[i][j-1])*grid[i][j];
                    dpmin[i][j]=Math.max(dp[i-1][j],dp[i][j-1])*grid[i][j];
                }
            }
        }
        
        int result=(int)(dp[m-1][n-1] % (1e9+7));
        return result<0?-1:result;
    }
}

