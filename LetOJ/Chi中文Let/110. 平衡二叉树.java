
/*
 * 
link: https://leetcode-cn.com/problems/balanced-binary-tree/

110. 平衡二叉树
难度
简单

874

收藏

分享
切换为英文
接收动态
反馈
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

 

示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：true
示例 2：


输入：root = [1,2,2,3,3,null,null,4,4]
输出：false
示例 3：

输入：root = []
输出：true
 

提示：

树中的节点数在范围 [0, 5000] 内
-104 <= Node.val <= 104


2022-01-30 at 20:04
 

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    boolean isBalanced=true;
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        preOrder(root);
        return isBalanced;
    }

    // 遍历所有节点
    public void preOrder(TreeNode root){
        if(root==null) return;
        if(!isBalancedSub(root)){
            isBalanced=false;
            return;
        }
        if(root.left!=null) preOrder(root.left);
        if(root.right!=null) preOrder(root.right);
    }
    
    //判断左右子树高度差是否为1
    public boolean isBalancedSub(TreeNode root){
        if(root==null) return true;
        int l=0,r=0;
        if(root.left==null&&root.right==null){
            return true;
        }
        if(root.left!=null) {
            l=getHeight(root.left);
        }
        if(root.right!=null){
            r=getHeight(root.right);
        }
        return Math.abs(r-l)<=1;
    }

    //获得当前节点的高度
    public int getHeight(TreeNode root){
        LinkedList<TreeNode> que=new LinkedList<TreeNode>();
        que.add(root);
        que.add(null);
        int height=0;
        while(!que.isEmpty()){
            TreeNode head=que.removeFirst();
            if(head==null){
                height++;
            }
            if(head==null&&!que.isEmpty()){
                que.add(null);
            }
            if(head!=null){
                if(head.left!=null) que.add(head.left);
                if(head.right!=null) que.add(head.right);
            }
        }
        return height;
    }
 
}




















