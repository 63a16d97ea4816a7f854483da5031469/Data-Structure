
/*

# Must write within 1
Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			List--->int len=list.size();
			
			String.valueOf(char[] ch);

##Binary operation / Bit operations

public String binarySearch(int n){
	StringBuilder sb=new StringBuilder(Integer.toBinaryString(n));
	return sb.reverse().toString();
}	 

##PreOrder Traversal

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}


public void preOrder(TreeNode root){
	
	if(root!=null){
	System.out.println(root.val);

	if(root.left!=null) preOrder(root.left);
	if(root.right!=null) preOrder(root.right);

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


public void levelTraversal(TreeNode root){
	
	LinkedList<TreeNode> que=new LinkedList<TreeNode>();
	que.addLast(root);


	while(!que.isEmpty()){
	
		TreeNode firstNode=que.removeFirst();

		if(firstNode==null){
	
		}else{
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

public int findDepth(TreeNode root){
	
	LinkedList<TreeNode> que=new LinkedList<TreeNode>();

	que.addLast(root);
	que.addLast(null);

	while(!que.isEmpty()){
		TreeNode firstNode=que.removeFirst();

		if(firstNode==null){
			depth++;
			que.addLast(null);
		}else{
			
			// System.out.println(firstNode.val);
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
	ListNode(int x){
	val=x;
	}
}


public void loopList(ListNode head){
	
	ListNode tmp=head;
	while(tmp!=null){
	System.out.println(tmp.val);
	tmp=tmp.next;
	}

}


##Fibonacci Number

public int findN(int n){
	if(n==0||n==1) return 1;
	return findN(n-1)+findN(n-2);
}

public int findFib(int n){
	if(n==0||n==1) return 1;
	
	int a=1;
	int b=1;
	int sum=a+b;
	for(int i=2;i<=n;i++){
	sum=a+b;
	a=b;
	b=sum;
	}
	return sum;
}


##BFS

##DFS

##Judge whether has cycle

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}

public boolean isCycle(ListNode head){
	
	ListNode fast=head;
	ListNode slow=head;

	while(fast!=null){
	
	if(fast.next!=null)
	{
	fast=fast.next.next;
	}else{
	fast=fast.next;
	}
	slow=slow.next;
	if(fast==slow) return true;
	}
return false;
}

##find the insection node of two single lists


class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}

public ListNode findInsection(ListNode head1,ListNode head2){

	ListNode tmp1=head1;
	ListNode tmp2=head2;
	
	int len1=0;
	int len2=0;

	while(tmp1!=null){
	len1++;
	tmp1=tmp1.next;
	}

	while(tmp2!=null){
	len2++;
	tmp2=tmp2.next;
	}

	tmp1=head1;
	tmp2=head2;

	int diff=0;

	if(len1>len2){
	diff=len1-len2;

		while(diff>0){
		tmp1=tmp1.next;
		diff--;
		}
	
	}

	if(len2>len1){
	diff=len2-len1;

		while(diff>0){
		tmp2=tmp2.next;
		diff--;
		}
	}
	
	while(tmp1!=null&&tmp2!=null){
		if(tmp1.val==tmp2.val) return tmp1;
	}

return null;
}

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