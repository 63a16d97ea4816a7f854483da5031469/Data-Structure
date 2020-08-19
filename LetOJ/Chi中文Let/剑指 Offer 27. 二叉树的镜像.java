
/*
 * 
link: 
https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/

2020-8-19 at 9:06 pm


剑指 Offer 27. 二叉树的镜像
难度
简单

55

收藏

分享
切换为英文
关注
反馈
请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 

示例 1：

输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
 

限制：

0 <= 节点个数 <= 1000

注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/

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
    //9.01pm-9.05pm
    public TreeNode mirrorTree(TreeNode root) {
        swap(root);
        return root;
    }
    public void swap(TreeNode root){
        if(root==null) return;
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=right;
        root.right=left;

        if(root.left!=null){
            swap(root.left);
        }
        if(root.right!=null){
            swap(root.right);
        }
    }
}





















