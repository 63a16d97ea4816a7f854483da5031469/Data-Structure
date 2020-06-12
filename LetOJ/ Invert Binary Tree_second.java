
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


Invert Binary Tree

Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.

3 June 2020 at 12:30 am


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
    //12.27pm-12.29pm
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }
    
    public TreeNode invert(TreeNode root){
        if(root==null) return null;
        
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        
        if(root.left!=null) {
            invert(root.left);
        }
        if(root.right!=null){
            invert(root.right);
        }
        return root;
    }
}


















