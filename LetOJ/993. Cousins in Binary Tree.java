
/*
 * 
https://leetcode.com/problems/cousins-in-binary-tree/

993. Cousins in Binary Tree
Easy

585

33

Add to List

Share
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.

7 May 2020 at 8:54 pm


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
	//8.54pm-9.14pm
	public boolean isCousins(TreeNode root, int x, int y) {
		if (root == null) return false;
		if (root.left == null && root.right == null) return false;
		List<TreeNode> xPath = new ArrayList<TreeNode> ();
		findPath(root, xPath, x);
		List<TreeNode> yPath = new ArrayList<TreeNode> ();
		findPath(root, yPath, y);
		for (TreeNode tmp: xPath) {
			System.out.println(tmp.val);
		}
		if (xPath.size() != yPath.size()) return false;
		if (xPath.size() >= 2) {
			return xPath.get(xPath.size() - 2).val == yPath.get(yPath.size() - 2).val ? false : true;
		}
		return false;
	}
	boolean findPath(TreeNode root, List<TreeNode> list, int val) {
		if (root == null) return false;
		list.add(root);
		if (root.val == val) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return false;
		}
		//if left cannot find then go to right
		if (root.left != null) {   //需要放这个判断，否则后面remove那个最后一个的时候，会出现路径问题
			if (findPath(root.left, list, val)) {
				return true;
			} else {
				list.remove(list.size() - 1);
			}
		}
		if (root.right != null) { //需要放这个判断，否则后面remove那个最后一个的时候，会出现路径问题
			if (findPath(root.right, list, val)) {
				return true;
			} else {
				list.remove(list.size() - 1);
			}
		}
		return false;
	}
}








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
    //9.51pm-10.04pm
    TreeNode xRoot=null, yRoot=null;
    int xlevel=-1, ylevel=-2;
	public boolean isCousins(TreeNode root, int x, int y) {
		if (root == null) return false;
		if (root.left == null && root.right == null) return false;
        xRoot=root;
        yRoot=root;
        dfs(root, 0, x, y,root);
		return (xRoot.val!=yRoot.val&&xlevel==ylevel)?true:false;
	}
	void dfs(TreeNode root, int level, int x, int y, TreeNode parent) {
		if (root == null) return;
		if (root.val == x) {
            xRoot=parent;
            xlevel=level;
		}
        
        if (root.val == y) {
            yRoot=parent;
            ylevel=level;
		}
        
		if (root.left == null && root.right == null) {
			return;
		}
		dfs(root.left,level+1,x,y,root);
        dfs(root.right,level+1,x,y,root);
	}
}











