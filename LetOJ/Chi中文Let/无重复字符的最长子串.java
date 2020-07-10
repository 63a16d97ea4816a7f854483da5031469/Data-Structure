
/*
 * 
link: https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/


2020-7-1 at 8:33 pm

  无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


 * 
 */

//11.49pm-12.11am
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<Character>();
        int max=0;
        for(int i=0, j=0;i<s.length();i++){
            while(set.contains(s.charAt(i))){
                if(s.charAt(j)==s.charAt(i)){
                    set.remove(s.charAt(j++));
                }else{
                    set.remove(s.charAt(j++));
                }
            }
            set.add(s.charAt(i));
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}




class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<Character>();
        int max=0;
        for(int i=0, j=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                while(set.contains(s.charAt(i))){
                    set.remove(s.charAt(j++));
                }
            }
            set.add(s.charAt(i));
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}

















