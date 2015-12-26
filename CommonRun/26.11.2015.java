# Must write within 1 minute

http://collabedit.com/yjege

Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			List--->int len=list.size();
			
			String.valueOf(char[] ch);

			Arrays.sort(xxxx[]);
			Collections.sort(List<xxxx>);



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
	public int findIndex(String str,String subString){

		//input validation
		if(str==null || subStr==null) return -1;
		if(str.length()<subStr.length()) return -1;
		if(subStr.length()==0) return -1;
		if(str.equals("")&&subStr.equals("")) return 0;

		//KMP
		int firstMatchedIndex=KMP(str,subStr);

		return firstMatchedIndex<0?-1:firstmatchedIndex;
	}

	public int[] getNextArr(String subStr){

		int subStr_len=subStr.length();
		int[] next=new int[subStr_len];
		int prefix_index=-1;
		int suffix_index=0;

		while(suffix_index<subStr_len){
			if(prefix_index==-1 || subStr.charAt(prefix_index)==str.charAt(suffix_index)){

				int numMatched_prefix_and_suffix=prefix_index+1;
				if(suffix_index+1>=subStr_len) break;
				next[suffix_index+1]=numMatched_prefix_and_suffix;

				prefix_index++;
				suffix_index++;
			}else{
				prefix_index=next[prefix_index];
			}

		}
		return next;
	}

	public int KMP(String str,String subStr){

		int str_len=str.length();
		int subStr_len=subStr.length();

		int str_start=0;
		int subStr_start=0;

		while(str_start<str_len&&subStr_start<subStr_len){
			if(subStr_start==-1 || subStr.charAt(subStr_start)==str.charAt(str_start)){

					str_start++;
					subStr_start++;

			}else{

				subStr_start=next[subStr_start];
			}

		}

		if(subStr_start>=subStr_len){
			return subStr_start-subStr_len;
		}else return -1;

	}



## Given a sorted (in increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height.  
			
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
				if(m<0) return;

				for(int i=0;i<nums.length;i++){

					if(!arr.isEmpty() && nums[i]<arr.get(arr.size()-1)){
						continue;
					}

					arr.add(nums[i]);
					getCombination(sum-nums[i],arr);
					if(!arr.isEmpty()){
						arr.remove(arr.size()-1);
					}

				}

			}



			
##Input m and an input Array,    Pick up some numbers from the input array, to fulfill the sum of them is equal to m. --can repeat pick up numbers

	LinkedList<Integer> list=new LinkedList<Integer>();

	public void findSum(int sum,int n){
		if(sum<=0 || n<=0) return;
		if(sum==n){

			for(int i=list.size()-1;i>0;i--){
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}else{

			list.push(n);
			findSum(sum-n,n-1);
			list.pop();
			findSum(sum,n-1);
		}
	}


##MaximumSubarray

	public void findMax(int[] nums){
		int max_ending_here=nums[0];
		int max_so_far=nums[0];
		for(int i=1;i<nums.length;i++){
			max_ending_here=Math.max(nums[i],max_ending_here);
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

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val=x;}
	}


	List<String> result=new ArrayList<String>();
	List<TreeNode> list=new ArrayList<TreeNode>();

	public void findPath(TreeNode root)
{
		if(root!=null){
			list.add(root);

			if(root.left==null && root.right==null){
					String str="";
					for(TreeNode tmp:list)
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

	for(Iterator it=set.iterator();it.hasNext();){
		System.out.println(it.next());
	}


##HashMap iteration

	for(Entry<String,String> entry:entrySet()){
		System.out.println(entry.getKey()+"="+entry.getValue());
	}


##HashTable iteration

Hashtable table=new Hashtable();
table.put("fds","fds");

Enumeration e=table.keys();
while(e.hasMoreElements()){
	String str=(String)e.nextElement();
	System.out.println(str+"="+table.get(str));
}






