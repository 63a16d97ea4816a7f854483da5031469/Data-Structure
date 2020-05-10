
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




/*
1 解题思想

编辑距离，即给了字符串T1和字符串T2，试问通过插入、删除、替换等的操作，T1可以通过几步变换成T2？

这道题首先还是动态规划解决，构建n*m矩阵，位置[i,j]标示串T1[0,i]和T2[0,j]的编辑距离。

显而易见的是，对于矩阵中的i,j位置，他可以有如下三种方式变换： 
1、从i-1,j 为T1增加一个字符，获得i，j，这样编辑距离本身就需要+1 
2、同理，从i，j-1过来，编辑距离必须+1。 
3、从i-1，j-1位置变换过来，那么这个时后，如果T1在i的取值和T2在j的取值一样，那么这个变换，编辑距离不变，如果不一样，那么就需要做替换操作，那么必须+1.

如上我们就看到了每一个子问题的求解方式，那么对于答案： 
1、首先构造边界的值，如i=0，j=0的时候，编辑距离就是和已匹配的长度一样，因为全都要做插入 
2、按照顺序遍历 
3、输出最终位置的答案。

我说的可能不够详细，可以看我代码里提供的一个参考链接
————————————————
版权声明：本文为CSDN博主「学术状态抽奖器」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/MebiuW/article/details/51420544
*/



public class Solution {
    /**
     * 编辑距离有经典算法，请看http://www.cnblogs.com/pandora/archive/2009/12/20/levenshtein_distance.html
     * */
    public int minDistance(String word1, String word2) {
        int n=word1.length(),m=word2.length(),cost;
        int dp[][]=new int [n+1][m+1];
        //初始化
        for(int i=0;i<=n;i++)
            dp[i][0]=i;
        for(int i=0;i<=m;i++)
            dp[0][i]=i;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
                cost= word1.charAt(i-1)==word2.charAt(j-1)?0:1;
                dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]+cost);
            }
        }
        return dp[n][m];
    }
}



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


















