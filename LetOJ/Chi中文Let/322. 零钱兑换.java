
/*
 * 
link: 

https://leetcode.cn/problems/coin-change/

322. 零钱兑换
中等
2.2K
相关企业
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

你可以认为每种硬币的数量是无限的。

 

示例 1：

输入：coins = [1, 2, 5], amount = 11
输出：3 
解释：11 = 5 + 5 + 1
示例 2：

输入：coins = [2], amount = 3
输出：-1
示例 3：

输入：coins = [1], amount = 0
输出：0
 

提示：

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104



DATE: 2022-October-22
TIME: 15:46:15
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




// 使用动态规划:

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];

        // 初始值为最大值+1
        Arrays.fill(dp, max);
        dp[0] = 0;

        // 从1开始,遍历所有的amount的值,从小到大,建立递推金字塔
        for (int i = 1; i <= amount; i++) {
           //遍历所有coin的面值
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) { // 当前coin的面值<剩余拼凑amount的值i
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}


时间复杂度：O(Sn)，其中 SSS 是金额，nnn 是面额数。我们一共需要计算 O(S) 个状态，SSS 为题目所给的总金额。对于每个状态，每次需要枚举 nnn 个面额来转移状态，所以一共需要 O(Sn) 的时间复杂度。
空间复杂度：O(S)。数组dp 需要开长度为总金额 S 的空间。

作者：力扣官方题解
链接：https://leetcode.cn/problems/coin-change/solutions/132979/322-ling-qian-dui-huan-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// 链接：https://leetcode.cn/problems/coin-change/solutions/132979/322-ling-qian-dui-huan-by-leetcode-solution/








public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
          // 在这里,使用了res<min,来依次只取最小值
            if (res >= 0 && res < min) {
         //  假设 F(S)是组成该面额最少硬币的最少面额数, C是最后一枚硬币的面额
        // 最优子结构, F(要拆分Amount S)=F(S-C(当前面额))+1
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}

时间复杂度：O(Sn)，其中 S 是金额，n 是面额数。我们一共需要计算 S 个状态的答案，且每个状态 F(S)由于上面的记忆化的措施只计算了一次，而计算一个状态的答案需要枚举 n个面额值，所以一共需要 O(Sn) 的时间复杂度。
空间复杂度：O(S)，我们需要额外开一个长为 S 的数组来存储计算出来的答案 F(S)










// 这种解法会超时

class Solution {
    //如果使用dfs,可能会超时
    List<String> result=new ArrayList<>();
    public int coinChange(int[] coins, int amount) {
        dfs(coins,amount,0, "");
        for(String tmp:result){
            System.out.println(tmp);
        }
         return 3;
    }
    public void dfs(int[] coins, int amount, int index, String str){
        if(amount<0) return;

        if(amount==0){
            if(!result.contains(str)){
                System.out.println(str);
                result.add(str);
            }
            return;
        }
        // 因为是从0开始,所以不需要另外继续开一个index+1
        for(int i=0;i<coins.length;i++){
            //继续深入
            // amount,  str在这里都是 程序自己matain的变量,不需要remove每次加上去的部分,如果使用 对象类型变量,则需要自己处理回溯状态
            dfs(coins,amount-coins[i], i, str+coins[i]+",");
            // System.out.println("-> "+(amount-coins[i])+" amount: "+amount+" coin: "+coins[i]+" "+i);
        }
    }

}




















