
/*
 * 
link: 
https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/

2020-8-20 at 9:01 pm

剑指 Offer 62. 圆圈中最后剩下的数字
难度
简单

201

收藏

分享
切换为英文
关注
反馈
0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

 

示例 1：

输入: n = 5, m = 3
输出: 3
示例 2：

输入: n = 10, m = 17
输出: 2
 

限制：

1 <= n <= 10^5
1 <= m <= 10^6


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




class Solution {
    //9.02pm-9.14pm
    public int lastRemaining(int n, int m) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int point=0;
        while(list.size()>1){
            point+=m;
            point=(point-1)%list.size();
            // System.out.println(list.get(point));
            list.remove(point);
        }
   
        return list.get(0);
    }
}



















