
/*
 * 
link: 
https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/

2020-8-19 at 10:56 pm

剑指 Offer 34. 二叉树中和为某一值的路径
难度
中等

70

收藏

分享
切换为英文
关注
反馈
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

 

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
 

提示：

节点总数 <= 10000
注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/

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
    //10.39pm-10.54pm
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        findPath(root,sum,0, new ArrayList<Integer>());
        return result;
    }
    public void findPath(TreeNode root, int sum, int currsum, List<Integer> list){
        // if(Math.abs(currsum)>sum) {
        //     list=new ArrayList<Integer>();
        //     return;
        // }
        if(root==null) return;
        currsum+=root.val;
        list.add(root.val);
        //must be leaf node
        if(sum==currsum&&root.left==null&&root.right==null){
            result.add(new ArrayList<Integer>(list));
            list=new ArrayList<Integer>();
            return;
        }
        if(root.left!=null){
            findPath(root.left,sum,currsum,list);
            if(list.size()>0)
            list.remove(list.size()-1);
        }
        if(root.right!=null){
            findPath(root.right,sum,currsum,list);
            if(list.size()>0)
            list.remove(list.size()-1);
        }
    }
}




















