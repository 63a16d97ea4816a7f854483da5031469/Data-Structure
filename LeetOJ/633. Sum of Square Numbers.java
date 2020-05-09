
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/

633. Sum of Square Numbers
Easy

471

299

Add to List

Share
Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:

Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
 

Example 2:

Input: 3
Output: False

9 May 2020 at 8:28 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





class Solution {
    //8.15pm-8.27pm  有参考答案
    //https://www.cnblogs.com/grandyang/p/7190506.html
    public boolean judgeSquareSum(int c) {
        if(c==0) return true;
        if(c==1) return true;
        for(int i=(int)Math.sqrt(c);i>0;i--){
            if(i*i==c) return true;
            int d=c-i*i, t=(int)Math.sqrt(d);
            if(t*t==d) return true;
        }
        return false;
    }
}


















