
/*
 * 
link: 
https://leetcode-cn.com/problems/rotate-array/

2020-7-25 at 11:00 am

189. 旋转数组
难度
简单

630

收藏

分享
切换为英文
关注
反馈
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    //10.54am-10.59am
    public void rotate(int[] nums, int k) {
      int n=nums.length;
      k=k%n;
      for(int j=0;j<k;j++){
        int lastOne=nums[n-1];
        for(int i=n-1;i>0;i--)
            nums[i]=nums[i-1];
        nums[0]=lastOne;
        }
    }
}





class Solution {
    //11.00am-11.06
    public void rotate(int[] nums, int k) {
        int[] copy=nums.clone();
        for(int i=0;i<copy.length;i++){
            nums[(i+k)%(copy.length)]=copy[i];
        }
    }
}















