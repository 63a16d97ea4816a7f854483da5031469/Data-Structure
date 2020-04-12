
/*
 * 
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3293/


  Diameter of Binary Tree
Solution
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

12 April 2020 at //10.07am-10.43am
 * 
 */



AC:

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
    //10.07am-10.43am
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        //对极限情况进行处理
        if(root==null) return 0;
        
        dfs(root);
        
        return max;
    }
    
    void dfs(TreeNode root){
        
        if(root==null) return;
 
          int left=0;  
          int right=0;  
            
            if(root.left!=null)
            left=findLength(root.left)+1;
            if(root.right!=null)
            right=findLength(root.right)+1;
            
              dfs(root.left);
              dfs(root.right);
      
        int curr= left+right;
        
        max=Math.max(max, curr);
        
        // return max;  
        
    }
    
    
    int findLength(TreeNode root){
        if(root==null) return 0;
  
        int leftMax=0;
        int rightMax=0;
    
            if(root.left!=null)
              leftMax=findLength(root.left)+1;
  
            if(root.right!=null)
             rightMax=findLength(root.right)+1;
       
        
        return Math.max(leftMax, rightMax);
        
    }
    
}















 一直写错：


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
    //10.07am-
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        //对极限情况进行处理
        if(root==null) return 0;
        
        dfs(root);
        
        return max;
    }
    
    void dfs(TreeNode root){
        
        // if(root==null) return 0;
 
          int left=0;  
              
                if(root.left!=null)
              left=findLength(root.left)+1;
        
   
          int right=0;  
              if(root.right!=null)
              right=findLength(root.right)+1;
        
        
        int curr= left+right;
        
        max=Math.max(max, curr);
        
        // return max;
        
    }
    
    
    int findLength(TreeNode root){
        if(root==null) return 0;
  
        int leftMax=0;
        int rightMax=0;
    
            if(root.left!=null)
              leftMax=findLength(root.left)+1;
  
            if(root.right!=null)
             rightMax=findLength(root.right)+1;
       
        
        return Math.max(leftMax, rightMax);
        
    }
    
}











