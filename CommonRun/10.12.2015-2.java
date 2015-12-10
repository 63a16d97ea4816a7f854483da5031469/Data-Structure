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
		
		if(!arr.isEmpty()&&nums[i]<arr.get(arr.size()-1))
		continue;

		arr.add(nums[i]);
		getCombination(m-nums[i],arr);
		if(!arr.isEmpty()){
		arr.remove(arr.size()-1);
		}
	}

}
 

##Input n,m    Pick up some numbers from 1,2,3....n, to fulfill the sum of them is equal to m. (can repeat)


##MaximumSubarray

public int findMax(int[] nums){
	int max_ending_here=nums[0];
	int max_so_far=nums[0];

	for(int i=1;i<nums.length;i++){
		max_ending_here=Math.max(max_ending_here,max_ending_here+nums[i]);
		max_so_far=Math.max(max_so_far,max_ending_here);
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
				for(Node tmp:firstNode.Children)
				que.addLast(tmp);
			}

			linksRightNode=firstNode;
		}
	}

}


##Input n,m    Pick up some numbers from 1,2,3....n, to fulfill the sum of them is equal to m. (0/1 bag)


List<Integer> list=new ArrayList<Integer>();

public void find_factor(int sum,int n){
	if(sum<=0 ||n<=0) return;

	if(sum==n){
		for(int i=list.size()-1;i>0;i--)
		System.out.print(list.get(i)+" ");
		System.out.println();
	}
	list.push(n);
	find_factor(sum-n,n-1);
	list.pop();
	find_factor(sum,n-1);
}

 


##Binary operation / Bit operations  --- The sum of two binary numbers

public String addBinaryString(String a,String b){

	if(a==null||a.length()==0) return b;
	if(b==null||b.length()==0) return a;

	int currA=a.length()-1;
	int currB=b.length()-1;
	int flag=0;

	StringBuilder sb=new StringBuilder();

	while(currA>=0||currB>=0){
		int va=0;
		int vb=0;

		if(currA>=0){
			va=a.charAt(currA)==0?0:1;
			currA--;
		}

		if(currB>=0){
			vb=b.charAt(currB)==0?0:1;
			currB--;
		}

		int sum=va+vb+flag;

		if(sum>=2){
			sb.append(sum-2);
			flag=1;
		}else{
			sb.append(sum);
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
			System.out.print(firstNode.val+" ");
			levelOrder(firstNode.left);
			levelOrder(firstNode.right);
		}else{
			System.out.print(null+" ");
		}
	}
}

##Deepth of binary tree Traversal

public int findDepth(TreeNode root){
	int depth=0;

	LinkedList<TreeNode> que=new LinkedList<TreeNode>();
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
				
				if(firstNode.left!=null){
					que.addLast(firstNode.left);
				}

				if(firstNode.right!=null){
					que.addLast(firstNode.right);
				}
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

public void loopList(ListNode head){
	ListNode tmp=head;
	while(tmp!=null){
	System.out.println(tmp);
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
	len1++;
	tmp1=tmp1.next;
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

		if(slow==fast) break;
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
	int depth=0;

	LinkedList<TreeNode> que=new LinkedList<TreeNode>();
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
				
				if(firstNode.left==null&&firstNode.right==null){
					return depth+1;
				}

				if(firstNode.left!=null) que.addLast(firstNode.left);
				if(firstNode.right!=null) que.addLast(firstNode.right);
			
			}
	}
	return depth;
}


##Maximum Depth of Binary Tree

##Binary Search

public int binarySearch(int[] nums,int key){
	int low=0;
	int high=nums.length-1;

	while(low<=high){
	int middle=low+((high-low)>>1);

	if(nums[middle]>key){
		high=middle-1;
	}else if(nums[middle]<key){
		low=middle+1;
	}else 
	return middle;
	}

	return -1;
}


##Implement Queue using stacks

##Implement Stack using Queues

##invert binary tree

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public void invertTree(TreeNode root){
	if(root!=null){
		if(root.left!=null||root.right!=null){
				TreeNode tmp=root.left;
				root.left=root.right;
				root.right=tmp;
		}

		if(root.left!=null){
			invertTree(root.left);
		}

		if(root.right!=null){
			invertTree(root.right);
		}
	}
}


##Swap two variables without using extra space

##Merge two sorted arrays ===> array operation

##Merge two sorted lists

##O(1) time complexity to get minimum value of stack

##Move-zeroes  ===> array operation

public void moveZero(int[] nums){
	int p=0;

	while(p<nums.length){
		if(nums[p]==0){
			for(int i=p+1;i<nums.length;i++){
				if(nums[i]!=0){
					nums[p]=nums[i];
					nums[i]=0;
					break;
				}
			}
		}

		p++;
	}
}


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


