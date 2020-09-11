
/*
 * 
link: 
https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/

2020-09-11 at 11:00 pm

375. 猜数字大小 II
难度
中等

182

收藏

分享
切换为英文
关注
反馈
我们正在玩一个猜数游戏，游戏规则如下：

我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。

每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。

然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。

示例:

n = 10, 我选择了8.

第一轮: 你猜我选择的数字是5，我会告诉你，我的数字更大一些，然后你需要支付5块。
第二轮: 你猜是7，我告诉你，我的数字更大一些，你支付7块。
第三轮: 你猜是9，我告诉你，我的数字更小一些，你支付9块。

游戏结束。8 就是我选的数字。

你最终要支付 5 + 7 + 9 = 21 块钱。
给定 n ≥ 1，计算你至少需要拥有多少现金才能确保你能赢得这个游戏。




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                // 从 i ~ j 寻找最小的开销
                for (int x = i; x < j; x++) {
                    // 后半部分表示当花了 x 之后可以在 i ~ x - 1 或者 x + 1 ~ j 的开销内找最大开销确保能对
                    dp[i][j] = Math.min(dp[i][j], x + Math.max(dp[i][x - 1], dp[x + 1][j]));
                }
            }
        }
        // 返回从 1 ~ n 猜中某个数字的最小命中的开销(不是最小开销，是确保能赢的最小开销)
        return dp[1][n];
    }
}

// 作者：Jasion_han
// 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/solution/375-cai-shu-zi-da-xiao-ii-zai-que-bao-neng-ying-de/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




















