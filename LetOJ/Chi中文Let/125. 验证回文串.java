
/*
 * 
link: https://leetcode-cn.com/problems/valid-palindrome/

125. 验证回文串
难度
简单

471





给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

 

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
解释："amanaplanacanalpanama" 是回文串
示例 2:

输入: "race a car"
输出: false
解释："raceacar" 不是回文串
 

提示：

1 <= s.length <= 2 * 105
字符串 s 由 ASCII 字符组成


2022-02-13 at 23:54
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    List<Character> list=new ArrayList<>();
    public boolean isPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            Character c=String.valueOf(s.charAt(i)).toLowerCase().charAt(0);
            if(isValid(c)){
                list.add(c);
            }
        }

        // 判断回文算法
        
        return false;
    }
    public boolean isValid(Character c){
        return (c>='A'&&c<='Z')||(c>='a' && c<='z')||(c>='0'&&c<='9');
    }

}

















