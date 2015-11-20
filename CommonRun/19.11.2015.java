

/*


# Must write within 1
Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			String.valueOf(char[] ch);

##Binary operation / Bit operations
	 

##PreOrder Traversal


##InOrder Traversal


##PostOrder Traversal


##LevelOrder Traversal


##Deepth of binary tree Traversal

 
Level Traversal:


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}


public int levelTraversal(TreeNode root){
	
	LinkedList<TreeNode> que=new LinkedList<TreeNode>();

	int levelCount=0;
	que.addLast(root);
	que.addLast(null);

	while(!que.isEmpty()){
	
	TreeNode firstNode=que.removeFirst();

	if(firstNode==null) {
	
	levelCount++;

	if(!que.isEmpty()){
		que.addLast(null);
	}

	}else
	{
	
	if(firstNode.left!=null) {
	que.addLast(firstNode.left);
	}

	if(firstNode.right!=null){
	que.addLast(firstNode.right);
	}
	}
	}

}




##Linked List Traversal

##Fibonacci Number

##BFS

##DFS

##Judge whether has cycle

##find the insection node of two single lists

##find the beginning node of cycle (Linked List)

##LRU Cache

##Minimum Depth of Binary Tree

##Maximum Depth of Binary Tree

##Binary Search

public int binarySearch(int nums[], int key){
	
	int low=0;
	int high=nums.length-1;

	while(low<=high){
		int middle=(low+high)/2;

		if(nums[middle]==key) return middle;

		if(nums[middle]>key){
			high=middle-1;
		}

		if(nums[middle]<key){
			low=middle+1;
		}

	}

	return -1;
}

 

Recursion implementation:
 
	public static int binarySearchRecursion(int[] nums, int key) {
	    return binarySearchRecursionSub(nums, 0, nums.length-1, key);
	}

	public static int binarySearchRecursionSub(int[] nums, int start, int end, int key) {
	    int middle = (start + end) / 2;
	    
 
	    if(end < start) {
	        return -1;
	    } 
	    

	    if(key==nums[middle]) {
	        return middle;
	    } else if(key<nums[middle]) {
	        return binarySearchRecursionSub(nums, start, middle - 1, key);
	    } else {
	        return binarySearchRecursionSub(nums, middle + 1, end, key);
	    }
	}

##Implement Queue using stacks

##Implement Stack using Queues

##invert binary tree

Input:
[4,1,null,2,null,3]
Output:
[4,null,1,null,2,3]
Expected:
[4,null,1,null,2,null,3]

		TreeNode root=new TreeNode(4);
 
		TreeNode secLeft=new TreeNode(1);
		TreeNode thirdLeft=new TreeNode(2);
		TreeNode fourthLeft=new TreeNode(3);
		secLeft.left=thirdLeft;
		thirdLeft.left=fourthLeft;

		root.left=secLeft;
		
 

			4
		   / \
		  1   null
		 / \
		2   null
	   /
	  3
			
			 4
		   /   \
		 null   1
		       / \
            null  2
                 /  \
				null 3


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public void invertBinary(TreeNode root){
 

	if(root!=null){

		if(root.left!=null) invertSubTree(root.left);
		if(root.right!=null) invertSubTree(root.right);
		invertSubTree(root);

	}


}


public void invertSubTree(TreeNode node){
	
	if(node==null) return;

	if(node!=null){
		TreeNode tmp=node.left;
		node.left=node.right;
		node.right=tmp;
	}

}
 
 
##Swap two variables without using extra space

public void swap(int a,int b){
	a=a^b;
	b=a^b;
	a=a^b;
}


##Merge two sorted arrays ===> array operation

##Merge two sorted lists

##O(1) time complexity to get minimum value of stack

##Move-zeroes  ===> array operation

##Palindrome Number (回文)

##Permutations (important)

## Find path of Binary Tree

##ReverseBits

##Reverse Integer

##Reverse Linked List

##Rotate Array

##Reverse Array

##Is Same Tree (/same-tree/)

## Symmetric Tree

## valid-anagram (/valid-anagram/)