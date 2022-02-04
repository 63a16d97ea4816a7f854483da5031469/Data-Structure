
/*
 * 
link: https://leetcode-cn.com/problems/sort-an-array/


2022-02-04 at 14:33
 


912. 排序数组
难度
中等

469

收藏

分享
切换为英文
接收动态
反馈
给你一个整数数组 nums，请你将该数组升序排列。

 

示例 1：

输入：nums = [5,2,3,1]
输出：[1,2,3,5]
示例 2：

输入：nums = [5,1,1,2,0,0]
输出：[0,0,1,1,2,5]
 

提示：

1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104



刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}


class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int tmp:nums){
            pq.add(tmp);
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=pq.poll();
        }
        return nums;
    }
}



时间： O(nlogn)
空间： O(n)






























