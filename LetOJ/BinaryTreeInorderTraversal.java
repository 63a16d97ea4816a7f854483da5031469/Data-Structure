package ok;

/*
https://leetcode.com/problems/binary-tree-inorder-traversal/

Given a binary tree, return the inOrder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
    }
}

9 November 2015 at 5:01:46 pm

 * 
 */


	/*
	 *          1
	 *         / \
	 * 		  2   6
	 *       / \
	 * 	    9   3
	 */

import java.util.*;

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//	}
//}


/*
 * 这个是一个必须记住的，保证熟练在1-3分钟内写出来的算法。
 * 包括 使用 递归 和 不使用递归的两种算法。必须烂熟于心。
 * 
 */


public class BinaryTreeInorderTraversal {
	
	List<Integer> list=new ArrayList<Integer>();
	
	public static void main(String args[]) {
		
		
//		TreeNode root=new TreeNode(1);
//		TreeNode secLeft=new TreeNode(2);
//		TreeNode secRight=new TreeNode(6);
//		TreeNode thirdRight=new TreeNode(3);
//		TreeNode thirdLeft=new TreeNode(9);
//		
//		root.left=secLeft;
//		root.right=secRight;
//		
//		secLeft.left=thirdLeft;
//		secLeft.right=thirdRight;
		
		
		
		
		
		TreeNode root=new TreeNode(1);
		TreeNode secRight=new TreeNode(2);
		TreeNode thirdRight=new TreeNode(3);
		root.right=secRight;
		secRight.left=thirdRight;
		
		

	    BinaryTreeInorderTraversal s=new BinaryTreeInorderTraversal();
 
	    List<Integer> list=s.inorderTraversal(root);
	    
//	    List<Integer> list=s.inOrderTraversalRecursion(root);
		
	    
	    for(int tmp:list)
	    	System.out.print(tmp+" ");
		
		
	}

	
	
	/*
	 * Accepted
	 * 
	 * 
Features:
1. the parents are always visited first.
2. there are two kinds of nodes--->
(1)the node which contain children
(2)the node which does not contain children.

	 * 
	 */
	
	/*
	 * 使用堆栈来模拟递归的，
	 * 同时使父节点“再入”，					
	 * if (node.left != null || node.right != null)
		s.push(node);

	 * 使用HashMap来标记访问情况，来区分出使第一次访问父节点，还是第二次访问父节点。如果使第二次，要放入到结果list中。
	 * 通过控制进棧的先后顺序，来控制遍历顺序，最终实现inOrder遍历。
	 * 
	 */
	public List<Integer> inorderTraversal(TreeNode root) {

		Stack<TreeNode> s = new Stack<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();
		HashMap<TreeNode, Boolean> vistedMap = new HashMap<TreeNode, Boolean>();

		s.push(root);
		while (!s.isEmpty()) {
			TreeNode node = s.pop();

			if (node != null) {

				if (vistedMap.get(node) == null) {
					if (node.right != null) {
						s.push(node.right);
					}

					if (node.left != null || node.right != null)
						s.push(node);

					if (node.left == null && node.right == null) {
						result.add(node.val);
					}

					if (node.left != null) {
						s.push(node.left);
					}

					// marke it as visted.
					if (vistedMap.get(node) == null) {
						vistedMap.put(node, true);
					}

				} else {
					result.add(node.val);
				}

			}

		}

		return result;
	}
	
	
	public List<Integer> inOrderTraversalRecursion(TreeNode root){
		

		
		if(root.left!=null) inOrderTraversalRecursion(root.left);
		
		list.add(root.val);
		
		if(root.right!=null) inOrderTraversalRecursion(root.right);
		
		return list;
	}
	
	

}






































