
/*
 * 
https://leetcode-cn.com/problems/palindrome-number/


9. 回文数

给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。

 

示例 1：

输入：x = 121
输出：true
示例 2：

输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3：

输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。
示例 4：

输入：x = -101
输出：false
 

提示：

-231 <= x <= 231 - 1
 

进阶：你能不将整数转为字符串来解决这个问题吗？


2022-01-17 14:08


对题目易错地方进行总结:

Integer,我们要考虑到几个情况：

1. 正负 2.溢出 3. 左边为0的整数是不存在的 

对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


自己的解法:

class Solution {
    public int reverse(int x) {
        int result=0;
        boolean isNegative=false;
        if(x<0)  isNegative=true;
        x=Math.abs(x);
        while(x>0){
            int curr=x%10;
            x/=10;
            result=result*10+curr;
        }
        if(isNegative) return -result;
        return result;
    }
}

但是1534236469 case outOfBound没有过:
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

使用这个方法解决:

class Solution {
    public int reverse(int x) {
        Long result=0L;
        boolean isNegative=false;
        if(x<0)  isNegative=true;
        x=Math.abs(x);
        while(x>0){
            int curr=x%10;
            x/=10;
            result=result*10+curr;
        }
        if(result>Integer.MAX_VALUE){
            return 0;
        }
        int resultInt=Integer.valueOf(result+"");
        if(isNegative) return -resultInt;
        return resultInt;
    }
}



进阶：你能不将整数转为字符串来解决这个问题吗？

方法一：反转一半数字

思路
映入脑海的第一个想法是将数字转换为字符串，并检查字符串是否为回文。但是，这需要额外的非常量空间来创建问题描述中所不允许的字符串。
第二个想法是将数字本身反转，然后将反转后的数字与原始数字进行比较，如果它们是相同的，那么这个数字就是回文。
但是，如果反转后的数字大于 
int.MAX
int.MAX，我们将遇到整数溢出问题。
按照第二个想法，为了避免数字反转可能导致的溢出问题，为什么不考虑只反转 
int
int 数字的一半？毕竟，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
例如，输入 1221，我们可以将数字 “1221” 的后半部分从 “21” 反转为 “12”，并将其与前半部分 “12” 进行比较，因为二者相同，我们得知数字 1221 是回文。
算法
首先，我们应该处理一些临界情况。所有负数都不可能是回文，例如：-123 不是回文，因为 - 不等于 3。所以我们可以对所有负数返回 false。除了 0 以外，所有个位是 0 的数字不可能是回文，因为最高位不等于 0。所以我们可以对所有大于 0 且个位是 0 的数字返回 false。
现在，让我们来考虑如何反转后半部分的数字。
对于数字 1221，如果执行 1221 % 10，我们将得到最后一位数字 1，要得到倒数第二位数字，我们可以先通过除以 10 把最后一位数字从 1221 中移除，1221 / 10 = 122，再求出上一步结果除以 10 的余数，122 % 10 = 2，就可以得到倒数第二位数字。如果我们把最后一位数字乘以 10，再加上倒数第二位数字，1 * 10 + 2 = 12，就得到了我们想要的反转后的数字。如果继续这个过程，我们将得到更多位数的反转数字。
现在的问题是，我们如何知道反转数字的位数已经达到原始数字位数的一半？
由于整个过程我们不断将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于或等于反转后的数字时，就意味着我们已经处理了一半位数的数字了。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。









