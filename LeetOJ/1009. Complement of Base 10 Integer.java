
/*
 * 
https://leetcode.com/problems/complement-of-base-10-integer/


1009. Complement of Base 10 Integer
Easy

176

26

Add to List

Share
Every non-negative integer N has a binary representation.  For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.  Note that except for N = 0, there are no leading zeroes in any binary representation.

The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.  For example, the complement of "101" in binary is "010" in binary.

For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.

 

Example 1:

Input: 5
Output: 2
Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
Example 2:

Input: 7
Output: 0
Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
Example 3:

Input: 10
Output: 5
Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 

Note:

0 <= N < 10^9
This question is the same as 476: https://leetcode.com/problems/number-complement/

5 May 2020 at 12:06 am


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





class Solution {
    public int bitwiseComplement(int N) {
        int num=N;
        if(num==0) return 1;
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

 


















