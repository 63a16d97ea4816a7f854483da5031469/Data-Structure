
/*
 * 
https://leetcode.com/problems/is-subsequence/


392. Is Subsequence
Easy

1413

198

Add to List

Share
Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 10^4
Both strings consists only of lowercase characters.

14 June 2020 at 9:17 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */






class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for(char c : s.toCharArray()){
            index = t.indexOf(c, index+1);
            if(index == -1) return false;
        }
        return true;
    }
}




/*

解法一（贪心算法）：其实有点像字符串匹配的问题。如果维持两个指针分别指向两个字符串起点并开始遍历，找到匹配就移动两个指针向后，找到不匹配只移动待搜索的字符串的指针以寻找下一个匹配点。最后判断时候目标字符串已被遍历完成即可。思路很简单，而且是有一种“贪心”的想法在里面，即遇到匹配的就加入。

 

解法二（动态规划）：看到follow up和标签，想想其他的办法。首先动态规划是一定可以做的。假设boolean dp[i][j]表示s从0到i位置的字符串是否是t从0到j位置字符串的子串。那么当s[i]和t[j]相等的时候，只需要判断s(0, i-1)是不是t(0, j-1)的子串；如果s[i]和t[j]不相等，那么要一直往前看s(0, i)是不是t(0, j-1)的子串。只要注意边界情况就好。如果j是0，即t只有一个字符的时候都还没有能和s匹配，那么一定是不匹配。而且如果i>j，那么dp[i][j]一定是false，因为短字符串没法匹配长字符串。把递推公式实现，就是动态规划的解法。虽然运行速度很慢，但还是能过，显然这个方法是被允许的。

 

解法三（二分查找）：最后想一下，如果输入是大量的s需要进匹配那要怎么做。s可以有很多，但t只有一个。如果把t里面每个字符出现时的索引存起来，这样遇到一个s，那就看首先s中的字符在t中有没有出现（即存储那个索引的结构是不是空），没有出现直接返回false。如果出现了，那么记下它在t中出现的位置，比如设为preIndex，之后搜索s中下一个字符。这时候如果字符仍然在t中存在，那其实应该寻找第一个大于preIndex的位置（即寻找第一个大于等于preIndex+1的索引）才可以实现匹配。在有序结构里寻找特定数，就是标签中有二分查找的由来。

*/


class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for(char c : s.toCharArray()){
            index = t.indexOf(c, index+1);
            if(index == -1) return false;
        }
        return true;
    }
}



// 解法一（Java）
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        if(i == s.length()) return true;
        return false;
    }
}

// 解法二（Java）
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0) return true;
        if (n == 0) return false;
        boolean[][] dp = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) dp[i][j] = false;
                else if (s.charAt(i) == t.charAt(j)) {
                    // if (i == 0 || j == 0) dp[i][j] = i <= j ? true : false;
                    if (i == 0 || j == 0) dp[i][j] = true;
                    else dp[i][j] = dp[i-1][j-1];
                } 
                else dp[i][j] = j == 0 ? false : dp[i][j-1];
            }
        }    
        return dp[m-1][n-1];
    }   
}


// DP:
class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int[][] dp= new int[s.length()+1][t.length()+1];
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    
                }
            }
        }
        
       if(dp[s.length()][t.length()]==s.length())
           return true;
        else
            return false;
        
    }
}


// 二分查找法: AC
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null)
            return false;
        Map<Character,List<Integer>> map = new HashMap<>();
        
        for(int i = 0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i)))
                map.put(t.charAt(i),new ArrayList<>());
            List<Integer> idx = map.get(t.charAt(i));
            idx.add(i);
        }
        
        int prev = -1;
        for(int i = 0;i<s.length();i++){
            if(map.get(s.charAt(i)) == null)
                return false;
            List<Integer> res = map.get(s.charAt(i));
            prev = binarySearch(prev,res,0,res.size()-1);
            if(prev == -1)
                return false;
            prev++;
        }
        
        return true;
        
    }
    
    private int binarySearch(int prev,List<Integer>list, int start, int end){
        while(start<=end){
            int mid = start + (end- start)/2;
            if(list.get(mid)<prev)
                start = mid + 1;
            else
                end = mid - 1;
        }
        
        return start == list.size() ? -1 : list.get(start);
    }
}