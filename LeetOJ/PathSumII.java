import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
 

/*
 * 
https://leetcode.com/problems/path-sum-ii/

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
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

/*
        	  5
             / \
            4   8
           /   / \
          11  7   4
          
          
          					      1
          					    /   \
          					 -2     -3
           				     / \    / \
          				    1   3 -2  null
          				   /  	
          				  -1	
          
          
 * 
 * 
 */
public class PathSumII {
	public static void main(String args[]){
		
//		TreeNode root=new TreeNode(5);
//		TreeNode secLeft=new TreeNode(4);
//		TreeNode secRight=new TreeNode(8);
//		
//		root.left=secLeft;
//		root.right=secRight;
//		
//		secLeft.left=new TreeNode(11);
//		
//		secRight.left=new TreeNode(7);
//		secRight.right=new TreeNode(4);
		
		
		TreeNode root=new TreeNode(1);
		TreeNode secLeft=new TreeNode(-2);
		TreeNode secRight=new TreeNode(-3);
				
		secRight.left=new TreeNode(-2);
		secRight.right=null;
		
		root.left=secLeft;
		root.right=secRight;
		
		TreeNode fourLeft=new TreeNode(-1);
		
		TreeNode ThreeLeft=new TreeNode(1);
		ThreeLeft.left=fourLeft;
		TreeNode ThreeRight=new TreeNode(3);
		
		secLeft.left=ThreeLeft;
		secLeft.right=ThreeRight;
		
		
 
		PathSumII path=new PathSumII();
		path.pathSum(root, 2);
		
		//find all the root-leaf paths in binary tree.
//		path.loopTreePath(root, new LinkedList());
		
		
	}
	
	
	
	
	
	/*
	 *  Because we need to remove and add objects frequently,
	 *  we should use LinkedList rather than ArrayList.
	 *  
	 * Accepted.
	 * 
	 */
	
	List<List<Integer>> result=new ArrayList<List<Integer>>();
	int sum=0;
	
	public List<List<Integer>> pathSum(TreeNode root,int sum){
		this.sum=sum;
		
		loopTree(root, new LinkedList(),0);

		
		for(List<Integer> tmplist:result){
			
			for(int tmp:tmplist){
				System.out.print(tmp+" ");
			}
			System.out.println();
			
		}
//		
		
		return result;
	}
	
	public void loopTree(TreeNode node, LinkedList<Integer> list,int prevSum){
		
		if(node!=null){
			prevSum+=node.val;
			
			// LinkedList add() will add element from the rear.
			list.add(node.val);
			
			if(node.left==null&&node.right==null){
				if(sum==prevSum){
					ArrayList<Integer> newlist=new ArrayList<Integer>();
					for(int tmp:list){
						newlist.add(tmp);
					}
					result.add(newlist);
				}
			}
			
			
//			if(node.left==null&&node.right==null) {
//				
//				System.out.print("one: "+node.val+" >>>");
//				for(int tmp:list){
//					System.out.print(" "+tmp+" ");
//				}
//				
//				System.out.println();
//				
//			}
			
 
			
			if (node.left != null) {
				loopTree(node.left, list, prevSum);
				// delete the previous node
				// recover the status
				
				/*
				 * because list has two methos:
				 * 
				 *   E remove(int index);
				 *   boolean remove(Object o);
				 *   
				 *   so you need to take care what you write.
				 *   node.left.val is not a object. it is int.
				 *   You need cast it to object.
				 * 
				 */
				list.removeLast();
			}

			if (node.right != null) {
				loopTree(node.right, list, prevSum);
				// delete the previous node
				// recover the status
				list.removeLast();
			}
 
	 

		}
		
	}
	
	
	
	/*
Input:
[1,-2,-3,1,3,-2,null,-1]
2
Output:
[[-2,1,3]]
Expected:
[[1,-2,3]]


Reason:

list.remove(Object o) will remove all the o in the list. it means it will remove more than one objects at a time.
So it will make the path broken.

	 * 
	 * 
	 */
	
//	List<List<Integer>> result=new ArrayList<List<Integer>>();
//	int sum=0;
//	
//	public List<List<Integer>> pathSum(TreeNode root,int sum){
//		this.sum=sum;
//		
//		loopTree(root, new ArrayList(),0);
//
//		
////		for(List<Integer> tmplist:result){
////			
////			for(int tmp:tmplist){
////				System.out.print(tmp+" ");
////			}
////			System.out.println();
////			
////		}
////		
//		
//		return result;
//	}
//	
//	public void loopTree(TreeNode node, List<Integer> list,int prevSum){
//		
//		if(node!=null){
//			prevSum+=node.val;
//			list.add(node.val);
//			
//			if(node.left==null&&node.right==null){
//				if(sum==prevSum){
//					ArrayList<Integer> newlist=new ArrayList<Integer>();
//					for(int tmp:list){
//						newlist.add(tmp);
//					}
//					result.add(newlist);
//				}
//			}
//			
//			
//			if(node.left==null&&node.right==null) {
//				
//				System.out.print("one: "+node.val+" >>>");
//				for(int tmp:list){
//					System.out.print(" "+tmp+" ");
//				}
//				
//				System.out.println();
//				
//			}
//			
// 
//			
//			if (node.left != null) {
//				loopTree(node.left, list, prevSum);
//				// delete the previous node
//				// recover the status
//				
//				/*
//				 * because list has two methos:
//				 * 
//				 *   E remove(int index);
//				 *   boolean remove(Object o);
//				 *   
//				 *   so you need to take care what you write.
//				 *   node.left.val is not a object. it is int.
//				 *   You need cast it to object.
//				 * 
//				 */
	
	/*
		list.remove(Object o) will remove all the o in the list. it means it will remove more than one objects at a time.
		So it will make the path broken.
	 * 
	 */
 
//				list.remove((Integer)node.left.val);   //wrong!!!!!
//			}
//
//			if (node.right != null) {
//				loopTree(node.right, list, prevSum);
//				// delete the previous node
//				// recover the status
//				list.remove((Integer)node.right.val);   //wrong!!!!!
//			}
// 
//	 
//
//		}
//		
//	}
	
	
	
	
	/*
	 * 
	 * How to write a program:
	 * 
	 * To record the path of each root-leaf path
	 * 
	 * 
	 */
	
	public void loopTreePath(TreeNode node, LinkedList<Integer> list){
		if(node!=null){
			//LinkedList add the element from the rear of the list.
			list.add(node.val);
			
			if(node.left==null&&node.right==null){
				
				for(int tmp:list){
					System.out.print(tmp+" ");
				}
				System.out.println();
			}
			
			
 
			if (node.left != null) {
 
				loopTreePath(node.left,list);
				
				// delete the previous node
				// recover the status
				
				/*
				 * because list has two methos:
				 * 
				 *   E remove(int index);
				 *   boolean remove(Object o);
				 *   
				 *   so you need to take care what you write.
				 *   node.left.val is not a object. it is int.
				 *   You need cast it to object.
				 *   
				 *   list.remove(Object obj) will remove all the elements which are equal to obj from the list.
				 *   
				 * 
				 */
//				list.remove((Integer)node.left.val);
				list.removeLast();
			}

			if (node.right != null) {
	 
				loopTreePath(node.right, list);
				// delete the previous node
				// recover the status
//				list.remove((Integer)node.right.val);
				list.removeLast();
			}
 
	 

		}
	}
	
	

}
