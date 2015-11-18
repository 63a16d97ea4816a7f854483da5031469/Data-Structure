/*
https://leetcode.com/problems/binary-tree-paths/

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        
    }
}


 * 
 */
import java.util.*;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

/*
   1
 /   \
2     3
 \
  5
 * 
 */



public class BinaryTreePaths {
	List<String> result=new ArrayList<String>(); 
	
	public static void main(String args[]){
		BinaryTreePaths s=new BinaryTreePaths();
		
		TreeNode root=new TreeNode(1);
		TreeNode secLeft=new TreeNode(2);
		secLeft.right=new TreeNode(5);
		 root.left=secLeft;
		 root.right=new TreeNode(3);
		List<String> list=s.binaryTreePaths(root,new ArrayList<Integer>());
		
		for(String tmp:list)
			System.out.print(tmp+" ");
	}
 
 /*
  * Accepted.
  * 
  */

		public List<String> binaryTreePaths(TreeNode root,ArrayList<Integer> tmpList){

			if(root!=null) {

			tmpList.add(root.val);

			if(root.left==null&&root.right==null) {
			
			String str="";

			for(int i=0;i<tmpList.size();i++){
			   str+=tmpList.get(i);
			   if(i!=tmpList.size()-1){str+="->";}	
			}

			 result.add(str);

			tmpList=new ArrayList<Integer>();

			}

			if(root.left!=null) {binaryTreePaths(root.left,tmpList);
				tmpList.remove(tmpList.size()-1);
			}
			if(root.right!=null) {binaryTreePaths(root.right,tmpList);
				tmpList.remove(tmpList.size()-1);
			}
			}

			return result;
		}
	}
	
 




























