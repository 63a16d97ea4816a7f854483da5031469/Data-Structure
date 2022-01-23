
/*
 * 
link: https://leetcode-cn.com/problems/count-elements-with-strictly-smaller-and-greater-elements/


5989. 元素计数
难度
简单

0

收藏

分享
切换为英文
接收动态
反馈
给你一个整数数组 nums ，统计并返回在 nums 中同时具有一个严格较小元素和一个严格较大元素的元素数目。

 

示例 1：

输入：nums = [11,7,2,15]
输出：2
解释：元素 7 ：严格较小元素是元素 2 ，严格较大元素是元素 11 。
元素 11 ：严格较小元素是元素 7 ，严格较大元素是元素 15 。
总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
示例 2：

输入：nums = [-3,3,3,90]
输出：2
解释：元素 3 ：严格较小元素是元素 -3 ，严格较大元素是元素 90 。
由于有两个元素的值为 3 ，总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
 

提示：

1 <= nums.length <= 100
-105 <= nums[i] <= 105



2022-01-23 at 12:22
 

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public int countElements(int[] nums) {
        int count=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(findLarger(nums,nums[i],i+1)&&findSmaller(nums,nums[i],i-1)){
                count++;
            }
        }
        return count;
    }
    public boolean findLarger(int[] nums,int target,int startIndex){
        if(startIndex<0) return false;
        for(int i=startIndex;i<nums.length;i++){
            if(nums[i]>target) return true;
        }
        return false;
    }
    public boolean findSmaller(int[] nums,int target, int endIndex){
        if(endIndex>nums.length-1) return false;
        for(int i=0;i<=endIndex;i++){
            if(nums[i]<target) return true;
        }
        return false;
    }
}





















