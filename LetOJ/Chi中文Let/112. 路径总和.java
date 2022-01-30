
/*
 * 
link: https://leetcode-cn.com/problems/path-sum/


112. 路径总和
难度
简单

774

收藏

分享
切换为英文
接收动态
反馈
给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。

叶子节点 是指没有子节点的节点。

 

示例 1：


输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
输出：true
解释：等于目标和的根节点到叶节点路径如上图所示。
示例 2：


输入：root = [1,2,3], targetSum = 5
输出：false
解释：树中存在两条根节点到叶子节点的路径：
(1 --> 2): 和为 3
(1 --> 3): 和为 4
不存在 sum = 5 的根节点到叶子节点的路径。
示例 3：

输入：root = [], targetSum = 0
输出：false
解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 

提示：

树中节点的数目在范围 [0, 5000] 内
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000



2022-01-30 at 17:33
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    boolean isTrue=false;
    List<TreeNode> path=new ArrayList<TreeNode>();
    public boolean hasPathSum(TreeNode root, int targetSum) {
        preOrder(root,targetSum);
        return isTrue;
    }
    public void preOrder(TreeNode root,int targetSum){
        if(root==null) return;
        path.add(root);
        if(root.left==null&&root.right==null){
            int sum=0;
            for(TreeNode tmp:path){
                sum+=tmp.val;
            }
            if(sum==targetSum) isTrue=true;
        }
        if(root.left!=null) preOrder(root.left,targetSum);
        if(root.right!=null) preOrder(root.right,targetSum);
        path.remove(path.size()-1);
    }
}




















