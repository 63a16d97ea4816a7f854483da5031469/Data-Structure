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

public void levelTraversal(TreeNode root){
	
	if(root!=null){

	LinkedList<TreeNode> que=new LinkedList<TreeNode>();
	que.add(root);

	while(!que.isEmpty()){

		TreeNode firstNode=que.removeFirst();
 		if(firstNode!=null){
 		   System.out.print(firstNode.val+" ");
 		   que.addLast(firstNode.left);
 		   que.addLast(firstNode.right);
 		}else{
 			System.out.print(null+" ");
 		}
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

int depth=0;

public int getDepth(TreeNode root){
	

	if(root!=null){

		LinkedList<TreeNode> que=new LinkedList<TreeNode>();
		que.addLast(root);
		que.addLast(null);

		while(!que.isEmpty()){

		LinkedList firstNode=que.removeFirst();

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

	}

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
		System.out.println(tmp.val);
		tmp=tmp.next;
	}
}



##Fibonacci Number


public void fibonacci(int n){
	if(n==0||n==1) return 1;

	return fibonacci(n-1)+fibonacci(n-2);
}




public void fibonacci(int n){
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
	int val
	ListNode next;
	ListNode(int x){val=x;}
}


pulbic boolean hasCycle(ListNode head){
	 
	ListNode fast=head;
	ListNode slow=head;
	while(fast!=null){

	if(fast.next!=null)
	fast=fast.next.next;

	slow=slow.next; 


	if(slow==fast) return true;

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
	len2++;
	tmp2=tmp2.next;
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

public ListNode findStartNode(ListNode head){


	//Need to consider three cases:
/*

[],
[1],
[1,2]

*/	

//So you need to put checking here:

		if (head == null)
			return null; // when head==null
		if (head.next == null)
			return null; // when only contain head node.
		if (head.next == head)
			return head;

//--------------------------------------------------------


	ListNode fast=head;
	ListNode slow=head;

	while(fast!=null){

		if(fast.next!=null) 
		fast=fast.next.next;

		slow=slow.next;

		if(slow==fast) break;
	}

	fast=head;

	while(fast!=null&&slow!=null){

	 if(fast==slow) return fast;

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

public int minDepth(TreeNode root){
	
	if(root==null) return 0;

	int depth=0;    
	TreeNode tmp=root;
	LinkedList<TreeNode> que=new LinkedList<TreeNode>();
	que.addLast(root);
	que.addLast(null);

	while(!que.isEmpty()){

	TreeNode fistNode=que.removeFirst();

	if(firstNode==null){
		depth++;

		if(!que.isEmpty()){
			que.addLast(null);
		}
	}else{

		if(firstNode.left==null&&firstNode.right==null) {
		   depth++;
		   break;
		}

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



##Maximum Depth of Binary Tree

##Binary Search


public int binarySearch(int[] nums,int key){
	int low=0;
	int high=nums.length-1;

	while(low<=high){
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

public boolean palindrome(int n){
	
	int another=0;
	int tmp=n;
	while(tmp!=0){
		another=another*10+tmp%10;
		tmp/=10;
	}

	return another==n;

}

public boolean palindrome2(int n){
	
	int tmp=n;
	int div=1;
	
	while(tmp!=0){
	div*=10;
	tmp/=10;
	}

	div/=10;

	tmp=n;

	while(tmp!=0){
		int h=tmp/div;
		int l=tmp%10;
		if(h!=l) return false;
		div/=100;
	}

return true;
}





##Permutations (important)

public void perm(String str){
	permutation("",str);
}

public void permutation(String prev,String str){

	if(str.length()==0) System.out.println(prev);
	
	for(int i=0;i<str.length();i++){
		permutation(prev+str.charAt(i),str.substring(0,i)+str.substring(i,str.length()-1));
	}

}

##Find path of Binary Tree

 class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x){val=x;}
 }

 List<String> result=new ArrayList<String>();


 public List<String> findPath(TreeNode root){

 	binaryTree(root,new ArrayList<TreeNode>());
 	return result;

 }




 public void binaryTree(TreeNode root,List<Integer> list){

 	if(root!=null){
 		list.add(root);

 		if(root.left==null&&root.right==null){

 		String str="";
 		for(TreeNode tmp:list){
 		str+=tmp.val;
 		}
 		   result.add(str);
 		   list=new ArrayList<TreeNode>();
 		}
 	
 		if(root.left!=null){
 			binaryTree(root.left,list);
 			list.remove(list.size()-1);
 		}

 		if(root.right!=null){
 	 		binaryTree(root.right,list);
 			list.remove(list.size()-1);
 		}
 	}
 
 }

##ReverseBits

public void reverse(int n){
		StringBuilder nb = new StringBuilder(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(n));

		char[] nbchar=nb.toString().toCharArray();
		int head=0;
		int end=nb.length()-1;
		
		/*
		 *   replace(old char,new char) this one will 
		 *   replace all the old char to new char.
		nbstr=nbstr.replace(nbstr.charAt(end), nbstr.charAt(head));
		nbstr=nbstr.replace(nbstr.charAt(head), tmp);
		 */
		
	while(head<end){
		char tmp=nbchar[end];
		nbchar[end]=nbchar[head];
		nbchar[head]=tmp;
 
		head++;
		end--;
	}
	}



By using the java's reverse method of StringBuilder:

    public int reverseBits(int n) {
    	 
		StringBuilder nb = new StringBuilder(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(n));
		nb.reverse();
 
		int tmpN = 32 - nb.length();
		for (int i = 0; i < tmpN; i++) {
			nb.append("0");
		}
 
		return  (int)Long.parseLong(String.valueOf(nb),2);
    }





##Reverse Integer

public boolean reverse(int n){
	
	int another=0;
	int tmp=n;
	while(tmp!=0){
		another=another*10+tmp%10;
		tmp/=10;
	}

	return another==n;

}

##Reverse Linked List

public ListNode reverseList(ListNode head){

if(head==null) return head;
	
	ListNode prev=null;
	ListNode curr=head;
	ListNode nextNext=head.next;

	while(curr!=null){
		nextNext=curr.next;

		curr.next=prev;
		prev=curr;
		curr=nextNext;
	}

return head;

}





##Rotate Array

public void rotate(int[] nums){
	int[] tmp=nums.clone();

	for(int i=0;i<nums.length;i++){
		nums[i]=tmp[(i+k)%nums.length];
	}
}


##Reverse Array

public void reverseArr(int[] nums){
	for(int i=0;i<nums.length/2;i++){
	int tmp=nums[i];
	nums[i]=nums[nums.length-1-i];
	nums[nums.length-1-i]=tmp;
	}
}


##Is Same Tree (/same-tree/)

## Symmetric Tree

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public boolean isSymm(TreeNode root){
	if(root==null) return true;

	return isSymmTree(root.left,root.right);
}


public boolean isSymmTree(TreeNode p, TreeNode q){
	if(p==null&&q==null) return true;

	if(p==null||q==null) return false;

	return (p.val==q.val)&&isSymmTree(p.right,q.left)&&isSymmTree(p.left,q.right)

}




## valid-anagram (/valid-anagram/)

use hashmap to compare


##HashSet iteration
 
public void setIteration(){
	
	Set set=new HashSet();
	set.add("fds");
	set.add("fds");

	for(Iterator it=set.iterator();it.hasNext();){
	 	System.out.println(it.next());
	}

}

##HashMap iteration

for(Entry<Integer,String> enty:map.entrySet()){
	System.out.println(entry.getKey()+"=>"+entry.getValue());
}


for(Entry<Integer,String> entry:map.entrySet()){
	System.out.println(entry.getKey()+"=>"+entry.getValue());
}


##Hashtable iteration

 
Hashtable table=new Hashtable();

Enumeration keys=table.keys();

while(keys.hasMoreElements()){

	   str = (String) keys.nextElement();   //if the name is String.
	   System.out.println(str + ": " + table.get(str));
 
}


 
Enumeration keys=table.keys();

while(keys.hasMoreElements()){

	Str=(String) keys.nextElement();
	System.out.println(str+": "+ table.get(str));

}





