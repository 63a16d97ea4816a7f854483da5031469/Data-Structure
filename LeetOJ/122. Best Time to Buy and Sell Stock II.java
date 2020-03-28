
/*
 * 

 122. Best Time to Buy and Sell Stock II
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

122. Best Time to Buy and Sell Stock II
Easy

1744

1595

Add to List

Share
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.


28 March 2020 at 8:33:31 pm
 * 
 */


看题解：
波峰，波谷法：

class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int i=0;
        int low=0;
        int high=0;
        int max=0;
        while(i<n-1){
            while(i<n-1 && prices[i]>=prices[i+1]){
                i++;
            }
            low=prices[i];
            while(i<n-1 && prices[i]<=prices[i+1]){
                i++;
            }
            high=prices[i];
            
            max+=high-low;
        }
        return max;
    }
}





看题解： 超时

但是比较有启发的是这个思路：

暴力破解：

class Solution {
    public int maxProfit(int[] prices) {
        
        return findMax(prices,0);
    }
    
    int findMax(int[] prices, int s){
        
        if(s>=prices.length) return 0;
        
        int max=0;
 
        for(int start=s;start<prices.length;start++){
            int max_profit=0;
            for(int j=start+1;j<prices.length;j++){
                max_profit=Math.max(max_profit,findMax(prices, j+1)+(prices[j]-prices[start]));
            }
            max=Math.max(max,max_profit);
        }
        
        return max;
    }
}

























