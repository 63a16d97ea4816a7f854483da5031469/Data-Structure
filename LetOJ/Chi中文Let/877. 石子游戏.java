
/*
 * 
link: 
https://leetcode.cn/problems/stone-game/description/

877. 石子游戏
中等
455
相关企业
Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i] 。

游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。

Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中 石子最多 的玩家 获胜 。

假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回 true ，当 Bob 赢得比赛时返回 false 。

 

示例 1：

输入：piles = [5,3,4,5]
输出：true
解释：
Alice 先开始，只能拿前 5 颗或后 5 颗石子 。
假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
如果 Bob 拿走前 3 颗，那么剩下的是 [4,5]，Alice 拿走后 5 颗赢得 10 分。
如果 Bob 拿走后 5 颗，那么剩下的是 [3,4]，Alice 拿走后 4 颗赢得 9 分。
这表明，取前 5 颗石子对 Alice 来说是一个胜利的举动，所以返回 true 。
示例 2：

输入：piles = [3,7,2,3]
输出：true
 

提示：

2 <= piles.length <= 500
piles.length 是 偶数
1 <= piles[i] <= 500
sum(piles[i]) 是 奇数



刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

DATE: 2022-October-22
TIME: 15:00:15

 * 
 */


class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        // 类似于 环形打家劫舍,分为两类情况讨论: 
        // alice取了前面 bob取了前面,bob取了最后面,
        // alice取了后面 bob取了前面,bob取了最后面.

        // 使用dfs,遍历所有的可能性(肯定会超时)

        // 假设 Alice 和 Bob 都发挥出最佳水平(即,每个人都取最大值)
        // 取所有情况的最大值

        int sum=0;
        for(int tmp:piles){
            sum+=tmp;
        }

        //表示第i回合, bob的最多石子数
        int[][] bob=new int[n][4];
        bob[0][0]=0;
        for(int i=1;i<n;i++){
            // alice取了前面, bob在i,0处的最大值,来自于 bob前一个的两种状态的最大值+取前面
            bob[i][0]=bob[i-1][0]+piles[i];
            // alice取了前面, bob在i,0处的最大值,来自于 bob前一个的两种状态的最大值+只取后面
            bob[i][1]=bob[i-1][1]+piles[n-i];

            // alice取了最后面, bob在i,0处的最大值,来自于 bob前一个的两种状态的最大值+取前面
            bob[i][2]=bob[i-1][2]+piles[i-1];
            // alice取了最后面, bob在i,0处的最大值,来自于 bob前一个的两种状态的最大值+只取后面
            bob[i][3]=bob[i-1][3]+piles[n-i-1];
        }
        int maxBob=0;
        for(int j=0;j<4;j++){
            maxBob=Math.max(maxBob,bob[n-1][j]);
        }
        return maxBob-(sum-maxBob)>0;
    }
}




