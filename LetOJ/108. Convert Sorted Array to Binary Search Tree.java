
/*
 * 
 108. Convert Sorted Array to Binary Search Tree
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/


108. Convert Sorted Array to Binary Search Tree
Easy

1921

185

Add to List

Share
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

29 March 2020 at 1.06pm
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

//12.52pm - 1.05pm  (13m)

//使用递归方式重建，重要的是划分左右子树
class Solution {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
        //考虑数组为空的极限情况
        if(nums.length==0){
            return null;
        }
        
        int l=0;
        int r=nums.length;
        
        int mid=(l+r)/2;
        
        TreeNode root=new TreeNode(nums[mid]);
        
        root.left=buildBST(nums,0,mid-1);
        root.right=buildBST(nums,mid+1,nums.length-1);
        
        return root;
    }
    
    TreeNode buildBST(int[] nums, int l, int r){
         
        if(l>r){
            return null;
        }
        
        //在坐标上，捉摸了好半天
        int mid=(l+r+1)/2;
        
        TreeNode root=new TreeNode(nums[mid]);
        
        root.left=buildBST(nums,l,mid-1);
        root.right=buildBST(nums,mid+1,r);
        
        return root;
    }
}





















