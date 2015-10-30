package ok;


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

 * 
 */

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}


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
		TreeNode root=new TreeNode(1);
		TreeNode sec=new TreeNode(2);
		TreeNode secLeft=new TreeNode(3);
		TreeNode secRight=new TreeNode(4);
		sec.left=secLeft;
		sec.right=secRight;
		root.left=sec;
		TreeNode result=invertTree(root);
		
		loopTree(root);
		
		
	}

    public static void loopTree(TreeNode root) {
 
//    	if(root.left!=null||root.right!=null){
//        	TreeNode tmp=root.right;
//    		root.right=root.left;
//    		root.left=tmp;
//    	}
    	
    	
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
    	
    	if(root==null||(root.left==null&&root.right==null)) return root;	
    	
    	
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
