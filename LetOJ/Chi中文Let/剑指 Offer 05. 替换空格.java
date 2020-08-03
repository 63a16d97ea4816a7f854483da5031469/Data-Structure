
/*
 * 
link: 
https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/

2020-8-3 at 9:09 am

剑指 Offer 05. 替换空格
难度
简单

31

请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."

限制：

0 <= s 的长度 <= 10000

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




class Solution {
    //9.08am-9.08am
    public String replaceSpace(String s) {
        return s.replace(" ","%20");
    }
}



















