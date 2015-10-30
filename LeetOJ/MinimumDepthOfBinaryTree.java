
//https://leetcode.com/problems/minimum-depth-of-binary-tree/
/*
 * 

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the
nearest leaf node.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
public class Solution {
    public int minDepth(TreeNode root) {
        
    }
}



Thinking:

if you think this question, you may wonder when could we find the minimum depth.
Actually, the feature is, when could you find the first node which does not contain left and right nodes.

最开始想这个问题，可能你会想到测量二叉树高度，如果用测量高度的方法，不仅耗时，而且要记录每个节点的高度，然后做比较。所以测量高度不是一个好办法。

但是，从测量二叉树高度这个思路，想到使用BFS，使用BFS有一个特点，就是先遍历一层的每一个节点，所以，可以利用这个特性。

其实，最先找到的那个没有left和right子树的节点，就可以终止了，就已经找到最小的depth了。

那么问题来了，你可以多块写出来BFS?

 * 
 */
import java.util.*;

public class MinimumDepthOfBinaryTree {

	/*
	 * 1 / 2 / 4
	 * 
	 */

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		// root.right=new TreeNode(4);
		// TreeNode sec=new TreeNode(2);
		// root.left=sec;
		// TreeNode third=new TreeNode(4);
		// sec.left=third;
		System.out.println(minDepth2(root));

	}


	
	
	/*
	 * 
	 * You must think more than focusing on coding.
	 * 
	 * 思考，什么时候是终止条件？
	 * 
	 * BFS是正确的思路，但是在什么时候终止，在哪里添加停止标志，这个需要思考。
	 * 
	 * 停止时刻： 当在这一层发现有一个node，其同时没有左右node的时候，就应当停止了。
	 * 但是，由于使用null来区别每一层，所以不能立刻停止，需要在读完这层后停止。（这样做是为了维持原有的 数层数 逻辑的完整性）
	 * 
	 * 
	 * 
	 */

	public static int minDepth2(TreeNode root) {

		boolean foundFlag = false;

		if (root == null)
			return 0;

		int result = 0;
		LinkedList<TreeNode> que = new LinkedList<TreeNode>();

		que.add(root);
		que.add(null);

		while (!que.isEmpty()) {

			TreeNode firstNode = que.pop();

			if (firstNode == null) {
				result++;
				if (foundFlag)
					return result;
				if (!que.isEmpty())
					que.addLast(null);

			} else {

				if (firstNode.left == null && firstNode.right == null) {
					foundFlag = true;
				}
				if (firstNode.left != null)
					que.addLast(firstNode.left);

				if (firstNode.right != null)
					que.addLast(firstNode.right);
			}

		}

		return result;
	}

	/*
	 * 
	 * Choose the BFS to find the first node which do not have left and right at
	 * the same time.
	 * 
	 * Submission Result: Wrong Answer More Details
	 * 
	 * Input: [1,2] Output: 1 Expected: 2
	 * 
	 * 
	 */

	public static int minDepth(TreeNode root) {

		if (root == null)
			return 0;

		int result = 0;
		LinkedList<TreeNode> que = new LinkedList<TreeNode>();

		que.add(root);
		que.add(null);

		while (!que.isEmpty()) {

			TreeNode firstNode = que.pop();
			if (firstNode == null) {
				result++;
				if (!que.isEmpty())
					que.addLast(null);
			} else {

				if (firstNode.left == null || firstNode.right == null) {

					return result;
				}

				if (firstNode.left != null)
					que.addLast(firstNode.left);

				if (firstNode.right != null)
					que.addLast(firstNode.right);
			}

		}

		return result;
	}


	
	/*
	 * Using the recursion
	 * 
	 * According to previous solution, the issue is resolved.
	 * 
	 * However, we also can think in this way:
	 * 
	 * find the root's minimum depth = min{left sub-tree's minimum depth, right sub-tree's minimum depth};
	 * 
	 * left sub-tree's minimum depth= min{left sub-sub-tree's minimum depth, right sub-sub-tree's minimum depth}
	 * 
	 * In this case, even you can find the above equation, it is useless.
	 * 
	 * Recursion should not be used. Unless, the result rely on the previous results. 
	 * 
	 */

}
