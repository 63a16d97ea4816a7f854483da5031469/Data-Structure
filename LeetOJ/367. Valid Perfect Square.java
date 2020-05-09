
/*
 * 
https://leetcode.com/problems/valid-perfect-square/

367. Valid Perfect Square
Easy

698

151

Add to List

Share
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */






class Solution {
    //7.59pm-8.03pm
    public boolean isPerfectSquare(int num) {
        if(num==0) return true;
        if(num==1) return true;
        
        for(int i=0;i<num;i++){
            if(i*i>num) return false;
            if(i*i==num){
                return true;
            }
        }
        return false;
    }
}

















