
/*
 * 
link: 
岛屿的最大面积 leetcode

2020-7-12 at 10:38 pm

695. 岛屿的最大面积
难度
中等

313

收藏

分享
切换为英文
关注
反馈
给定一个包含了一些 0 和 1 的非空二维数组 grid 。

一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。

找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)

 

示例 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。

示例 2:

[[0,0,0,0,0,0,0,0]]
对于上面这个给定的矩阵, 返回 0。

 

注意: 给定的矩阵grid 的长度和宽度都不超过 50。


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    //10.32pm-10.37pm
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ans=Math.max(ans,area(grid,visited,i,j));
                }
            }
        return ans;
    }
    
    public int area(int[][] grid,boolean[][] visited,int x, int y){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||visited[x][y]||grid[x][y]==0){
            return 0;
        }
        
        visited[x][y]=true;
        
        return (1+area(grid,visited,x+1,y)+area(grid,visited,x-1,y)+area(grid,visited,x,y+1)+area(grid,visited,x,y-1));
    }
}


















