import java.util.Stack;

/*
 * Maximum Depth of Binary Tree
 * 
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * 
 */

class TreeNode {
	// boolean isVisted;  //no need to use mark variable
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class MaximumDepthOfBinaryTree {

	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);
		// TreeNode secondRoot=new TreeNode(2);
		// secondRoot.left=new TreeNode(333);
		// root.left = secondRoot;
		root.right = new TreeNode(2);
		System.out.println(maxDepth(root));
		// System.out.println(maxDeepbyDeepSearch(root));
	}

	/*
	 * 
	 * Using stack to find out the maxDepth
	 * 
	 * Draw the tree structure and stack status, you will know the steps.
	 * 
	 */

	public static int maxDeepbyDeepSearch(TreeNode root) {

		if (root == null)
			return 0;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);

		int maxDepth = 0;
		TreeNode prev = null;
		while (!s.empty()) {
			TreeNode curr = s.peek();

			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null)
					s.push(curr.left);
				else if (curr.right != null)
					s.push(curr.right);

			} else if (curr.left == prev) {
				if (curr.right != null)
					s.push(curr.right);
			} else {
				s.pop();
			}
			prev = curr;
			if (s.size() > maxDepth)
				maxDepth = s.size();
		}
		return maxDepth;
	}

	/*
	 * 
	 * Cannot use this way
	 * 
	 * As it will not record each sub-tree's root node
	 * 
	 */

	// public static int maxDeepbyDeepSearch(TreeNode node) {
	//
	// int result = 0;
	//
	// int left = 0, right = 0;
	// if (node == null)
	// return 0;
	// if (node != null && node.left == null && node.right == null)
	// return 1;
	//
	// Stack<TreeNode> stack = new Stack<TreeNode>();
	// stack.push(node);
	//
	// while (!stack.isEmpty()) {
	// TreeNode v = stack.pop();
	// // System.out.println("pop out:"+v.val);
	//
	// if (v.right != null) {
	// stack.push(v.right);
	// // System.out.println("push right:"+v.right.val);
	// }
	// if (v.left != null) {
	// stack.push(v.left);
	// // System.out.println("push left:"+v.left.val);
	// }
	// if (v != null && v.right == null && v.left == null) {
	// if (result < Math.max(left, right)) {
	// result = Math.max(left, right);
	// }
	// // System.out.println(Math.max(left, right));
	// } else {
	// result++;
	// }
	//
	// }
	//
	// return result + 1;
	// }

	// Deep search method:

	/*
	 * Reason: Iterative deep search will not go back to root.
	 * As it will not record each sub-tree's root node
	 * 
	 * wrong answer: Input: [1,2,3] Output: 3 Expected: 2
	 * 
	 */

	// public static int maxDeepbyDeepSearch(TreeNode node){
	//
	// int result=0;
	// if(node==null) return 0;
	//
	//
	// Stack<TreeNode> stack=new Stack<TreeNode>();
	// stack.push(node);
	//
	// while(!stack.isEmpty()){
	// TreeNode v=stack.pop();
	// if(!v.isVisted){
	// result++;
	// if(v.right!=null) stack.push(v.right);
	// if(v.left!=null) stack.push(v.left);
	// }
	//
	// }
	// return result;
	// }

	// class TreeNode{
	// int val;
	// TreeNode left;
	// TreeNode right;
	// TreeNode(int x){val=x;}
	// }

	/*
	 * 
	 * Accepted:
	 * This is used the Deep search.
	 * 
	 * BFS - visit all children, then grandchildren, then great-grandchildren,
	 * etc..
	 * 
	 * DFS - visit a child, then that child's child and so forth, when you reach
	 * as far as you can go via a child, x, you move back up a level and
	 * continue the process with the sibling of x (call it y)
	 * 
	 * 
	 * 
	 */

	public static int maxDepth(TreeNode node) {

		int left = 0, right = 0;

		if (node == null)
			return 0;
		if (node != null && node.left == null && node.right == null)
			return 1;

		if (node != null) {
			if (node.left != null) {
				left++;
				left += maxDepth(node.left);
			}

			if (node.right != null) {
				right++;
				right += maxDepth(node.right);

			}

			return Math.max(left, right);
		}

		return 0;

	}

}

/*
 * Reason: I did not consider the case: only one element there.
 * 
 * 
 * 
 * Wrong Answer
 * 
 * Input: [0] Output: 0 Expected: 1
 * 
 */

// class TreeNode{
// int val;
// TreeNode left;
// TreeNode right;
// TreeNode(int x){val=x;}
// }
//

// public static int maxDepth(TreeNode node){
//
// int left=0, right=0;
//
// if(node==null) return 0;
//
//
// if(node!=null){
// if(node.left!=null){
// left++;
// left+=maxDepth(node.left);
// }
//
//
// if(node.right!=null){
// right++;
// right+=maxDepth(node.right);
//
// }
//
// return Math.max(left, right);
// }
//
//
// return 0;
//
// }

/*
 * 
 * Reason: I typed wrong capital Right. The right one should be: TreeNode right;
 * 
 * Attitude decides everything , detail makes difference
 * 
 * 
 * Status: Runtime Error Last executed input: [1,null,2]
 * 
 * 
 */

// class TreeNode{
// int val;
// TreeNode left;
// TreeNode Right;
// TreeNode(int x){val=x;}
// }

// public static int maxDepth(TreeNode node){
//
// int left=0, right=0;
//
// if(node==null) return 0;
//
//
// if(node!=null){
// if(node.left!=null){
// left++;
// left+=maxDepth(node.left);
// }
//
//
// if(node.Right!=null){
// right++;
// right+=maxDepth(node.Right);
//
// }
//
// return Math.max(left, right);
// }
//
//
// return 0;
//
// }

// }
