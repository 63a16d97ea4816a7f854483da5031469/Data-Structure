
/*
 * 
https://leetcode.com/problems/counting-bits/

338. Counting Bits
Medium

2145

139

Add to List

Share
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]
Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.


12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

class Solution {
    //11.35pm-12.06am
    //题解 递推公式: dp[n]=dp[n>>1]+n&1
    public int[] countBits(int num) {
        int[] arr=new int[num+1];
        
        for(int i=0;i<=num;i++){
            // arr[i]=arr[i/2] + (i%2==0?0:1);
            arr[i]=arr[i/2] + i%2;
            // arr[i]=arr[i/2] + i%2==0?0:1; 会得到错误答案（在input是4的时候)
            // System.out.println(i+" "+arr[i/2]+" "+(i%2==0?0:1));
        }
        System.out.println(Arrays.toString(arr));
        
        return arr;
    }
}




















