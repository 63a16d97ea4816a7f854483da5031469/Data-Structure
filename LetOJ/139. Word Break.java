
/*
 * 
https://leetcode.com/problems/word-break/

139. Word Break
Medium

6085

289

Add to List

Share
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

25 Feb 2021 at 13:33 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



class Solution {
    //一维dp
    //dp[i] represents if we can form the string, whose index from 0 to i, with words from dict
    //dp[0] == true;
    //induction rule:
    //termination :dp[n]
    //optimization
    
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict == null || wordDict.size() == 0){
            throw new IllegalArgumentException();
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1;i <= n; i++){
            for(int j = 0; j <=i; j++){
                if(dp[j] == true && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }            
        }
        return dp[n];
    }
}


class Solution {    
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict == null || wordDict.size() == 0){
            return false;
        }      
        //index stores index that (0, index) is true , can be word break
        List<Integer> index = new ArrayList<>();
        index.add(0);
        for(int i = 1;i <= s.length(); i++){
            for(int id : index){
                if(wordDict.contains(s.substring(id, i))){
                    index.add(i);
                    break;
                }
            }            
        }
        return index.contains(s.length());
    }
}

















