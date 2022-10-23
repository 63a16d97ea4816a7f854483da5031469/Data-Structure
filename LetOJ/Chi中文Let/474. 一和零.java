
/*
 * 
link: 


474. 一和零
中等

813

相关企业

给你一个二进制字符串数组 strs 和两个整数 m 和 n 。

请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。

如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。

示例 1：

输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3

输出：4

解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。

其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。


示例 2：

输入：strs = ["10", "0", "1"], m = 1, n = 1

输出：2

解释：最大的子集是 {"0", "1"} ，所以答案是 2 。


提示：

1 <= strs.length <= 600

1 <= strs[i].length <= 100

strs[i] 仅由 '0' 和 '1' 组成

1 <= m, n <= 100
 


DATE: 2022-October-23
TIME: 15:39:52


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

// 01背包问题,只是放到weight是 m,n
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        // i==0,表示不选择任何字符串,dp结果自然为0
        // 选择第i个字符串,i从1开始,仍然剩下m个0和n个1
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        // 选择第i个字符串,从i=1开始到i=n为止
        for (int i = 1; i <= length; i++) {
            // 获得0和1的个数,并用int[]返回
            int[] zerosOnes = getZerosOnes(strs[i - 1]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            // 遍历j,k的所有可能性
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    // 如果后面条件不满足,那么就等于dp[i-1][j][k],即不选择i
                    dp[i][j][k] = dp[i - 1][j][k];
                    // 只有当j>=zeros && k>=ones
                    if (j >= zeros && k >= ones) {
                        // 满足条件,则dp值在Math.max(不选这个第i数,选择这个第i数)
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        //返回最长n的m和n都满足的结果
        return dp[length][m][n];
    }

    public int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }
}


作者：力扣官方题解
链接：https://leetcode.cn/problems/ones-and-zeroes/solutions/814806/yi-he-ling-by-leetcode-solution-u2z2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



















