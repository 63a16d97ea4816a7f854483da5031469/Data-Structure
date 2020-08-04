
/*
 * 
link: 
https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/

2020-8-4 at 8:13 am


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    //8.12am-8.15am
    public String reverseLeftWords(String s, int n) {
        char[] c=s.toCharArray();
        char[] ans=new char[c.length];
        for(int i=0;i<c.length;i++){
            ans[i]=c[(i+n)%c.length];
        }
        return String.valueOf(ans);
    }
}




















