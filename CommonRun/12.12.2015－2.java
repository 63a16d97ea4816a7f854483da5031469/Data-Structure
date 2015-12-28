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
		}

		if(m<1) return;

		for(int i=0;i<nums.length;i++){
			if(!arr.isEmpty()&& arr.get(arr.size()-1)<nums[i])
			continue;
			
			arr.add(nums[i]);
			getCombination(sum-nums[i],arr);
			if(!arr.isEmpty()){
				arr.remove(arr.size()-1);
			}

		}
	}


##Input n,m    Pick up some numbers from 1,2,3....n, to fulfill the sum of them is equal to m. (0/1 bag)

	LinkedList<Integer> list=new LinkedList<Integer>();

	public void find_factor(int sum,int n){
		if(sum<=0||n<=0) return;

		if(sum==n){
			
			for(int i=list.size()-1;i>0;i--){
				System.out.println(list.get(i));
			}

		}else{
			
			list.push(n);
			find_factor(sum-n,n-1);
			list.pop();
			find_factor(sum,n-1);
		}
	}



##MaximumSubarray

public int findMax(int[] nums,int sum){
	int max_ending_here=nums[0];
	int max_so_far=nums[0];

	for(int i=1;i<nums.length;i++){
		max_ending_here=Math.max(nums[i],max_ending_here+nums[i]);
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

public void linksRight(Node root){

	if(root==null) return; // consider the null case.

	LinkedList<Node> que=new LinkedList<Node>();

	que.addLast(root);
	que.addLast(null);

	Node linkRightNode=null;

	while(!que.isEmpty()){
			Node firstNode=que.removeFirst();

			if(firstNode==null){
				linkRightNode=null;
				if(!que.isEmpty()){
					que.addLast(null);
				}
			}else{
				
				if(linkRightNode!=null){
					linkRightNode.Right=firstNode;
				}

				if(firstNode.Children!=null){
					for(Node tmp:firstNode.Children){
						que.addLast(tmp);
					}
				}

				linkRightNode=firstNode;

			}
	}
}




##Binary operation / Bit operations  --- The sum of two binary numbers
	 
	 public void binarySum(String a,String b){
		if(a==null || a.length()==0) return b;
		if(b==null || b.length()==0) return a;

		int currA=a.length()-1;
		int currB=b.length()-1;
		int flag=0;

		StringBuilder sb=new StringBuilder();

		while(currA>=0||currB>=0){
			int va=0;
			int vb=0;


			if(currA>=0){
				va=a.charAt(currA)=='0'?0:1;
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


##InOrder Traversal


##PostOrder Traversal


##LevelOrder Traversal

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public void levelOrder(TreeNode root){
	
	LinkedList<TreeNode> que=new LinkedList<TreeNode>();
	que.addLast(root);

	while(!que.isEmpty()){
		TreeNode firstNode=que.removeFirst();

		if(firstNode!=null){
			System.out.println(firstNode.val);
			que.addLast(firstNode.left);
			que.addLast(firstNode.right);
		}else{
			System.out.println(null);
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
			depth++;
			if(!que.isEmpty()){
				que.addLast(null);
			}
		}else{
			if(firstNode.left!=null)
			findDepth(firstNode.left);

			if(firstNode.right!=null)
			findDepth(firstNode.right);
		}
	}

}


##Linked List Traversal

class TreeNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}

public void loopList(ListNode head){
	ListNode tmp=head;
	while(tmp!=null){
	System.out.println(tmp.val);
	tmp=tmp.next;
	}
}

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


