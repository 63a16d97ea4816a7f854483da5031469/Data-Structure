
/*
 * 
link: 
https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/

2022-02-07 at 23:21


剑指 Offer 13. 机器人的运动范围
难度
中等

147

收藏

分享
切换为英文
关注
反馈
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

 

示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20



对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    //9.54pm-10.04pm
    int[][] grid;
    boolean[][] visited;
    int gk;
    int count=0;
    public int movingCount(int m, int n, int k) {
        grid=new int[m][n];
        visited=new boolean[m][n];
        gk=k;
        dfs(0,0);
        return count;
    }
    public void dfs(int x, int y){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length|| visited[x][y] || !isValid(x,y)) return;
        count++;
        visited[x][y]=true;
        dfs(x-1,y);
        dfs(x, y-1);
        dfs(x+1,y);
        dfs(x,y+1);
    }

    public boolean isValid(int x, int y){
        int sum=0;
        while(x>0){
            sum+=(x%10);
            x/=10;
        }
        while(y>0){
            sum+=(y%10);
            y/=10;
        }
        return sum<=gk;
    }
}







class Solution {
    int bound=0;
    public int movingCount(int m, int n, int k) {
        if(m==0) return 0;

        boolean[][] v=new boolean[m][n];
        bound=k;
        dfs(v,0,0);
        int count=0;
        for(int i=0;i<v.length;i++){
            for(int j=0;j<v[i].length;j++){
                if(v[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(boolean[][] v, int x, int y){

        //出界
        if(x<0||y<0||x>=v.length||y>=v[0].length){
            return;
        }

        // 访问过,返回
        if(v[x][y]){
            return;
        }

        // 行坐标和列坐标的数位之和大于k的格子
        if(sum(x)+sum(y)>bound){
            return;
        }

        v[x][y]=true;

        dfs(v,x+1,y);
        dfs(v,x-1,y);
        dfs(v,x,y+1);
        dfs(v,x,y-1);
    }
    public int sum(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}













