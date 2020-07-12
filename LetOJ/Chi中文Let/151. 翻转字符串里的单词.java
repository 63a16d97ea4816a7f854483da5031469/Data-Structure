
/*
 * 
link: 
https://leetcode-cn.com/problems/reverse-words-in-a-string/

2020-7-12 at 6:38 pm


151. 翻转字符串里的单词
难度
中等

196

收藏

分享
切换为英文
关注
反馈
给定一个字符串，逐个翻转字符串中的每个单词。

 

示例 1：

输入: "the sky is blue"
输出: "blue is sky the"
示例 2：

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：

输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 

说明：

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 

进阶：

请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。



对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




//6.38pm-6.45pm
class Solution {
    public String reverseWords(String s) {
        if(s.length()==0) return s;
        String[] str=s.split(" ");
        Stack<String> stack=new Stack<String>();
        for(int i=0;i<str.length;i++){
            if(str[i].equals("")) continue;
            stack.push(str[i]);
            if(!stack.isEmpty()&&i!=str.length-1){
                stack.push(" ");
            }
        }
        String result="";
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
}


//最快解答：
class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuffer sBuff = new StringBuffer();
        for(int i=str.length-1;i>=0;i--){
            if(!str[i].isEmpty()){
              sBuff= sBuff.append(str[i]);
                if(i!=0){
                    sBuff.append(" ");
                }  
            }
 
        }
        return sBuff.toString().trim();
    }
}














