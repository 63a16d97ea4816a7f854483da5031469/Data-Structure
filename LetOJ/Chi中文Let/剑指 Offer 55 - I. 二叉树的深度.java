
/*
 * 
link: 
https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/

2020-8-6 at 10:48 pm

剑指 Offer 55 - I. 二叉树的深度
难度
简单

34





输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：

给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。

 

提示：

节点总数 <= 10000


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
    //10.48pm-11.07pm
    int max=0;
    public int maxDepth(TreeNode root) {
       if(root==null) return 0;
       if(root.left==null&&root.right==null) return 1;
       max=Math.max(dfs(root.left,2),dfs(root.right,2));
       return max;
    }
    public int dfs(TreeNode root,int depth){

          if(root==null) {
            return depth-1;
          }
          int left=0,right=0;
       
            left=dfs(root.left,depth+1);
            right=dfs(root.right,depth+1);
        
          return Math.max(left,right);
    }
}






















