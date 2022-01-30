
/*
 * 
link: https://leetcode-cn.com/problems/house-robber/


2022-01-30 at 21:31
 

198. 打家劫舍
难度
中等

1859

收藏

分享
切换为英文
接收动态
反馈
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

 

示例 1：

输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 2：

输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 

提示：

1 <= nums.length <= 100
0 <= nums[i] <= 400



刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


输入：
[2,1,1,2]
输出：
3
预期结果：
4


class Solution {
    public int rob(int[] nums) {
        //极限case
        if(nums.length==1) return nums[0];
        //
        if(nums.length==2){
            int result=nums[0]>=nums[1]?nums[0]:nums[1];
            return result;
        }
        int[] dp=new int[nums.length+1];
        dp[0]=nums[0];
        dp[1]=nums[1];
        for(int i=2;i<nums.length;i++){
            // [1,2,3,1]
            //只偷倒数第一家，或者只偷倒数第二家（忽略倒数第一家)
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}



class Solution {
    public int rob(int[] nums) {
        //极限case
        if(nums.length==1) return nums[0];
        //
        if(nums.length==2){
            int result=nums[0]>=nums[1]?nums[0]:nums[1];
            return result;
        }
        int[] dp=new int[nums.length+1];
        dp[0]=nums[0];
        
        //需要额外注意这里：
        dp[1]=Math.max(nums[0],nums[1]);   <-----

        for(int i=2;i<nums.length;i++){
            // [1,2,3,1]
            //只偷倒数第一家，或者只偷倒数第二家（忽略倒数第一家)
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            // System.out.println(i+" "+dp[i-1]+" "+(dp[i-2]+nums[i]));
        }
        return dp[nums.length-1];
    }
}















