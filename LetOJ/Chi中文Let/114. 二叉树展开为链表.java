
/*
 * 
link: https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/

114. 二叉树展开为链表
难度
中等

1045

收藏

分享
切换为英文
接收动态
反馈
给你二叉树的根结点 root ，请你将它展开为一个单链表：

展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。
 

示例 1：


输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [0]
输出：[0]
 

提示：

树中结点数在范围 [0, 2000] 内
-100 <= Node.val <= 100
 

进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？


2022-01-25 at 21:53
 

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



有问题：(不可以赋值回之前的变量节点root):

class Solution {
    List<Integer> list=new ArrayList<Integer>();
    TreeNode newHead=null;
    TreeNode lastNode=null;
    public void flatten(TreeNode root) {
        preOrder(root);
        buildTree();
    }

    public void buildTree(){
        for(int tmp:list){
            if(newHead==null&&lastNode==null){
                newHead=new TreeNode(tmp);
                lastNode=newHead;
            }else if(lastNode!=null){
                lastNode.right=new TreeNode(tmp);
            }
        }
    }

    public void preOrder(TreeNode root){
        if(root==null) return;
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

}



通过:
class Solution {
    List<TreeNode> list=new ArrayList<TreeNode>();
    public void flatten(TreeNode root) {
        preOrder(root);
        for(int i=0;i<=list.size()-2;i++){
            TreeNode curr=list.get(i);
            TreeNode currNext=list.get(i+1);
            curr.left=null;
            curr.right=currNext;
        }
    }
 
    public void preOrder(TreeNode root){
        if(root==null) return;
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }

}














