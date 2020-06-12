
/*
 * 
https://leetcode.com/problems/permutation-in-string/

567. Permutation in String
Medium

1050

52

Add to List

Share
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 

Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
    }
}

28 March 2020 at 2.41pm to 2.51pm
 * 
 */








class Solution {
    
    //7.20 - 7.36pm
    public boolean checkInclusion(String s1, String s2) {
        char[] map1=new char[26];
        char[] map2=new char[26];

        char[] arr1=s1.toCharArray();
        char[] arr2=s2.toCharArray();
        
        for(int i=0;i<arr1.length;i++){
            map1[arr1[i]-'a']++;
        }
        
        //注意这里是<=，千万不能因为这个少case
        for(int i=0;i<=arr2.length-arr1.length;i++){
            map2=new char[26];
            for(int j=0;j<arr1.length;j++){
                map2[(arr2[i+j]-'a')]++;
                
                if(match(map1,map2)){
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean match(char[] map1, char[] map2){
        for(int i=0;i<map1.length;i++){
            if(map1[i]!=map2[i]){
                return false;
            }
        }
        return true;
    }
}







超过时间：

class Solution {
    
    List<String> list=new ArrayList<String>();
    
    //2.41pm to 2.51pm
    //思路，先搞出来s1的全排列，然后用在s2中寻找是否有，不过可能超时
    public boolean checkInclusion(String s1, String s2) {
        char[] sc1=s1.toCharArray();
        findPerm(sc1, 0, s1.length()-1);
 
        for(String tmp:list){
            if(s2.contains(tmp)){
                return true;
            }
        }
        return false;
    }
    
    void findPerm(char[] arr, int from, int to){
        //找到排列
        if(from==to){
            String s="";
            for(char tmp:arr){
                s+=tmp+"";
            }
            list.add(new String(s));
        }
        for(int i=from;i<=to;i++){
            
            //想不起来了，这里看了之前的如何做permutation排列的答案
         swap(arr, from, i);
         findPerm(arr,from+1, to);
            //switch back
         swap(arr, from, i);
        }
        
    }
    
    void swap(char[] arr, int i, int j){
        char tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    
}
























