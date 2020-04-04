
/*
 * 
https://leetcode.com/problems/decode-ways/

91. Decode Ways
Medium

2243

2475

Add to List

Share
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

4 April 2020 at 5.45pm
 * 
 */





题解：

class Solution {
 
    
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return digui(s, 0);
    }

//递归的套路，加一个index控制递归的层次
    private int digui(String s, int start) {
        //递归的第一步，应该是加终止条件，避免死循环。
        if (s.length() == start) {
            return 1;
        }
        //以0位开始的数是不存在的
        if (s.charAt(start) == '0') {
            return 0;
        }
        //递归的递推式应该是如果index的后两位小于等于26，  
        // digui(s, start) = digui(s, start+1)+digui(s, start+2)   
        // 否则digui(s, start) = digui(s, start+1)
        int ans1 = digui(s, start + 1);
        int ans2 = 0;
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = (s.charAt(start + 1) - '0');
            if (ten + one <= 26) {
                ans2 = digui(s, start + 2);
            }
        }
        return ans1 + ans2;
    }

// 作者：reedfan
// 链接：https://leetcode-cn.com/problems/decode-ways/solution/di-gui-dong-tai-gui-hua-kong-jian-ya-suo-man-man-d/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}




动态规划:
https://www.cnblogs.com/grandyang/p/4313384.html

class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; ++i) {
            if (s.charAt(i - 1) != '0') dp[i] += dp[i - 1];
            if (i >= 2 && (s.substring(i - 2, i).compareTo("10") >= 0 && s.substring(i - 2, i).compareTo("26") <= 0)) {
                dp[i] += dp[i - 2];
            }
        }
        
        System.out.println(Arrays.toString(dp));
        
        return dp[s.length()];
    }
}













