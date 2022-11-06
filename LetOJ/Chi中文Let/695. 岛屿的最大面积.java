
/*
 * 
link: https://leetcode-cn.com/problems/max-area-of-island/

695. 岛屿的最大面积
难度
中等

675


给你一个大小为 m x n 的二进制矩阵 grid 。

岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。

岛屿的面积是岛上值为 1 的单元格的数目。

计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。

 

示例 1：


输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
输出：6
解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
示例 2：

输入：grid = [[0,0,0,0,0,0,0,0]]
输出：0
 

提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] 为 0 或 1



2022-02-01 at 21:51
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



输出
5
差别
预期结果
6


// 错误的主要原因: DFS如果不累加四个方向的面积,
// 在有boolean的情况下,是在算单个选择方向一直走到头的面积,这样会漏掉一些面积.
class Solution {
    int max=0;
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] v=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(grid,v,i,j,0);
                }
            }
        }
        return max;
    }

    public void dfs(int[][] grid, boolean[][] v, int x, int y, int land){
        int m=grid.length;
        int n=grid[0].length;
        // 出界
        if(x<0||y<0||x>=m||y>=n){
            return;
        }
        // 如果不是陆地，也跳过; 如果访问过，也跳过
        if(grid[x][y]==0||v[x][y]){
            return;
        }
        System.out.println("==> "+x+" "+y+" land:"+land);
        if(grid[x][y]==1&&!v[x][y]){
            // 增加
            land++;
            // 设置标志
            v[x][y]=true;
            max=Math.max(land,max);
        }
        dfs(grid,v,x+1,y,land);
        dfs(grid,v,x-1,y,land);
        dfs(grid,v,x,y-1,land);
        dfs(grid,v,x,y+1,land);
    }
}



==> 3 8 land:1
==> 4 8 land:2
==> 4 9 land:3
==> 4 10 land:4
==> 5 10 land:5
==> 3 10 land:5





正确：

class Solution {
    int max=0;
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] v=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(grid,v,i,j,0);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, boolean[][] v, int x, int y, int land){
        int m=grid.length;
        int n=grid[0].length;
        // 出界
        if(x<0||y<0||x>=m||y>=n){
            return land;
        }
        // 如果不是陆地，也跳过; 如果访问过，也跳过
        if(grid[x][y]==0||v[x][y]){
            return land;
        }
        if(grid[x][y]==1&&!v[x][y]){
            // 增加
            land++;
            // 设置标志
            v[x][y]=true;
        }
        land=Math.max(dfs(grid,v,x+1,y,land),land);
        land=Math.max(dfs(grid,v,x-1,y,land),land);
        land=Math.max(dfs(grid,v,x,y-1,land),land);
        land=Math.max(dfs(grid,v,x,y+1,land),land);
        max=Math.max(land,max);
        return land;
    }
}



// 普通的DFS的写法,会漏掉面积,这里使用的是循环.
class Solution {
    int result=0;
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    result=Math.max(result,dfs(grid,i,j));
                }
            }
        }

        return result;
    }

    public int dfs(int[][] grid, int x, int y){

        if(x<0||y<0||x>=grid.length||y>=grid[0].length){
                return 0;
        }

        if(grid[x][y]==0){
            return 0; // 如果是0,则停止
        }

        int ans=1; //能到这里,肯定已经是有1个面积

        //这句非常关键,因为这样就省去了boolean[][] v
        grid[x][y]=0; // 对已经访问的节点置为0,防止重复访问

        int[][] m=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=0;i<m.length;i++){
            int dx=m[i][0];
            int dy=m[i][1];
            int currX=dx+x;
            int currY=dy+y;
            ans+=dfs(grid,currX,currY);
        }

        //如果需要回溯,则这里可以恢复状态;
        // grid[x][y]=1

       return ans;
    }
}














