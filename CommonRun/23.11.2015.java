/*




# Must write within 1
Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			String.valueOf(char[] ch);

##Binary operation / Bit operations

		StringBuilder nb = new StringBuilder(Integer.toBinaryString(n));

		StringBuilder nb=new StringBuilder(Integer.toBinaryString(n));

##PreOrder Traversal

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public void preOrderTraversal(TreeNode root){
	
	if(root!=null){
	
	System.out.println(root.val);

	if(root.left!=null){
		preOrderTraversal(root.left);
	}

	if(root.right!=null){
		preOrderTraversal(root.right);
	}



	}

}


##InOrder Traversal


##PostOrder Traversal


##LevelOrder Traversal

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

 

public void getLevel(TreeNode root){
	
	LinkedList<TreeNode> que=new LinkedList<TreeNode>(); 

	que.addLast(root);

	while(!que.isEmpty()){
	
		TreeNode firstNode=que.removeFirst();

		if(firstNode!=null){
			System.out.println(firstNode.val);

			if(firstNode.left!=null) que.addLast(firstNode.left);

			if(firstNode.right!=null) que.addLast(firstNode.right);
		}
	}


}




##Deepth of binary tree Traversal

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public int getDepth(TreeNode root){
	
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


##Linked List Traversal

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}


public void loopLinkedList(ListNode head){
	
	ListNode tmp=head;

	while(tmp!=null){
		
		System.out.println(tmp.val);
		tmp=tmp.next;
	}


}



##Fibonacci Number

By using recursion:

public int fibonacci(int n){
	if(n==0||n==1) return 1;

	return fibonacci(n-1)+fibonacci(n-1);
}



Do not using recursion:

public int fibonacci(int n){
	if(n==0||n==1) return 1;

	int a=1;
	int b=1;
	int sum=a+b;
	for(int i=2;i<n;i++){
	sum=a+b;
	a=b;
	b=sum;

		}
		return sum;
}




##BFS

##DFS

##Judge whether has cycle

##find the insection node of two single lists

##find the beginning node of cycle (Linked List)

##LRU Cache

##Minimum Depth of Binary Tree

##Maximum Depth of Binary Tree

##Binary Search

##Implement Queue using stacks

##Implement Stack using Queues

##invert binary tree

##Swap two variables without using extra space

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

##HashSet iteration

##HashMap iteration

##HashTable iteration