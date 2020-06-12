
/*
 * 
https://leetcode.com/problems/kth-smallest-element-in-a-bst/

230. Kth Smallest Element in a BST
Medium

1907

53

Add to List

Share
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?



28 March 2020 at 12:45 pm
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
    //使用递归回退方法 -- 走不通，因为递归回退方法在树下面不是线性回退的，有向right子树的回退和下一步


class Solution {
    //12.13pm - 12.45pm
    
     List<Integer> list=new ArrayList<Integer>();

    public int kthSmallest(TreeNode root, int k) {
        
        if(root==null) return -1;
        
        //考虑如果只有一个节点呢？
        if(root.left==null && root.right==null){
            return root.val;
        }
        
        inorder(root);
        
        return list.get(k-1);
    } 
    
    void inorder(TreeNode root){
        
        if(root==null) return;
        
        if(root.left!=null) {
            inorder(root.left);
        }
        
        list.add(root.val);
        
        if(root.right!=null){
            inorder(root.right);
        }
        
        
    }
}



















