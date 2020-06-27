
/*
 * 
https://leetcode.com/problems/longest-substring-without-repeating-characters/


Reverse a linked list from position m to n. Do it in-place and in one-pass.
3. Longest Substring Without Repeating Characters
Medium

8597

522

Add to List

Share
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

9 May 2020 at 12:20: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


 * 
 */


class Solution {
    //双指针--滑动窗口
    //11.22pm-11.32pm
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        HashSet<Character> set=new HashSet<Character>();
            for(int i=0,j=0;i<s.length();i++){
                if(set.contains(s.charAt(i))){
                    while(j<s.length()&&set.contains(s.charAt(i))){
                        set.remove(s.charAt(j++));                        
                    }
                }
                set.add(s.charAt(i));
                max=Math.max(max,i-j+1);
            }
        return max;
    }
}



class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
			return s.length();
		}
		int maxLen = 1, start = 0, end = 1, len = 1;
		String curStr;
		while (end < s.length()) {
			curStr = s.substring(start, end);
			if (curStr.contains(String.valueOf(s.charAt(end)))) {
				start = s.indexOf(s.charAt(end), start) + 1;
				end++;
				continue;
			}
			len = end - start + 1;
			if (len > maxLen) {
				maxLen = len;
			}
			end++;
		}
 
		return maxLen;
    }
}

// ————————————————
// 版权声明：本文为CSDN博主「Alan_Xiang」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/xiangwanpeng/article/details/77854210






// https://github.com/Cee/Leetcode/blob/master/3%20-%20Longest%20Substring%20Without%20Repeating%20Characters.java


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

















