
/*
 * 
link: 
https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/

2020-8-10 at 11:08 pm

剑指 Offer 17. 打印从1到最大的n位数
难度
简单

42

收藏

分享
切换为英文
关注
反馈
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
 

说明：

用返回一个整数列表来代替打印
n 为正整数


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */







class Solution {
    public int[] printNumbers(int n) {
        List<Integer> list=new ArrayList<Integer>();
        int now=1;
        while(countDigital(now)<=n){
            list.add(now);
            now++;
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    public int countDigital(int now){
        return (now+"").length();
    }
}


class Solution {
    public int[] printNumbers(int n) {
        int max = 0;
        for(int i = 1; i <= n; i++){
            max = max * 10 + 9;
        }
        int[] ans = new int[max];
        for(int i = 1; i <= max; i++){
            ans[i - 1] = i;
        }
        return ans;

    }
}



class Solution {
    public int[] printNumbers(int n) {
        double m=Math.pow(10,n)-1;
        int[] nums=new int[(int)m];
        for(int i=0;i<m;i++){
            nums[i]=i+1;
        }
        return nums;
    }
}

