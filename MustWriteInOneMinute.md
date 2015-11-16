# Must write within 1

Remember:    String --->  str.length();
			 Array---> arr.length;
			 
			 String.valueOf(char[] ch);


##Binary operation / Bit operations
	public static String addBinary4(String a, String b){

	if(a==null&&a.length()==0) return b;
	if(b==null&&b.length()==0) return a;


	int currA=a.length()-1;
	int currB=b.length()-1;
	int flag=0;
	StringBuilder sb=new StringBuilder();
	
	while(currA>=0||currB>=0){

	int va=0;
	int vb=0;


	if(currA>=0){
	va=a.charAt(currA)==0?0:1;
	currA--;
	}

	if(currB>=0){
	vb=b.charAt(currB)==0?0:1;
	currB--;
	}
	
	int sum=va+vb+flag;

	if(sum>=2){
	sb.append(sum-2);
	flag=1;
	}else{
	sb.append(sum);
	//flag=0;
	}	


##PreOrder Traversal


##InOrder Traversal


##PostOrder Traversal


##LevelOrder Traversal


##Deepth of binary tree Traversal


##Linked List Traversal

##Fibonacci Number

##BFS

##DFS

##Judge whether has cycle

##find the insection node of two single lists

##find the beginning node of cycle (Linked List)

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

##
