/*

# Must write within 1 minute
Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			List--->int len=list.size();
			
			String.valueOf(char[] ch);

##Binary operation / Bit operations

Integer.toBinaryString(n);

##PreOrder Traversal


##InOrder Traversal


##PostOrder Traversal

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}


public void postOrder(TreeNode root){
	
	if(root!=null){
	
	if(root.left!=null){
	postOrder(root.left);
	}

	if(root.right!=null){
	postOrder(root.right);
	}

	System.out.println(root.val);

	}

}



##LevelOrder Traversal

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public void levelOrderTraversal(TreeNode root){
	
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

public ListNode findInsection(ListNode head1, ListNode head2){
	
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

public ListNode findCycleNode(ListNode head){
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
	
				if(firstNode.left==null&&fristNode.right==null){
	
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

		if(root.left!=null) invertTree(root.left);
		if(root.right!=null) invertTree(root.right);
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

public boolean palindrome(int n){
	
	int another=0;

	int tmp=n;

	while(tmp!=null){
	
		another=another*10+tmp%10;
		tmp/=10;
	}
return another==n;
}







##Permutations (important)

method 1:

public void permutate(String str){
	permutations("",str);
}

public void permutations(String pre,String str){
	
	if(str.length()==0){
	System.out.println(pre);
	}else{
		for(int i=0;i<str.length();i++){
			permutations(pre+str.charAt(i),str.substring(0,i)+str.substring(i+1,str.length()));
		}
	}


}








method 2:

public void permutation(int[] nums,int i,int n){
	
	if(i==n){
		for(int tmp:nums)
		 System.out.print(tmp+" ");

		 System.out.println();
	}else{
		
		for(int j=i;j<nums.length;j++){
			swap(nums,i,j);
			permutation(nums,i+1,n);
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

public String reverseBit(int n){
	StringBuilder sb=new StringBuilder(Integer.toBinaryString(n));

	return sb.reverse().toString();
}

public String reverseInt(int n){
	String str=Integer.toBinaryString(n);
	Char[] c=str.toCharArray();

	for(int i=0;i<c.length;i++){
		Char tmp=c[i];
		c[i]=c[c.length-1-i];
		c[c.length-1-i]=tmp;
	}
}




##Reverse Integer

##Reverse Linked List

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}

public void reverseArr(ListNode head){
		ListNode curr=head;
		ListNode nextNext=curr.next;
		ListNode prev=null;

		while(tmp!=null){
	
		nextNext=curr.next;

		curr.next=prev;
		prev=curr;
		curr=nextNext;
		}

}

##Rotate Array

public void rotate(int[] nums){
	
	int[] c=nums.clone();

	for(int i=0;i<nums.length;i++){
		nums[i]=c[(i+k)%nums.length];
	}

}


##Reverse Array

public void reverseArr(int[] nums){
	
	int low=0;
	int high=nums.length-1;

	while(low<high){
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
	
	return isSymmSub(root.left,root.right);
}

public boolean isSymmSub(TreeNode p, TreeNode q){
	
	if(p==null&&q==null) return true;
	if(p==null||q==null) return false;

	if(p!=null&&q!=null){
		return (p.val==q.val)&&isSymmSub(p.right,q.left)&&isSymmSub(p.left,q.right);
	}
return false;
}

## valid-anagram (/valid-anagram/)

##HashSet iteration

for(Iterator it=set.iterator();it.hasNext();){
	System.out.println(it.next());
}


##HashMap iteration

for(Entry<String,String> entry:map.entrySet()){
	System.out.println(entry.getKey()+":"+entry.getValue());
}

##HashTable iteration

Hashtable table=new Hashtable();
table.put("fds","fds");

Enumeration e=table.keys();

while(e.hasMoreElements()){
	String str=e.nextElement();
	System.out.println(str+"="+table.get(str));
}
