
/*
 * 

https://leetcode.com/problems/deepest-leaves-sum/

1302. Deepest Leaves Sum
Medium

276

21

Add to List

Share
Given a binary tree, return the sum of values of its deepest leaves.
 

Example 1:



Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
 

Constraints:

The number of nodes in the tree is between 1 and 10^4.
The value of nodes is between 1 and 100.

3 Apr. 2020 at 11:18:31 pm
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
	//11.01pm-11.17pm

	public int deepestLeavesSum(TreeNode root) {
		if (root == null) return 0;

		Queue<TreeNode> que = new LinkedList<TreeNode> ();
		que.add(root);

		boolean is_bottom = true;
		int sum = 0;

		while (!que.isEmpty()) {

			int n = que.size();

			for (int i = 0; i<n; i++) {

				TreeNode curr = que.poll();

				if (curr.left == null && curr.right == null) is_bottom = true;

				if (curr.left != null) {
					is_bottom = false;
					que.add(curr.left);
				}

				if (curr.right != null) {
					is_bottom = false;
					que.add(curr.right);
				}

				if (is_bottom) {
					if (curr != null)
						sum += curr.val;
				} else {
					sum = 0;
				}

			}

			//如果队列不为空，说明还没有到底
			if (!que.isEmpty()) {
				sum = 0;
			}

		}
		return sum;

	}
}




刚开始写成求，最深路径的sum了:

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
    //11.01pm
    
    public int deepestLeavesSum(TreeNode root) {
        if(root==null) return 0;
        
         
        
        return dfs(root);
        
    }
    
    int dfs(TreeNode root){
        if(root==null) return 0;
        
        if(root.left==null && root.right==null){
            return root.val;
        }
        
      return Math.max(root.val+dfs(root.left), root.val+dfs(root.right));
    }
    
    
}








