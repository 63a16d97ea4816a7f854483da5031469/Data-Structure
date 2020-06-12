
/*
 * 
https://leetcode.com/problems/remove-invalid-parentheses/


Facebook面试题目 leetcode 301 Remove Invalid Parentheses解题笔记2
24 April 2019

Facebook面试题目 leetcode 301 Remove Invalid Parentheses
输入一个字符串， 里面有左括弧，右括弧， 还有其他字符， 但是括弧可能不匹配， 要求删除一些括弧，使得左右匹配，
问最后有哪些合法的字符串？

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]

Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]

Example 3:

Input: ")("
Output: [""]


解题思路分析

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

 * 
 */



http://www.noteanddata.com/leetcode-301-Remove-Invalid-Parentheses-java-solution-note2.html


class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int leftRemoveCount = 0, rightRemoveCount = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') {
                leftRemoveCount++;
            }
            else if(s.charAt(i) == ')'){
                if(leftRemoveCount > 0) {
                    leftRemoveCount--;
                }
                else {
                    rightRemoveCount++;
                }
            }
        }
        
        Set<String> set = new HashSet<>();
        backtrack(s, 0, leftRemoveCount, rightRemoveCount, "", set, 0);
        return new ArrayList<>(set);
    }
    
    public void backtrack(String s, int from, int leftRemoveCount, int rightRemoveCount, String cur, Set<String> set, int opencount) {
        
        if(leftRemoveCount < 0 || rightRemoveCount < 0 || opencount < 0) return ;
        if(from == s.length() ) {
            if(opencount == 0 && leftRemoveCount == 0 && rightRemoveCount == 0) {
                set.add(cur);    
            }
            return;
        }
        char ch = s.charAt(from);
        if(ch == '(') {
            if(rightRemoveCount == 0) { // only remove left when rightRemoveCount == 0
                backtrack(s, from+1, leftRemoveCount-1, rightRemoveCount, cur, set, opencount); // remove current (    
            }
            
            backtrack(s, from+1, leftRemoveCount, rightRemoveCount, cur + ch, set, opencount+1); // not remove current (
        }
        else if(ch == ')'){
            backtrack(s, from+1, leftRemoveCount, rightRemoveCount-1, cur, set, opencount); // remove current )
            backtrack(s, from+1, leftRemoveCount, rightRemoveCount, cur + ch, set, opencount-1); // not remove current )            
        }
        else {
            backtrack(s, from+1, leftRemoveCount, rightRemoveCount, cur + ch, set, opencount); 
        }
    }
}





http://www.noteanddata.com/leetcode-301-Remove-Invalid-Parentheses-java-solution-note2.html















