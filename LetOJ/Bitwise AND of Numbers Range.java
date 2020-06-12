
/*
 * 
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3308/

https://leetcode.com/problems/bitwise-and-of-numbers-range/

Bitwise AND of Numbers Range
Solution
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0


12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


 * 
 */

/*

https://www.cnblogs.com/grandyang/p/4431646.html
又是一道考察位操作Bit Operation的题，相似的题目在LeetCode中还真不少，比如Repeated DNA Sequences 求重复的DNA序列， Single Number 单独的数字,   Single Number II 单独的数字之二 ， Grey Code 格雷码，和 Reverse Bits 翻转位 等等，那么这道题其实并不难，我们先从题目中给的例子来分析，[5, 7]里共有三个数字，分别写出它们的二进制为：

101　　110　　111

相与后的结果为100，仔细观察我们可以得出，最后的数是该数字范围内所有的数的左边共同的部分，如果上面那个例子不太明显，我们再来看一个范围[26, 30]，它们的二进制如下：

11010　　11011　　11100　　11101　　11110

发现了规律后，我们只要写代码找到左边公共的部分即可，我们可以从建立一个32位都是1的mask，然后每次向左移一位，比较m和n是否相同，不同再继续左移一位，直至相同，然后把m和mask相与就是最终结果，代码如下：
*/

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int d = Integer.MAX_VALUE;
        while ((m & d) != (n & d)) {
            d <<= 1;
        }
        return m & d;
    }
}

 
















