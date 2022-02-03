
/*
 * 
link: https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/


https://www.baeldung.com/java-bigdecimal-biginteger

剑指 Offer 10- I. 斐波那契数列
难度
简单

292

收藏

分享
切换为英文
接收动态
反馈
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 

示例 1：

输入：n = 2
输出：1
示例 2：

输入：n = 5
输出：5
 

提示：

0 <= n <= 100


2022-02-03 at 18:01
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



import java.math.BigInteger;    
class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        BigInteger a=new BigInteger("0");
        BigInteger b=new BigInteger("1");
        BigInteger c=a.add(b);
        for(int i=2;i<=n;i++){
            c=a.add(b);
            a=b;
            b=c;
        }
        return c.mod(new BigInteger("1000000007")).intValue();
    }
}


















