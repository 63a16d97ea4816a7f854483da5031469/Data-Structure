
/*
 * 
link: 
https://leetcode-cn.com/problems/longest-consecutive-sequence/

2020-7-18 at 11:09 pm


128. 最长连续序列
难度
困难

461

给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




class Solution {
    //11.47pm-11.51pm 看过答案
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int tmp:nums){
            set.add(tmp);
        }
        
        int max=0;
        
        for(int tmp:set){
            if(!set.contains(tmp-1)){
                int currNumber=tmp;
                int longthNumber=1;
                while(set.contains(currNumber+1)){
                    currNumber++;
                    longthNumber++;
                }
                max=Math.max(max,longthNumber);
            }
        }
        return max;
    }
}



















