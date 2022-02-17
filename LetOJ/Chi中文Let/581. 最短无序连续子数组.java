
/*
 * 
link: https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/


581. 最短无序连续子数组
难度
中等

782





给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

请你找出符合题意的 最短 子数组，并输出它的长度。

 

示例 1：

输入：nums = [2,6,4,8,10,9,15]
输出：5
解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
示例 2：

输入：nums = [1,2,3,4]
输出：0
示例 3：

输入：nums = [1]
输出：0
 

提示：

1 <= nums.length <= 104
-105 <= nums[i] <= 105
 

进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？


2022-02-17 at 22:50
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */





class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int max=nums[0];
        int right=0;
        for(int i=1;i<n;i++){
            max=Math.max(max,nums[i]);
            if(nums[i]<max){
                right=i;
            }
        }
        int left=n-1;
        int min=nums[n-1];
        for(int i=n-2;i>=0;i--){
            min=Math.min(min,nums[i]);
            if(nums[i]>min){
                left=i;
            }
        }
        // System.out.println(right+" "+left);
        if(right>left){
            return right-left+1;
        }
        return 0;
    }
}




















