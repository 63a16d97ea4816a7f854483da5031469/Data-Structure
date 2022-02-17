
/*
 * 
link: https://leetcode-cn.com/problems/longest-palindromic-substring/

5. 最长回文子串
难度
中等

4712





给你一个字符串 s，找到 s 中最长的回文子串。

 

示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"
 

提示：

1 <= s.length <= 1000
s 仅由数字和英文字母组成


2022-02-17 at 23:47
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    public String longestPalindrome(String s) {
        String max = "";
        for(int i=0;i<s.length();i++){
            String s1 = extend(s,i,i), s2 = extend(s,i,i+1); //s2 focuses on midpoint betweek 2 letters in case of even letters
            if(max.length() < Math.max(s1.length(),s2.length()))
                max = s1.length() > s2.length() ? s1 : s2;
        }
        return max;
    }
    
    private String extend(String s, int l, int r){
        while(l >= 0 && r < s.length()){
            if(s.charAt(l) != s.charAt(r))
                break;
            l--;r++;
        }
        return s.substring(l+1,r); //handle the extra decrement in the while loop
    }
}




















