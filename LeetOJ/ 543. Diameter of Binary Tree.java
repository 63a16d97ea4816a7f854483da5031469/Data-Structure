
/*
 * 

 543. Diameter of Binary Tree

https://leetcode.com/problems/diameter-of-binary-tree/


Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 

          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
    }
}

27 March 2020 at 8:33:31 pm
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
    int max=Integer.MIN_VALUE;
    //10.41pm
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root==null) return 0;
        
        if(root.left==null && root.right ==null){
            return 0;
        }
        
       dfs(root);
        
        return max;
    }
    
    void dfs(TreeNode root){
        if(root==null) return;
           findMaxLeftPlusRight(root);
        
        if(root.left!=null)
           dfs(root.left);
 
        if(root.right!=null)
           dfs(root.right);
    }
    
    void findMaxLeftPlusRight(TreeNode root){
        
        if(root==null) return;
        
       int left=maxlength(root.left);
       int right=maxlength(root.right);
        
        max=max>(left+right)?max:(left+right);
    }
    
    int maxlength (TreeNode root){
        
        if(root==null) return 0;
        
        if(root.left==null && root.right ==null){
            return 1;
        }
         
        return Math.max(1+maxlength(root.left),1+maxlength(root.right));
    }
    
}




















