
/*
 * 
https://leetcode.com/problems/find-all-anagrams-in-a-string/


438. Find All Anagrams in a String
Medium

2505

165

Add to List

Share
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


11 May 2020 at 11:33 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




题目 leetcode 438 Find All Anagrams in a String

输入字符串s和p，要求返回s中有哪些index开始的子字符串和p是Anagrams, 也就是字符是一样的，只是打乱了。

解题思路分析

还是今天的sliding windows系列题, 和前面几道题类似
http://www.noteanddata.com/leetcode-159-Longest-Substring-with-At-Most-Two-Distinct-Characters-java-sliding-windows-solution-note.html
http://www.noteanddata.com/leetcode-76-Minimum-Window-Substring-java-sliding-windows-solution-note.html
http://www.noteanddata.com/leetcode-1004-Max-Consecutive-Ones-III-java-sliding-window-solution-note.html
http://www.noteanddata.com/leetcode-3-Longest-Substring-Without-Repeating-Characters-java-sliding-windows-solution-note.html


首先对p建立一个hashmap，表示每个字符出现的次数， 这样方便到时候比较，直接比较hashmap就好
再建立一个新的hashamp，表示s中当前窗口的每个字符出现的次数
用两个index， 分别是i和j， 然后i一直向前移动，更新窗口的状态，
因为p的长度固定，所以每次当窗口大小和p的长度一样的时候，判断一下当前窗口是否合法，然后移动j并更新下当前窗口的状态就好

 * 
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pCountMap = new HashMap<>();
        for(char ch: p.toCharArray()) {
            pCountMap.put(ch, pCountMap.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> sCountMap = new HashMap<>();
        int j = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length(); ++i) {
            char chi = s.charAt(i);
            sCountMap.put(chi, sCountMap.getOrDefault(chi, 0) + 1);
            if(i-j+1 == p.length()) {  // check 
                if(pCountMap.equals(sCountMap)) {
                    list.add(j);
                }            
                char chj = s.charAt(j);
                if(sCountMap.get(chj) == 1) {
                    sCountMap.remove(chj);
                }
                else {
                    sCountMap.put(chj, sCountMap.get(chj)-1);                 
                }
                j++;
            }
        }
        return list;
    }
}



class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--; 
            
            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);
        
            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }   
}








I will first give the solution then show you the magic template.

The code of solving this problem is below. It might be the shortest among all solutions provided in Discuss.

string minWindow(string s, string t) {
        vector<int> map(128,0);
        for(auto c: t) map[c]++;
        int counter=t.size(), begin=0, end=0, d=INT_MAX, head=0;
        while(end<s.size()){
            if(map[s[end++]]-->0) counter--; //in t
            while(counter==0){ //valid
                if(end-begin<d)  d=end-(head=begin);
                if(map[s[begin++]]++==0) counter++;  //make it invalid
            }  
        }
        return d==INT_MAX? "":s.substr(head, d);
    }
Here comes the template.

For most substring problem, we are given a string and need to find a substring of it which satisfy some restrictions. A general way is to use a hashmap assisted with two pointers. The template is given below.

int findSubstring(string s){
        vector<int> map(128,0);
        int counter; // check whether the substring is valid
        int begin=0, end=0; //two pointers, one point to tail and one  head
        int d; //the length of substring

        for() { /* initialize the hash map here */ }

        while(end<s.size()){

            if(map[s[end++]]-- ?){  /* modify counter here */ }

            while(/* counter condition */){ 
                 
                 /* update d here if finding minimum*/

                //increase begin to make it invalid/valid again
                
                if(map[s[begin++]]++ ?){ /*modify counter here*/ }
            }  

            /* update d here if finding maximum*/
        }
        return d;
  }
One thing needs to be mentioned is that when asked to find maximum substring, we should update maximum after the inner while loop to guarantee that the substring is valid. On the other hand, when asked to find minimum substring, we should update minimum inside the inner while loop.

The code of solving Longest Substring with At Most Two Distinct Characters is below:

int lengthOfLongestSubstringTwoDistinct(string s) {
        vector<int> map(128, 0);
        int counter=0, begin=0, end=0, d=0; 
        while(end<s.size()){
            if(map[s[end++]]++==0) counter++;
            while(counter>2) if(map[s[begin++]]--==1) counter--;
            d=max(d, end-begin);
        }
        return d;
    }
The code of solving Longest Substring Without Repeating Characters is below:

Update 01.04.2016, thanks @weiyi3 for advise.

int lengthOfLongestSubstring(string s) {
        vector<int> map(128,0);
        int counter=0, begin=0, end=0, d=0; 
        while(end<s.size()){
            if(map[s[end++]]++>0) counter++; 
            while(counter>0) if(map[s[begin++]]-->1) counter--;
            d=max(d, end-begin); //while valid, update d
        }
        return d;
    }
I think this post deserves some upvotes! : )