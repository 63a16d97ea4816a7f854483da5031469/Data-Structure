
/*
 * 
link: https://leetcode-cn.com/problems/is-unique-lcci/

面试题 01.01. 判定字符是否唯一
难度
简单

184

收藏

分享
切换为英文
接收动态
反馈
实现一个算法，确定一个字符串 s 的所有字符是否全都不同。

示例 1：

输入: s = "leetcode"
输出: false 
示例 2：

输入: s = "abc"
输出: true
限制：

0 <= len(s) <= 100
如果你不使用额外的数据结构，会很加分。



2022-02-04 at 23:56
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public boolean isUnique(String astr) {
       int[] arr=new int[26];
       for(int i=0;i<astr.length();i++){
           int index=astr.charAt(i)-'a';
           arr[index]++;
           if(arr[index]>=2){
               return false;
           }
       }
       return true;
    }
}





















