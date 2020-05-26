
/*
 * 
https://leetcode.com/problems/average-of-levels-in-binary-tree/


637. Average of Levels in Binary Tree
Easy

1159

162

Add to List

Share
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:

Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:

The range of node's value is in the range of 32-bit signed integer.

26 May 2020 at 10:56 pm


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
    //10.36pm-10.54pm 18minutes AC.
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list=new ArrayList<Double>();
        if(root==null){
            list.add(Double.valueOf(0));
            return list;
        } 
        Queue<TreeNode> que=new LinkedList<TreeNode>();
        que.add(root);
        que.add(null);
        double sum=0;
        double count=0;

        while(!que.isEmpty()){
            TreeNode node=que.poll();
            if(node==null){
                if(!que.isEmpty()){
                    que.add(null);
                }
                    list.add((Double)(sum/count));
                   sum=0;
                    count=0;
            }else{
                sum+=node.val;
                count++;
                if(node.left!=null){
                    que.add(node.left);
                }
                if(node.right!=null){
                    que.add(node.right);
                }
            }
        }
        return list;
    }
}


















