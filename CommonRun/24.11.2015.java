/*



# Must write within 1 minute
Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			List--->int len=list.size();
			
			String.valueOf(char[] ch);

##Binary operation / Bit operations


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
	

	if(root.left!=null){
		preOrder(root.left);
	}
	if(root.right!=null){
		preOrder(root.right);
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
	
	if(root==null) return;

	LinkedList<TreeNode> que=new LinkedList<TreeNode>();
	que.addLast(root);

	while(!que.isEmpty()){
	
	TreeNode firstNode=que.removeFirst();

	if(firstNode==null){
		if(!que.isEmpty()){
			que.addLast(null);
		}
	}else{
		if(firstNode.left!=null) que.addLast(firstNode.left);
		if(firstNode.right!=null) que.addLast(firstNode.right);
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

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}

public boolean loopList(ListNode head){
	
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
		diff--;
	tmp2=tmp2.next;
	 }
	}


	while(tmp1!=null&&tmp2!=null){
	
	if(tmp1.val==tmp2.val) return tmp1;
	tmp1=tmp1.next;
	tmp2=tmp2.next;

	}

return null

}

##find the beginning node of cycle (Linked List)

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}

public ListNode findBegain(ListNode head){
	
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

			if(firstNode.left==null&&firstNode.right==null) return depth+1;

			if(fristNode.left!=null) que.addLast(firstNode.left);
			if(firstNode.right!=null) que.addLast(firstNode.right);
		}
	}



}

##Maximum Depth of Binary Tree

##Binary Search

public int binarySearch(int[] nums, int key){
	int low=0;
	int high=nums.length-1;
	
	while(low<=high){
	 int middle=(low+high)/2;

	 if(nums[middle]==key) return middle;

	 if(nums[middle]>key) {
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

public void swap(int a, int b){
	
	a=a^b;
	b=a^b;
	a=a^b;

}


##Merge two sorted arrays ===> array operation

##Merge two sorted lists

##O(1) time complexity to get minimum value of stack

##Move-zeroes  ===> array operation

public void moveArr(int[] nums){
	
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

public boolean palindrom(int n){
	
	int another=0;
	int tmp=n;
	while(tmp!=0){
	another=another*10+tmp%10;
	tmp/=10;
	}
return another==n;
}



##Permutations (important)

public List<String> permu(String str){
	return permutation("",str);
}

List<String> result=new ArrayList<String>();

public List<String> permutation(String pre,String str){
	
	if(str.length()==0) list.add(pre);

	for(int i=0;i<str.length;i++){
		permutation(pre+str.charAt(i),str.substring(0,i)+str.substring(i+1,str.length));
	}
return result;
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



public void findPathSub(TreeNode root,List<TreeNode> list){
 

	if(root!=null){

		list.add(root);
	
		if(root.left==null&&root.right==null){
			String str="";
			for(tmp:list){
			str+=tmp.val;
			}
			result.add(str);
			list=new ArrayList<TreeNode>();		

		}

		if(root.left!=null) {
			findPathSub(root.left,list);
			list.remove(list.size()-1);
		}

		if(root.right!=null){
			findPathSub(root.right,list);
			list.remove(list.size()-1);
		}
	}
}

##ReverseBits

public String reverseBit(int n){
	StringBuilder sb=new StringBuilder(Integer.toBinaryString(n));
	return sb.reverse().toString();
}

public String reverseBit2(int n){
	String str=Integer.toBinaryString(n);
	
	int head=0;
	int end=str.length()-1;

	Char[] cstr=str.toCharArray();
	while(head<end){
		Char c=str.charAt(head);
		cstr[head]=cstr[end];
		cstr[end]=c;
	}

	return String.valueOf(cstr);
}

##Reverse Integer


##Reverse Linked List

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}

public ListNode reverse(ListNode head){
	ListNode prev=null;
	ListNode curr=head;
	ListNode nextNext=head.next;

	while(curr!=null){
		nextNext=curr.next;

		curr.next=prev;
		prev=curr;
		curr=nextNext;
	}

	return prev;
}



##Rotate Array

rotate k steps.

public void rotateArr(int[] nums){
	int[] c=nums.clone();

	while(int i=0;i<nums.length;i++){
		nums[i]=c[(i+k)%nums.length];
	}
}



##Reverse Array

public void reverse(int[] arr){
	
	int low=0;
	int high=arr.length;

	while(low<high){
		int tmp=arr[low];
		arr[low]=arr[high];
		arr[high]=tmp;
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

public boolean isSymmetric(TreeNode root){
	if(root==null) return true;

	return isSymme(root.left,root.right);
}

public boolean isSymme(TreeNode p,TreeNode q){
	
	if(p==null&&q==null) return true;
	if(p!=null||q!=null) return false;

	if(p!=null&&q!=null){
		return p==q&&isSymme(p.left,q.right)&&isSymme(p.right,q,left);
	}
return null;
}


## valid-anagram (/valid-anagram/)

##HashSet iteration

Set set=new HashSet();

set.add("fds");
set.add("fdsfds");

for(Iterator it=set.iterator();it.hasNext();){
	System.out.println(it.next());
}



##HashMap iteration

HashMap<Integer,String> map=new HashMap<Integer,String>();

map.put(1,"fds");

map.put(2,"fdsf");


for(Entry<Integer,String> entry:map.entrySet()){
	System.out.println(entry.getKey()+"="+entry.getValue());
}


##HashTable iteration

Hashtable table=new Hashtable();
table.put("21","32");

Enumeration

Enumeration e=table.keys();

while(e.hasMoreElements()){
	str=(String)e.nextElement();
	System.out.println(str+":"+table.get(str));
}

