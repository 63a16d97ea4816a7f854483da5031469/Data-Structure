
/*
 * 
link: https://leetcode-cn.com/problems/unique-paths/

62. 不同路径
难度
中等

1256

收藏

分享
切换为英文
接收动态
反馈
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？

 

示例 1：


输入：m = 3, n = 7
输出：28
示例 2：

输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下
示例 3：

输入：m = 7, n = 3
输出：28
示例 4：

输入：m = 3, n = 3
输出：6
 

提示：

1 <= m, n <= 100
题目数据保证答案小于等于 2 * 109

2022-01-25 at 22:40
 

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


 * 
 */


// 错误,忘记处理第一行和第一列特殊边界:

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] s=new int[m+1][n+1];
        s[0][0]=0;
        s[1][0]=1
        s[0][1]=1
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++){
                s[i][j]= s[i-1][j]+s[i][j-1];
            }
       return s[m][n];
    }
}




class Solution {
    public int uniquePaths(int m, int n) {
        int[][] s=new int[m+1][n+1];
        s[0][0]=0;
        s[1][0]=1;
        s[0][1]=1;

        // 处理特殊边界：
        for(int i=0;i<m;i++){
            s[i][0]=1;
        }
        for(int j=0;j<n;j++){
            s[0][j]=1;
        }

        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++){
                s[i][j]= s[i-1][j]+s[i][j-1];
            }
            
       return s[m-1][n-1];
    }
}











