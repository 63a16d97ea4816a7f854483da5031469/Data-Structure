/*


# Must write within 1
Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			List--->int len=list.size();
			
			String.valueOf(char[] ch);

##Binary operation / Bit operations

public void getBinary(int n){
	String str=Integer.toBinaryString(n);
}
	 

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

		TreeNode firstNode=que.removeFisrt();
		if(firstNode==null){
			System.out.print(null+" ");
		}else{
			System.out.println(firstNode.val+" ");

			que.addLast(firstNode.left);
			que.addLast(firstNode.right);
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
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}


public boolean isCycle(ListNode head){
	
	ListNode slow=head;
	ListNode fast=head;
	while(fast!=null){
	   
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

public ListNode findFirstNodeCycle(ListNode head){
		
		ListNode fast=head;
		ListNode slow=head;


	while(fast!=null){
		if(fast.next!=null){
	fast=fast.next.next;
		}else
	{
		fast=fast.next;
	}

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

public int findMinDepth(TreeNode root){
		
	LinkedList<TreeNode> que=new LinkedList<TreeNode>();
	que.addLast(root);
	que.addLast(null);

	while(!que.isEmpty()){
	
	 TreeNode firstNode=que.removeFirst();

	 if(firstNode==null){
	depth++
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
	int middle=(low+high)/2;

	if(nums[middle]==key) return middle;

	if(nums[middle]>key) {
		high=middle-1;
	}

	if(nums[middle]<key){
		low=middle+1;
	}

	}
}


##Implement Queue using stacks


Stack<Integer> s1=new Stack<Integer>();
Stack<Integer> s2=new Stack<Integer>();

public int removeFirst(){
	if(!s1.isEmpty()){
		s2.push(s1.pop());
	}
	s2.pop();
}


public void addLast(int n){
	s1.push(n);
}


##Implement Stack using Queues

LinkedList<Integer> que1=new LinkedList<Integer>();
LinkedList<Integer> que2=new LinkedList<Integer>();

public int pop(){
	while(que1.isEmpty()&&que1.size()!=1){
		que2.addLast(que1.removeFirst());
	}
	int result=que1.removeFirst();
	LinkedList<Integer> tmp=que1;
	que1=que2;
	que2=tmp;
	return result;
}

public void push(int n){
	que1.addLast(n);
}

public int peek(){
	if(!que1.isEmpty()&&que1.size()!=1){
	que2.addLast(que1.removeFirst());
	}	
	return que1.peek();
}

##invert binary tree

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

public boolean palind(int n){
	
	int tmp=n;
	int another=0;
	while(tmp!=0){
	another=another*10+tmp%10;
	
	tmp/=10;
	}
return another==n;

}

public boolean palindromeNumber(int n){
	int div=1;
	
	while(n/10>0){
	div*=10;
	n/=10;
	}

	while(n!=0)
	{
	int l=n/div;
	int r=n%10;
	if(l!=r) return false;
	n=(n%10)/10;
	div/=100;	

	}


}



##Permutations (important)

public void permutations(String str){
	
	permuta("",str);
}


public void permuta(String prev,String str){
	
	if(str.length()==0) System.out.println(prev);

	for(int i=0;i<str.length();i++){
		permuta(prev+str.charAt(i),str.substring(0,i)+str.substring(i+1,str.length()));
	}

}


Another method:


public void permuta(int[] nums){
	permutations(nums,0,nums.length-1);
}


public void permutations(int[] nums,int i,int n){
	
	int j=0;

	if(i==n){
		for(int tmp:nums)
		System.out.print(tmp+" ");
	}else{
	
		for(j=i;j<n;j++){
			swap(nums,i,j);
			permutations(nums,i+1,n);
			swap(nums,i,j);
		}

	}


 
}


public void swap(int[] nums,int i,int j){
	int tmp=nums[i];
	nums[i]=nums[j];
	nums[j]=tmp;
}









## Find path of Binary Tree

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

List<String> result=new ArrayList<String>();

public void findPath(TreeNode root,List<TreeNode> list){
	
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
		findPath(root.left,list);
		list.remove(list.size()-1);
	}
	if(root.right!=null){
		findPath(root.right,list);
		list.remove(list.size()-1);
	}

	}
	
}




##ReverseBits


public String reverseStr(int n){
	StringBuilder str=new StringBuilder(Integer.toBinaryString(n));
	return str.reverse().toString();
}

public String reverseInt(int n){
	String str=Interger.toBinaryString(n);

	int low=0;
	int high=str.length()-1;
	Char[] c=str.toCharArray();
	while(low<high){
		Char tmp=c[low];
		c[low]=c[high];
		c[high]=tmp;
	}

	return String.valueOf(c);

}

##Reverse Integer

public void reverseInt(int n){
	
	int tmp=n;
	int another=0;
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
	ListNode prev=null;
	ListNode curr=head;
	ListNode nextNext=head.next;

	while(curr!=null){
		nextNext=curr.next;

		curr.next=prev;
		prev=curr;
		curr=nextNext;
	}	
}


##Rotate Array

rotate k steps.

public void rotateArr(int[] nums){
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
	}

}





##Is Same Tree (/same-tree/)

## Symmetric Tree

## valid-anagram (/valid-anagram/)

##HashSet iteration

Set set=new HashSet();
for(Iterator it=set.iterator;it.hasNext();){
	System.out.println(it.next());
}



##HashMap iteration

HashMap map=new HashMap();
map.put("dsf","fds");

for(Entry<String,String> entry:map.entrySet){
	System.out.println(entry.getKey()+"="+entry.getValue());
}


##HashTable iteration

Hashtable table=new Hashtable();

table.put("dsf","fds");


Enumeration
Enumeration e=table.elements();

while(e.hasMoreElements()){
	str=(String)e.nextElement();
	System.out.println(str+":"+table.get(str));
}



Hashtable table=new Hashtable();
table.put("dsf","fds");

Enumeration e=table.elements();
while(e.hasMoreElements()){
	str=(String)e.nextElement();
	System.out.println(str+":"+table.get(str));
}


HashSet set=new HashSet();
set.put("fds","fds");
for(Iterator it=set.iterator();it.hasNext();){
	System.out.println(it.next());
}


HashMap map=new HashMap();
map.put("dfs","dfs");

for(Entry<String,String> entry:map.entrySet();){
	System.out.println(entry.getKey()+"="+entry.getValue());
}




Hashtable table=new Hashtable();
table.put("fds","fds");

Enumeration e=table.keys();

while(e.hasMoreElements()){
	str=(String)e.nextElement();
	System.out.println(str+":"+table.get(str));
}



Enumeration e=table.keys();
while(e.hasMoreElements()){
	str=(String)e.nextElement();
	System.out.println(str+":"+table.get(str));
}





Enumeration e=table.keys();
while(e.hasMoreElements()){
	str=(String)e.nextElement();
	System.out.prinltn(str+":"+table.get(str));
}