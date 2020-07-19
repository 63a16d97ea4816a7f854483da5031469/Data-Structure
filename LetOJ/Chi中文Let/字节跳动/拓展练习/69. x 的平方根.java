
/*
 * 
link: 
https://leetcode-cn.com/problems/sqrtx/

2020-7-1 at 8:33 pm

69. x 的平方根
难度
简单

447

收藏

分享
切换为英文
关注
反馈
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去。


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    //8.38pm-8.54pm 看答案
    public int mySqrt(int x) {
        long left=0;
        long right=x;
        long tmp=0;
        while(left<=right){
            long mid=(long)(left+(right-left)/2);
            tmp=mid*mid;
            if(tmp==x){
                return (int)mid;
            }else if(tmp>x){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return (int)right;
    }
}




class Solution {
    //8.38pm-8.54pm 看答案
    public int mySqrt(int x) {
        long left=0;
        long right=x;
        long tmp=0;
        do{
            long mid=(long)(left+(right-left)/2);
            tmp=mid*mid;
            if(tmp==x){
                return (int)mid;
            }else if(tmp>x){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }while(left<=right);
        return (int)right;
    }
}





class Solution {

    int s;
    public int mySqrt(int x) {
        s=x;
        if(x==0) return 0;
        return (int)sqrts(x);
    }

    public double sqrts(double x){
        double res=(x+s/x)/2;
        if(res==x){
            return x;
        }else{
            return sqrts(res);
        }
    } 
}









