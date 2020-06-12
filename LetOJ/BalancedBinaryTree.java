/*
https://leetcode.com/problems/balanced-binary-tree/
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree 
in which the depth of the two subtrees of every node never differ by more than 1.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
public class Solution {
    public boolean isBalanced(TreeNode root) {
        
    }
}

 * 
 */
import java.util.*;
 
 
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val=x;
	}
}

 
public class BalancedBinaryTree {
    public static void main(String args[]){
		TreeNode root=new TreeNode(1);
		TreeNode secleft=new TreeNode(2);
		TreeNode secright=new TreeNode(2);
		
		TreeNode thirdLeft=new TreeNode(3);
		TreeNode thirdRight=new TreeNode(3);
		
//		TreeNode fourLeft=new TreeNode(4);
//		TreeNode fourRight=new TreeNode(4);
		
//		thirdRight.right=fourRight;
//		thirdLeft.left=fourLeft;
		
		secleft.left=thirdLeft;
		secright.right=thirdRight;

		root.left=secleft;
		root.right=secright;
		
		BalancedBinaryTree bt=new BalancedBinaryTree();
		
		System.out.println(bt.isBalanced(root));
		
		bt.levelTraversal(root);
    }
    
    
	public static void levelTraversal(TreeNode root){
		
		if(root!=null){

		LinkedList<TreeNode> que=new LinkedList<TreeNode>();
		que.add(root);

		while(!que.isEmpty()){

			TreeNode firstNode=que.removeFirst();
	 		if(firstNode!=null){
	 			System.out.print(" "+firstNode.val);
	 		     que.addLast(firstNode.left);
	 		     que.addLast(firstNode.right);
	 		}else
	 			System.out.print(" "+null);
		}

		}
	}
	
	
    /*
	Accpeted.
     * 
     */
    public boolean isBalanced(TreeNode root){
    	
    	if(root==null) return true;
    	
    	return isBalancedSub(root.left,root.right);
    }
    
    
    public boolean isBalancedSub(TreeNode p,TreeNode q){
    	int l=0;
    	int r=0;
    	
    	if(p==null&&q==null) return true;
    	
    	if(p==null&&q!=null){
    		l=0;
    		r=findDepthOfSubTree(q);
    		return !(Math.abs(l-r)>1);
    	}
    	
    	if(p!=null&&q==null){
    		r=0;
    		l=findDepthOfSubTree(p);
    		return !(Math.abs(l-r)>1);
    	}
    	
    	if(p!=null&&q!=null){
    	 l=findDepthOfSubTree(p);
    	 r=findDepthOfSubTree(q);
    	
    	return (Math.abs(l-r)<=1)&&isBalancedSub(p.left,p.right)&&isBalancedSub(q.left,q.right);
    	}
 
    	return false;
    }
    
    
    public int findDepthOfSubTree(TreeNode root){
    	
    	if(root==null) return 0;
    	
    	LinkedList<TreeNode> que=new LinkedList<TreeNode>();
    	int depth=0;
    	que.addLast(root);
    	que.addLast(null);
    	
    	while(!que.isEmpty()){
    		TreeNode firstNode=que.removeFirst();
    		if(firstNode==null){
    			depth++;
    			if(!que.isEmpty()){
    				que.addLast(null);
    			}
    		}else{
    			
    			if(firstNode.left!=null) que.addLast(firstNode.left);
    			if(firstNode.right!=null) que.addLast(firstNode.right);
    			
    		}
    		
    	}
    	return depth;
    }
    
    

}















