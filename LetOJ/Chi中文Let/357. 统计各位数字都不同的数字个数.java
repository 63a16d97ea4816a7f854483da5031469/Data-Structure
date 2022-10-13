
/*
 * 
link: https://leetcode.cn/problems/count-numbers-with-unique-digits/description/?orderBy=most_votes&languageTags=java

357. 统计各位数字都不同的数字个数


2022-10-13 at 15:19
 

357. 统计各位数字都不同的数字个数
中等
304
相关企业
给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 

示例 1：

输入：n = 2
输出：91
解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。 
示例 2：

输入：n = 0
输出：1
 

提示：

0 <= n <= 8


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


方法一：回溯

这个需要遍历都所有有效数字，复杂度高


class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        return dfs(Math.min(10, n), 0, new boolean[10]);
    }

    private int dfs(int n, int idx, boolean[] used) {
        int count = 0;
        if (idx != n) {
            for (int i = 0; i < 10; i++) {
                // 剪枝：多位数时，第一个数字不能为0
                if (i == 0 && n > 1 && idx == 1) {
                    continue;
                }
                // 剪枝：不能使用用过的数字
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                count += dfs(n, idx + 1, used) + 1;
                used[i] = false;
            }
        }
        return count;
    }
}


方法二：DP

根据规律，只关心数量，不用遍历到每个有效数字

class Solution {
    /**
     * 排列组合：n位有效数字 = 每一位都从 0~9 中选择，且不能以 0 开头
     * 1位数字：0~9                      10
     * 2位数字：C10-2，且第一位不能是0      9 * 9
     * 3位数字：C10-3，且第一位不能是0      9 * 9 * 8
     * 4位数字：C10-4，且第一位不能是0      9 * 9 * 8 * 7
     * ... ...
     * 最后，总数 = 所有 小于 n 的位数个数相加
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int first = 10, second = 9 * 9;
        int size = Math.min(n, 10);
        for (int i = 2; i <= size; i++) {
            first += second;
            second *= 10 - i;
        }
        return first;
    }
}


class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        // f(0)=1
        // f(1)=10
        // f(2)=9*(10-2+1)+f(1)
        // f(3)=9*(10-2+1)*(10-3+1)+f(2)
        
        if(n==0) return 1;
        if(n==1) return 10;
        int result=9;
        int second=countNumbersWithUniqueDigits(n-1);
        for(int i=2;i<=n;i++){
            result=result*(10-i+1);
        }
        return result+second;
    }
}

















