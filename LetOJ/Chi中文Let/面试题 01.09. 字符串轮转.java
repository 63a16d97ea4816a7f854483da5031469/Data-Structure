
/*
 * 
link: https://leetcode-cn.com/problems/string-rotation-lcci/

2022-02-06 at 22:35

面试题 01.09. 字符串轮转
难度
简单

97

收藏

分享
切换为英文
接收动态
反馈
字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。

示例1:

 输入：s1 = "waterbottle", s2 = "erbottlewat"
 输出：True
示例2:

 输入：s1 = "aa", s2 = "aba"
 输出：False
提示：

字符串长度在[0, 100000]范围内。
说明:

你能只调用一次检查子串的方法吗？

 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.equals(s2)) return true;
        LinkedList<Character> l1=new LinkedList<>();
        LinkedList<Character> l2=new LinkedList<>();
        int len1=s1.length();
        int len2=s2.length();
        for(int i=0;i<s1.length();i++){
            l1.add(s1.charAt(i));
        }
        for(int i=0;i<s2.length();i++){
            l2.add(s2.charAt(i));
        }
        if(len1!=len2) return false;

        int flipeCount=0;

        while(flipeCount<s1.length()){
            Character head=l1.removeFirst();
            l1.add(head);
            if(isSame(l1,l2)){
                return true;
            }
            flipeCount++;
        }
        return false;
    }

    public boolean isSame(LinkedList l1, LinkedList l2)
    {
        int len1=l1.size();
        int len2=l2.size();

        for(int i=0;i<len1;i++){
            if(l1.get(i)!=l2.get(i)){
                return false;
            }
        }
        return true;
    }
}




class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length()!=s2.length()) return false;

        for(int i=0;i<s1.length();i++){
            String sub1=s1.substring(0,i);
            String sub2=s1.substring(i,s1.length());
            String changed=sub2+sub1;
            // System.out.println(changed+" ");
            if(changed.equals(s2)){
                return true;
            }
        }
        return false;
    }
}

















