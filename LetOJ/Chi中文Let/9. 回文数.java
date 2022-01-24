
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



class Solution {
    public boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





class Solution {
    public boolean isPalindrome(int x) {
        //如果是单个数，肯定是回文数
        if(x>=0&&x<10) return true;

        // 如果最右侧有0，而只有0的情况已经被排除，则肯定不是
        if(x%10==0) return false;

        // 如果是负数，则肯定不是
        if(x<0) return false;
        int curr=0;

        while(x>curr){
            int num=x%10;
      
            curr=curr*10+num;
            // 不能等到除完再判断，否则就是错的
            if(curr==x&&x/10<=curr){
                return true;
            }
            x/=10;
             if(curr==x&&x/10<=curr){
                return true;
            }
        }

        return false;
    }
    
}





