
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



这道题给了我们一个数组（元素非负），和一个目标值，要求给数组中每个数字前添加正号或负号所组成的表达式结果与目标值S相等，求有多少种情况。

假设所有元素和为sum，所有添加正号的元素的和为A，所有添加负号的元素和为B，则有sum = A - B 且 S = A + B，解方程得A = (sum + S)/2。即题目转换成：从数组中选取一些元素使和恰好为(sum + S) / 2。可见这是一个恰好装满的01背包问题，要求所有方案数，将1.2节状态转移方程中的max改成求和即可。需要注意的是，虽然这里是恰好装满，但是dp初始值不应该是inf，因为这里求的不是总价值而是方案数，应该全部初始为0（除了dp[0]初始化为1）。所以代码如下：

//动态规划
class Solution {
  public int findTargetSumWays(int[] nums, int target) {
    int n = nums.length;
    int sun = 0;
    for (int i: nums) sun += i;
    if (target > sun || -target > sun) return 0;
    if ((sun + target) % 2 == 1) return 0;
    int t = (sun + target) / 2;
    int[] dp = new int[t + 1];
    dp[0] = 1;
    for (int i = 0; i < n; i++) {
      for (int j = t; j >= nums[i]; j--) {
        dp[j] += dp[j - nums[i]];
      }
    }
    return dp[t];
  }
}

int findTargetSumWays(vector<int>& nums, int S) {
    int sum = 0;
    // for(int &num: nums) sum += num;
    sum = accumulate(nums.begin(), nums.end(), 0);
    if(S > sum || sum < -S) return 0; // 肯定不行
    if((S + sum) & 1) return 0; // 奇数
    int target = (S + sum) >> 1;

    vector<int>dp(target + 1, 0);

    dp[0] = 1;
    for(int i = 1; i <= nums.size(); i++)
        for(int j = target; j >= nums[i-1]; j--)
            dp[j] = dp[j] + dp[j - nums[i-1]];

    return dp[target];
}






// 自己写的:
class Solution {
  public int findTargetSumWays(int[] nums, int target) {
    int n = nums.length;
    int sum=0;
    for(int tmp:nums){
        sum+=tmp;
    }

    // sum = positive - negtive; (1)

    //根据题意,要求给数组中每个数字前添加正号或负号所组成的表达式结果与目标值target相等
    // target = positive + negitive; (2) 

    // (1)式+(2)式=sum+target=2postive
    // postive = (sum+target) / 2    (能被2÷,一定是偶数,因为按题意,都是整数,整数+-整数,一定是整数)

    // 如果nums的sum是小于target, 是拼凑不出来的
    if(sum<target) return 0;
    int amount=(sum+target)/2;

    //通过公式计算, postive一定是一个偶数
    if((sum-target) % 2!=0){
        return 0;
    }

    // 在i-1之间,拼出j的组合数 (01背包,不选i-1和选i-1, 装进去,不装进去)
    int[][] dp=new int[n+1][amount+1];
    dp[0][0]=1;

    for(int i=1;i<=n;i++){
        for(int j=0;j<=amount;j++){
            // 如果j>=nums[i]
            if(j>=nums[i-1]){
                // dp值= Math.max(不取这个数, 取这个数)
                dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
            }else{
                // dp值 = 不取这个数
                dp[i][j]=dp[i-1][j];
            }
        }
    }

    return dp[n][amount];
  }
}



