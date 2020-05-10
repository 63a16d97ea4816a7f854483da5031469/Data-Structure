
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


72. Edit Distance
Hard

3309

50

Add to List

Share
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

10 May 2020 at 8:39pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */







class Solution {
    public int minDistance(String word1, String word2) {
      int n = word1.length();
      int m = word2.length();
      int[][] dp = new int[n + 1][m + 1];
      for (int i = 0; i < m + 1; i++) {
          dp[0][i] = i;
      }
      for (int i = 0; i < n + 1; i++) {
          dp[i][0] = i;
      }
      for (int i = 1; i < n + 1; i++) {
          for (int j = 1; j < m + 1; j++) {
              if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                  dp[i][j] = dp[i - 1][j - 1];
              } else {
                  dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
              }
          }
      }
      return dp[n][m];
  }
  }
  
  // 作者：morethink
  // 链接：https://juejin.im/post/5c5d4c026fb9a049e93d2fe3
  // 来源：掘金
  // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


















