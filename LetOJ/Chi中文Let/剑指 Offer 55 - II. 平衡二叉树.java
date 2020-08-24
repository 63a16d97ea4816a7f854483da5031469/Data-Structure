
/*
 * 
link: 
https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/

2020-8-24 at 3:35 pm

剑指 Offer 55 - II. 平衡二叉树
难度
简单

57

收藏

分享
切换为英文
关注
反馈
输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

 

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。

 

限制：

1 <= 树的结点个数 <= 10000
注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/

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
    //3.03pm-3.34pm
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return isbalancedTree(root);
    }
    public boolean isbalancedTree(TreeNode root){
        if(root==null) return true;
        boolean isTrue=(Math.abs(findDepth(root.left,0)-findDepth(root.right,0)))<=1;
        return isTrue && isbalancedTree(root.left) && isbalancedTree(root.right);
    }
    public int findDepth(TreeNode root,int depth){
        if(root==null) return depth;  // very important.
        int left=0;
        left=findDepth(root.left,depth+1);
        int right=0;
        right=findDepth(root.right,depth+1);
        return Math.max(left,right);
    }
}







class Solution {
    public boolean isBalanced(TreeNode root) {
        return depth(root)!=-1;
    }
    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=depth(root.left);
        if(left==-1){
            return -1;
        }
        int right=depth(root.right);
        if(right==-1){
            return -1;
        }
        //不在1的差距内
        if(left-right>1||left-right<-1){
            return -1;
        }else{
            //在1的差距内，如实返回最大深度
            return 1+(left>right?left:right);
        }
    }
}











