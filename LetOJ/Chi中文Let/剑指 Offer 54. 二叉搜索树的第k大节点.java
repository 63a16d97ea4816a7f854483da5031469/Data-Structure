
/*
 * 
link: 
https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/

2020-9-9 at 9:03 pm

剑指 Offer 54. 二叉搜索树的第k大节点
难度
简单

60

收藏

分享
切换为英文
关注
反馈
给定一棵二叉搜索树，请找出其中第k大的节点。

 

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4
 

限制：

1 ≤ k ≤ 二叉搜索树元素个数

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //8.59pm-9.02pm
    List<Integer> list=new ArrayList<Integer>();
    public int kthLargest(TreeNode root, int k) {
        inorder(root);
        return list.get(list.size()-k);
    }

    public void inorder(TreeNode root){
        if(root==null) return;
        if(root.left!=null) inorder(root.left);
        list.add(root.val);
        if(root.right!=null) inorder(root.right);
    }

}




















