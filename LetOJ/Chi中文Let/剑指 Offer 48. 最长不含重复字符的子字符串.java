
/*
 * 
link: 
https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/

2020-9-5 at 9:04 pm

剑指 Offer 56 - I. 数组中数字出现的次数
难度
中等

213

一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]
 

限制：

2 <= nums.length <= 10000


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */









class Solution {
    //10.32pm-10.36pm
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<Character>();
        int length=0;
        for(int i=0,j=0;i<s.length();i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(j++));
            }
            length=Math.max(length,i-j+1);
            set.add(s.charAt(i));
        }
        return length;
    }
}














