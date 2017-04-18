/*

# Must write within 1 minute

http://collabedit.com/yjege

Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			List--->int len=list.size();
			
			String.valueOf(char[] ch);

			Arrays.sort(xxxx[]);
			Collections.sort(List<xxxx>);


str.length()
arr.length;
int len=list.size();

String.valueOf(char[] ch);

Arrays.sort(xxxx[]);
Collections.sort(List<xxx>);


##Clone Undirected graph. 

Each node in the graph contains a label and a list of its neighbors.

class UndirectedGraphNode {
      int label;
      ArrayList neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList(); }
  };
  
Implementation with DFS

Implementation with BFS

##Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.(KMP)


## Given a sorted (in increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height.  
		
	public void convert(int[] nums,int left,int right){
	
	if(left>right){
	return null;
	}

	int middle=low+((right-left)>>1);   //  >>1       (right-left)/2
	
	TreeNode root=new TreeNode(nums[middle]);
	root.left=convert(nums,left,middle-1);
	root.right=convert(nums,middle+1,right);

	return root;
	}


			
##Input m and an input Array,    Pick up some numbers from the input array, to fulfill the sum of them is equal to m. --can repeat pick up numbers

##Input n,m    Pick up some numbers from 1,2,3....n, to fulfill the sum of them is equal to m. (can repeat)


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

##Input n,m    Pick up some numbers from 1,2,3....n, to fulfill the sum of them is equal to m. (0/1 bag)



##Binary operation / Bit operations  --- The sum of two binary numbers

	public static String addBinary(String a, String b){
	if(a==null || a.length()==0){
		return b;
	}

	if(b==null || b.length()==0){
		return a;
	}

	int currA=a.length()-1;
	int currB=b.length()-1;
	int flag=9;
	StringBuilder sb=new StringBuilder();

	while(currA>=0||currB>=0){
		int va=0;
		int vb=0;

		if(currA>=0){
			va=a.charAt(currA)=='0'? 0:1;
			currA--;
		}

		if(currB>=0){
			vb=b.charAt(currB)=='0'?0:1;
			currB--;
		}

		int sum=va+vb+flag;
		if(sum>=2){
			sb.append(sum-2);
			flag=1;
		}else{
			sb.append(sum);
			flag=0;
		}
	}

	if(flag==1){
	sb.append("1");
	}

	return sb.reverse().toString();
	}

##PreOrder Traversal

Without using recursion:

	public List<Integer> preorderTraversal(TreeNode root){
		
		Stack<TreeNode> s=new Stack<TreeNode>();
		s.push(root);

		ArrayList<Integer> arr=new  ArrayList<Integer>();
		while(!s.isEmpty()){
			TreeNode node=s.pop();
		
		if(node!=null){
			arr.add(node.val);
		}
		if(node.right!=null){
			s.push(node.right);
		}

		if(node.left!=null){
			s.push(node.left);
		}
 
		}

		return arr;
	}


Using recustion:

public TreeNode{
	String val;
	TreeNode left;
	TreeNode right;
}

public void preOrder(TreeNode root){
		if(root!=null){
			System.out.println(root.val);
		if(root.left!=null) preOrder(root.left);
		if(root.right!=null) preOrder(root.right);
		}
 
}

##InOrder Traversal

public void InOrder(TreeNode root){
	if(root!=null){
	if(root.left!=null){
		InOrder(root.left);
	}

		if(root!=null) {
	System.out.println(root.val);
		}

	if(root.right!=null){
		InOrder(root.right);
	}

	}
}



##PostOrder Traversal


##LevelOrder Traversal

	public static List<List<Integer>> levelOrder(TreeNode root){
	
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

			//reset the list arraylist:
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



##Deepth of binary tree Traversal


public int deepOfTree(TreeNode root){
	

	if(root==null)  return 0;

	int height=0;

	LinkedList<Integer> que=new LinkedList<Integer>();
	
	que.add(root);
	que.add(null);

	while(!que.isEmpty()){
		TreeNode firstNode=que.removeFirst();

		if(firstNode==null){
			if(!que.isEmpty()) que.addLast(null);
			hight++;
		}else{
			if(firstNode.left!=null) que.add(firstNode.left);
			if(firstNode.right!=null) que.add(firstNode.right);
		}
	}
return height;

}




##Linked List Traversal


public ListNode{
	int val;
	ListNode next;
}



	public void traversal(ListNode root){

		while(root!=null){
			System.out.println(root.val);
			root=root.next;
		}

	}



##Fibonacci Number
1 1 2 3 5......

public long finFib(int n){
	long v3=0;

	long v1=1;
	long v2=1;

	if(n==0||n==1){
		return 1;
	}

	for(int i=1;i<n;i++){
		v3=v1+v2;
		v1=v2;
		v2=v3;
	}

	return v3;
}




##BFS

##DFS

##Judge whether has cycle

public ListNode{
	int val;
	ListNode next;
}

public static boolean hasCycle(ListNode head){

	ListNode first=head,second=head;
	
	if(head==null) return false;

	if(head.next==null) return false;

	int j=0;
	
	while(first.next!=null){
			first=first.next;
			j++;
			if(j==2){
			j=0;
			second=second.next;
			}
		if(first==second) return true;
	}

	
}

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




