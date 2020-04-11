
/*
 * 
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3291/

Backspace String Compare
Solution
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?

7 2020 at //6.38pm-6.43pm
 * 
 */


双指针:
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}


class Solution {
    //6.38pm-6.43pm
    public boolean backspaceCompare(String S, String T) {
        
        return getFinalStr(S).equals(getFinalStr(T));
        
    }
    
    String getFinalStr(String s){
        
        if(s.length()==0) return s;
        Stack<Character> stack=new Stack<Character>();
        
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)=='#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(s.charAt(i)!='#'){
                stack.push(s.charAt(i));
            }
        }
        
        String str="";
        
        while(!stack.isEmpty()){
            str+=stack.pop();
        }
        return str;
    }
}




















