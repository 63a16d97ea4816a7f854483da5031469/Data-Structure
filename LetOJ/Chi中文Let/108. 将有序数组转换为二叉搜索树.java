
/*
 * 
link: https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/

108. 将有序数组转换为二叉搜索树
难度
简单

925

收藏

分享
切换为英文
接收动态
反馈
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

 

示例 1：


输入：nums = [-10,-3,0,5,9]
输出：[0,-3,9,-10,null,5]
解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：

示例 2：


输入：nums = [1,3]
输出：[3,1]
解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
 

提示：

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 按 严格递增 顺序排列


2022-01-28 at 15:57
 


刚看到想到的思路是什么？：

就是以递归形式，继续这种装配过程。 这是有一个固定模式的装配.


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        TreeNode root=buildTree(nums,0,nums.length-1);
        return root;
    }
    public TreeNode buildTree(int[] nums, int start, int end){
 
        if(start>=0&&start<=end&&end<nums.length){
     
            int middle=start+(end-start)/2;
            TreeNode root=new TreeNode(nums[middle]);
            root.left=buildTree(nums,start,middle-1);
            root.right=buildTree(nums,middle+1,end);
            return root;
        }else{
            return null;
        }
    }
}




















