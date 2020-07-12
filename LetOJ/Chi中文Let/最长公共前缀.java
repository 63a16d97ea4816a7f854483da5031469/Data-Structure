
/*
 * 
link: 
https://leetcode-cn.com/problems/longest-common-prefix/submissions/

14. 最长公共前缀

2020-7-12 at 11:16 am

14. 最长公共前缀
难度
简单

1148

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


 * 
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];

        String shortestWord=strs[0];
        int min=Integer.MAX_VALUE;
        for(String tmpStr:strs){
            if(tmpStr.length()<min){
                min=tmpStr.length();
                shortestWord=tmpStr;
            }
        }
        for(int i=0;i<shortestWord.length();i++){
            String tmpStr=shortestWord.substring(0,shortestWord.length()-i);
            boolean isMatchAll=true;
            for(String str:strs){
                if(!str.substring(0,shortestWord.length()-i).equals(tmpStr)) {
                    isMatchAll=false;
                    break;
                }
            }
            if(isMatchAll){
                return tmpStr;
            }
        }
        return "";
    }
}




















