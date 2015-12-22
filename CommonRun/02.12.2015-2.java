
/*
# Must write within 1 minute
Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			List--->int len=list.size();
			
			String.valueOf(char[] ch);

##Binary operation / Bit operations



##PreOrder Traversal


##InOrder Traversal

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public void inOrder(TreeNode root){
	
	if(root!=null){

		inOrder(root.left);
		System.out.println(root.val);
		inOrder(root.right);

	}

}


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
	
			if(firstNode!=null){
					System.out.print(root.val+" ");

					que.addLast(root.left);

					que.addLast(root.right);
			}else{
				System.out.print(null+" ");
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

public void listLoop(ListNode head){
	
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

public boolean isCycle(ListNode heas){
	
	ListNode fast=head;
	ListNode slow=head;

	while(fast!=null){
	
	if(fast.next!=null){
	fast=fast.next.next;
	}else{
	fast=fast.next;
	}

	slow=slow.next;

	if(fast==slow) return fast;

	}

return null;
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

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public int findDepth(TreeNode root){
	int depth=0;

	LinkedList<TreeNdoe> que=new LinkedList<TreeNode>();

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
}

##Maximum Depth of Binary Tree

##Binary Search

public int binarySearch(int[] nums,int key){
	
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
	
			for(int i=p+1,;i<nums.length;i++){
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

public void permutations(int[] nums, int i, int n){
		
	if(i==n){
		for(int tmp:nums)
			System.out.print(tmp+" ");

			System.out.println();
	}else{
		for(int j=i;j<nums.length;j++){
		swap(nums,i,j);
		permutations(nums,i+1,n);
		swap(nums,i,j);
		}
	}
}



## Find path of Binary Tree

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
	val=x;
	}
}

List<String> result=new ArrayList<String>();
List<TreeNode> list=new ArrayList<TreeNode>();

public void findPath(TreeNode root){
	
	LinkedList<TreeNode> que=new LinkedList<TreeNode>();

	que.addLast(root);
	que.addLast(null);

	while(!que.isEmpty()){
			
		TreeNode firstNode=que.removeFirst();

		if(firstNode==null){
			
		}else{
			list.add(firstNode);

			if(firstNode.left==null&&firstNode.right==null){
				String str="";
				for(TreeNode tmp:list){
					str+=tmp.val;
				}
				result.add(str);
				list=new ArrayList<TreeNode>();
			}

			if(firstNode.left!=null){
				findPath(firstNode.left);
				list.remove(list.size()-1);
			}

			if(firstNode.right!=null){
				findPath(firstNode.right);
				list.remove(list.size()-1);
			}

		}

	}
}


##ReverseBits

##Reverse Integer


public void reverseInt(int n){
	int another=0;
	int tmp=n;

	while(tmp!=0){
	another=another*10+tmp%10;
	tmp/=10;
	}
}

##Reverse Linked List

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}

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

public void reveseArr(int[] nums){
	
	int low=0;
	int high=nums.length-1;

	while(low<high){
		int tmp=nums[low];
		nums[low]=nums[high];
		nums[high]=tmp;
	}

}



##Is Same Tree (/same-tree/)

## Symmetric Tree

public boolean isSymm(TreeNode root){
	//input validation
	if(root==null) return true;

	return isSymmSub(root.left,root.right);
}

public boolean isSymmSub(TreeNode p,TreeNode q){
	
	if(p==null&&q==null) return true;

	if(p==null||q==null) return false;

	if(p!=null&&q!=null){
		return (p.val==q.val)&&isSymmSub(p.right,q.left)&&isSymmSub(q.right,p.left);
	}
	return false;
}



## valid-anagram (/valid-anagram/)

##HashSet iteration

Set set=new HashSet();

for(Iterator it=set.iterator();it.hasNext();{
	System.out.println(it.next());
}



##HashMap iteration

HashMap<String,String> map=new HashMap<String,String>();

map.put("fds","fds");

for(Entry<String,String> entry:map.entrySet()){
	System.out.println(map.getKey()+":"+map.getValue());
}



##HashTable iteration

Hashtable table=new Hashtable();
table.put("fds","fds");

Enumeration e=map.keys();
while(e.hasMoreElements()){
	String str=(String)e.nextElement();
	System.out.println(str+"="+table.get(str));
}


