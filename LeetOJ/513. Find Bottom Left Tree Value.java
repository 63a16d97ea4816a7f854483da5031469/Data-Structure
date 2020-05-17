
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


513. Find Bottom Left Tree Value
Medium

813

130

Add to List

Share
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:

Input:

    2
   / \
  1   3

Output:
1
Example 2: 

Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.

12 April 2020 at 8:33: pm


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
    //11.21pm- 11.36pm AC
    int maxLevel=0;
    TreeNode node=null;
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return 0;
        dfs(root, 0);
        if(node==null){
            return root.val;
        }
        return node.val;
    }
    
    public void dfs(TreeNode root, int level){
        if(root==null) return;
        if(maxLevel<level){
            maxLevel=level;
            node=root;
        }
        
        dfs(root.left, level+1);
        dfs(root.right, level+1);
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
    
    int left = -1, height = 0;
    
    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            return -1;
        helper(root, 1);
        return left;
    }
    
    public void helper(TreeNode root, int depth) {
        if (height < depth) {
            left = root.val;
            height = depth;
        }
        
        if (root.left != null) 
            helper(root.left, depth +1);
        if (root.right !=  null)
            helper(root.right, depth +1);
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(q.size() > 0) {
            root = q.poll();
            if (root.right != null) {
                q.offer(root.right);
            }
            if (root.left != null) {
                q.offer(root.left);
            }
        }
        return root.val;
    }
    
}






