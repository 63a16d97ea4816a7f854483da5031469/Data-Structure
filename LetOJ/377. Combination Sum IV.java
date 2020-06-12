
/*
 * 
https://leetcode.com/problems/combination-sum-iv/

377. Combination Sum IV
Medium

1278

164

Add to List

Share
Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
 

Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.

31 May 2020 at 11:36 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


 * 
 */


// This problem is similar to Coin Change. It's a typical dynamic programming problem.

class Solution {
    public int combinationSum4(int[] nums, int target) {
       if(nums==null || nums.length==0)
           return 0;
       int[] dp = new int[target+1];
       dp[0]=1;
       for(int i=0; i<=target; i++){
          for(int num: nums){
              if(i+num<=target){
                  dp[i+num]+=dp[i];
              }
          }
       }
       return dp[target];
   }
}






// import java.util.ArrayList;
// import java.util.List;
/*
 * 就想到可以用动态规划来做, 也是一个背包问题, 求出[1, target]之间每个位
 * 置有多少种排列方式, 这样将问题分化为子问题. 状态转移方程可以得到为: 
 * 
 * dp[i] = sum(dp[i - nums[j]]),  (i-nums[j] > 0);
 * */
class Solution 
{
    List<List<Integer>> res=new ArrayList<>();
    public int combinationSum4(int[] nums, int target) 
    {
/*      List<Integer> one = new ArrayList<>(); 
        Arrays.sort(nums);
        getAllByDFS(nums,target,0,one);
        return res.size();*/

        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                if(i>=nums[j])
                    dp[i]=dp[i]+dp[i-nums[j]];
            }
        }
        return dp[target];
    }


    /*
     * DFS深度优先遍历
     * */
    public void getAllByDFS(int[] nums, int target, int sum,List<Integer> one) 
    {
        if(sum>target)
            return ;
        else if(sum==target)
        {
            res.add(new ArrayList<>(one));
            return ;
        }else 
        {
            for(int i=0;i<nums.length;i++)
            {
                one.add(nums[i]);
                getAllByDFS(nums, target, sum+nums[i], one);
                one.remove(one.size()-1);
            }
        }
    }
}
// ————————————————
// 版权声明：本文为CSDN博主「JackZhangNJU」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/JackZhang_123/article/details/78174174












