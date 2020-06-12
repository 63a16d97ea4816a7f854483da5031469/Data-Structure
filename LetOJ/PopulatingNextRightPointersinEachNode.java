/*
 * 
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 * 
 */

import java.util.*;

class TreeLinkNode{
	int val;
	TreeLinkNode left,right,next;
	TreeLinkNode(int x){val=x;}
}


public class PopulatingNextRightPointersinEachNode {

	public static void main(String args[]){
		
	}
	
	/*
	 * 
	 *   Accepted.
	 * 
	 */
	
	public void linksRight(TreeLinkNode root){
		
		if(root==null) return;  // need to consider the null case.  !!!!!
		
		LinkedList<TreeLinkNode> que=new LinkedList<TreeLinkNode>();
		que.addLast(root);
		que.addLast(null);
		
		TreeLinkNode linksRightNode=null;
		
		while(!que.isEmpty()){
				TreeLinkNode firstNode=que.removeFirst();
				if(firstNode==null){
					linksRightNode=null;
					if(!que.isEmpty()){
						que.addLast(null);
					}
				}else{
					
					if(linksRightNode!=null){
						linksRightNode.next=firstNode;
					}
					
					if(firstNode.left!=null){
						que.addLast(firstNode.left);
					}
					if(firstNode.right!=null){
						que.addLast(firstNode.right);
					}
					
					linksRightNode=firstNode;
					
				}
		}
		
	}
	

}


















