
/*
 * 
link: https://leetcode-cn.com/problems/palindrome-partitioning/


2021-3-7 at 2:58 pm

131. 分割回文串
难度
中等

572

收藏

分享
切换为英文
接收动态
反馈
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]

对题目易错地方进行总结:

对题目的实现思路进行几句话总结:

从这道题目学到了什么，哪些地方需要提升? :

 * 
 */



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
        // 注意：只使用 stack 相关的接口
        Deque<String> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, len, stack, res);
        return res;
    }

    /**
     * @param charArray
     * @param index     起始字符的索引
     * @param len       字符串 s 的长度，可以设置为全局变量
     * @param path      记录从根结点到叶子结点的路径
     * @param res       记录所有的结果
     */
    private void dfs(char[] charArray, int index, int len, Deque<String> path, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            // 因为截取字符串是消耗性能的，因此，采用传子串下标的方式判断一个子串是否是回文子串
            if (!checkPalindrome(charArray, index, i)) {
                continue;
            }
            path.addLast(new String(charArray, index, i + 1 - index));
            dfs(charArray, i + 1, len, path, res);
            path.removeLast();
        }
    }

    /**
     * 这一步的时间复杂度是 O(N)，优化的解法是，先采用动态规划，把回文子串的结果记录在一个表格里
     *
     * @param charArray
     * @param left      子串的左边界，可以取到
     * @param right     子串的右边界，可以取到
     * @return
     */
    private boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// 作者：liweiwei1419
// 链接：https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



// import java.util.ArrayDeque;
// import java.util.ArrayList;
// import java.util.Deque;
// import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        char[] charArray = s.toCharArray();
        // 预处理
        // 状态：dp[i][j] 表示 s[i][j] 是否是回文
        boolean[][] dp = new boolean[len][len];
        // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
        for (int right = 0; right < len; right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (charArray[left] == charArray[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        Deque<String> stack = new ArrayDeque<>();
        dfs(s, 0, len, dp, stack, res);
        return res;
    }

    private void dfs(String s, int index, int len, boolean[][] dp, Deque<String> path, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            if (dp[index][i]) {
                path.addLast(s.substring(index, i + 1));
                dfs(s, i + 1, len, dp, path, res);
                path.removeLast();
            }
        }
    }
}

// 作者：liweiwei1419
// 链接：https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




// 速度最快解法：


class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> list = new ArrayList<>();
    boolean[][] dp;
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        dp = new boolean[n][n];
        for (boolean[] array : dp) {
            Arrays.fill(array, true);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }
        dfs(s, 0);
        return result;
    }

    public void dfs(String s, int start) {
        if (start == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < n; i++) {
            if (dp[start][i]) {
                list.add(s.substring(start, i + 1));
                dfs(s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}

// 作者：StackExplosion
// 链接：https://leetcode-cn.com/problems/palindrome-partitioning/solution/131fen-ge-hui-wen-chuan-javahui-su-dong-kt608/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        // f[i][j] 代表 [i, j] 这一段是否为回文串
        boolean[][] f = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                // 当 [i, j] 只有一个字符时，必然是回文串
                if (i == j) {
                    f[i][j] = true;
                } else {
                    // 当 [i, j] 长度为 2 时，满足 cs[i] == cs[j] 即回文串
                    if (j - i + 1 == 2) {
                        f[i][j] = cs[i] == cs[j];

                    // 当 [i, j] 长度大于 2 时，满足 (cs[i] == cs[j] && f[i + 1][j - 1]) 即回文串
                    } else {
                        f[i][j] = cs[i] == cs[j] && f[i + 1][j - 1];
                    }
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        dfs(s, 0, ans, cur, f);
        return ans;
    }
    /**
     * s: 要搜索的字符串
     * u: 以 s 中的那一位作为回文串分割起点
     * ans: 最终结果集
     * cur: 当前结果集
     * f: 快速判断 [i,j] 是否为回文串
     */
    void dfs(String s, int u, List<List<String>> ans, List<String> cur, boolean[][] f) {
        int n = s.length();
        if (u == n) ans.add(new ArrayList<>(cur));
        for (int i = u; i < n; i++) {
            if (f[u][i]) {
                cur.add(s.substring(u, i + 1));
                dfs(s, i + 1, ans, cur, f);
                cur.remove(cur.size() - 1);
            }
        }
    }
}

// 作者：AC_OIer
// 链接：https://leetcode-cn.com/problems/palindrome-partitioning/solution/wei-sha-yao-zhe-yang-bao-sou-ya-shi-ru-h-41gf/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



<p><a href="https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/" target="_blank">17. 电话号码的字母组合(中等)</a> : <a href="https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/shua-chuan-lc-dfs-hui-su-jie-fa-by-ac_oi-qa02/" target="_blank">从一道「回溯算法」经典题与你分享回溯算法的基本套路</a></p>

<p><a href="https://leetcode-cn.com/problems/combination-sum/" target="_blank">39. 组合总和(中等)</a> : <a href="https://leetcode-cn.com/problems/combination-sum/solution/dfs-hui-su-suan-fa-yi-ji-ru-he-que-ding-wpbo5/" target="_blank">DFS + 回溯算法，以及如何确定一道题是否应该使用 DFS + 回溯来求解</a></p>

<p><a href="https://leetcode-cn.com/problems/combination-sum-ii/" target="_blank">40. 组合总和 II(中等)</a> : <a href="https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-qiu-mu-biao-he-de-zu-he-f-1iys/" target="_blank">【回溯算法】求目标和的组合方案（升级篇）</a></p>

<p><a href="https://leetcode-cn.com/problems/combination-sum-iii/" target="_blank">216. 组合总和 III(中等)</a> : <a href="https://leetcode-cn.com/problems/combination-sum-iii/solution/hui-su-suan-fa-jie-zhu-zui-hou-yi-dao-zu-n1lo/" target="_blank">【回溯算法】借助最后一道「组合总和」问题来总结一下回溯算法</a></p>

<p><a href="https://leetcode-cn.com/problems/sudoku-solver/" target="_blank">37. 解数独(困难)</a> : <a href="https://leetcode-cn.com/problems/sudoku-solver/solution/he-n-huang-hou-yi-yang-shi-yi-dao-hui-su-lfpd/" target="_blank">【数独问题】经典面试题：解数独</a></p>




class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        int n=s.length();
        char[] c=s.toCharArray();

        boolean[][] f=new boolean[n][n];
        for(int j=0;j<n;j++){
            for(int i=j;i>=0;i--){
                if(i==j){
                    f[i][j]=true;
                }else if(j-i+1==2){
                        f[i][j]=c[i]==c[j];
                }else{
                    f[i][j]= f[i+1][j-1] && c[i]==c[j];
                }
            }
        }
        result=new ArrayList<>();
        dfs(s,f,0, new ArrayList<>());
        return result;
    }
    public void dfs(String s, boolean[][] f, int index, List<String> list){
        if(index>s.length()) return;

        if(index==s.length())
        {
            result.add(new ArrayList<String>(list));
            return;
        }

        for(int i=index;i<s.length();i++){
            String str=s.substring(index,i+1);
            if(f[index][i]){
                list.add(str);
                dfs(s,f,i+1,list);  // [易错]，这里是i+1，不是index+1
                list.remove(list.size()-1);
            } 
        }
    }
}





class Solution {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> partition(String s) {
        int n=s.length();
        char[] c=s.toCharArray();
        boolean[][] dp=new boolean[n][n];
        for(int j=n-1;j>0;j--){ // 易错
            for(int i=j;i<n-2;i++){// 易错
                if(i==j){
                    dp[i][j]=true;
                }else if(j-i+1==2){
                    dp[i][j]= c[i]==c[j];
                }else{
                    dp[i][j]= c[i]==c[j] && dp[i+1][j-1];
                }
            }
        }
        dfs(s,dp,0,new ArrayList<String>());
        return result;
    }

    public void dfs(String s, boolean[][] dp, int index, List<String> list){
        if(index>s.length()) return;
        if(index==s.length()){
            result.add(new ArrayList<String>(list));
            return;
        }

        for(int i=index;i<s.length();i++){
                String tmp=s.substring(index,i+1);
                if(isValid(tmp)){  // 易错 易于忘记isValid(xxx)
                    list.add(tmp);
                    dfs(s,dp,i+1,list);
                    list.remove(list.size()-1);
                }
        }
    }

    public boolean isValid(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

