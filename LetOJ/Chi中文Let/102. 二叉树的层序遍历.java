
/*
 * 
link: https://leetcode-cn.com/problems/binary-tree-level-order-traversal/

102. 二叉树的层序遍历
难度
中等

1162

收藏

分享
切换为英文
接收动态
反馈
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

 

示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]
示例 2：

输入：root = [1]
输出：[[1]]
示例 3：

输入：root = []
输出：[]
 

提示：

树中节点数目在范围 [0, 2000] 内
-1000 <= Node.val <= 1000

2022-01-24 at 17:32
 

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //特殊case
       if(root==null) return new ArrayList<List<Integer>>();
       
       List<List<Integer>> result=new ArrayList<List<Integer>>();

       LinkedList<TreeNode> queue=new LinkedList();

       queue.add(root);
       queue.add(null);
       List<Integer> level=new ArrayList<Integer>();
       while(!queue.isEmpty()){
           TreeNode firstNode=queue.removeFirst();
           if(firstNode==null&&!queue.isEmpty()){
             queue.add(null);
             // 保存现在的level的list
             result.add(new ArrayList<Integer>(level));
             // 清空
             level=new ArrayList<Integer>();
           }

           if(firstNode!=null){
              level.add(firstNode.val);
              if(firstNode.left!=null){
                  queue.addLast(firstNode.left);
              }
              if(firstNode.right!=null){
                  queue.addLast(firstNode.right);
              }
           }
       }
       result.add(new ArrayList<Integer>(level));
       return result;
    }
}




















