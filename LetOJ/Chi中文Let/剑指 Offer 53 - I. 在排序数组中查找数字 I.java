
/*
 * 
link: 
https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/

2020-9-19 at 11:53 pm

剑指 Offer 53 - I. 在排序数组中查找数字 I
难度
简单

64

收藏

分享
切换为英文
关注
反馈
统计一个数字在排序数组中出现的次数。

 

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
 

限制：

0 <= 数组长度 <= 50000


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    //11.48pm-11.52pm
    public int search(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int tmp:nums){
            map.put(tmp, map.getOrDefault(tmp,0)+1);
        }
        return map.getOrDefault(target,0);
    }
}




















