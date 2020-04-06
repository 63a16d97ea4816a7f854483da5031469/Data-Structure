
/*
 * 
https://leetcode.com/problems/longest-valid-parentheses/


32. Longest Valid Parentheses
Hard

2954

125

Add to List

Share
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

6 April 2020 at 8:33:31 pm
 * 
 */


public class Solution {

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
// ————————————————
// 版权声明：本文为CSDN博主「北邮张博」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/Irving_zhang/article/details/78809697

// 分析：一开始我想的是，当遇到”(“时，将”(“入栈；遇到”)”时，如果栈不为空，那么弹出一个”(“，然后最大长度加2；如果栈为空，就说明count需要重新计数。即：

// for(int i = 0; i < len; i++){
//     if(s.charAt(i) == '('){
//         stack.push('(');
//     }else if(!stack.isEmpty()){
//         stack.pop();
//         count += 2;
//         maxCount = Math.max(maxCount, count);
//     }else{
//         count = 0;
//     }
// }
 
// 但是，这样有一个问题，就是”()(()”，最后一个”)”弹出来时，count就为4了，但是最大的合法括号长度实际上为2，因为第三个”(“并不合法。所以入栈的元素不仅是”(“这么简单，实际上应该填充本次合法的位置索引。以”()(()”为例，
// 初始化入栈”-1”，
// i=0，入栈0;
// i=1，出栈0，最大长度为max(0, 1-(-1)) = 2;
// i=2，入栈2;
// i=3，入栈3;
// i=4，出栈3，最大长度为max(2, 4-2) = 2;
// 此时循环结束，返回最大长度为2。

// 具体的解法请看该题的Solution。
// ————————————————
// 版权声明：本文为CSDN博主「北邮张博」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/Irving_zhang/article/details/78809697





















