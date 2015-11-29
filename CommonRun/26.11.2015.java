

/*



# Must write within 1
Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			List--->int len=list.size();
			
			String.valueOf(char[] ch);

##Binary operation / Bit operations
	 

##PreOrder Traversal


##InOrder Traversal


##PostOrder Traversal


##LevelOrder Traversal


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
	val=x;
	}
}


public void levelTraversal(TreeNode root){
	LinkedList<TreeNode> que=new LinkedList<TreeNode>();
	que.addLast(root);

	while(!que.isEmpty()){
		TreeNode firstNode=que.removeFirst();
		if(firstNode==null){
	
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


List<String> list=new ArrayList<String>();




public int findDepth(TreeNode root){
	
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
	System.out.println(tmp.val);
	tmp=tmp.next;

	}

}



##Fibonacci Number


public int getF(int n){
	
	if(n==0||n==1) return 1;

	return getF(n-1)+getF(n-2);

}

public int getF(int n){
	
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
	ListNode tmp=head;
	ListNode slow=head;
	while(tmp!=null){
	if(tmp.next!=null){
	tmp=tmp.next.next;
	}else{
	tmp=tmp.next;
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
	ListNode tmp=head;
	ListNode slow=head;

	while(tmp!=null){
		
		if(tmp.next!=null){
		tmp=tmp.next.next;
		}else{
		tmp=tmp.next;
		}

	slow=slow.next;

	if(slow=tmp) break;
	}

	tmp=head;

	while(tmp!=null&&slow!=null){
		
		tmp=tmp.next;
		slow=slow.next;
		if(tmp==slow) return tmp;
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
	
	int depth=0;
	
	LinkedList<TreeNode> que=new LinkedList<TreeNode>();
	que.addLast(root);
	que.addLast(null);

	while(!que.isEmpty()){
		TreeNode firstNode=que.removeFirst();

		if(firstNode==null) {
			depth++;
			if(!que.isEmpty()){
				que.addLast(null);
			}
		}else{
			if(firstNode.left==null&&firstNode.right==null){
				return detph+1;
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
	
	if(nums[middle]==key){
		return middle;
	}

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

public void invertBinaryTree(TreeNode root){
	
	if(root!=null){
	
	if(root.left!=null||root.right!=null){
		TreeNode tmp=root.left;
		root.left=root.right;
		root.right=tmp;
	}


	if(root.left!=null) invertBinaryTree(root.left);
	if(root.right!=null) invertBinaryTree(root.right);

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
	}
}

##Palindrome Number (回文)

public boolean isPalindrome(int n){
		
	int div=1;
	int tmp=n;
	while(tmp/10>0){
		div=div*10;
		tmp/=10;
	}

	
	while(n!=0){
		int l=n%10;
		int h=n/div;

	if(l!=h) return false;


		div/=100;
		n=n%div/10;
	}

return true;
}



##Permutations (important)

public void permut(String str){
	permutations("",str);
}

public void permutations(String prev,String str){
	
	if(str.length()==0) {
	System.out.println(prev);
	}

	for(int i=0;i<str.length();i++){
		permutations(prev+str.charAt(i),str.substring(0,i)+str.substring(i+1,str.length()));
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


public List<String> findPath(TreeNode root){
	findPahtSub(root);
	return result;
}


public void findPathSub(TreeNode root){
	
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
			findPathSub(root.left);
			list.remove(list.size()-1);
		}

		if(root.right!=null){
			findPathSub(root.right);
			list.remove(list.size()-1);
		}
	}	

}






##ReverseBits

public String reverseStr(int n){
	StringBuilder sb=new StringBuilder(Integer.toBinaryString(n));
	return sb.reverse().toString();
}

public String reverseBit(int n){
	String str=Integer.toBinaryString(n);

	Char[] c=str.toCharArray();

	int head=0;
	int end=c.length;
	while(head<end){
	int tmp=c[head];
	c[head]=c[end];
	c[end]=tmp;
	head++;
	end--;
	}
	return String.valueOf(c);
}



##Reverse Integer

public int reverseInt(int n){
	
	int tmp=n;
	int another=0;
	while(tmp!=0){
	another=another*10+tmp%10;
	tmp/10;
	}
return another;

}

##Reverse Linked List

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}

public void reverse(ListNode head){
		
		ListNode tmp=head;

		ListNode prev=null;
		ListNode nextNext=tmp.next;
	while(tmp!=null){
		nextNext=tmp.next;

		tmp.next=prev;
		prev=tmp;
		tmp=nextNext;
	}



}






##Rotate Array

public void rotate(int[] arr){
    int[] c=arr.clone();

    for(int i=0;i<c.length;i++){
        arr[i]=c[(i+k)%length];
    }
}


##Reverse Array

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
	return isSymmTwo(root.left,root.right);
}

public boolean isSymmTwo(TreeNode p, TreeNode q){
	if(p==null&&q==null) return true;
	if(p==null||q==null) return false;

	if(p!=null&&q!=null){
	
	return (p.val==q.val)&&isSymmTwo(p.right,q.left)&&isSymmTwo(q.left,p.right);
	}


}


## valid-anagram (/valid-anagram/)

Use hashMap.
 

##HashSet iteration

HashSet set=new HashSet();

set.add("fds");


for(Iterator it=set.iterator;it.hasNext();){
	System.out.println(it.next());
}


##HashMap iteration

HashMap<Integer,String> map=new HashMap<Integer,String>();

map.put("dfsfd","fdsf");

for(Entry<Integer,String> entry:map.entrySet()){
	System.out.println(entry.getKey()+":"+entry.getValue());
}


##HashTable iteration


Hashtable table=new Hashtable();

table.put("fds","fds");


Emuneration e=table.elements();

while(e.hasMoreElement()){
 String str=(String)e.nextElement();
 System.out.println(str+" "+table.get(str));
}