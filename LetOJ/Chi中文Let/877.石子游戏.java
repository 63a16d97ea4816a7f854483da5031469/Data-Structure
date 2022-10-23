
/*
 * 
link: 


877.石子游戏

亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。

刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

DATE: 2022-October-23
TIME: 15:31:40

 * 
 */

// 自己写的:
public boolean stoneGame(int[] piles) {
        int n=piles.length;
        // 类似于 环形打家劫舍,分为四类情况讨论: 
        // alice取了前面 bob取了前面.
       // alice取了前面,bob取了最后面.
        // alice取了后面, bob取了前面,
       // alice取了后面,bob取了最后面.

        // 使用dfs,遍历所有的可能性(肯定会超时)

        // 假设 Alice 和 Bob 都发挥出最佳水平(即,每个人都取最大值)
        // 取所有情况的最大值

        int sum=0;
        for(int tmp:piles){
            sum+=tmp;
        }

        //表示第i回合, bob的最多石子数
        int[][] bob=new int[n][4];
// bob在最开始没有石子,alice每次先手
        bob[0][0]=0;

        for(int i=1;i<n;i++){
           // alice取了前面, bob在i,0处的最大值,来自于 bob前一个的两种状态的最大值+取前面
            bob[i][0]=bob[i-1][0]+piles[i];
           // alice取了前面, bob在i,0处的最大值,来自于 bob前一个的两种状态的最大值+只取后面
            bob[i][1]=bob[i-1][1]+piles[n-i];

            // alice取了最后面, bob在i,2处的最大值,来自于 bob前一个的两种状态的最大值+取前面
            bob[i][2]=bob[i-1][2]+piles[i-1];
            // alice取了最后面, bob在i,3处的最大值,来自于 bob前一个的两种状态的最大值+只取后面
            bob[i][3]=bob[i-1][3]+piles[n-i-1];
        }
        int maxBob=0;
        for(int j=0;j<4;j++){
            maxBob=Math.max(maxBob,bob[n-1][j]);
        }
       return maxBob-(sum-maxBob)>0;
    }



















