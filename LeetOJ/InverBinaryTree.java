package ok;

import java.util.LinkedList;

/*
 * https://leetcode.com/problems/invert-binary-tree/
 * Invert Binary Tree
     4
   /   \
  2     7
 / \   / \
1   3 6   9

to

     4
   /   \
  7     2
 / \   / \
9   6 3   1



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        
    }
}

7 November 2015 at 8:54:31 pm

 * 
 */

//class TreeNode{
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x){val=x;}
//}


public class InverBinaryTree {
	
	
	/*
	 * 
	 * 			1
	 * 		   / 
	 *        2
	 *       / \
	 *      3   4
	 *      
	 *      	1
	 *           \
	 *            2
	 *           / \
	 *      	3   4
	 *      
	 *      
	 *      Expect:
	 *      	1
	 *           \
	 *            2
	 * 			 / \
	 *          4   3
	 * 
	 */

	public static void main(String args[]){
//		TreeNode root=new TreeNode(1);
//		TreeNode sec=new TreeNode(2);
//		TreeNode secLeft=new TreeNode(3);
//		TreeNode secRight=new TreeNode(4);
//		sec.left=secLeft;
//		sec.right=secRight;
//		root.left=sec;
		
		
		/*
		 * 
			4
		   / \
		  1   null
		 / \
		2   null
	   /
	  3
		 * 
		 */
		
		TreeNode root=new TreeNode(4);
		 
		TreeNode secLeft=new TreeNode(1);
		TreeNode thirdLeft=new TreeNode(2);
		TreeNode fourthLeft=new TreeNode(3);
		secLeft.left=thirdLeft;
		thirdLeft.left=fourthLeft;
		root.left=secLeft;
		
		levelLoopTree(root);
		

		
		TreeNode result=invertTree(root);
		
		System.out.println("------");
		
		levelLoopTree(root);
		
		
	}
	
 
	
  public static void levelLoopTree(TreeNode root){
	  
	  LinkedList<TreeNode> que=new LinkedList<TreeNode>();
	  
	  que.add(root);
	  
	  while(!que.isEmpty()){
		  	
		  TreeNode firstNode=que.removeFirst();
		  
		  if(firstNode!=null){
			  System.out.print(firstNode.val+" ");
			  
			  que.addLast(firstNode.left);
			  que.addLast(firstNode.right);
		  }else{
			  System.out.print(" null ");
		  }
		  
		  
	  }
	  
  }
	

	
	

    public static void loopTree(TreeNode root) {
 
    	
    	if(root!=null){
    		System.out.println(root.val);
    		
    		 loopTree(root.left);
    		 loopTree(root.right);
    	}else{
    		System.out.println("null");
    	}
    	
    	
    	
    	
    	
    }
	
    /*
     * Accepted:
     * 
     * 
     */
    
    public static TreeNode invertTree(TreeNode root){
    	
//    	if(root==null||(root.left==null&&root.right==null)) return root;	  //no need this one
    	
    	
    	if(root!=null){
    		
        	if(root.left!=null||root.right!=null){
            	TreeNode tmp=root.right;
        		root.right=root.left;
        		root.left=tmp;
        	}
    		
    		if(root.left!=null)
    			invertTree(root.left);
    		
    		if(root.right!=null)
    			invertTree(root.right);
    	}
    	
    	   
    	return root;
    	
    }
	
	
}
