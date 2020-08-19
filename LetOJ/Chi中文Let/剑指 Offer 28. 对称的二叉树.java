
/*
 * 
link: 
https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/

2020-8-19 at 9:18 pm

剑指 Offer 28. 对称的二叉树
难度
简单

70

收藏

分享
切换为英文
关注
反馈
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3

 

示例 1：

输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：

输入：root = [1,2,2,null,3,null,3]
输出：false
 

限制：

0 <= 节点个数 <= 1000

注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/

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

    public boolean isSymmetric(TreeNode root) {
        return root==null?true:isSame(root.left,root.right);
    }
    public boolean isSame(TreeNode left,TreeNode right){
        if(left==null && right==null) return true;
        if(left==null||right==null||left.val!=right.val) return false;

        return isSame(left.left,right.right) && isSame(left.right,right.left);
    }
}



















/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//错误答案：
class Solution {
    //9.07pm-9.18
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;
        if(root.left==null||root.right==null) return false;
        if(!isSame(root.left,root.right)) return false;
        return isSame(root.left.left,root.right.right) && isSame(root.left.right, root.right.left);
    }
    public boolean isSame(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        if(left.val==right.val) return true;

        return false;
    }
}
