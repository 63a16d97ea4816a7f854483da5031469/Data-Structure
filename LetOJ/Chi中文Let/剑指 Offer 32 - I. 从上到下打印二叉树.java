
/*
 * 
link: 
https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/

2020-8-19 at 10:32 pm

剑指 Offer 32 - I. 从上到下打印二叉树
难度
中等

33

收藏

分享
切换为英文
关注
反馈
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

 

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回：

[3,9,20,15,7]
 

提示：

节点总数 <= 1000


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


















