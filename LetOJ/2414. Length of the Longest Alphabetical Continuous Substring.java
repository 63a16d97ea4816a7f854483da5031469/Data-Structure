
/*
 * 
date "+DATE: %Y-%B-%d%nTIME: %T"

date +"Year: %Y, Month: %m, Day: %d"
date "+DATE: %Y-%B-%d%nTIME: %T"


2414. Length of the Longest Alphabetical Continuous Substring
Medium

223

13

Add to List

Share
An alphabetical continuous string is a string consisting of consecutive letters in the alphabet. In other words, it is any substring of the string "abcdefghijklmnopqrstuvwxyz".

For example, "abc" is an alphabetical continuous string, while "acb" and "za" are not.
Given a string s consisting of lowercase letters only, return the length of the longest alphabetical continuous substring.

 

Example 1:

Input: s = "abacaba"
Output: 2
Explanation: There are 4 distinct continuous substrings: "a", "b", "c" and "ab".
"ab" is the longest continuous substring.
Example 2:

Input: s = "abcde"
Output: 5
Explanation: "abcde" is the longest continuous substring.
 

Constraints:

1 <= s.length <= 105
s consists of only English lowercase letters.

DATE: 2022-October-13
TIME: 20:12:37

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public int longestContinuousSubstring(String s) {
        String letters="abcdefghijklmnopqrstuvwxyz";
        int l=0, r=0;
        int max=0;
        while(l<s.length()&&r<s.length()&&l<=r){
            String curr=s.substring(l,r+1);
            while(!letters.contains(curr)){
                l++;
                if(l>r) break;
                curr=s.substring(l,r+1);
            }
            max=Math.max(curr.length(), max);
            r++;
        }
        return max;
    }
}


















