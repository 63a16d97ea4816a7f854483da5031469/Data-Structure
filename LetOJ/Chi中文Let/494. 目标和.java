
/*
 * 
 

 494. 目标和
中等
1.4K
相关企业
给你一个整数数组 nums 和一个整数 target 。

向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：

例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

 

示例 1：

输入：nums = [1,1,1,1,1], target = 3
输出：5
解释：一共有 5 种方法让最终目标和为 3 。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
示例 2：

输入：nums = [1], target = 1
输出：1
 

提示：

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000


DATE: 2022-October-22
TIME: 19:00:31


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

//动态规划
class Solution {
  public int findTargetSumWays(int[] nums, int target) {
    int l = nums.length;
    int sun = 0;
    for (int i: nums) sun += i;
    if (target > sun || -target > sun) return 0;
    if ((sun + target) % 2 == 1) return 0;
    int t = (sun + target) / 2;
    int[] dp = new int[t + 1];
    dp[0] = 1;
    for (int i = 0; i < l; i++) {
      for (int j = t; j >= nums[i]; j--) {
        dp[j] += dp[j - nums[i]];
      }
    }
    return dp[t];
  }
}


















