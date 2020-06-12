
/*
 * 
https://leetcode.com/problems/first-unique-character-in-a-string/


387. First Unique Character in a String
Easy

1623

108

Add to List

Share
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




public class Solution {
    public int firstUniqChar(String s) {
        char[] array = s.toCharArray();
        int[] a = new int[26];
        for(int i=0;i<s.length();i++)a[array[i]-'a']++;
        for(int i=0;i<s.length();i++){
            if(a[array[i]-'a']==1){
                return i;
            }
        }
        return -1;
    }
}

// ————————————————
// 版权声明：本文为CSDN博主「厚积_薄发」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/yuxin6866/article/details/52389320




class Solution {
    //11.43pm-11.58pm
    public int firstUniqChar(String s) {
        //处理极端情况
        if(s.length()==0) return -1;
        HashMap<Character, String> map=new HashMap<Character, String>();
        for(int i=0;i<s.length();i++){
            String curr=map.get(s.charAt(i));
            if(curr!=null){
                String[] strArr=curr.split(",");
                map.put(s.charAt(i),i+","+(Integer.parseInt(strArr[1])+1));
            }else{
                 map.put(s.charAt(i),i+","+1);
            }
        }
        int min=s.length()+1;
        for(Map.Entry<Character,String> entry:map.entrySet()){
            String str=entry.getValue();
            String[] strArr=str.split(",");
            
            if(Integer.parseInt(strArr[1])==1&&min>Integer.parseInt(strArr[0])){
                min=Integer.parseInt(strArr[0]);
            }
        }
        if(min>s.length()){
            return -1;
        }
      return min;
    }
}


















