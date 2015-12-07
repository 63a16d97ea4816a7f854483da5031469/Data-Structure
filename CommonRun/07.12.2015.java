
/*


# Must write within 1 minute
Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			List--->int len=list.size();
			
			String.valueOf(char[] ch);

##Binary operation / Bit operations
	 

##PreOrder Traversal


##InOrder Traversal

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public void inOrder(TreeNode root){
	if(root!=null){
		
		if(root.left!=null) inOrder(root.left);
		System.out.println(root.val);
		if(root.right!=null) inOrder(root.right);
	}
}


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

public int findDepth(TreeNode root){

LinkedList<TreeNode> que=new LinkedList<TreeNode>();
que.addLast(root);
que.addLast(null);
 	
 	int depth=0;

 	while(!que.isEmpty()){
			
		TreeNode firstNode=que.removeFirst();

		if(firstNode==null){
			detph++;
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

public int findFibonacci(int n){
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
		if(fast.next!=null){
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
	tmp1=tmp1.next;
	len1++;
	}

	while(tmp2!=null){
	tmp2=tmp2.next;
	len2++;
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

	tmp1=tmp1.next;
	tmp2=tmp2.next;
	if(tmp1.val==tmp2.val) return tmp1;
	}

return null;
}


##find the beginning node of cycle (Linked List)

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}

public ListNode findBegin(ListNode head){
	ListNode fast=head;
	ListNode slow=head;

	while(fast!=null){
		if(fast.next!=null){
			fast=fast.next.next;
		}else{
			fast=fast.next;
		}

		slow=slow.next;
		if(fast==slow) break;
	}

	fast=head;

	while(fast!=null&&slow!=null){
		
		fast=fast.next;
		slow=slow.next;

		if(fast==slow) return fast;
	}
return null;
}

##LRU Cache

##Minimum Depth of Binary Tree

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public int findMin(TreeNode root){
	LinkedList<TreeNode> que=new LinkedList<TreeNode>();

	que.addLast(root);
	que.addLast(null);

	int depth=0;

	while(!que.isEmpty()){
		TreeNode firstNode=que.removeFirst();

		if(firstNode!=null){
			
			if(firstNode.left==null&&firstNode.right==null){
				return depth+1;
			}

			if(firstNode.left!=null){
				findMin(root.left);
			}
			if(firstNode.right!=null){
				findMin(root.right);
			}


		}else{
			depth++;
			if(!que.isEmpty()){
				que.addLast(null);
			}
		}
	}

return depth;
}


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

##Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


##MaximumSubarray


##LinkRightNode

Link all the same level node from left to right by using "Right" field.

class Node
{
    public Node[] Children;
    public Node Right;
    public int val;
    Node(int x){val=x;}
}

