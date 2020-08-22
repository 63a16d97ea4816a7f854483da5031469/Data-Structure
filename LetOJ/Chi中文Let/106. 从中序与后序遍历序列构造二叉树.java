
/*
 * 
link: 
https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

2020-7-1 at 8:33 pm


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
    //9.01pm-9.09
    int head=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        head=postorder.length-1;
        return helper(inorder,postorder,0,inorder.length-1);
    }

    public TreeNode helper(int[]inorder,int[] postorder,int instart,int inend){
        if(instart>inend) return null;

        TreeNode root=new TreeNode(postorder[head--]);
        int mid=findValue(inorder,root.val);
        root.right=helper(inorder,postorder,mid+1,inend);
        root.left=helper(inorder,postorder,instart,mid-1);
        return root;
    }
    public int findValue(int[] inorder, int target){
        for(int i=0;i<inorder.length;i++){
            if(target==inorder[i]) return i;
        }
        return 0;
    }
}
















