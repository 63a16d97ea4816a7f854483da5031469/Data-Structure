
/*
 * 
link: 
https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/

2020-7-19 at 4:02 pm

103. 二叉树的锯齿形层次遍历
难度
中等

221

收藏

分享
切换为英文
关注
反馈
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


//最快实现：
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> res = new ArrayList<>();
       traversal(root, res, 0);
       return res;
   }

   private void traversal(TreeNode root, List<List<Integer>> res, int level) {
       if (root == null) {
           return;
       }

       if (res.size() == level) {
           res.add(new ArrayList<Integer>());
       }

       if ((level & 1) == 1){
           res.get(level).add(0, root.val);
       } else {
           res.get(level).add(root.val);
       }

       traversal(root.left, res, level + 1);
       traversal(root.right, res, level + 1);
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
class Solution {
    //3.43pm-4.00pm
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<List<Integer>>(); // []
        Queue<TreeNode> que=new LinkedList<TreeNode>();
        que.add(root);
        que.add(new TreeNode(999));
        List<Integer> list=new ArrayList<Integer>();
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        while(!que.isEmpty()){
            TreeNode node=que.poll();
            if(node!=null&&node.val==999){
                if(!que.isEmpty()){
                    que.add(new TreeNode(999));
                    ans.add(new ArrayList<Integer>(list));
                    list=new ArrayList<Integer>();
                }
            }else if(node!=null){
                list.add(node.val);
                if(node.left!=null){
                    que.add(node.left);
                }
                if(node.right!=null){
                    que.add(node.right);
                }
            }
        }
        ans.add(new ArrayList<Integer>(list));
        for(int i=0;i<ans.size();i++){
            if(i%2==1){
                reverse(ans.get(i));
            }
        }
        return ans;
    }
    public void reverse(List<Integer> list){
        for(int i=0;i<list.size()/2;i++){
            int tmp=list.get(i);
            list.set(i,list.get(list.size()-1-i));
            list.set(list.size()-1-i,tmp);
        }
    }
}



















