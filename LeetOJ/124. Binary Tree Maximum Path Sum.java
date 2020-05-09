
/*
 * 
https://leetcode.com/problems/binary-tree-maximum-path-sum/

124. Binary Tree Maximum Path Sum
Hard

3231

261

Add to List

Share
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


// 计算二叉树中的路径之和最大值，起止节点为任意（此题和求二叉树的直径差不多，参考）

// 543. Diameter of Binary Tree Java版 (二叉树的最大直径） 


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
    private int maxVal = Integer.MIN_VALUE;
 
	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		maxCore(root);
		return maxVal;
	}
 
	// 该函数返回是左右的最大路径和，而非左+右+root的最大值
	// 使用curValue，来标记左+右+root
	private int maxCore(TreeNode root) {
		if (root == null)
			return 0;
		// 求以root为根的当前子树的最大路径和
		// 如果左右子树都是负数，
		// 那么就最大路径就是当前结点值（无论正负）
		int curValue = root.val;
		int lmax = maxCore(root.left);
		int rmax = maxCore(root.right);
		if (lmax > 0)
			curValue += lmax;
		if (rmax > 0)
			curValue += rmax;
		maxVal = Math.max(curValue, maxVal);
		// 返回以当前root为根的子树的最大路径和
		// 左右有可能都为负数，所以需要参与比较大小
		int thisMax = Math.max(root.val, 
				Math.max(lmax + root.val, 
						rmax + root.val));
		return thisMax;
	}
}













