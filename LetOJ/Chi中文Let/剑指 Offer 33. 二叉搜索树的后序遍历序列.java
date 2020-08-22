
/*
 * 
link: 
https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/

2020-8-22 at 10:11 am

剑指 Offer 33. 二叉搜索树的后序遍历序列
难度
中等

96

收藏

分享
切换为英文
关注
反馈
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

 

参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
示例 1：

输入: [1,6,3,2,5]
输出: false
示例 2：

输入: [1,3,2,6,5]
输出: true
 

提示：

数组长度 <= 1000


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    public boolean verifyPostorder(int[] postorder) {
       return helper(postorder,0,postorder.length-1);
    }

    public boolean helper(int[] postorder, int start, int end){
        if(start>=end){
            return true;
        }
        int mid=start;
        int root=postorder[end];
        //找到比root大的那个mid
        while(postorder[mid]<root){
            mid++;
        }
        int tmp=mid;
        while(tmp<end){
            if(postorder[tmp++]<root){
                return false;
            }
        }
        return helper(postorder,start,mid-1) && helper(postorder,mid,end-1);
    }
}




















