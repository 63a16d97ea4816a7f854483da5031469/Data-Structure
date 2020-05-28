
/*
 * 
https://leetcode.com/problems/counting-bits/


338. Counting Bits
Medium

2428

152

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


29 May 2020 at 12:29 am


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


class Solution {
    public int[] countBits(int num) {
        if (num < 0)
            return new int[1];
        
        // allocate array incuding 0->num
        int[] countBitArray = new int[num + 1];
        
        // initial DP data
        countBitArray[0] = 0;
        
        for (int i = 1; i <= num; i++) {
            // if num is even, bit count is same as num / 2
            // if odd, bit count is same as (num / 2) + 1
            countBitArray[i] = countBitArray[i >> 1] + i % 2;
        }
        
        return countBitArray;

    }
}





















