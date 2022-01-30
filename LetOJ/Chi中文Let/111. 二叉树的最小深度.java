
/*
 * 
link: https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/

111. 二叉树的最小深度
难度
简单

656

收藏

分享
切换为英文
接收动态
反馈
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明：叶子节点是指没有子节点的节点。

 

示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：2
示例 2：

输入：root = [2,null,3,null,4,null,5,null,6]
输出：5
 

提示：

树中节点数的范围在 [0, 105] 内
-1000 <= Node.val <= 1000



2022-01-24 at 18:26
 

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
    int minDepth=9999;
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        dfs(root,1);
        return minDepth;
    }
    public void dfs(TreeNode root,int depth){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            //已经到根部
            minDepth=Math.min(minDepth,depth);
        }
        depth++;
        if(root.left!=null) dfs(root.left,depth);
        if(root.right!=null) dfs(root.right,depth);
    }
}




class Solution {
    int min=9999;
    List<TreeNode> path=new ArrayList<TreeNode>();
    public int minDepth(TreeNode root) {
        //特殊情况处理
        if(root==null) return 0;
        
        preOrder(root);
        return min;
    }

    public void preOrder(TreeNode root){
        if(root==null) return;
        path.add(root);
        if(root.left==null&&root.right==null){
            min=Math.min(min,path.size());
        }
        if(root.left!=null) preOrder(root.left);
        if(root.right!=null) preOrder(root.right);
        path.remove(path.size()-1);
    }
}














