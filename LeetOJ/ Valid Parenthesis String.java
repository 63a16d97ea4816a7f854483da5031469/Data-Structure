
/*
 * 
https://leetcode.com/problems/valid-parenthesis-string/


Valid Parenthesis String
Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].

12 April 2020 at 9.15pm-10.10pm 看题解


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

刚开始想到了使用替换法，将*换掉，但是考虑到多个*，没法使用堆栈加替换方法。

当时没想到回溯方法，如果有回溯，就可以使用替换法。


 * 
 */


双堆栈:
class Solution {
    //9.15pm-10.10pm 看题解
    public boolean checkValidString(String s) {
        if(s.length()==0) return true;
        Stack<Integer> bracketStack=new Stack<Integer>();
        Stack<Integer> starStack=new Stack<Integer>();
        for(int i=0;i<s.length();i++){
            char tmp=s.charAt(i);
            if(tmp=='*'){
                starStack.push(i);
            }else if(tmp=='('){
                bracketStack.push(i);
            }else if(tmp==')'){
                if(!bracketStack.isEmpty()){
                    bracketStack.pop();
                }else if(!starStack.isEmpty()){
                    starStack.pop();
                }else{
                    return false;
                }
            }
        }
        while(!bracketStack.isEmpty()){
                if(!starStack.isEmpty()){
                    int star=starStack.peek();
                    int left=bracketStack.peek();
                    if(star<=left){
                        // *(
                        return false;
                    }else{
                        starStack.pop();
                        bracketStack.pop();
                    }
                }else{
                    return false;
                }
        }
        return bracketStack.isEmpty();
    }
}



题解，回溯法:

// https://leetcode.com/problems/valid-parenthesis-string/discuss/107566/Java-12-lines-solution-backtracking

// How to check valid parenthesis w/ only ( and )? Easy. Count each char from left to right. When we see (, count++; when we see ) count--; if count < 0, it is invalid () is more than (); At last, count should == 0.
// This problem added *. The easiest way is to try 3 possible ways when we see it. Return true if one of them is valid.

class Solution {
    public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }
    
    private boolean check(String s, int start, int count) {
        if (count < 0) return false;
        
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            else if (c == ')') {
                if (count <= 0) return false;
                count--;
            }
            else if (c == '*') {
                return check(s, i + 1, count + 1) || check(s, i + 1, count - 1) || check(s, i + 1, count);
            }
        }
        
        return count == 0;
    }
}









