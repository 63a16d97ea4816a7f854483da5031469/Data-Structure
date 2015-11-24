/*




# Must write within 1
Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			String.valueOf(char[] ch);

##Binary operation / Bit operations

		StringBuilder nb = new StringBuilder(Integer.toBinaryString(n));

		StringBuilder nb=new StringBuilder(Integer.toBinaryString(n));

##PreOrder Traversal

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public void preOrderTraversal(TreeNode root){
	
	if(root!=null){
	
	System.out.println(root.val);

	if(root.left!=null){
		preOrderTraversal(root.left);
	}

	if(root.right!=null){
		preOrderTraversal(root.right);
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
	TreeNode(int x){val=x;}
}

 

public void getLevel(TreeNode root){
	
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

public int getDepth(TreeNode root){
	
	LinkedList<TreeNode> que=new LinkedList<TreeNode>();
	int depth=0;

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
	ListNode(int x){val=x;}
}


public void loopLinkedList(ListNode head){
	
	ListNode tmp=head;

	while(tmp!=null){
		
		System.out.println(tmp.val);
		tmp=tmp.next;
	}


}



##Fibonacci Number

By using recursion:

public int fibonacci(int n){
	if(n==0||n==1) return 1;

	return fibonacci(n-1)+fibonacci(n-1);
}



Do not using recursion:

public int fibonacci(int n){
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

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}

public ListNode findInsection(ListNode head1, ListNode head2){
	
	int len1=0;
	int len2=0;
	ListNode tmp1=head1;
	ListNode tmp2=head2;

	while(tmp1!=null){
	len1++;
	tmp1=tmp1.next;
	}
	while(tmp2!=null){
	len2++;
	tmp2=tmp2.next;
	}


	int diff=0;
	tmp1=head1;
	tmp2=head2;

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

public ListNode findCycle(ListNode head){
	
	ListNode fast=head;
	ListNode slow=head;

	while(fast!=null){
	
	if(fast.next!=null)
	fast=fast.next.next;
	else{
	fast=fast.next;
	}
	slow=slow.next;

	if(fast.val==slow.val) break;
	}


	fast=head;

	while(fast!=null&&slow!=null){
	
	if(fast.val==slow.val) return fast;

	fast=fast.next;
	slow=slow.next;
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

public int findMinValue(TreeNode root){
	
	LinkedList<TreeNode> que=new LinkedList<TreeNode>();

	int depth=0;

	que.add(root);
	que.add(null);

	while(!que.isEmpty()){
		TreeNode firstNode=que.removeFirst();

		if(firstNode==null){
			depth++;
			if(!que.isEmpty()){
				que.addLast(null);
			}

		}else{
	
			if(firstNode.left==null&&firstNode.right==null) return depth+1;

			if(firstNode.left!=null) que.addLast(firstNode.left);
			if(firstNode.right!=null) que.addLast(firstNode.right);

		}


	}


}



##Maximum Depth of Binary Tree

##Binary Search

public int binarySearch(int[] nums,int key){
	
	int low=0;
	int high=nums.length-1;

	while(low<high){
	  int curr=(low+high)/2;
	  if(nums[curr]==key) return curr;

	  if(nums[curr]>key){
		high=curr-1;
	  }

	  if(nums[curr]<key){
		low=curr+1;
	  }

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


	if(root==null) return;
	
	if(root!=null){
	
	if(root.left!=null||root.right!=null){	
	TreeNode tmp=root.left;
	root.left=root.right;
	root.right=tmp;
	}

	if(root.left!=null) invertTree(root.left);
	if(root.right!=null) invertTree(root.right);

	}

}
 
##Swap two variables without using extra space

pubilc void swap(int a,int b){
	
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

public void permu(String str){
	
	permutations("",str);

}


public void permutations(String pre,String str){
	
	if(str.length()==0) {
	System.out.println(pre);
	}

	for(int i=0;i<str.length();i++){
		permutations(pre+str.charAt(i),str.substring(0,i)+str.substring(i+1,str.length));
	}
}


## Find path of Binary Tree

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}
List<String> result=new ArrayList<String>();

public List<String> findPath(TreeNode root){
	
	findPathSub(root,new ArrayList<TreeNode>());
	return result;
}




public void findPathSub(TreeNode node,List<TreeNode> list){
	


	if(node!=null){
		list.add(node);
	
	if(node.left==null&&node.right==null){
		String str="";

		for(TreeNode tmp:list){
			str+=tmp.val;
		}
	list=new ArrayList<TreeNode>();
		result.add(str);
	}

	if(node.left!=null) {findPathSub(node.left,list);
	list.remove(list.size()-1);
	}
	if(node.right!=null) {findPathSub(node.right,list);
	list.remove(list.size()-1);
	}
	}

 


}



##ReverseBits

public String reverse(int n){
	
	StringBuilder str=new StringBuilder(Integer.toBinaryString(n));
	
	str=str.reverse();

	return str.toString();

}



public String reverse2(int n){
	
	String str=Integer.toBinaryString(n);
	Char[] cstr=str.toCharArray();
	
	head=0;
	end=str.length()-1;

	while(head<end){
	Char c=cstr[head];
	cstr[head]=cstr[end];
	cstr[end]=c;
	head++;
	end--;
	}

return String.valueOf(cstr);
}




##Reverse Integer

public int reverseInt(int n){
	int another=0;
	while(n!=0){
		another=another*10+n%10;
	}
return another;
}


##Reverse Linked List


public void reverse(ListNode head){
	
	ListNode tmp=head;
	ListNode nextNext=head.next;
	ListNode prev=null;

	while(tmp!=null){
	nextNext=tmp.next;
	
	tmp.next=prev;
	prev=tmp;
	tmp=nextNext;
	}

}



##Rotate Array

##Reverse Array

##Is Same Tree (/same-tree/)

## Symmetric Tree


 public static boolean isSymmetric(TreeNode root) {
	    if(root==null) 
	        return true;
	        
	    return isSymmetricTree(root.left,root.right);
 }

public boolean isSymmetricTree(TreeNode p,TreeNode q){
 
	if(p==null&&q==null) return true;
	if(q==null||q==null) return false;
 
return (p.val==q.val)&&isSymmetric(p.left,q.right)&&isSymmetric(p.right,q.left);
 
}




## valid-anagram (/valid-anagram/)

##HashSet iteration

HashSet set=new HashSet();

set.add("f");
set.add("f");

for(Iterator it=set.iterator;it.hasNext;){
	System.out.println(it.next());
}




##HashMap iteration

for(Entry<Integer,String> entry:map.entrySet()){
	System.out.println(entry.getKey()+"="+entry.getValue());
}




##HashTable iteration


Enumeration keys=table.keys();

while(keys.hasMoreElements()){

	   str = (String) keys.nextElement();   //if the name is String.
	   System.out.println(str + ": " + table.get(str));
 
}


Hashtable table=new Hashtable()

table.put("dfs","fds");

Enumeration keys=table.keys();

while(keys.hasMoreElements()){
	str=(String) keys.nextElement();
	System.out.println(str+":"+table.get(str));
}





