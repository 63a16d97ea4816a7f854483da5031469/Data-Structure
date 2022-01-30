
/*
 * 
link: https://leetcode-cn.com/problems/climbing-stairs/


70. 爬楼梯
难度
简单

2136

收藏

分享
切换为英文
接收动态
反馈
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 

示例 1：

输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
示例 2：

输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
 

提示：

1 <= n <= 45


2022-01-23 at 22:35
 

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


超时：

class Solution {
    public int climbStairs(int n) {
       return f(n);
    }
    public int f(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        return f(n-2)+f(n-1);
    }
}




通过：
class Solution {
    public int climbStairs(int n) {
       return f(n);
    }
    public int f(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        int a=1;
        int b=2;
        for(int i=2;i<n;i++){
            int tmp=b;
            b=a+b;
            a=tmp;
        }
        return b;
    }
}





class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int a=1;
        int b=1;
        int c=0;
        for(int i=1;i<n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}









