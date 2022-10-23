
/*
 * 
link: https://leetcode.cn/problems/partition-equal-subset-sum/description/


416. 分割等和子集
中等
1.5K
相关企业
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
示例 1：
输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：
输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。

 
提示：
1 <= nums.length <= 200
1 <= nums[i] <= 100

DATE: 2022-October-23
TIME: 11:57:33


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

public boolean canPartition(int[] nums) {
        int n = nums.length;
       // 如果size<2,则肯定没法拆分
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
       // 如果是和为奇数,肯定拆不出来
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
       // 如果最大的数自己就比和的一半还大,剩下的数肯定拼凑不出来
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];
       //对于任意的从0 to n范围,拼凑0一定是可以的,即不选任何数
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        // 如果是在0 to 0范围内选择一个数,那么一定能凑成nums[0]的值
        dp[0][nums[0]] = true;

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                  // 01背包, 不选这个数 || 选择这个数
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                   // 不选择这个数
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

// 链接：https://leetcode.cn/problems/partition-equal-subset-sum/solutions/442320/fen-ge-deng-he-zi-ji-by-leetcode-solution/




sum = A-B
target = A+B


A = (s+sum) /2 
target = (s+sum)/2
将问题转化为,01背包问题,即能否从nums的(0 to i)里面找到这样一个A的 组合数种类

dp[i][j]

dp[0][0]=1;

for(int i=0;i<nums.length;i++){
    dp[i][0]=1;
}

for(int i=0;i<nums.length;i++){
    for(int j=nums[i];j<=target;j++){
        if(j>nums[i]){
            dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i]];
        }else{
            dp[i][j]=dp[i-1][j];
        }
    }
}

dp[nums.length-1][target];









































