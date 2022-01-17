
/*
 * 

https://leetcode.com/problems/palindrome-number/

2022-01-17 13:14

9. Palindrome Number

9. Palindrome Number
Easy

4855

1986

Add to List

Share
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

For example, 121 is a palindrome while 123 is not.
 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1

对题目易错地方进行总结:

整数的所有情况： 1. 正负 2.整数的基本范围 3. 整数翻转的时候，左侧出现0的情况


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


 * 
 */


class Solution {
    public boolean isPalindrome(int x) {
        // handle the signle digtal case
        if(String.valueOf(x).length()==1) return true;
        String xstr=String.valueOf(x);
        String process="";
        if(xstr.length()%2==0){
            process=xstr.substring(0,xstr.length()/2);
            process+="*";
            process+=xstr.substring(xstr.length()/2,xstr.length());
        }else{
            process=xstr;
        }
        int midIndex=process.length()/2;
        int i=1;
        while(midIndex-i>=0&&midIndex+i<process.length()){
            if(process.charAt(midIndex-i)!=process.charAt(midIndex+i)) return false;
            i++;
        }
        return true;
    }
    
}




















