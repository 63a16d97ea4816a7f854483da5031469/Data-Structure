/*

# Must write within 1
Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			String.valueOf(char[] ch);

##Binary operation / Bit operations
	 

##PreOrder Traversal



By using recursion:

Class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}


public void TraversalTree(TreeNode root){
	
	if(root!=null){
		System.out.println(root.val);
		if(root.left!=null)  {TraversalTree(root.left);}
		if(root.right!=null) {TraversalTree(root.right);}
	}
}



##InOrder Traversal

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public void TraversalTree(TreeNode root){
	if(root!=null){
		
		if(root.left!=null) TraversalTree(root.left);
		System.out.println(root.val);
		if(root.right!=null) TraversalTree(root.right);

	}
}





##PostOrder Traversal

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){val=x;}
}

public void TraversalTree(TreeNode root){
	if(root.left!=null) TraversalTree(root.left);
	if(root.right!=null) TraversalTree(root.right);
	System.out.println(root.val);
}



##LevelOrder Traversal

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}


public void TraversalTree(TreeNode root){
	
	Queue<TreeNode> que=new Queue<TreeNode>();

	que.addLast(root);
	que.addLast(null);

	while(!que.isEmpty()){
	
	TreeNode firstNode=que.removeFirst();

	  if(firstNode==null){
		
		if(!que.isEmpty){
			que.addLast(null);
		}

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

public void TraversalTree(TreeNode root){

	Queue<TreeNode> que=new Queue<TreeNode>

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
	System.out.println(que.val);
	if(firstNode.left!=null) que.addLast(firstNode.left);
	if(firstNode.right!=null) que.addLast(firstNode.right);
	}

	}


}



##Linked List Traversal

class LinkedNode{
	int val=0;
	LinkedNode next;
	LinkedNode(int x){val=x;}
}

public void TraversalLinkedList(LinkedNode node){

	while(node!=null){
		System.out.println(node.val);
		node=node.next;
	}
}


##Fibonacci Number

by using recursion:

1 1 2 3 5 8 13 21

public int getN(int n){
	
	if(n==0||n==1) return 1;

	return getN(n-1)+getN(n-2);

}


by using for iteration:

public int getN(int n){

if(n==0||n==1) return 1;

int a=1;   //prev 
int b=1;   //next
int sum=0;  //sum
for(int i=1;i<n;i++){
	sum=a+b;
	a=b;
	b=sum;
}

}


##BFS

class TreeNode{
	
	int val;
	TreeNode left;
	TreeNdoe right;
	TreeNode(int x){val=x;}

}


public void TraversalTree(TreeNode root){
	
	Queue<TreeNode> que=new Queue<TreeNode>();
	que.add(root);
	
	while(!que.isEmpty()){
	  TreeNode firstNode=que.removeFirst();
	  if(firstNode!=null) {
	System.out.println(firstNode.val);
	if(firstNode.left!=null) que.addLast(firstNode.left);
	if(firstNode.right!=null) que.addLast(firstNode.right);
	  }
	}


}

##DFS

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public void TraversalTree(TreeNode root){
	
	if(root!=null){
	if(root.left!=null) TraversalTree(root,left);
	System.out.println(root.val);
	if(root.right!=null) TraversalTree(root.right);
	}
}




##Judge whether has cycle

class LinkedNode{
	int val=0;
	LinkedNode next;
	LinkedNode(int x){val=x;}
}

public boolean isContainCycle(LinkedNode root){
	LinkedNode fast=root;
	LinkedNode slow=root;

	while(fast!=null&&slow!=null){
	
	if(fast.next!=null){
	fast=fast.next.next;
	}else{
	fast=fast.next;
	}

 	slow=slow.next;

	if(slow==fast) return true;


	}

return false;
}



##find the insection node of two single lists

class LinkedNode{
	int val;
	LinkedNode next;
	LinkedNode(int x){val=x;}
}


public LinkedNode findIntersection(LinkedNode head1, LinkedNode head2){
	
	LinkedNode l1=head1;
	LinkedNode l2=head2;

	
	int len1=0;
	int len2=0;

	while(l1!=null){
	len1++;
	l1=l1.next;
	}

	while(l2!=null){
	len2++;
	l2=l2.next;
	}

	int diff=0;

	if(len1>len2){
	 diff=len1-len2;
	
	l1=head1;
	//adjust the l1's start node postion
	while(diff>0){
		l1=l1.next;
		diff--;
	}

	}
	
	if(len2>len1){
	
	diff=len2-len1;

	l2=head2;
	//adjust the l2's start node position

	while(diff>0){
	l2=l2.next;
	diff--;
	}

	}


	while(l2!=null&&l1!=null){
	
	if(l2.val!=l1.val) return false;

	}

 
return true;

}

##find the beginning node of cycle (Linked List)

class LinkedNode{
	int val;
	LinkedNode next;
	LinkedNode(int x){val=x;}
}

public LinkedNode findStartNode(LinkedNode head){
	
	LinkedNode fast=head;
	LinkedNode slow=head;

	int meetTime=0;

	while(fast!=null&&slow!=null){
	
	if(fast.next!=null)  fast=fast.next.next;
	slow=slow.next;

	if(fast.val==slow.val) {
	meetTime++;
	break;}

	}

	fast=head;

	while(fast!=null&&slow!=null){
		
		fast=fast.next;
		slow=slow.next;
		if(meetTime==1){
		return fast;
		}
	}

return null;

}


##LRU Cache

##Minimum Depth of Binary Tree







##Maximum Depth of Binary Tree

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}


public int findMaxDepth(TreeNode root){
	
	if(root==null) return 0;
	//because we are using the level traversal, so the level's depth is the max depth.
	int maxDepth=0;

	Queue<TreeNode> que=new Queue<TreeNode>();

	que.add(root);
	que.add(null);
	while(!que.isEmpty()){
		TreeNode firstNode=que.removeFirst();

		if(firstNode==null){
 		   maxDepth++;

		if(!que.isEmpty()){
			que.add(null);
		}

		}
	

	}

return maxDepth;
}





##Binary Search





##Implement Queue using stacks





##Implement Stack using Queues






##invert binary tree





##Swap two variables without using extra space

public void swap(int a, int b){
	a=a^b;
	b=a^b;
	a=a^b;
}

##Merge two sorted arrays ===> array operation




##Merge two sorted lists




##O(1) time complexity to get minimum value of stack

//the s1 is used to save the normal values
Stack<Integer> s1=nwe Stack<Integer>();

//the s2 is used to save the minimum value
Stack<Integer> s2=new Stack<Integer>();

public void push(int val){
	s1.push(val);

	if(s2.isEmpty()) {s2.push(val);
	}else{
		   if(val<s2.peek()){
			   s2.push(val);
		   }else{
			   s1.push(s1.peek());
		   }
	}
}


public void pop(){
	s1.pop();
	s2.pop();
}


public void peek(){
	return s1.peek();
}

public int minValue(){
	return s2.peek();
}



##Move-zeroes  ===> array operation


Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

The solution:  find the first zero and then move it to the first find non-zero postion (swap them)
[1,2,3,4,6,0,0,0,0,0,0,1,2,3] ===>[1,2,3,4,6,1,0,0,0,0,0,0,2,3]


public void moveZero(int[] nums){
	
	int i=0;
	while(i<nums.length){
	
	int p=0;

	if(nums[i]==0){
	   p=i+1;

	//find the following non-zero number
	while(p<nums.length){
	   if(nums[p]!=0){
		break;
	   }
	   p++;
	}

 

if(nums[p]!=0){
nums[i]=nums[p];
nums[p]=0;
}


	}


	}


	i++;


}







##Palindrome Number (回文)

##Permutations (important)

## Find path of Binary Tree

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

 List<List<TreeNode>> result=new ArrayList<ArrayList<TreeNode>>();
 ArrayList<TreeNode> tmp=new ArrayList<TreeNode>();

public List<List<TreeNode>> findPath(TreeNode root){
	
	getPath(root);
	return result;

}





public void getPath(TreeNode root){
	
	if(root!=null){
		tmp.addLast(root);


	if(root.left==null&&root.right==null) {
	result.add(tmp);
	tmp=new ArrayList<TreeNode>();
		}


	if(root.left!=null){
		getPath(root.left);
		tmp.remove(tmp.size()-1);
	}

	if(root.right!=null){
		getPath(root.right);
		tmp.remove(tmp.size()-1);
	}

	}
}

##ReverseBits

32 bits:

  public int reverse(int n){
	
	StringBuilder sb=new StringBuilder(Integer.toBinaryString(n));
	
	sb.reverse();

	int tmpLength=32-sb.length();

	for(int i=0;i<tmpLength;i++){
	   sb.append("0");
	}

	sb.reverse();

	char[] sbchar=sb.toString().toCharArray();
	int head=0;
	int end=sb.length()-1;

	while(head<end){
		int tmp=sbchar[head];
		sbchar[head]=sbchar[end];
		sbchar[end]=tmp;
	
	head++;
	end--;
	}

	Long result=Long.parseLong(String.valueOf(sbchar),2);

   return (int)result;
  }


##Reverse Integer

 String ----> str.length();

 Array ----> arr.length;


	public int reverseInt(int n) {

		String str = "";

		while (n != 0) {
			str += n % 10;
			n /= 10;
		}
 
		int result = 0;
		for (int i = 0; i < str.length(); i++) {

			int curr = Integer.parseInt(str.charAt(i) + "");
			result += Math.pow(10, str.length()-1-i) * curr;

		}

		return result;

	}




##Reverse Linked List

class LinkedNode{
	int val=0;
	LinkedNode next;
	LinkedNode(int x){val=x;}
}


public LinkedNode reverseLinkedList(LinkedNode head){

  LinkedNode prev=null;
  LinkedNode curr=head;
  LinkedNode next=head.next;

  while(curr!=null){
  	next=curr.next;
	curr.next=prev;

 // move the pointers.
 	prev=curr;
	curr=next;
  }

 return prev;
	
}

##Rotate Array

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

   (index+k)%length=(0+3)%6=3

public void rotateArray(int[] arr){

	int[] n=arr.clone();

	for(int i=0;i<arr.length;i++){
	arr[(i+k)%arr.length]=n[i];
	}

}




##Reverse Array

	public int[] reverseArray(int[] nums){
		
		int head=0;
		int end=nums.length-1;

		while(head<end){
		  int tmp=nums[head];
		  nums[head]=nums[end];
		  nums[end]=tmp;
		  head++;
		  end--;
		}

		return nums;

	}

##Is Same Tree (/same-tree/)



## Symmetric Tree



## valid-anagram (/valid-anagram/)














