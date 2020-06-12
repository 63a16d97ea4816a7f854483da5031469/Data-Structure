
/*
 * 
https://leetcode.com/problems/number-complement/

476. Number Complement
Easy

767

79

Add to List

Share
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

 

Example 1:

Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 

Example 2:

Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 

Note:

The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/

4 May 2020 at 11:10 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


class Solution {
    //11.10pm-11.27pm
    public int findComplement(int num) {
        StringBuilder sb=new StringBuilder();
        while(num!=0){
            sb.append((num&1^1)+"");
            num=num>>1;
        }
        // System.out.println(sb.toString());
        int count=0;
        int sum=0;
        for(int i=0;i<=sb.toString().length()-1;i++){
            sum+=Math.pow(2,count++)*Integer.parseInt(sb.toString().charAt(i)+"");
        }
        return sum;
    }
}





















