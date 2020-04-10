
/*
 * 
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

106. Construct Binary Tree from Inorder and Postorder Traversal
Medium

1351

29

Add to List

Share
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

10 April 2020 at 8.04pm
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
    
    
    HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
    int[] postOrderArr;
    
    int postOrderIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex=postorder.length-1;
        
        postOrderArr=postorder;
        //存起来，比较好找索引位置
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
       return createTree(0, inorder.length-1);
    }
    
    TreeNode createTree(int start, int end){
        
        if(start>end || postOrderIndex<0) return null;
        
         // pick up post_idx element as a root
        int root_val = postOrderArr[postOrderIndex];
        TreeNode root = new TreeNode(root_val);

         
        int index=map.get(root.val);
        
        postOrderIndex--;
        
        //这个顺序很重要，不能反序 - Right子树先，Left子树后
        root.right=createTree(index+1, end);
        root.left=createTree(start, index-1);

        
        return root;
    }
    
    
    
}


















