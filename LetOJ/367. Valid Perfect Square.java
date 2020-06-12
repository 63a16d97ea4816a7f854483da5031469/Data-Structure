
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


// 使用二分查找法：

public class Solution {
    public boolean isPerfectSquare(int num) {
        long L = 1, R = (num >> 1) + 1;
		while (L <= R) {
			long  m = L + ((R - L) >> 1);
			long  mul = m * m;
			if (mul == num) return true;
			else if (mul > num) R = m - 1;
			else L = m + 1;
		}
		return false;
    }
}


//使用hashset
//https://www.cnblogs.com/grandyang/p/7190506.html
class Solution {
    public boolean judgeSquareSum(int c) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=0;i<=Math.sqrt(c);i++){
            set.add(i*i);
            if(set.contains(c-i*i)){
                return true;
            }
        }
        return false;
    }
}
 



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

















