
/*
 * 
link: 
https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/

2020-8-12 at 8:20 am

剑指 Offer 10- I. 斐波那契数列
难度
简单

48

收藏

分享
切换为英文
关注
反馈
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

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


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */





class Solution {
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}

// 作者：jyd
// 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/solution/mian-shi-ti-10-i-fei-bo-na-qi-shu-lie-dong-tai-gui/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






//错误,溢出： 

class Solution {
    //8.12am-8.20
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;

        long  first=0;
        long  second=1;
        long  third=0;
        for(int i=0;i<n-1;i++){
            third=first+second;
            first=second;
            second=third;
            // System.out.println(third);
        }
        return (int)(third%(long)1000000007);
    }
}









