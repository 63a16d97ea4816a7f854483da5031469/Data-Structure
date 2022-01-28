
/*
 * 
link: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/

104. 二叉树的最大深度
难度
简单

1098

给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。


2022-01-17 at 19:04
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    List<TreeNode> path=new ArrayList<TreeNode>();
    int max=0;
    public int maxDepth(TreeNode root) {
        preOrder(root);
        return max;
    }
    public void preOrder(TreeNode root){
        if(root==null) return;
        path.add(root);
        //到path最底部了
        if(root.left==null&&root.right==null){
            max=Math.max(max,path.size());
        }
        if(root.left!=null) preOrder(root.left);
        if(root.right!=null) preOrder(root.right);
        path.remove(path.size()-1);
    }
}




















