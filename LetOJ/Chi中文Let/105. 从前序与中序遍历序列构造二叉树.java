
/*
 * 
link: 
https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

2020-8-24 at 9:27 am

105. 从前序与中序遍历序列构造二叉树
难度
中等

637


根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

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
    //9.21am-9.26am
    int point=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0) return null;
        return rebuildTree(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode rebuildTree(int[] preorder, int[] inorder,int instart, int inend){
        if(preorder==null||preorder.length==0) return null;
        if(instart>inend) return null;

        TreeNode root=new TreeNode(preorder[point++]);
        int mid=findMid(inorder,root.val);
        root.left=rebuildTree(preorder,inorder,instart,mid-1);
        root.right=rebuildTree(preorder,inorder,mid+1,inend);

        return root;
    }
    public int findMid(int[] inorder, int target){
        for(int i=0;i<inorder.length;i++){
            if(target==inorder[i]){
                return i;
            }
        }
        return -1;
    }
}



















