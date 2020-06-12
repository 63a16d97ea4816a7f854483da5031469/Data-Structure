
/*
 * 
https://leetcode.com/problems/binary-tree-maximum-path-sum/


Binary Tree Maximum Path Sum
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

30 April 2020 at 7:40 pm


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
   
    public int maxPathSum(TreeNode root) {
    int[] max = new int[1];
    max[0] = Integer.MIN_VALUE;
    findmax(root,max);
    return max[0];
    }

    public int findmax(TreeNode root, int[] max){
        if(root==null)
            return 0;

        int left = findmax(root.left,max);
        int right = findmax(root.right,max);

        int ans = Math.max(root.val,Math.max(root.val+left, root.val+right));

        max[0] = Math.max(max[0],Math.max(ans,root.val+left+right));

        return ans;

    }
    
}








Input
[-10,9,20,null,null,15,7]
Output
50
Expected
42

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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0]=Integer.MIN_VALUE;
        getSum(root,max);
        
        return max[0];
    }
    
 
    
    int getSum(TreeNode root, int[] max){
        
        if(root==null) return 0;
        int rootVal=root.val;
        
         int left = getSum(root.left,max);
         int right = getSum(root.right,max);
        
        int ans = Math.max(root.val,Math.max(root.val+left, root.val+right));
        max[0] = Math.max(max[0],Math.max(ans,root.val+left+right));
        
        return max[0];
    }
    
    
}




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
    int sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        getSum(root,sum);
        
        return sum;
    }
    
 
    
    int getSum(TreeNode root, int max){
        
        if(root==null) return 0;
        int rootVal=root.val;
        
         int left = getSum(root.left,max);
         int right = getSum(root.right,max);
        
        int ans = Math.max(root.val,Math.max(root.val+left, root.val+right));
        sum = Math.max(sum,Math.max(ans,root.val+left+right));
        
        return sum;
    }
    
    
}




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
    int sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        
        return sum;
    }
    
    void dfs(TreeNode root){
        if(root==null) return;
        getSum(root);
        
        getSum(root.left);
        getSum(root.right);
    }
    
    int getSum(TreeNode root){
        
        if(root==null) return 0;
        int rootVal=root.val;
        
        int left=getSum(root.left);
        int right=getSum(root.right);
        
        if(left+right+rootVal>sum){
            sum=left+right+rootVal;
        }
        return left+right+rootVal;
    }
    
    
}




