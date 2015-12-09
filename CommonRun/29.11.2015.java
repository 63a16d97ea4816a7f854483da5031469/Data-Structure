# Must write within 1
Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			List--->int len=list.size();
			
			String.valueOf(char[] ch);

##Binary operation / Bit operations

Integer.toBinaryString(n);
	 

##PreOrder Traversal

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public void preOrder(TreeNode root){

	if(root!=null){
	System.out.println(root.val);
	
	if(root.left!=null) {preOrder(root.left);}
	if(root.right!=null) {preOrder(root.right);}
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

	LinkedList<TreeNode> que=new LinkedList<TreeNode>();

	que.addLast(root);

	while(!que.isEmpty()){
		TreeNode firstNode=que.removeFirst();

		if(firstNode==null){
 			System.out.println(null);
		}else{

			System.out.println(firstNode.val);

			que.addLast(firstNode.left);
			que.addLast(firstNode.right);
		}

	}
}


##Deepth of binary tree Traversal


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

public int findN(int n){
	if(n==0||n==1) return 1;

	return findN(n-1)+findN(n-2);
}

public int findN2(int n){

	if(n==0||n==1)return 1;

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

public boolean findCycle(ListNode head){

	ListNode fast=head;
	ListNode slow=head;

	while(fast!=null){

		if(fast.next!=null){
			fast=fast.next.next;
		}else{
			fast=fast.next;
		}
		slow=slow.next;

		if(fast==slow)  return true;
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

		if(tmp1.val==tmp2.val) return tmp1;
		tmp1=tmp1.next;
		tmp2=tmp2.next;
	}

return null;
}

##find the beginning node of cycle (Linked List)

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}

public ListNode beginNode(ListNode head){

	ListNode fast=head;
	Listnode slow=head;


	while(fast!=null){

		if(fast.next!=null){
			fast=fast.next.next;
		}else{
			fast=fast.next;
		}

		slow=slow.next;
		if(fast==slow) break;
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

public void permuta(int[] nums,int i,int n){
	int j;

	if(i==n){
		for(int tmp:nums)
			System.out.print(tmp+" ");

		System.out.println();

	}else{
		for(j=i;j<nums.length;j++){
		swap(nums,i,j);
		permuta(nums,i+1,n);
		swap(nums,i,j);
		}

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
List<TreeNode> list=new ArrayList<TreeNode>();

public void findPath(TreeNode root){

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

		if(firstNode.left!=null) {
			findPath(firstNode.left);
			list.remove(list.size()-1);
		}

		if(firstNode.right!=null){
			findPath(firstNode.right);
			list.remove(list.size()-1);
		}

	}

}


##ReverseBits

##Reverse Integer

##Reverse Linked List

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}

public void reverse(ListNode head){

	ListNode curr=head;
	ListNode prev=null;
	ListNode nextNext=curr.next;

	while(curr!=null){

		nextNext=curr.next;

		curr.next=prev;
		prev=curr;
		curr=nextNext;
	}

}

##Rotate Array

##Reverse Array

public void reverseArr(int[] nums){
	int low=0;
	int high=nums.length-1;

	while(low<=high){

		int tmp=nums[low];
		nums[low]=nums[high];
		nums[high]=tmp;

		low++;
		high--;
	}
}


##Is Same Tree (/same-tree/)

## Symmetric Tree

public boolean isSymm(TreeNode root){

	if(root==null) return true;

	return isSymmSub(root.left,root.right);

}


public boolean isSymmSub(TreeNode p,TreeNode q){
	if(p==null&&q==null) return true;

	if(p==null||q==null) return false;

	if(p!=null&&q!=null){
		return (p.val==q.val)&&isSymmSub(p.left,q.right)&&isSymmSub(q.right,q.left);
	}
	return false;
}


## valid-anagram (/valid-anagram/)

##HashSet iteration

for(Iterator it=set.iterator();it.hasNext();){
	System.out.println(it.next());
}

##HashMap iteration

HashMap<String,String> map=new HashMap<String,String>();

for(Entry<String,String> entry:map.entrySet()){
System.out.println(entry.getKey()+":"+entry.getValue());
}

##HashTable iteration

Hashtable table=new Hashtable();

table.put("fds","fds");

Enumeration e=table.keys();

while(e.hasMoreElements()){
	String str=(String)e.nextElement();
	System.out.prinlnt(str+":"+table.get(str));
}


