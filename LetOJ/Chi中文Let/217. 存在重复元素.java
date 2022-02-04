
/*
 * 
link: https://leetcode-cn.com/problems/contains-duplicate/


2022-02-04 at 23:45


217. 存在重复元素
难度
简单

613

收藏

分享
切换为英文
接收动态
反馈
给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 

示例 1：

输入：nums = [1,2,3,1]
输出：true
示例 2：

输入：nums = [1,2,3,4]
输出：false
示例 3：

输入：nums = [1,1,1,3,3,4,3,2,4,2]
输出：true
 

提示：

1 <= nums.length <= 105
-109 <= nums[i] <= 109

 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int tmp:nums){
            map.put(tmp,map.getOrDefault(tmp,0)+1);
            if(map.get(tmp)>=2){
                return true;
            }
        }
        return false;
    }
}




















