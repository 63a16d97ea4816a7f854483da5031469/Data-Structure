
/*
 * 
link: https://leetcode-cn.com/problems/rotting-oranges/

994. 腐烂的橘子
难度
中等

481

收藏

分享
切换为英文
关闭提醒
反馈
在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：

值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。

返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。

 

示例 1：



输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
输出：4
示例 2：

输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
输出：-1
解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
示例 3：

输入：grid = [[0,2]]
输出：0
解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 

提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] 仅为 0、1 或 2


2022-01-25 at 21:49
 

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length==0) return 0;

        int m=grid.length;
        int n=grid[0].length;

        int count=0;
        LinkedList<int[]> queue=new LinkedList<int[]>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    count++;
                }
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        // add the first level end mark
        queue.add(new int[]{-1,-1});

        int minute=0;
        while(!queue.isEmpty()){
            int[] head=queue.removeFirst();
            int x=head[0];
            int y=head[1];

            if(x==-1&&y==-1){
                minute++;

                if(!queue.isEmpty()){
                    queue.add(new int[]{-1,-1});
                }
                continue;
            }

            if(x+1<m&&grid[x+1][y]==1){
                count--;
                grid[x+1][y]=2;
                queue.add(new int[]{x+1,y});
            }
            if(x-1>=0&&grid[x-1][y]==1){
                count--;
                grid[x-1][y]=2;
                queue.add(new int[]{x-1,y});
            }
            if(y+1<n&&grid[x][y+1]==1){
                count--;
                grid[x][y+1]=2;
                queue.add(new int[]{x,y+1});
            }
            if(y-1>=0&&grid[x][y-1]==1){
                count--;
                grid[x][y-1]=2;
                queue.add(new int[]{x,y-1});
            }
        }

    if(count>0) return -1;

    return minute-1;
    }
}




















