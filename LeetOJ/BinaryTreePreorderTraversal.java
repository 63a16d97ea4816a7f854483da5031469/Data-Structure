package ok;
/*
 * 


https://leetcode.com/problems/binary-tree-preorder-traversal/

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
    }
}

9 November 2015 at 4:12:06 pm

 * 
 */


/*
 * 
 * Analysis:
     *          1
     *         / \
     *        2   6
     *       / \
     *      9   3


1
2,6
9,3,6,


Stack

1. do the operation from one end.
2. do the same operation until get the null



 * 
 * 
 */


import java.util.*;

//class TreeNode{
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x){val=x;}
//}


/*
 * 这个算法很重要，需要在1-3分钟内写出。
 * 包括 递归方法 和 非递归实现
 * 
 */

public class BinaryTreePreorderTraversal {

	
	
	/*
	 *          1
	 *         / \
	 * 		  2   6
	 *       / \
	 * 	    9   3
	 */
	
	public static void main(String args[]){
		BinaryTreePreorderTraversal s=new BinaryTreePreorderTraversal();
		
		TreeNode root=new TreeNode(1);
		TreeNode secLeft=new TreeNode(2);
		TreeNode secRight=new TreeNode(6);
		TreeNode thirdRight=new TreeNode(3);
		TreeNode thirdLeft=new TreeNode(9);
		
		root.left=secLeft;
		root.right=secRight;
		
		secLeft.left=thirdLeft;
		secLeft.right=thirdRight;

		
		
		
		List<Integer> list=s.preorderTraversal3(root);
		
		for(int tmp:list)
			System.out.print(tmp+" ");
		
		
		
	}
	
	
	
	/*
	 * if you want to use other iterative method except for stack, you need to record the status of the whole path.
	 * so after you finish you can return to the previous one.
	 * 
	 * Accepted.
	 * 
	 */
	
    public List<Integer> preorderTraversal3(TreeNode root) {
    	Stack<TreeNode> s=new Stack<TreeNode>();
    	s.push(root);
    	ArrayList<Integer> arr=new ArrayList<Integer>();

    	while(!s.isEmpty()){
         TreeNode node=s.pop();
    	  if(node!=null){
//    	 System.out.print(node.val+" ");
    		  arr.add(node.val);
    	  //Last in first out.
    	    if(node.right!=null){
    	        s.push(node.right);
    	    }

 
    	    if(node.left!=null) {
    	        s.push(node.left);
    	    }
    	}

    	}

		return arr;

    }
    
	
	
	
	
	
	//By using Loop--BFS:----> it is not preorder traversal
    public List<Integer> preorderTraversal2(TreeNode root) {
//    	Stack<TreeNode> s=new Stack<TreeNode>();
    	LinkedList<TreeNode> que=new LinkedList<TreeNode>();
    	que.addLast(root);
//    	que.addLast(null);   //if you need to compute the depth,you need this one.
    	
    	while(!que.isEmpty()){
    		TreeNode firstNode=que.removeFirst();
    		if(firstNode!=null) {
    			System.out.println(firstNode.val);
    			if(firstNode.left!=null) {
    				que.addLast(firstNode.left);
    			}
    			
    			if(firstNode.right!=null)
    			{
    				que.addLast(firstNode.right);
    			}
    		}
    	}
    	
    	
    
    	return null;
    
    }
    
    
    
    
    //By using recursion:
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
    	if(root!=null){
    		
    		System.out.println(root.val);
    		
    		if(root.left!=null) preorderTraversal(root.left);
    		
    		if(root.right!=null) preorderTraversal(root.right);
    		
    		
    	}
    	
    	
    return null;
    }
	
}
































