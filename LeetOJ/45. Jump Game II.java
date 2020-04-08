
/*
 * 
https://leetcode.com/problems/jump-game-ii/


45. Jump Game II
Hard

2044

118

Add to List

Share
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:

You can assume that you can always reach the last index.

9 April 2020 at 12.19am
 * 
 */



class Solution {
    //12.02pm-12.19am
    // https://www.cnblogs.com/grandyang/p/4373533.html
    // 这题是之前那道 Jump Game 的延伸，那题是问能不能到达最后一个数字，而此题只让求到达最后一个位置的最少跳跃数，貌似是默认一定能到达最后位置的? 此题的核心方法是利用贪婪算法 Greedy 的思想来解，想想为什么呢？ 为了较快的跳到末尾，想知道每一步能跳的范围，这里贪婪并不是要在能跳的范围中选跳力最远的那个位置，因为这样选下来不一定是最优解，这么一说感觉又有点不像贪婪算法了。其实这里贪的是一个能到达的最远范围，遍历当前跳跃能到的所有位置，然后根据该位置上的跳力来预测下一步能跳到的最远距离，贪出一个最远的范围，一旦当这个范围到达末尾时，当前所用的步数一定是最小步数。需要两个变量 cur 和 pre 分别来保存当前的能到达的最远位置和之前能到达的最远位置，只要 cur 未达到最后一个位置则循环继续，pre 先赋值为 cur 的值，表示上一次循环后能到达的最远位置，如果当前位置i小于等于 pre，说明还是在上一跳能到达的范围内，根据当前位置加跳力来更新 cur，更新 cur 的方法是比较当前的 cur 和 i + A[i] 之中的较大值，如果题目中未说明是否能到达末尾，还可以判断此时 pre 和 cur 是否相等，如果相等说明 cur 没有更新，即无法到达末尾位置，返回 -1，代码如下：
    
    public int jump(int[] nums) {
        int res = 0, n = nums.length, i = 0, cur = 0;
        while (cur < n - 1) {
            ++res;
             int pre = cur;
            //在这个之前能够到达的所有范围里面，进行取最大值
            for(;i<=pre;i++){
                 cur = Math.max(cur, i + nums[i]);
            }
            
        }
        return res;
    }
}




















