
/*
 * 
link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/

DATE: 2022-November-04
TIME: 21:40:35

123. Best Time to Buy and Sell Stock III
Hard
7.3K
141
Companies
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 105
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



动态规划解决:

for (int i = 1; i < prices.length; i++) {
      // 持有股票，还有两次交易机会
      // 持有股票,还有两次机会=max{仍然维持上次选择,立刻持有}
      hold[0][i] = Math.max(hold[0][i - 1], -prices[i])
      // 持有股票，还有一次交易机会(易错点,从不持有股票还有2次机会,转移而来)
      // 持有股票仍有1次机会=max{仍然维持上次选择,之前不持有现在立刻持有(从仍然有两次机会的不持有转移)}
      hold[1][i] = Math.max(hold[1][i - 1], notHold[0][i - 1] - prices[i])

      // 不持有股票，还有两次交易机会
      // 持有股票仍然有两次机会=max{维持之前不选择的值,现在卖出}
      notHold[0][i] = Math.max(notHold[0][i - 1], prices[i] + hold[0][i - 1])
      // 不持有股票，还有一次交易机会
      // 持有股票仍然有一次机会=max{维持之前的选择,现在卖出}
      notHold[1][i] = Math.max(notHold[1][i - 1], prices[i] + hold[1][i - 1])
    }
    
    return notHold[1][prices.length - 1]




class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;

        // 0 ---> still get 2 transactions
        // 1 ---> still get 1 transaction
        int[][] hold=new int[n][2];
        int[][] notHold=new int[n][2];

        //易错点,两维度,均可以买入
        hold[0][0]=-prices[0];
        hold[0][1]=-prices[0];

        notHold[0][0]=0;
        notHold[0][1]=0;
        
        for(int i=1;i<n;i++){
            hold[i][0]=Math.max(hold[i-1][0],-prices[i]);
            // 易错点, hold[i][1]是从notHold[i-1][0]转移而来(从仍然有两个交易机会,转移到仍然只有一个交易机会)
            hold[i][1]=Math.max(hold[i-1][1],notHold[i-1][0]-prices[i]);
            notHold[i][0]=Math.max(notHold[i-1][0], hold[i-1][0]+prices[i]);
            notHold[i][1]=Math.max(notHold[i-1][1],hold[i-1][1]+prices[i]);
        }
        // 易错点,只需要返回notHold的只有一个交易机会的最后值
        return notHold[n-1][1];
    }
}





















