
/*
 * 
link: https://leetcode-cn.com/problems/symmetric-tree/

101. 对称二叉树
难度
简单

1714

收藏

分享
切换为英文
接收动态
反馈
给你一个二叉树的根节点 root ， 检查它是否轴对称。

 

示例 1：


输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：


输入：root = [1,2,2,null,3,null,3]
输出：false
 

提示：

树中节点数目在范围 [1, 1000] 内
-100 <= Node.val <= 100
 

进阶：你可以运用递归和迭代两种方法解决这个问题吗？


2022-01-24 at 18:19
 

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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetricSub(root.left,root.right);
    }

    public boolean isSymmetricSub(TreeNode left,TreeNode right){
         if(left==null&&right==null) return true;
         if(left==null||right==null) return false;

         if(left.val!=right.val) return false;

         if(!isSymmetricSub(left.left,right.right)) return false;
         if(!isSymmetricSub(left.right, right.left)) return false;
         return true;
    }
}



class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSubSymm(root.left,root.right);
    }

    public boolean isSubSymm(TreeNode left, TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        return (left!=null&&right!=null&&left.val==right.val) && isSubSymm(left.left, right.right) && isSubSymm(left.right,right.left);
    }
}












