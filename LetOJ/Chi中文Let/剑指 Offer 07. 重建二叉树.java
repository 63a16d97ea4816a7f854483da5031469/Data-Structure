
/*
 * 
link: 
https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/

2020-8-24 at 11:03 am

剑指 Offer 07. 重建二叉树
难度
中等

182

收藏

分享
切换为英文
关注
反馈
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 

限制：

0 <= 节点个数 <= 5000



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




// 使用HashMap映射，快速加速寻找速度
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
    int point=0;
    HashMap<Integer, Integer> indexMap=new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0) return null;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < preorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return rebuildTree(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode rebuildTree(int[] preorder, int[] inorder,int instart, int inend){
        if(instart>inend) return null;
        TreeNode root=new TreeNode(preorder[point++]);
        int mid=indexMap.get(root.val)==null?-1:indexMap.get(root.val);
        root.left=rebuildTree(preorder,inorder,instart,mid-1);
        root.right=rebuildTree(preorder,inorder,mid+1,inend);

        return root;
    }
}













