//https://leetcode.com/problems/binary-tree-level-order-traversal/
/*
 * 
Given a binary tree, return the level order traversal of its nodes' 
values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
    }
}

 * 
 */
import java.util.*;

class TreeNode {
	  int val;
	  TreeNode left;
	  TreeNode right;
	  TreeNode(int x){ val=x;}

}

public class BinaryTreeLevelOrderTraversal {
	
	

	public static void main(String args[]){
		
		/*				1
		 * 			   / \
		 *            2   3
		 *               / 
		 *              4   
		 *              
		 *      Considering the following cases:        
		 *             1
		 *            /
		 *           2  
		 *             
		 *             1
		 *              \
		 *               2 
		 *              
		 * 
		 */
		
		
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
//		TreeNode secRight=new TreeNode(3);
//		secRight.left=new TreeNode(4);
//		root.right=secRight;
		
		List<List<Integer>> tmp=levelOrder(root);
		
		for(List<Integer> t:tmp){
			
			for(int m:t){
				System.out.print(m+" ");
			}
			System.out.println();
		}
		
		
	}
	
	
 
    public static List<List<Integer>> levelOrder(TreeNode root) {
    	
    	if(root==null) return new ArrayList<List<Integer>>();
    	
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        
        LinkedList<TreeNode> que=new LinkedList<TreeNode>();
        
        List<Integer> list=new ArrayList<Integer>();
        
        que.add(root);
        que.add(null);
        
        while(!que.isEmpty()){
        	
        	TreeNode firstNode=que.removeFirst();
 
        	
        	if(firstNode==null){
        		result.add(list);
        		//reset the list ArrayList.
        		list=new ArrayList<Integer>();
        		if(!que.isEmpty()) que.addLast(null);
        	}else{
        		
            	list.add(firstNode.val);
        		if(firstNode.left!=null) que.add(firstNode.left);
        		if(firstNode.right!=null) que.add(firstNode.right);
        		
        	}

        }
        
        return result;
    }
	
}
