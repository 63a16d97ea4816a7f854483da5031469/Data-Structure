
/*
 * 
link: https://leetcode-cn.com/problems/unique-paths-ii/

63. 不同路径 II
难度
中等

715

收藏

分享
切换为英文
接收动态
反馈
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

网格中的障碍物和空位置分别用 1 和 0 来表示。

 

示例 1：


输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
输出：2
解释：3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
示例 2：


输入：obstacleGrid = [[0,1],[0,0]]
输出：1
 

提示：

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] 为 0 或 1


2022-01-17 at 19:04
 


刚看到想到的思路是什么？：
动态规划

意识到的边界条件是什么？：

漏掉了：
(1）如果第一个入口是block的，那么应该是返回0
(2) 如果边沿的点，有一个被block住，那么其后续，也为0 (这个包含了point 1)


考虑到的速度和空间复杂度是多少？：

O(n平方)
O(n平方)

对题目易错地方进行总结:

漏掉了：
(1）如果第一个入口是block的，那么应该是返回0
(2) 如果边沿的点，有一个被block住，那么其后续，也为0 (这个包含了point 1)


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        //极限case，如果第一个是block的，整个肯定为0
        if(obstacleGrid[0][0]==1) return 0;

        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            // 如果在这一行被堵住，则后面都没法过去
            if(obstacleGrid[i][0]==1) {
                break;
            }
            dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            // 如果在这一行被堵住，则后面都没法过去
            if(obstacleGrid[0][i]==1) {
                break;
            }
            dp[0][i]=1;
        }
       
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}



















