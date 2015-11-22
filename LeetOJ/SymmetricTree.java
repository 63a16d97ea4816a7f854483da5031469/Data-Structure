package ok;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/*

https://leetcode.com/problems/symmetric-tree/

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

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
    public boolean isSymmetric(TreeNode root) {
        
    }
}

7 November 2015 at 8:53:10 pm
 * 
 */













//
//class TreeNode{
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x){ val=x;}
//}

public class SymmetricTree {
	
//	public static TreeNode recordRoot=null;
//	static LinkedList<String> list=new LinkedList<String>();  //to record the left leaf
 
	static ArrayList<String> list=new ArrayList<String>();
	
	public static void main(String args[]){
		
		
		/*
		 * 		 1
		 * 	   /   \
		 * 	  2      2
		 * 	 / \    / \ 
		 *  3   #  #   3
		 *              \
		 *               4
		 * 
		 * 
    1
   / \
  2   2
 / \ / \
3  4 4  3

		 * 
		 * 
		 * 
		 */
		

		
		
		
		
		
		TreeNode root=new TreeNode(1);
		TreeNode secleft=new TreeNode(2);
		TreeNode secright=new TreeNode(2);
		secleft.right=new TreeNode(3);
		secright.left=new TreeNode(3);

		root.left=secleft;
		root.right=secright;
		System.out.println(isSymmetric2(root));
		levelTraversal(root);
		for(String tmp:list){
			System.out.print(tmp+" ");
		}
		System.out.println();
	 
//		for(String tmp:list2){
//			System.out.print(tmp+" ");
//		}
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
	
	
	//use recursion:
	/*
	 * Accepted
	 * 
	 */
	public static boolean isSymmetricTree(TreeNode p,TreeNode q){
	     if(p == null&&q == null)
	        return true;
	     if(p == null||q == null)
	        return false;
	     return (p.val == q.val) && isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
	}

	public static boolean isSymmetric4(TreeNode root) {
	    if(root==null) 
	        return true;
	        
	    return isSymmetricTree(root.left,root.right);
	}
	
	
	//do not use recursion:
	/*
	 * Accepted
	 * 
	 */
	
	public static boolean isSymmetric3(TreeNode root) {
	    if(root == null)
	        return true;
	    if(root.left == null && root.right == null)
	        return true;
	    if(root.left == null || root.right == null)
	        return false;
	    LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
	    LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
	    q1.add(root.left);
	    q2.add(root.right);
	    while(!q1.isEmpty() && !q2.isEmpty()){
	        TreeNode n1 = q1.poll();
	        TreeNode n2 = q2.poll();
	        
	        if(n1.val != n2.val)
	            return false;
	        if((n1.left == null && n2.right != null) || (n1.left != null && n2.right == null))
	            return false;
	        if((n1.right == null && n2.left != null) || (n1.right != null && n2.left == null))
	            return false;
	        
	        if(n1.left != null && n2.right != null){
	            q1.add(n1.left);
	            q2.add(n2.right);
	        }
	        
	        if(n1.right != null && n2.left != null){
	            q1.add(n1.right);
	            q2.add(n2.left);
	        }            
	    }
	    return true;
	}
	
	
	
	/*
	 * Use another method:
	 * 
	 * Accepted
	 * 
	 * 
	 *
	 * 
	 * 
	 * 
	 */
	
	
    public static boolean isSymmetric2(TreeNode root) {
    	
    	if(root==null) return true;
    	
    	return symmSubTree(root.left,root.right);    	
    }
    
    
    public static boolean symmSubTree(TreeNode left, TreeNode right){
    	
    	if(left==null&&right==null) return true;
    	if(left!=null&&right==null) return false;
    	if(left==null&&right!=null) return false;
    	
    	if(left.val!=right.val) return false;
    	
    	if(!symmSubTree(left.left,right.right)) return false;  
    	if(!symmSubTree(left.right,right.left)) return false;
    	
    	
    	return true; 	
    	
    }
	
	
	
	
	
	
	
	/*
	 * 
	 * According to the feature of the binary tree and the result
    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3

3,2,4,1 || 4,2,3

#,2,3,1||#,2,3


	 * 1. record the root.
	 * 2. for the whole tree's left leaf, we use queue to record the nodes.
	 * 3. for the whole tree's right leaf, we use queue to record the nodes. If they can match, it is symmetric.
	 * 4. for the null nodes, we add # into the listue and stack.
	 * 
	 * 
	 * In fact, no need to use two queues, only use one queue can solve this problem.
	 * 
	 * 
	 */

	
	
	/*
[1,2,2]
Output:
false
Expected:
true


Very strange, actually, if I run this case in local, it can pass.


	 * 
	 */
	
    public static boolean isSymmetric(TreeNode root) {
    	

        
    	loopTree(root);
 
    	int n=list.size();
    	if(n==0) return true;
    	if(n==1) return true;
 
    	
    	int rootIndex=0;
    	
    	if(n%2==0) {
    		return false;
    	}else{
    		rootIndex=n/2;
    	}
    	
    	int i=1;
    	while(true){
    		if(rootIndex-i>=0&&rootIndex+i<=list.size()-1){
    		System.out.println(list.get(rootIndex-i)+"-"+list.get(rootIndex+i));
    		if(!list.get(rootIndex-i).equals(list.get(rootIndex+i))) return false;
    		i++;
    		}else
    		{
    			break;
    		}
    	}
    	
    	return true;
 
    }
    
    
    public static void loopTree(TreeNode root){
 
 
    	if(root==null) return;
    	

    	
    	if(root.left!=null) loopTree(root.left);
    	else if(root.left!=null||root.right!=null){
    		list.add("#");
    	}
    	
    	if(root!=null) list.add(root.val+"");

    	
    	if(root.right!=null) loopTree(root.right);
    	else if(root.left!=null||root.right!=null){
    		list.add("#");
    	}
    	
    }
    
    
}
