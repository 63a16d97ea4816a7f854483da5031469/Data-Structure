
/*
 * 
link: https://leetcode-cn.com/problems/invert-binary-tree/

226. 翻转二叉树
难度
简单

1146

收藏

分享
切换为英文
接收动态
反馈
翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
备注:
这个问题是受到 Max Howell 的 原问题 启发的 ：

谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。



2022-01-24 at 19:21
 

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
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        reverseTree(root);
        return root;
    }
    public void reverseTree(TreeNode root){
        if(root==null) return;
        if(root.left==null&&root.right==null) return;
        // 翻转
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        if(root.left!=null) reverseTree(root.left);
        if(root.right!=null) reverseTree(root.right);
    }
}
















