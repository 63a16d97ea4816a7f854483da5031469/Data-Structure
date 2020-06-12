
/*
 * 
https://leetcode.com/problems/perfect-squares/


279. Perfect Squares
Medium

2332

175

Add to List

Share
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

 * 
 */



class Solution {
    public int numSquares(int n) {
      int[] dp = new int[n+1];
        
        /* i表示从0到n的数，j表示平方根 */
      for(int i = 1; i <= n; ++i) {
          int min = Integer.MAX_VALUE;
          for(int j = 1; j * j <= i; ++j) {
              min = Math.min(min, 1 + dp[i-j*j]);
          }
          dp[i] = min;
      }
      return dp[n];
        
  }
}

/*

只需要找到j*j之前的dp[i-j*j]的，然后加1就可以了，那个1就是j*j

dp[1]=dp[0]=1;
dp[2]=

i=4 j=1   Math.min(min, 1+dp[3])
i=4 j=2   Math.min(min, 1+dp[0])

dp[4]=


*/























