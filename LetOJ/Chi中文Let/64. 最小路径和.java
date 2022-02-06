
/*
 * 
link: https://leetcode-cn.com/problems/minimum-path-sum/


2022-02-06 at 20:52
 
64. 最小路径和
难度
中等

1129

收藏

分享
切换为英文
接收动态
反馈
给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

 

示例 1：


输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。
示例 2：

输入：grid = [[1,2,3],[4,5,6]]
输出：12
 

提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100


刚看到想到的思路是什么？：

动态规划。

唯一的问题是，边界上的值是如何计算的。（这个部分我有怀疑过我自己，但是我还是坚持写下去了，自信很重要）

另一个思路是 DFS

意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */





class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        if(m==0) return 0;

        //动态规划
        int[][] dp=new int[m+1][n+1];

        // Fill each row with -1. 
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0]=grid[0][0];
        
        for(int i=0;i<m;i++){
            int tmp=i;
            int sum=0;
            while(tmp>=0){
                sum+=grid[tmp--][0];
            }
            dp[i][0]=sum;
        }

        for(int i=0;i<n;i++){
            int tmp=i;
            int sum=0;
            while(tmp>=0){
                sum+=grid[0][tmp--];
            }
            dp[0][i]=sum;
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}







[[1,2,5],
 [3,2,1]]


0 0 >> 1 sum:1
1 0 >> 3 sum:4
1 1 >> 2 sum:6
1 2 >> 1 sum:7
0 1 >> 2 sum:3
0 2 >> 5 sum:8

0 0 >> 1 sum:1
0 1 >> 2 sum:3
0 2 >> 5 sum:8
1 2 >> 1 sum:9
1 1 >> 2 sum:5
1 0 >> 3 sum:4


错误解 (原因是错误的使用了 visit标志数组，这个情况是枚举，应该是不需要标志数组)：

class Solution {
    int min=Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        if(grid.length==0) return 0;
        
        boolean[][] v=new boolean[grid.length][grid[0].length];
        dfs(grid,v,0,0,0);
        return min;
    }

    public void dfs(int[][] grid, boolean[][] v, int x, int y, int sum){
        if(x<0||x>grid.length-1||y<0||y>grid[0].length-1){
            return;
        }

        if(v[x][y]) return;

        v[x][y]=true;
        sum+=grid[x][y];

        System.out.println(x+" "+y+" >> "+grid[x][y]+" sum:"+sum);

        if(x==grid.length-1&&y==grid[0].length-1){
            min=Math.min(sum,min);
        }

        //向下
        dfs(grid,v,x+1,y,sum);
        //向右
        dfs(grid,v,x,y+1,sum);
    }
}









超出时间限制:

class Solution {
    int min=Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        if(grid.length==0) return 0;
        
        dfs(grid,0,0,0);
        return min;
    }

    public void dfs(int[][] grid, int x, int y, int sum){
        if(x<0||x>grid.length-1||y<0||y>grid[0].length-1){
            return;
        }
        sum+=grid[x][y];
        // System.out.println(x+" "+y+" >> "+grid[x][y]+" sum:"+sum);

        if(x==grid.length-1&&y==grid[0].length-1){
            min=Math.min(sum,min);
        }

        //向下
        dfs(grid,x+1,y,sum);
        //向右
        dfs(grid,x,y+1,sum);
    }
}



