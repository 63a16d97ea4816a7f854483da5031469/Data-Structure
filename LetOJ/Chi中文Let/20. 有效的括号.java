
/*
 * 
link: https://leetcode-cn.com/problems/valid-parentheses/

20. 有效的括号
难度
简单

2948





给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
 

示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
示例 4：

输入：s = "([)]"
输出：false
示例 5：

输入：s = "{[]}"
输出：true
 

提示：

1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成



2022-02-04 at 16:01
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public boolean isValid(String s) {
        if(s.length()==0) return true;

        HashMap<Character,Character> map=new HashMap<Character,Character>(){{
            put('(',')');
            // put(')','(');

            put('[',']');
            // put(']','[');

            put('{','}');
            // put('}','{');
        }};

        Stack<Character> stack=new Stack<>();
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(!stack.isEmpty()){
                if(map.getOrDefault(stack.peek(),'0')!=s.charAt(i)){
                    stack.push(s.charAt(i));
                }else{
                    stack.pop();
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        
        return stack.isEmpty();
    }
}


















