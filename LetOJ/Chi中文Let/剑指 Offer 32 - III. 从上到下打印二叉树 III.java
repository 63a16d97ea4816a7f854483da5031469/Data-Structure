
/*
 * 
link: 
https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/

2020-8-24 at 12:37 pm

剑指 Offer 32 - III. 从上到下打印二叉树 III
难度
中等

39

收藏

分享
切换为英文
关注
反馈
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

 

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [20,9],
  [15,7]
]
 

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
    //12.29pm-12.36pm
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(root==null) return ans;
        Queue<TreeNode>  que=new LinkedList<TreeNode>();
        que.add(root);
        que.add(null);
        List<Integer> list=new ArrayList<Integer>();
        while(!que.isEmpty()){
            TreeNode element=que.poll();
            if(element==null){
                if(!que.isEmpty()){
                    que.add(null);
                    ans.add(new ArrayList<Integer>(list));
                    list=new ArrayList<Integer>();
                }else{
                    ans.add(new ArrayList<Integer>(list));
                }
            }else{
                list.add(element.val);
                if(element.left!=null){
                    que.add(element.left);
                }
                if(element.right!=null){
                    que.add(element.right);
                }
            }
        }
        for(int i=0;i<ans.size();i++){
            if(i%2==1){
                reorder(ans.get(i));
            }
        }
        return ans;
    }
    public void reorder(List<Integer> list){
        for(int i=0;i<list.size()/2;i++){
            int tmp=list.get(i);
            list.set(i,list.get(list.size()-1-i));
            list.set(list.size()-1-i,tmp);
        }
    }
}


















