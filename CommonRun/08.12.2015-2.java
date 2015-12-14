
/*


# Must write within 1 minute
Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			List--->int len=list.size();
			
			String.valueOf(char[] ch);


##Input n,m    Pick up some numbers from 1,2,3....n, to fulfill the sum of them is equal to m. (can repeat)

int[] nums;

public void findSum(int[] nums,int sum){
	this.nums=nums;
	combine(sum);
}

public void combine(int m){
	if(m<1) return;
	ArrayList<Integer> arr=new ArrayList<Integer>();
	getCombination(m,arr);
}

public void getCombination(int m,ArrayList<Integer> arr){
	if(m==0 && arr.size()>=1){
		for(int tmp:arr)
		System.out.print(tmp+" ");

		System.out.println();
		return;
	}

	if(m<0) return;

	for(int i=0;i<nums.length;i++){
		if(!arr.isEmpty()&&nums[i]<arr.get(arr.size()-1))
		continue;

		arr.add(nums[i]);
		getCombination(m-nums[i],arr);
		arr.remove(arr.size()-1);
	}
}

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

	public void linksRight(Node root){
		if(root==null) return; // consider the null case.

		LinkedList<Node> que=new LinkedList<Node>();
		que.addLast(root);
		que.addLast(null);

		Node linksRightNode=null;
		while(!que.isEmpty()){
			Node firstNode=que.removeFirst();
			if(firstNode==null){
				linksRightNode=null;
				if(!que.isEmpty()){
					que.addLast(null);
				}
			}else{
				if(linksRightNode!=null){
					linksRightNode.Right=firstNode;
				}

				if(firstNode.Children!=null){
					for(Node tmp:firstNode.Children){
						que.addLast(tmp);
					}
				}

				linksRightNode=firstNode;
			}
		}

	}





##Input n,m    Pick up some numbers from 1,2,3....n, to fulfill the sum of them is equal to m. (0/1 bag)



##Binary operation / Bit operations
	 

##PreOrder Traversal


##InOrder Traversal


##PostOrder Traversal


##LevelOrder Traversal


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


