

/*


# Must write within 1
Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			String.valueOf(char[] ch);

##Binary operation / Bit operations
	 

##PreOrder Traversal

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}


public void preOrderTraversal(TreeNode root){
	

	if(root!=null) {
	
	System.out.println(root.val);

	if(root.left!=null){preOrderTraversal(root.left);}
	if(root.right!-null){preOrderTraversal(root.right);}
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

public List<TreeNode> levelTraversal{
	
	List<TreeNode> result=new ArrayList<TreeNode>();

	LinkedList<TreeNode> que=new LinkedList<TreeNode>();
	que.addLast(root);

	while(!que.isEmpty()){
		TreeNode firstNode=que.removeFirst();

		if(firstNode!=null) {
			result.add(firstNode);
		
		if(firstNode.left!=null) que.addLast(firstNode.left);
		if(firstNode.right!=null) que.addLast(firstNode.right);

		}
	}

return result;

}


##Deepth of binary tree Traversal

 
Level Traversal:


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}


public int levelTraversal(TreeNode root){
	
	LinkedList<TreeNode> que=new LinkedList<TreeNode>();

	int levelCount=0;
	que.addLast(root);
	que.addLast(null);

	while(!que.isEmpty()){
	
	TreeNode firstNode=que.removeFirst();

	if(firstNode==null) {
	
	levelCount++;

	if(!que.isEmpty()){
		que.addLast(null);
	}

	}else
	{
	
	if(firstNode.left!=null) {
	que.addLast(firstNode.left);
	}

	if(firstNode.right!=null){
	que.addLast(firstNode.right);
	}
	}
	}

}

##Linked List Traversal

class LinkedNode{
	int val;
	LinkedNode next;
	LinkedNode(int x){val=x;}
}

public void loopLinkedList(LinkedNode head){
	
	LinkedNode tmp=head;

	while(tmp!=null){
	System.out.println(tmp.val);
	tmp=tmp.next;
	}

}




##Fibonacci Number


by using recursion:

public int getN(int n){
	if(n==0||n==1) return 1;

	return getN(n-1)+getN(n-2);
}


without using recursion:
0 1 2 3
1 1 2 3

public int getN(int n){
	
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

##find the insection node of two single lists

O(n)

class LinkedNode{
	int val;
	LinkedNode next;
	LinkedNode(int x){val=x;}
}


public LinkedNode findInsection(LinkedNode l1, LinkedNode l2){
	
	int tmp1=l1;
	int tmp2=l2;

	int len1=0,len2=0;

	while(tmp1!=null){
	tmp1=tmp1.next;
	len1++;
	}

	while(tmp2!=null){
	tmp2=tmp2.next;
	len2++;
	}

	if(len1>len2){
	  tmp1=l1;
	  for(int i=0;i<len1-len2;i++){
			tmp1=tmp1.next;
	  }

	}else if(len2>len1){
		tmp2=l2;
		for(int i=0;i<len2-len1;i++){	 
		tmp2=tmp2.next;
		}
		}

 
	while(tmp1!=null&&tmp2!=null){
	

	if(tmp1.val==tmp2.val){
	  return tmp1;
	}else{
	tmp1=tmp1.next;
	tmp2=tmp2.next;
	}

	}





return null;

} 
 
##find the beginning node of cycle (Linked List)


class LinkedNode{
	int val;
	LinkedNode next;
	LinkedNode(int x){val=x;}
}


public LinkdedNode findFirst(LinkedNode head){
	
	LinkedNode fast=head;
	LinkedNode slow=head;

	while(fast!=null){

	if(fast.next!=null)
	fast=fast.next.next;

	slow=slow.next;

	if(fast==slow){
	break;
	}

	}

	fast=head;

	while(fast!=null){

	fast=fast.next;
	slow=slow.next;

	if(fast==slow){
		return fast;
	}

	}

return null;
}



##LRU Cache

##Minimum Depth of Binary Tree

##Maximum Depth of Binary Tree

##Binary Search

public int binarySearch(int nums[], int key){
	
	int low=0;
	int high=nums.length-1;

	while(low<=high){
		int middle=(low+high)/2;

		if(nums[middle]==key) return middle;

		if(nums[middle]>key){
			high=middle-1;
		}

		if(nums[middle]<key){
			low=middle+1;
		}

	}

	return -1;
}

 

Recursion implementation:
 
	public static int binarySearchRecursion(int[] nums, int key) {
	    return binarySearchRecursionSub(nums, 0, nums.length-1, key);
	}

	public static int binarySearchRecursionSub(int[] nums, int start, int end, int key) {
	    int middle = (start + end) / 2;
	    
 
	    if(end < start) {
	        return -1;
	    } 
	    

	    if(key==nums[middle]) {
	        return middle;
	    } else if(key<nums[middle]) {
	        return binarySearchRecursionSub(nums, start, middle - 1, key);
	    } else {
	        return binarySearchRecursionSub(nums, middle + 1, end, key);
	    }
	}

##Implement Queue using stacks

##Implement Stack using Queues

##invert binary tree

Input:
[4,1,null,2,null,3]
Output:
[4,null,1,null,2,3]
Expected:
[4,null,1,null,2,null,3]

4 1  null 2  null 3  null  null  null ------
4  null 1  null 2  null 3  null  null 


		TreeNode root=new TreeNode(4);
 
		TreeNode secLeft=new TreeNode(1);
		TreeNode thirdLeft=new TreeNode(2);
		TreeNode fourthLeft=new TreeNode(3);
		secLeft.left=thirdLeft;
		thirdLeft.left=fourthLeft;

		root.left=secLeft;
		
 

			4
		   / \
		  1   null
		 / \
		2   null
	   /
	  3
			
			 4
		   /   \
		 null   1
		       / \
            null  2
                 /  \
				null 3


Input:
[4,1,null,2,null,3]
Output:
[4,null,1,null,2,3]
Expected:
[4,null,1,null,2,null,3]

4 1  null 2  null 3  null  null  null ------
4  null 1  null 2 3  null  null  null 


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public void invertBinary(TreeNode root){
	if(root!=null){
		if(root.left!=null) invertSubTree(root.left);
		if(root.right!=null) invertSubTree(root.right);
		invertSubTree(root);
	}
}


public void invertSubTree(TreeNode node){
	if(node==null) return;
	if(node!=null){
		TreeNode tmp=node.left;
		node.left=node.right;
		node.right=tmp;
	}
}
 


    public static TreeNode invertTree(TreeNode root){
    	
    	if(root==null||(root.left==null&&root.right==null)) return root;	
    	
    	
    	if(root!=null){
    		
        	if(root.left!=null||root.right!=null){
            	TreeNode tmp=root.right;
        		root.right=root.left;
        		root.left=tmp;
        	}
    		
    		if(root.left!=null)
    			invertTree(root.left);
    		
    		if(root.right!=null)
    			invertTree(root.right);
    	}
    	
    	   
    	return root;
    	
    }



	public static TreeNode invertTree2(TreeNode root){
 
		if(root!=null){
			
        	if(root.left!=null||root.right!=null){
			TreeNode tmp=root.left;
			root.left=root.right;
			root.right=tmp;
		}

			if(root.left!=null) invertSubTree(root.left);
			if(root.right!=null) invertSubTree(root.right);

		}

		return root;

	}



 
##Swap two variables without using extra space

public void swap(int a,int b){
	a=a^b;
	b=a^b;
	a=a^b;
}


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

List<List<Integer>> result=new ArrayList<ArrayList<Integer>>();


public List<List<Integer>> getTreePath(TreeNode root){
	return getPath(root,new ArrayList<Integer>());
}




public List<List<Integer>> getPath(TreeNode root,List<Integer> list){

  
  if(root!=null){
	list.add(root.val);


	if(root.left==null&&root.right==null) {
	   result.add(list);

	   list=new ArrayList<Integer>();
	}

	if(root.left!=null) {
		getPath(root.left,list);
		list.remove(list.size()-1);
	}	

	if(root.right!=null){
		getPath(root.right,list);
		list.remove(list.size()-1);
	}

  }

return result;

}





##ReverseBits


##Reverse Integer






##Reverse Linked List


class LinkedNode{
	int val;
	LinkedNode next;
	LinkedNode(int x){val=x;}
}



public void reverseLinkedList(LinkedNode head){

	if(head!=null){

	LinkedNode prev=null;
	LinkedNode curr=head.next;
	LinkedNode nextNext=head.next;

	while(curr!=null){
		nextNext=curr.next;
		curr.next=prev;
		prev=curr;
		curr=nextNext;
	}

	}

}

 


##Rotate Array

move to right side k steps.

public void rotateArr(int[] nums,int k){
	
	int[] newArr=nums.clone();

	for(int i=0;i<nums.length;i++){
	   nums[i]=newArr[(i+k)/nums.length];
	}

}



##Reverse Array

##Is Same Tree (/same-tree/)

## Symmetric Tree

## valid-anagram (/valid-anagram/)