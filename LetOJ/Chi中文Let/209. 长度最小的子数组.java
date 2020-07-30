
/*
 * 
link: 
https://leetcode-cn.com/problems/minimum-size-subarray-sum/

2020-7-30 at 2:23pm

209. 长度最小的子数组
难度
中等

391

收藏

分享
切换为英文
关注
反馈
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。

示例：
输入：s = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 
进阶：

如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。

对题目易错地方进行总结:

对题目的实现思路进行几句话总结:

从这道题目学到了什么，哪些地方需要提升? :

 * 
 */

//双指针, 滑动窗口，收缩边界
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0) return 0;
        
        int n=nums.length;
        int start=0,end=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        while(end<n){
            sum+=nums[end];
            while(sum>=s){
                ans=Math.min(ans,end-start+1);
                sum-=nums[start++];
            }
            end++;
        }
        if(ans==Integer.MAX_VALUE&&sum<s){
            return 0;
        }
        return ans;
    }
}





//错误：思路是正确的，但是实现的方式是错的：
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min=Integer.MAX_VALUE;
        int sum=0;
        sum+=nums[0];
        for(int i=1,j=0;i<nums.length;){
            if(sum>=s){
                while(j<i&&sum>=s){
                    min=Math.min(i-j+1,min);
                    sum-=nums[j];
                    System.out.println(sum);
                    j++;
                }
            }else{
                System.out.println(sum+" "+i+" "+j);
                sum+=nums[i];
                i++;
            }
        }
        return min;
    }
}














