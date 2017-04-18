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

str.length();
arr.length;
int len=list.size();

str.length();
arr.length;
int len=list.size();

Arrays.sort(xxx[]);
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
	 

##PreOrder Traversal

public TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
	this.val=val;
	}
}

public List<Integer> preOrderTraversal(TreeNode root){
	
	if(root!=null){
	System.out.println(root.val);

	if(root.left!=null) preOrderTraversal(root.left);

	if(root.right!=null) preOrderTraversal(root.right);

	}

	return null;

}



without using the recursion:

public List<Integer> preOrderTraversal(TreeNode root){
	
	Stack<TreeNode> s=new Stack<TreeNode>();
	s.push(root);
	ArrayList<Integer> arr=new ArrayList<Integer>();

	while(!s.isEmpty()){
		TreeNode node=s.pop();
		if(node!=null){
			arr.add(node.val);
			if(node.right!=null){
				s.push(node.right);
			}

			if(node.left!=null){
				s.push(node.left);
			}

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
	TreeNode(int x){
	val=x;
	}
}


public void levelOrder(TreeNode root){
	LinkedList<TreeNode> que=new LinkedList<TreeNode>();

	que.addLast(root);

	while(!que.isEmpty()){
	TreeNode firstNode=que.removeFirst();

	if(firstNode==null){
		System.out.println(null);
	}else{
		System.out.println(firstNode.val);
		if(firstNode.left!=null){
			que.addLast(firstNode.left);
		}
		if(firstNode.right!=null){
			que.addLast(firstNode.right);
		}

	}
	}
}


##Deepth of binary tree Traversal


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

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

List<String> result=new ArrayList<String>();
List<TreeNode> list=new ArrayList<TreeNode>();

public void findPath(TreeNode root){
	if(root!=null){
	list.add(root);
	}

	if(root.left==null&&root.right==null){
	String str="";
	for(TreeNode tmp:list){
	str+=tmp.val;
	result.add(str);
	list=new ArrayList<TreeNode>();
	}

	if(root.left!=null){
		findPath(root.left);
		list.remove(list.size()-1);
	}

	if(root.right!=null){
		findPath(root.right);
		list.remove(list.size()-1);
	}


	}
}



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




