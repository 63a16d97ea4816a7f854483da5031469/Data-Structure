
/*
 * 
link: https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/

剑指 Offer 46. 把数字翻译成字符串
难度
中等

198

收藏

分享
切换为英文
接收动态
反馈
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

 

示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 

提示：

0 <= num < 231


2021-03-10 at 11:42 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

//递归
class Solution {
    private String s;
    public int translateNum(int num) {
        s = String.valueOf(num);
        return f(0);
    }
    private int f(int i) {
        if(i >= s.length() - 1)    return 1;
        int res = f(i + 1);
        if(s.charAt(i) != '0' && Integer.parseInt(s.substring(i, i + 2)) < 26)
            res += f(i + 2);
        return res;
    }
}

// 作者：tyanyonecancode
// 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/marvelzhong-deng-de-xue-xi-bi-ji-jian-zh-uiig/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//记忆化递归

// 在递归的过程中，我们发现求f(i)的时候需要先求解f(i + 1)和f(i + 2)，显然，这两者的求解过程中间存在许多重复解，这样会产生许多冗余的计算。我们把这些重复子问题的解，即中间解，记录下来，以避免冗余计算。因此记忆化递归便很自然地写出来了。

class Solution {
    private String s;
    private int[] dp;
    public int translateNum(int num) {
        s = String.valueOf(num);
        dp = new int[s.length()];
        return f(0);
    }
    private int f(int i) {
        if(i >= s.length() - 1)    return 1;
        if(dp[i] > 0)    return dp[i];
        int res = f(i + 1);
        if(s.charAt(i) != '0' && Integer.parseInt(s.substring(i, i + 2)) < 26)
            res += f(i + 2);
        dp[i] = res;
        return res;
    }
}

// 作者：tyanyonecancode
// 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/marvelzhong-deng-de-xue-xi-bi-ji-jian-zh-uiig/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// 方法三：动态规划

// 记忆化递归出来后，动态规划也就不远了。
// 其实从递归到动态规划就是一种自顶向下分析，自底向上实现的思想。
// 动态规划通常会使用一维或二维的数组来记录子问题的解（中间解），然后基于循环去实现（去填充数组）。
// 我们分析记忆化递归中dp[i]的求解方法如下：

class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        dp[len - 1] = 1;
        for(int i = len - 2; i >= 0; i--) {
            dp[i] = dp[i + 1];
            if(s.charAt(i) != '0' && Integer.parseInt(s.substring(i, i + 2)) < 26)
                dp[i] += dp[i + 2];
        }
        return dp[0];
    }
}

// 作者：tyanyonecancode
// 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/marvelzhong-deng-de-xue-xi-bi-ji-jian-zh-uiig/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



public class Solution {

    public int translateNum(int num) {
        String n=Integer.toString(num);
        return numsoftrans(n,0);
    }
    private int  numsoftrans(String n,int i) {
        if(i==n.length()||i==n.length()-1) return 1;
        if(Integer.valueOf(n.substring(i,i+1))!=0&&Integer.valueOf(n.substring(i,i+2))<26)
            return numsoftrans(n, i+1)+numsoftrans(n, i+2);
        return numsoftrans(n, i+1);	
    }
}
// 作者：CYINGENOHALT
// 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/javadi-gui-100-by-cyingenohalt-d2d6/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



public class Solution {
    int res = 0;
    List<Integer> list = new ArrayList<>();

    public int translateNum(int num) {
        while (num > 0) {
            list.add(0, num % 10);
            num /= 10;
        }
        backtrack(0);
        return res;
    }

    public void backtrack(int index) {
        if (index == list.size()) {
            res++;
            return;
        }
        backtrack(index + 1);
        if (list.get(index) == 0 || list.get(index) >= 3 || index >= list.size() - 1) {
            return;
        }
        if (list.get(index) == 1 || (list.get(index) == 2 && list.get(index + 1) <= 5)) {
            backtrack(index + 2);
        }
    }
}

// 作者：1iin
// 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/java-bao-li-di-gui-0ms-by-1iin-nm0d/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


















