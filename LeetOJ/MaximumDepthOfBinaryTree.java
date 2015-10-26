
/*
 * Maximum Depth of Binary Tree
 * 
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * 
 */

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public class MaximumDepthOfBinaryTree {

	public static void main(String args[]){

		TreeNode root=new TreeNode(1);
		//		TreeNode secondRoot=new TreeNode(2);
		//		secondRoot.left=new TreeNode(333);

		root.left=null;
		root.right=new TreeNode(2);


		System.out.println(maxDepth(root));

	}



	//	class TreeNode{
	//	    	int val;
	//	    	TreeNode left;
	//	    	TreeNode right;
	//	    	TreeNode(int x){val=x;}
	//	    }

	/*
	 * Accepted:
	 */

	public static int maxDepth(TreeNode node){

		int left=0, right=0;

		if(node==null) return 0;
		if(node!=null&&node.left==null&&node.right==null) return 1;


		if(node!=null){
			if(node.left!=null){
				left++;
				left+=maxDepth(node.left);
			}


			if(node.right!=null){
				right++;
				right+=maxDepth(node.right);

			}

			return Math.max(left, right);	
		}


		return 0;

	}

}	




/*
 * Reason: I did not consider the case: only one element there.
 * 
 * 
 * 
 * Wrong Answer 
 * 
Input:
[0]
Output:
0
Expected:
1
 * 
 */

//	class TreeNode{
//	    	int val;
//	    	TreeNode left;
//	    	TreeNode right;
//	    	TreeNode(int x){val=x;}
//	    }
//	


//	public static int maxDepth(TreeNode node){
//		 
//		int left=0, right=0;
//		
//		if(node==null) return 0;
//		
//
//		if(node!=null){
//			if(node.left!=null){
//			left++;
//			left+=maxDepth(node.left);
//			}
//			
//			
//			if(node.right!=null){
//				right++;
//				right+=maxDepth(node.right);
//			
//			}
//			
//		return Math.max(left, right);	
//		}
//		
//		
//		return 0;
//		
//	}




/*
 * 
 * Reason: I typed wrong capital Right. The right one should be: TreeNode right;
 * 
 * Attitude decides everything , detail makes difference 
 * 
 * 
Status: Runtime Error
Last executed input:
[1,null,2]
 * 
 * 
 */



//	class TreeNode{
//	    	int val;
//	    	TreeNode left;
//	    	TreeNode Right;
//	    	TreeNode(int x){val=x;}
//	    }

//	public static int maxDepth(TreeNode node){
// 
//		int left=0, right=0;
//		
//		if(node==null) return 0;
//		
//
//		if(node!=null){
//			if(node.left!=null){
//			left++;
//			left+=maxDepth(node.left);
//			}
//			
//			
//			if(node.Right!=null){
//				right++;
//				right+=maxDepth(node.Right);
//			
//			}
//			
//		return Math.max(left, right);	
//		}
//		
//		
//		return 0;
//		
//	}



//}
