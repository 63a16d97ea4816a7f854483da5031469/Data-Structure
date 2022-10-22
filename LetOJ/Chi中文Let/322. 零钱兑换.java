
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




















