# Must write within 1 minute

http://collabedit.com/yjege

Remember:    

            String --->  str.length();  
            Array---> arr.length; 
            List--->int len=list.size();
            
            String.valueOf(char[] ch);

            Arrays.sort(xxxx[]);
            Collections.sort(List<xxxx>);



##Clone Undirected graph. 

Each node in the graph contains a label and a list of its neighbors.

class UndirectedGraphNode {
      int label;
      ArrayList neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList(); }
  };
  
Implementation with DFS

Implementation with BFS

##Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.(KMP)

    public int findSubStrIndex(String str, String subStr){
        
        //input validation
        if(str==null || subStr==null) return -1;
        if(subStr.length()>str.length()) return -1;
        if(subStr.length()==0) return -1;
        if(str.equals("") && subStr.equals("")) return 0;
        
        //KMP
        int firstMatchedIndex=KMP(str,subStr);
        return firstMatchedIndex<0?0:1;
    }
    
    
    public int[] getNextArr(String subStr){
        
        int subStr_len=subStr.length();
        
        int[] next=new int[subStr_len];
        
        int prefix_index=-1;
        int suffix_index=0;
        
        while(subStr_start<subStr_len){
        
            if(prefix_index==-1|| subStr.charAt(subStr_start)==str.charAt(str_start)){
                
                int numMatched_prefix_and_suffix=prefix_index+1;
                if(suffix_index+1>=suffix_len) break;
                next[suffix_index+1]=numMatched_prefix_and_suffix;
                
                prefix_index++;
                suffix_index++;
                
            }else{
                prefix_index=next[prefix_index];
            }
        
        }
        return next;
    }
    
    public int KMP(String str,String subStr){
        int str_len=str.length();
        int subStr_len=subStr.length();
        
        int str_start=0;
        int subStr_start=0;
        
           
        while(str_start<str_len&&subStr_start<subStr_len){
            if(subStr_start==-1 || subStr.charAt(subStr_start)==str.charAt(str_start)){
                str_start++;
                subStr_start++;
            }else{
                subStr_start=next[subStr_start];
            }
        }
        
        if(subStr_start>=subStr_len){
            return subStr_start-subStr_len;
        }else return -1;
    
    }



## Given a sorted (in increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height.  
            
            
##Input n,m    Pick up some numbers from 1,2,3....n, to fulfill the sum of them is equal to m. --can repeat pick up numbers         
            
            int[] nums;
            public void findSum(int[] nums,int sum){
                this.nums=nums;
                combine(sum);
            }
            
            public void combine(int m){
                if(m<1) return;
                ArrayList<Integer> arr=new ArrayList<Integer>();
                getCombination(m,arr);
            }
            
            public void getCombination(int m,ArrayList<Integer> arr){
                if(m==0 && arr.size()>=1){
                    for(int i=0;i<arr.size();i++){
                        System.out.println(arr.get(i));
                    }
                }
                if(m<0) return;
                
                for(int i=0;i<nums.length;i++){
                
                if(!arr.isEmpty() && nums[i]<arr.get(arr.size()-1))
                continue;
                
                    arr.add(nums[i]);
                    getCombination(sum-nums[i],arr);
                    if(!arr.isEmpty()){
                        arr.remove(arr.size()-1);
                    }
                }
                
            }
##Input n,m    Pick up some numbers from 1,2,3....n, to fulfill the sum of them is equal to m. (can repeat)

    LinkedList<Integer> list=new ArrayList<Integer>();

    public void findSum(int sum,int n){
        if(sum<=0 ||n<=0) return;
        if(sum==n){
            for(int i=list.size()-1;i>0;i--){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }else{
            list.push(n);
            findSum(sum-n,n-1);
            list.pop();
            findSum(sum,n-1);
        }
    }



##MaximumSubarray

    public void findMax(int[] nums){
         int max_ending_here=nums[0];
         int max_so_far=nums[0];
         
             for(int i=1;i<nums.length;i++){
                 max_ending_here=Math.max(nums[i],max_ending_here+nums[i]);
                 max_so_far=Math.max(max_ending_here,max_so_far);
             }
             return max_so_far;
    }



##LinkRightNode

Link all the same level node from left to right by using "Right" field.

class Node
{
    public Node[] Children;
    public Node Right;
    public int val;
    Node(int x){val=x;}
}

    public void linksRight(TreeNode root){
     
         LinkedList<Node> que=new LinkedList<Node>();
         que.addLast(root);
         que.addLast(null);
         
         Node linksRightNode=null;
         
         
         while(!que.isEmpty()){
             Node firstNode=que.removeFirst();
             if(firstNode==null){
                 linksRightNode=null;
                 if(!que.isEmpty()){
                     que.addLast(null);
                 }
             }else{
                 
                 if(linksRightNode!=null){
                     linksRightNode.Right=firstNode;
                 }
                 
                 if(firstNode.Children!=null){
                     for(Node tmp:firstNode.Children)
                        que.addLast(tmp);
                 }
                 linksRightNode=firstNode;
             }
         }
    }

##Input n,m    Pick up some numbers from 1,2,3....n, to fulfill the sum of them is equal to m. (0/1 bag)

    LinkedList<Integer> list=new LinkedList<Integer>();

        public void findSum(int sum,int n){
            if(sum<=0 || n<=0) return;
            if(sum==n){
                for(int i=list.size()-1;i>0;i--){
                    System.out.println(list.get(i));
                }
            }
        }else{
            list.push(n);
            findSum(sum-n,n-1);
            list.pop();
            findSum(sum,n-1);
        }



##Binary operation / Bit operations  --- The sum of two binary numbers

    public String binarySum(String a,String b){
        if(a==null || a.length()==0) return b;
        if(b==null || b.length()==0) return a;
        
        int currA=a.length()-1;
        int currB=b.length()-1;
        int flag=0;
        
        StringBuilder sb=new StringBuilder();
        
        while(currA>=0 || currB>=0){
            int va=0;
            int vb=0;
            
            if(currA>=0){
                va=a.charAt(currA)=='0'?0:1;
                currA--;
            }
            
            if(currB>=0){
                vb=b.charAt(currB)=='0'?0:1;
                currB--;
            }
            
            int sum=va+vb+flag;
            
            if(sum>=2){
                sb.append(sum-2);
                flag=1;
            }else{
                sb.append(sum);
                flag=0;
            }
            
            
        }
        
        if(flag==1){
            sb.append("1");
        }
        
        return sb.reverse().toString();
        
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
    
    public void levelOrder(TreeNode root){
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
    class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
    val=x;
    }
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

public void loopList(ListNode head){

    ListNode tmp=head;
    
    
    while(tmp!=null){
        
        System.out.println(tmp.val);
        tmp=tmp.next;
    }

}


##Fibonacci Number

    public int findN(int n){
        if(n==1 ||n==0) return 1;
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
            diff--;
            tmp1=tmp1.next;
        }
    }
    
    if(len2>len1){
        diff=len2-len1;
        while(diff>0){
          tmp2=tmp2.next;
          diff--;
        }
    }
    
     while(tmp1!=null &&tmp2!=null){
     
     
     tmp1=tmp1.next;
     tmp2=tmp2.next;
     
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
    
    public ListNode findBeginNode(ListNode head){
    
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

    public void permutations(int[] nums,int i,int n){
        if(i==n){
            for(int tmp:nums)
            System.out.print(tmp+" ");
            System.out.println(); 
        }else{
        
            swap(nums,i,j);
            permutations(nums,i+1,n);
            swap(nums,i,j);
        }
    }
    
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    
    
    Method 2:
    
    public void permutations(String pre,String str){
    
        if(str.length()==0){
            System.out.println(pre);
        }else{
            for(int i=0;i<str.length();i++)
            permutations(pre+str.charAt(i),str.substring(0,i)+sub.substring(i+1,str.length());
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

            if(root.left==null && root.right==null){
                String str="";
                for(TreeNode tmp:list)
                str+=tmp.val;
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

##Reverse Integer

##Reverse Linked List

    class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val=x;}
    }
    
    public void reverseList(ListNode head){
        ListNode nextNext=head.next;
        ListNode curr=head;
        ListNode prev=null;
        
        while(curr!=null){
            nextNext=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNext;
        }
    }


##Rotate Array

##Reverse Array


    public void reverseArr(int[] nums,int key){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int middle=low+((high-low)>>1);
            
            if(nums[middle]>key){
            
                high=middle-1;
            
            }else if(nums[middle]<key){
                low=middle+1;
            
            }else return middle;
            
        }
        return -1;
    }


##Is Same Tree (/same-tree/)

## Symmetric Tree

## valid-anagram (/valid-anagram/)

##HashSet iteration

    for(Iterator it=set.iterator();it.hasNext()){
        System.out.println(it.next());
    }


##HashMap iteration

    for(Entry<String,String> entry:map.entrySet()){
    
    System.out.println(entry.getKey()+"="+entry.getValue());

    }
    
    
##HashTable iteration

    Hashtable table=new Hashtable();
    table.put("fdsfds","fdsfds");
    
    Enumeration e=table.keys();
    
    while(e.hasMoreElements()){
        String str=(String)e.nextElement();
        System.out.println(str+" "+table.get(str));
    }







