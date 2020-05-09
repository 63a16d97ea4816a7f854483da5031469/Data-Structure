
/*
 * 
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

105. Construct Binary Tree from Preorder and Inorder Traversal
Medium

2779

79

Add to List

Share
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

10 April 2020 at 8.16pm
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
    
    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    int[] preorder;
    int startIndex=0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return createTree(0,inorder.length-1);
    }
    
    TreeNode createTree(int start, int end){
        
        if(start>end) return null;
        
        int value=preorder[startIndex];
        
        TreeNode root=new TreeNode(value);
        
        int index= map.get(root.val);
        
        
        startIndex++;
        
        //顺序很重要，不能颠倒，必须左子树，因为先序遍历 的下一个root是左子树的root，如果颠倒，startIndex的下一个会被分配给错误的子树。
        root.left=createTree(start, index-1);
        root.right=createTree(index+1, end);
        
        return root;
    }
}









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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return helper (0, 0, inorder.length - 1,  preorder, inorder);
    }
    
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        
        //base condition
        if (preStart > preorder.length - 1 || inStart > inEnd) 
            return null;
        
        //get the root node with curr preorder element
        TreeNode root = new TreeNode(preorder[preStart]);
        
        //get inIndex; finding preorder's element's index in inorder
        int inIndex = 0;
        
        for (int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == root.val) {
                inIndex = i; 
            }
        }
        //(next, left of inIndex is the end for left subtree)
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        //(prestart + length of left subtree + 1)
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        
        return root;
    }
    //T O(n) S O(n)
}















