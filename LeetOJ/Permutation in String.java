
/*
 * 
https://leetcode.com/problems/permutation-in-string/

567. Permutation in String
Medium
1400
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

19 May 2020 at 8:55 pm

对题目易错地方进行总结:

对题目的实现思路进行几句话总结:

从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



class Solution {
    public boolean checkInclusion(String p, String s) {
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        int windowSize = p.length();
        List<Integer> result = new ArrayList<>(s.length());
        for (int i=0; i<p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
        }
        for (int i=0; i<s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            if (i >= windowSize) {
                sCount[s.charAt(i-windowSize) - 'a']--;
            }
            if (Arrays.equals(sCount, pCount)) {
               result.add(i-windowSize+1);
            }
        }
        return (result.size() > 0) ? true : false;
    }
}









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
