
/*
 * 
link: https://leetcode-cn.com/problems/container-with-most-water/


11. 盛最多水的容器
难度
中等

3119

收藏

分享
切换为英文
关闭提醒
反馈
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器。

2022-01-19 at 10.25am 


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int sum=0;
        int maxSum=0;
        while(l<=height.length&&r>=0){
            sum=Math.min(height[l],height[r])*(r-l);
            maxSum=Math.max(sum,maxSum);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxSum;
    }
}



















