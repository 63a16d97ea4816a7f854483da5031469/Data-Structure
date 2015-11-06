/*
 * 
Path Sum

https://leetcode.com/problems/path-sum/

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        
    }
}

 * 
 */

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public class PathSum {

	
	/*

        	  5
             / \
            4   8
           /   / \
          11  13  4

	 * 
	 * 
	 */
	


	
	public static void main(String args[]){
		TreeNode root=new TreeNode(1);
//		TreeNode secLeft=new TreeNode(4);
//		TreeNode secRight=new TreeNode(8);
//		
//		root.left=secLeft;
//		root.right=secRight;
//		
//		secLeft.left=new TreeNode(11);
//
//		
//		secRight.left=new TreeNode(13);
//		secRight.right=new TreeNode(4);
//		
		
		PathSum s=new PathSum();
		s.hasPathSum(root, 1);
 
	}
	
/*
 * Accepted.
 * 
 */
	
	boolean flag=false;
	int sum=0;
	
	public boolean hasPathSum(TreeNode root,int sum){
		
		if(root==null&&sum!=0) return false;
		if(root==null&&sum==0) return false;
		
		this.sum=sum;
 
		
		
		return loopTree(root,0);
	}
	
	
	public boolean loopTree(TreeNode root,int prevSum){


		//stop faster.
		if(flag) return true;

		if(root!=null){
			
			prevSum+=root.val;
//			System.out.println(root.val);

			
			if(root.left==null&&root.right==null) {
//				System.out.println(prevSum+"<-"+(prevSum==sum));
				if(prevSum==sum) flag=true;
			}
			
			if(root.left!=null) loopTree(root.left,prevSum);
			
//			 result-=root.val;
			
			 if(root.right!=null) loopTree(root.right,prevSum);
		}
		
		if(flag) return true;
	 return false;
		
	}
	
	
	
}
