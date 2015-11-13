package ok;

import java.util.ArrayList;

/*
 * https://leetcode.com/problems/same-tree/
 * 
Given two binary trees, write a function to check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
	public class Solution {
	    public boolean isSameTree(TreeNode p, TreeNode q) {
	        
	    }
	}
*/

/*
 * test cases:
 * 
 * []
 * [0]
 * 
 * [1,2]
 * [1,null,2]
 * 
 * 
 *    1
 *   /
 *  2
 * 
 *    1
 *     \
 *      2
 * 
 * 
 * 28 October 2015 at 12:30:05 pm
 */

public class SameTree {

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		TreeNode root2 = new TreeNode(1);
		root2.right = new TreeNode(2);
		System.out.println(isSameTree(root, root2));
	}

	/*
	 * 
	 * Accepted:
	 * 
	 * 
	 * 
	 */

	public static boolean isSameTree(TreeNode p, TreeNode q) {

		ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> list2 = new ArrayList<TreeNode>();
		getListFromTree(p, list1);
		getListFromTree(q, list2);

		if (list1.size() != list2.size())
			return false; // need to consider the length is different case.

		for (int i = 0; i < list1.size(); i++) {
			// Compare the value
			if (list1.get(i) != null && (list2.get(i) != null) && list1.get(i).val != list2.get(i).val)
				return false;

			// Compare the structure ---> use the null to distinguish differences.
			if ((list1.get(i) == null && list2.get(i) != null) || (list1.get(i) != null && list2.get(i) == null))
				return false;
		}

		return true;
	}

	public static void getListFromTree(TreeNode tree, ArrayList list) {

		if (tree == null)
			return;

		list.add(tree); // Do not forget the root element

		if (tree.left != null) {
			getListFromTree(tree.left, list);
			list.add(tree.left);
		} else {
			list.add(tree.left); // Do not forget null---> distinguish the
									// structure
		}

		/*
		 * In order to make the logic clear to read, keep the above code
		 * 
		 * Actually, it can be replaced below:
		 * 
		 * if(tree.left!=null) getListFromTree(tree.left,list);
		 * list.add(tree.left);
		 * 
		 * 
		 */

		if (tree.right != null) {
			getListFromTree(tree.right, list);
			list.add(tree.right);
		} else {
			list.add(tree.right); // Do not forget null---> distinguish the
									// structure
		}

		/*
		 * In order to make the logic clear to read, keep the above code
		 * 
		 * Actually, it can be replaced below:
		 * 
		 * if(tree.right!=null) getListFromTree(tree.right,list);
		 * list.add(tree.right);
		 * 
		 * 
		 */

	}

}
