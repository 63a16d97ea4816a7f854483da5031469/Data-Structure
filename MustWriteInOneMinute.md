# Must write within 1

##Binary operation
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


##CheckDeepth Traversal


##LinkedList Traversal

##Fibonacci Number

##BFS

##DFS

##Judge whether has cycle

##find the insection node

##find the beginning node of cycle

##LRU Cache

##MinimumDepth

##

