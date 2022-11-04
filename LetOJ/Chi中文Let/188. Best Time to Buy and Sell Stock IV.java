
/*
 * 
link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

DATE: 2022-November-04
TIME: 21:40:35

188. Best Time to Buy and Sell Stock IV
Hard
5.8K
190
Companies
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

Constraints:

1 <= k <= 100
1 <= prices.length <= 1000
0 <= prices[i] <= 1000



刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public int maxProfit(int k, int[] prices) {
  if (prices.length == 0 || prices.length == 1) {
      return 0;
    }

    if (k == 0) {
      return 0;
    }

    if (k >= prices.length / 2) {
      //转化为不限制次数的dp
      k = -1;
    }

    int n = prices.length;

    if (k == -1) {
      //转化为不限制次数的dp
      int[] hold = new int[n];
      int[] notHold = new int[n];
      hold[0] = -prices[0];
      notHold[0] = 0;

      for (int i = 1; i < prices.length; i++) {
        hold[i] = Math.max(hold[i - 1], notHold[i - 1] - prices[i]);
        notHold[i] = Math.max(notHold[i - 1], prices[i] + hold[i - 1]);
      }
      return notHold[prices.length - 1];

    } else {
      int[][] hold = new int[k][n];
      int[][] notHold = new int[k][n];

      for (int i = 0; i < k; i++) {
        //易错点,每个维度i的起点,都是-prices[0]
        hold[i][0] = -prices[0];
        notHold[i][0] = 0;
      }

      for (int i = 1; i < prices.length; i++) {
        for (int j = 0; j < k; j++) {
          //对第一回合进行特殊处理  
          if (j == 0) {
            hold[j][i] = Math.max(hold[j][i - 1], -prices[i]);
          } else {
            // 第j回合的,由第j-1回合转移而来, 每次都是从上一个回合转移而来
            hold[j][i] = Math.max(hold[j][i - 1], notHold[j - 1][i - 1] - prices[i]);
          }
          notHold[j][i] = Math.max(notHold[j][i - 1], prices[i] + hold[j][i - 1]);
        }
      }

      return notHold[k - 1][prices.length - 1];
    }
  }
}





















