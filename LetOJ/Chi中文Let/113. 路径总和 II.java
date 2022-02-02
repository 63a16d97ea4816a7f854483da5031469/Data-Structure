
/*
 * 
link: https://leetcode-cn.com/problems/path-sum-ii/

113. 路径总和 II
难度
中等

663

收藏

分享
切换为英文
接收动态
反馈
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

叶子节点 是指没有子节点的节点。

 

示例 1：


输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]
示例 2：


输入：root = [1,2,3], targetSum = 5
输出：[]
示例 3：

输入：root = [1,2], targetSum = 0
输出：[]
 

提示：

树中节点总数在范围 [0, 5000] 内
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000


2022-02-02 at 16:34
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

class Solution {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        findPath(root,new ArrayList(),targetSum);
        return result;
    }
    public void findPath(TreeNode root, List<Integer> list, int targetSum){
        if(root==null) return;
        list.add(root.val);
        if(root.left==null&&root.right==null){
            if(countSum(list)==targetSum){
                result.add(new ArrayList(list));
            }
            // 注意这里不能return
        }
        if(root.left!=null) findPath(root.left,list,targetSum);
        if(root.right!=null) findPath(root.right,list,targetSum);

        //注意这里一定要remove
        if(list.size()>0){
            list.remove(list.size()-1);
        }
    }
    public int countSum(List<Integer> list){
        int sum=0;
        for(int tmp:list){
            sum+=tmp;
        }
        return sum;
    }
}






















