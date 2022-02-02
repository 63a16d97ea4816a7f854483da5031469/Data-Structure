
/*
 * 
link: https://leetcode-cn.com/problems/smallest-range-i/

908. 最小差值 I
难度
简单

77





给你一个整数数组 nums，和一个整数 k 。

在一个操作中，您可以选择 0 <= i < nums 的任何索引 i 。将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。

nums 的 分数 是 nums 中最大和最小元素的差值。 

在对nums中的每个索引最多应用一次上述操作后，返回 nums 的最低 分数 。

 

示例 1：

输入：nums = [1], k = 0
输出：0
解释：分数是 max(nums) - min(nums) = 1 - 1 = 0。
示例 2：

输入：nums = [0,10], k = 2
输出：6
解释：将 nums 改为 [2,8]。分数是 max(nums) - min(nums) = 8 - 2 = 6。
示例 3：

输入：nums = [1,3,6], k = 3
输出：0
解释：将 nums 改为 [4,4,4]。分数是 max(nums) - min(nums) = 4 - 4 = 0。
 

提示：

1 <= nums.length <= 104
0 <= nums[i] <= 104
0 <= k <= 104


2022-02-02 at 23:10
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



状态：超出时间限制
[4103,2214,5569,6335,4244,9485,7545,8323,7841,8858]
391

class Solution {
    int result=9999;
    public int smallestRangeI(int[] nums, int k) {
        Set<Integer> set=new HashSet();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        dfs(nums,k,0);
        return result;
    }
    public void dfs(int[] nums, int k, int index){
        if(index>=nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            for(int s=-k;s<=k;s++){
                nums[i]=nums[i]+s;
                int max=-1;
                int min=9999;
                for(int j=0;j<nums.length;j++){
                    max=Math.max(max,nums[j]);
                    min=Math.min(min,nums[j]);
                }
                result=Math.min(result,max-min);
                dfs(nums,k,i+1);
                nums[i]=nums[i]-s;
            }
        }
    }
}

















