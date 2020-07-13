
/*
 * 
link: 
https://leetcode-cn.com/problems/kth-largest-element-in-an-array/

2020-7-13 at 11:08 am

215. 数组中的第K个最大元素
难度
中等

607

在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */





class Solution {
    //11.04am-11.07am
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> que=new PriorityQueue<Integer>(); //最小堆
        for(int i=0;i<k;i++){
            que.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(que.peek()<nums[i]){
                que.poll();
                que.add(nums[i]);
            }
        }
        return que.peek();
    }
}


















