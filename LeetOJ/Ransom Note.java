
/*
 * 
https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/


Ransom Note
Solution
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true


3 May 2020 at 4.22pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




class Solution {
    //4.14pm-4.16pm
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] ransomArr=new int[26];
        int[] magazineArr=new int[26];
        
        for(int i=0;i<ransomNote.length();i++){
            ransomArr[ransomNote.charAt(i)-'a']++;
        }
        for(int i=0;i<magazine.length();i++){
            magazineArr[magazine.charAt(i)-'a']++;
        }
        
        for(int i=0;i<ransomArr.length;i++){
            if(ransomArr[i]!=0 && ransomArr[i]>magazineArr[i]){
                return false;
            }
        }
        return true;
    }
}



















