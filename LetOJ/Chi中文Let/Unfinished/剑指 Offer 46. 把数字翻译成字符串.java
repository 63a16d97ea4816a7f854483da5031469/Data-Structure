
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

// 最后还有两个问题要注意：

// 由状态转移方程可知，以上动态规划的解法还可以进行空间上的优化。
// 注意前导零。举个例子，06只有一种翻译方法，即0和6，不能06一起翻译为6，本题不接受前导零。
 

// 作者：tyanyonecancode
// 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/marvelzhong-deng-de-xue-xi-bi-ji-jian-zh-uiig/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



class Solution {
    public int translateNum(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); ++i) {
            p = q; 
            q = r; 
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-by-leetcode-sol/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution{
    public int translateNum(int num) {
        //将字符串转化为数字
        String str = String.valueOf(num);
        //dfs遍历字符串求解
        return dfs(str, 0);
    }
    //表示从index位置开始有好多种翻译方法
    public int dfs(String str, int index){
        //如果当前的下标大于等于字符串的长度 - 1，则说明当前位置是由上一次跳到此处的，则直接返回1
        if(index >= str.length() - 1)
            return 1;
        //先求解每一次都翻译一个字符的方法数
        int res = dfs(str, index + 1);
        //以当前字符的下标为开始，截取两位，判断这位组成的数字是否在10~25之间
        //如果在这一次就可以直接翻译两个字符，然后从两个字符后面的位置开始翻译
        String temp = str.substring(index, index + 2);
        if(temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0)
            res += dfs(str, index + 2);
        return res;
    }
}





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


















