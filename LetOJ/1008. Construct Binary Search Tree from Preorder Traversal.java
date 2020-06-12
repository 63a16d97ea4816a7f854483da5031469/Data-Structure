
/*
 * 
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

1008. Construct Binary Search Tree from Preorder Traversal
Medium

873

30

Add to List

Share
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

 

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

 

Note: 

1 <= preorder.length <= 100
The values of preorder are distinct.
12 April 2020 at 11.34pm-11.49pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :
递归解决这类问题，关键是，找到root，左子树，右子树的区间，并合理组织递归

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
    //11.34pm-11.49pm
    public TreeNode bstFromPreorder(int[] preorder) {
        
        return buildTree(preorder, 0, preorder.length-1);
    }
    
    public TreeNode buildTree(int[] preorder, int start, int end){
        
        //越界控制
        if(start>end){
            return null;
        }
        
        //第一个是根节点
        TreeNode root=new TreeNode(preorder[start]);
        //从根节点下一个开始
        int i=start+1; 
        
        while(i<=end && preorder[i]<=root.val){
            i++;
        }
        
        root.left=buildTree(preorder, start+1, i-1);
        root.right=buildTree(preorder, i, end);
        
        return root;
    }
}


















