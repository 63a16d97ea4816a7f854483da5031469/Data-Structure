/*


# Must write within 1 minute
Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			List--->int len=list.size();
			
			String.valueOf(char[] ch);
			
			
##Input n,m    Pick up some numbers from 1,2,3....n, to fulfill the sum of them is equal to m. --can repeat pick up numbers			

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
			if(!arr.isEmpty() && nums[i]<arr.get(arr.size()-1))
			continue;

			arr.add(nums[i]);
			getCombination(m-nums[i],arr);
			if(!arr.isEmpty()){
				arr.remove(arr.size()-1);
			}
		}
	}
			


##Input n,m    Pick up some numbers from 1,2,3....n, to fulfill the sum of them is equal to m. (can repeat)

LinkedList<Integer> list=new LinkedList<Integer>();

	public void pickUpSum(int sum,int n){
		if(sum<=0||n<=0) return;
		if(sum==n){
			for(int i=list.size()-1;i>0;i--){
				System.out.print(list.get(i));
			}
		}
		
		list.push(n);
		pickUpSum(sum-n,n-1);
		list.pop();
		pickUpSum(sum,n-1);
	}


##MaximumSubarray

public int findMax(int[] nums){
	int max_ending_here=nums[0];
	int max_so_far=nums[0];

	for(int i=1;i<nums.length;i++){
		max_ending_here=Math.max(max_ending_here,max_ending_here+nums[i]);
		max_so_far=Math.max(max_ending_here,max_so_far);
	}
	return max_so_far;
}


##LinkRightNode

Link all the same level node from left to right by using "Right" field.

class Node
{
    public Node[] Children;
    public Node Right;
    public int val;
    Node(int x){val=x;}
}

public void linkRight(Node root){
	
	LinkedList<Node> que=new LinkedList<Node>();

	que.addLast(root);
	que.addLast(null);

	Node listRightNode=null;

	while(!que.isEmpty()){
		Node firstNode=que.removeFirst();

		
	}

}



##Input n,m    Pick up some numbers from 1,2,3....n, to fulfill the sum of them is equal to m. (0/1 bag)



##Binary operation / Bit operations  --- The sum of two binary numbers
	 

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


