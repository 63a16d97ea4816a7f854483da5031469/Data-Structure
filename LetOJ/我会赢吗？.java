
/*
 * 
leetcode-cn 随机面试练习：

在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到 100 的玩家，即为胜者。

如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？

例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。

给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？

你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。

示例：

输入：
maxChoosableInteger = 10
desiredTotal = 11

输出：
false

解释：
无论第一个玩家选择哪个整数，他都会失败。
第一个玩家可以选择从 1 到 10 的整数。
如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。

21 June 2020 at 4:35 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



// AC:
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int canReachTotal = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (canReachTotal < desiredTotal) { // 达不到
            return false;
        } else if (canReachTotal == desiredTotal) { // 刚好达到，maxChoosableInteger奇数赢
            return (maxChoosableInteger & 1) == 1;
        }
        
        return canWin(0, desiredTotal, maxChoosableInteger, new int[1 << maxChoosableInteger]);
    }
    
    private boolean canWin(int bits, int distance, int maxChoosableInteger, int[] dp) {
        if (dp[bits] != 0) { // 已经计算过。0：未计算，1：true，2：false
            return dp[bits] == 1;
        }
        
        boolean result = false;
        for (int cur = maxChoosableInteger; cur > 0; cur--) {
            int curBit = 1 << (cur - 1);
            if ((bits & curBit) == 0) { // 当前值没有被使用
                if (cur >= distance // 可以一步成功
                    || !canWin(bits | curBit, distance - cur, maxChoosableInteger, dp)) { // 如果能找到一步让对方无法赢
                    result = true;
                    break;
                }
            }
        }
        
        dp[bits] = result ? 1 : 2;
        return result;
    }
}

// 作者：tao1428
// 链接：https://leetcode-cn.com/problems/can-i-win/solution/shi-yong-dai-you-bei-wang-lu-de-shen-du-you-xian-s/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



















