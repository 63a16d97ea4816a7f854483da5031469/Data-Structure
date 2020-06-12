
/*
 * 
https://leetcode.com/problems/partition-equal-subset-sum/

416. Partition Equal Subset Sum
Medium

2073

59

Add to List

Share
Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.
 

Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
 

Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
12 April 2020 at 8:33: pm


对题目易错地方进行总结:
DP的构造，数组长度的规划。

对题目的实现思路进行几句话总结:
使用01背包， 这个题目等价于求在 整个集合上求 容量为 sum/2的包， 能获得的最大价值

那么只要套用01背包的方法，(sum-2*dp[nums.length][sum/2])==0; 看最后的 sum/2的包的价值的两倍是否等于sum

从这道题目学到了什么，哪些地方需要提升? :

运用01背包的方法

 * 
 */




class Solution {
    //11.15pm-11.28pm
    //模仿01背包写法 AC，  模仿 1049. Last Stone Weight II 的写法 https://leetcode.com/problems/last-stone-weight-ii/submissions/

    //转化成 0,1背包问题，在取i时候，拥有j的value， 找sum/2的
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        for(int tmp:nums){
            sum+=tmp;
        }
        
        int[][] dp=new int[nums.length+1][sum/2+1];
        
        for(int i=1;i<nums.length+1;i++){
            for(int j=1;j<sum/2+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i-1]]+nums[i-1]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
     
        
        return (sum-2*dp[nums.length][sum/2])==0;
    }
}





















