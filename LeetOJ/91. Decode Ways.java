
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



Visualizing Recursion
https://www.coursera.org/lecture/principles-of-computing-2/visualizing-recursion-pubjS










增加了HashMap作为记事本   AC：

Runtime: 7 ms, faster than 12.08% of Java online submissions for Decode Ways.
Memory Usage: 40 MB, less than 5.66% of Java online submissions for Decode Ways.


class Solution {
    
    HashMap<String,Integer> map=new HashMap<>();
    
    public int numDecodings(String s) {
        if (!s.contains("0")) {
            return fun(s);
        }
        s = s.replaceAll("10", "A");
        s = s.replaceAll("20", "A");
        if (s.contains("0")) {
            return 0;
        }
        String[] as = s.split("A");
        int res = 1;
        for (String a : as) {
            res *= fun(a);
        }
        return res;
    }

    private int fun(String s) {
        if (s.length() < 2) {
            return 1;
        }
        if (s.length() == 2) {
            return s.compareTo("26") <= 0 ? 2 : 1;
        }
        String sub = s.substring(0, 2);
        if (sub.compareTo("26") <= 0) {
            
            Object f1=map.get(s.substring(1));
            Object f2=map.get(s.substring(2));
            
            if(f1!=null&&f2!=null){
                return (int)f1+(int)f2;
            }else{
                 f1=fun(s.substring(1));
                 f2=fun(s.substring(2));
                map.put(s.substring(1),(int)f1);
                map.put(s.substring(2),(int)f2);
                return (int)f1+(int)f2;
            }
            
            
        } else {
            
            Object f1=map.get(s.substring(1));
            
            if(f1!=null){
                return (int)f1;
            }else{
                 f1=fun(s.substring(1));
               return (int)f1;
            }
            
         
        }
    }
}

// 作者：jiayou-11
// 链接：https://leetcode-cn.com/problems/decode-ways/solution/zui-chuan-tong-de-di-gui-you-0de-shi-hou-te-shu-ch/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




不增加cache， 这个无法通过： "7541387519572282368613553811323167125532172369624572591562685959575371877973171856836975137559677665"


class Solution {
    public int numDecodings(String s) {
        if (!s.contains("0")) {
            return fun(s);
        }
        s = s.replaceAll("10", "A");
        s = s.replaceAll("20", "A");
        if (s.contains("0")) {
            return 0;
        }
        String[] as = s.split("A");
        int res = 1;
        for (String a : as) {
            res *= fun(a);
        }
        return res;
    }

    private int fun(String s) {
        if (s.length() < 2) {
            return 1;
        }
        if (s.length() == 2) {
            return s.compareTo("26") <= 0 ? 2 : 1;
        }
        String sub = s.substring(0, 2);
        if (sub.compareTo("26") <= 0) {
            return fun(s.substring(1)) + fun(s.substring(2));
        } else {
            return fun(s.substring(1));
        }
    }
}

// 作者：jiayou-11
// 链接：https://leetcode-cn.com/problems/decode-ways/solution/zui-chuan-tong-de-di-gui-you-0de-shi-hou-te-shu-ch/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。







增加cache，这个通过， AC：


import functools
class Solution:
    @functools.lru_cache(None)
    def numDecodings(self, s: str) -> int:
        if not s:
            return 1
        ans = 0
        if len(s) >= 1 and s[0] != '0':
            ans += self.numDecodings(s[1:])
        if len(s) >= 2 and s[0] != '0' and int(s[:2]) <= 26:
            ans += self.numDecodings(s[2:])
        return ans

# 作者：powcai
# 链接：https://leetcode-cn.com/problems/decode-ways/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-4/
# 来源：力扣（LeetCode）
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





不增加cache，这个无法通过：


class Solution:
    def numDecodings(self, s: str) -> int:
        if not s:
            return 1
        ans = 0
        if len(s) >= 1 and s[0] != '0':
            ans += self.numDecodings(s[1:])
        if len(s) >= 2 and s[0] != '0' and int(s[:2]) <= 26:
            ans += self.numDecodings(s[2:])
        return ans

# 作者：powcai
# 链接：https://leetcode-cn.com/problems/decode-ways/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-4/
# 来源：力扣（LeetCode）
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






题解：


递归方法：

递归和动态规划两种解法。本题解讲述如何从递推转换成动态规划。

从后往前遍历。如果
以22067为例，从后往前遍历。
首先如果为7。很显然是1种7->G
如果为67。很显然还是1种67->FG
如果为067。结果为0。
如果为2067。 结果为numDecodings（20 67）+ numDecodings（2 067）= numDecodings（20 67）->TFG
如果为22067。 结果为numDecodings（2 2067）+ numDecodings（22 067）= numDecodings（2 2067）->BTFG

从中，我们可以看出规律。
如果开始的数为0，结果为0。
如果开始的数加上第二个数小于等于26。结果为 numDecodings（start+1）+ numDecodings（start +2）
如果开始的数加上第二个数大于26。结果为 numDecodings（start +1）

作者：reedfan
链接：https://leetcode-cn.com/problems/decode-ways/solution/di-gui-dong-tai-gui-hua-kong-jian-ya-suo-man-man-d/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


递推公式，类似 斐波那数列 f(n)=f(n-1)+f(n-2);

每次向后看1位，然后看2位： 如果两位加起来大于26，则使用1位来组成字母，如果小于等于26，则使用这两位来组成字母。



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












class Solution {
  
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return digui(s, 0);
    }

//递归的套路，加一个index控制递归的层次
    private int digui(String s, int start) {
    	
    	System.out.println("first line start="+start);
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
            System.out.println("start="+start+"  ten+one="+ans2+" s.charAt(start):"+s.charAt(start)+" s.charAt(start+1):"+s.charAt(start + 1));
        }else {
            System.out.println("start="+start+" s.charAt(start):"+s.charAt(start));
        }
        
        
        System.out.println("start: "+start+" ans1="+ans1+"  ans2="+ans2+" ans1+ans2="+(ans1+ans2));
        
        return ans1 + ans2;
    }




input: 22067


first line start=0
first line start=1
first line start=2
first line start=3
first line start=4
first line start=5
start=4 s.charAt(start):7
start: 4 ans1=1  ans2=0 ans1+ans2=1
start=3  ten+one=67 ans2=0 s.charAt(start):6 s.charAt(start+1):7
start: 3 ans1=1  ans2=0 ans1+ans2=1
start=1  ten+one=20 ans2=1 s.charAt(start):2 s.charAt(start+1):0
start: 1 ans1=0  ans2=1 ans1+ans2=1
first line start=2
start=0  ten+one=22 ans2=0 s.charAt(start):2 s.charAt(start+1):2
start: 0 ans1=1  ans2=0 ans1+ans2=1




input: 22167

first line start=0
first line start=1
first line start=2
first line start=3
first line start=4
first line start=5
start=4 s.charAt(start):7
start: 4 ans1=1  ans2=0 ans1+ans2=1
start=3  ten+one=67 ans2=0 s.charAt(start):6 s.charAt(start+1):7
start: 3 ans1=1  ans2=0 ans1+ans2=1
first line start=4
first line start=5
start=4 s.charAt(start):7
start: 4 ans1=1  ans2=0 ans1+ans2=1
start=2  ten+one=16 ans2=1 s.charAt(start):1 s.charAt(start+1):6
start: 2 ans1=1  ans2=1 ans1+ans2=2
first line start=3
first line start=4
first line start=5
start=4 s.charAt(start):7
start: 4 ans1=1  ans2=0 ans1+ans2=1
start=3  ten+one=67 ans2=0 s.charAt(start):6 s.charAt(start+1):7
start: 3 ans1=1  ans2=0 ans1+ans2=1
start=1  ten+one=21 ans2=1 s.charAt(start):2 s.charAt(start+1):1
start: 1 ans1=2  ans2=1 ans1+ans2=3
first line start=2
first line start=3
first line start=4
first line start=5
start=4 s.charAt(start):7
start: 4 ans1=1  ans2=0 ans1+ans2=1
start=3  ten+one=67 ans2=0 s.charAt(start):6 s.charAt(start+1):7
start: 3 ans1=1  ans2=0 ans1+ans2=1
first line start=4
first line start=5
start=4 s.charAt(start):7
start: 4 ans1=1  ans2=0 ans1+ans2=1
start=2  ten+one=16 ans2=1 s.charAt(start):1 s.charAt(start+1):6
start: 2 ans1=1  ans2=1 ans1+ans2=2
start=0  ten+one=22 ans2=2 s.charAt(start):2 s.charAt(start+1):2
start: 0 ans1=3  ans2=2 ans1+ans2=5



从后往前遍历。如果
以22067为例，从后往前遍历。
首先如果为7。很显然是1种7->G
如果为67。很显然还是1种67->FG    numDecodings(6 7)
如果为067。结果为0。
如果为2067。 结果为numDecodings（20 67）+ numDecodings（2 067）= numDecodings（20 67）->TFG
如果为22067。 结果为numDecodings（2 2067）+ numDecodings（22 067）= numDecodings（2 2067）->BTFG

从中，我们可以看出规律。
如果开始的数为0，结果为0。
如果开始的数加上第二个数小于等于26。结果为 numDecodings（start+1）+ numDecodings（start +2）
如果开始的数加上第二个数大于26。结果为 numDecodings（start +1）



input:22367

first line start=0
first line start=1
first line start=2
first line start=3
first line start=4
first line start=5
start=4 s.charAt(start):7
start: 4 ans1=1  ans2=0 ans1+ans2=1
start=3  ten+one=67 ans2=0 s.charAt(start):6 s.charAt(start+1):7
start: 3 ans1=1  ans2=0 ans1+ans2=1
start=2  ten+one=36 ans2=0 s.charAt(start):3 s.charAt(start+1):6
start: 2 ans1=1  ans2=0 ans1+ans2=1
first line start=3
first line start=4
first line start=5
start=4 s.charAt(start):7
start: 4 ans1=1  ans2=0 ans1+ans2=1
start=3  ten+one=67 ans2=0 s.charAt(start):6 s.charAt(start+1):7
start: 3 ans1=1  ans2=0 ans1+ans2=1
start=1  ten+one=23 ans2=1 s.charAt(start):2 s.charAt(start+1):3
start: 1 ans1=1  ans2=1 ans1+ans2=2
first line start=2
first line start=3
first line start=4
first line start=5
start=4 s.charAt(start):7
start: 4 ans1=1  ans2=0 ans1+ans2=1
start=3  ten+one=67 ans2=0 s.charAt(start):6 s.charAt(start+1):7
start: 3 ans1=1  ans2=0 ans1+ans2=1
start=2  ten+one=36 ans2=0 s.charAt(start):3 s.charAt(start+1):6
start: 2 ans1=1  ans2=0 ans1+ans2=1
start=0  ten+one=22 ans2=1 s.charAt(start):2 s.charAt(start+1):2
start: 0 ans1=2  ans2=1 ans1+ans2=3




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













