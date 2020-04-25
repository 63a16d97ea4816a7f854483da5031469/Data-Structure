
/*
 * 
https://leetcode.com/problems/coin-change/

322. Coin Change
Medium

3355

118

Add to List

Share
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :
经典DP思想



 * 
 */




class Solution {
    //1.06pm
    //初步思想为dp
    public int coinChange(int[] coins, int amount) {
        // 解决边界条件
        if(coins==null||coins.length<=0||amount<0) return -1;
        int[] dp =new int[amount+1];
        //因为是取最小值，所以设定amount+1为上限
        Arrays.fill(dp, amount+1);
        //设置第一个数
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            // 寻找每一个数的dp值
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]==(amount+1)? -1: dp[amount];
    }
}










class Solution {
    //1.06pm
    //初步思想为dp
    public int coinChange(int[] coins, int amount) {
        
        int n=Math.max(amount, coins.length);
        int[] dp =new dp[n+1];
        
        
        for(int i=1;i<amount;i++){
            
            // 寻找每一个数的dp值
            
            for(int j=0;j<coins.length;j++){
                
            }
            
            
        }
        
        
    }
}















