
/*
 * 
https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/


  First Unique Number
You have a queue of integers, you need to retrieve the first unique integer in the queue.

Implement the FirstUnique class:

FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
void add(int value) insert value to the queue.
 

Example 1:

Input: 
["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
[[[2,3,5]],[],[5],[],[2],[],[3],[]]
Output: 
[null,2,null,2,null,3,null,-1]

Explanation: 
FirstUnique firstUnique = new FirstUnique([2,3,5]);
firstUnique.showFirstUnique(); // return 2
firstUnique.add(5);            // the queue is now [2,3,5,5]
firstUnique.showFirstUnique(); // return 2
firstUnique.add(2);            // the queue is now [2,3,5,5,2]
firstUnique.showFirstUnique(); // return 3
firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
firstUnique.showFirstUnique(); // return -1

Example 2:

Input: 
["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
[[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
Output: 
[null,-1,null,null,null,null,null,17]

Explanation: 
FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
firstUnique.showFirstUnique(); // return -1
firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
firstUnique.showFirstUnique(); // return 17

Example 3:

Input: 
["FirstUnique","showFirstUnique","add","showFirstUnique"]
[[[809]],[],[809],[]]
Output: 
[null,809,null,-1]

Explanation: 
FirstUnique firstUnique = new FirstUnique([809]);
firstUnique.showFirstUnique(); // return 809
firstUnique.add(809);          // the queue is now [809,809]
firstUnique.showFirstUnique(); // return -1

 

Constraints:

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^8
1 <= value <= 10^8
At most 50000 calls will be made to showFirstUnique and add.

12 April 2020 at 7.57pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :










FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
void add(int value) insert value to the queue.


 * 
 */

8.11pm- 



// Accept:

class Node {
    int num, count;
    Node pre, next;
    Node(int num, int count) {
        this.num=num;
        this.count=count;
        pre = this;
        next = this;
    }
} 

class FirstUnique {
    int count=0;
    HashMap<Integer, Node> map=new HashMap<Integer, Node>();
    private Node dummy;// dummy节点是一个冗余节点，dummy的next是链表的第一个节点，dummy的pre是链表的最后一个节点
    public FirstUnique(int[] nums) {
        dummy = new Node(999, 999);
        for(int i=0;i<nums.length;i++){
            Node currNode=map.get(nums[i]);
            int currCount=currNode==null?0:currNode.count;
            if(currCount==0){
                   Node node=new Node(nums[i],currCount+1);
                   add(node);
                   map.put(nums[i],node);
                   count++;
            }else{
                Node old=map.get(nums[i]);
                remove(old);
                count--;
            }
        }
    }
    public int showFirstUnique() {
        if(dummy.next!=null&&dummy.next.num!=999){
           return dummy.next.num;
        }
        return -1;
    }
    public void add(int value) {
            Node currNode=map.get(value);
            int currCount=currNode==null?0:currNode.count;
            if(currCount==0){
                   Node node=new Node(value,currCount+1);
                   add(node);
                   map.put(value,node);
            }else{
                Node old=map.get(value);
                remove(old);
            }
    }
   
    
    public boolean add(Node node)  
    {  
        addBefore(node, dummy);  
        return true;  
    }  

     //在某元素之前添加元素
     private void addBefore(Node newNode, Node node)  
     {  
       newNode.pre = node.pre;
       newNode.next = node;
       newNode.next.pre = newNode;
       newNode.pre.next = newNode;
     }  

     //移除特定元素
     private void remove(Node node)  
     { if(node.pre==null&&node.next==null) return; 
       node.next.pre = node.pre;
       node.pre.next = node.next;
       node.pre = null;
       node.next = null;
     }  

}










class DoubleLinkedList  
{  
private static class Node  
{  
  Object value;  
  Node prev = this;  
  Node next = this;  

  Node(Object v)  
  {  
    value = v;  
  }  
}  
private Node head = new Node(null); // 头节点  
// 以下是接口方法  


public boolean add(Object o)  
{  
    addBefore(new Node(o), head);  
    return true;  
}  

 //在某元素之前添加元素
 private void addBefore(Node newNode, Node node)  
 {  
   newNode.prev = node.prev;
   newNode.next = node;
   newNode.next.prev = newNode;
   newNode.prev.next = newNode;
 }  

 //移除特定元素
 private void removeNode(Node node)  
 {  
   node.next.prev = node.prev;
   node.prev.next = node.next;
   node.prev = null;
   node.next = null;
 }  


// ————————————————
// 版权声明：本文为CSDN博主「罗拙呓」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/as02446418/article/details/47114711






// Accept:

class Node {
    int num, count;
    Node pre, next;
    Node(int num, int count) {
        this.num=num;
        this.count=count;
        pre = this;
        next = this;
    }
}
class FirstUnique {
    int count=0;
    HashMap<Integer, Node> map=new HashMap<Integer, Node>();
    private Node dummy;// dummy节点是一个冗余节点，dummy的next是链表的第一个节点，dummy的pre是链表的最后一个节点
    public FirstUnique(int[] nums) {
        dummy = new Node(999, 999);
        for(int i=0;i<nums.length;i++){
            Node currNode=map.get(nums[i]);
            int currCount=currNode==null?0:currNode.count;
            if(currCount==0){
                   Node node=new Node(nums[i],currCount+1);
                   add(node);
                   map.put(nums[i],node);
                   count++;
            }else{
                Node old=map.get(nums[i]);
                remove(old);
                count--;
            }
        }
    }
    public int showFirstUnique() {
        if(dummy.next!=null&&dummy.next.num!=999){
           return dummy.next.num;
        }
        return -1;
    }
    public void add(int value) {
            Node currNode=map.get(value);
            int currCount=currNode==null?0:currNode.count;
            if(currCount==0){
                   Node node=new Node(value,currCount+1);
                   add(node);
                   map.put(value,node);
            }else{
                Node old=map.get(value);
                remove(old);
            }
    }
     /**
     * 在链表尾部添加新节点  @param node 新节点
     */
    private void add(Node node) {
        dummy.pre.next = node;
        node.pre = dummy.pre;
        node.next = dummy;
        dummy.pre = node;
    }
    /**
     * 从双向链表中删除该节点  @param node 要删除的节点
     */
    private void remove(Node node) {
        if(node.num==-999) return;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.num=-999;
    }
}





// Accept:

class FirstUnique {
    HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
    LinkedList<Integer> list=new LinkedList<Integer>();
    
    public FirstUnique(int[] nums) {
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
            int curr=map.getOrDefault(nums[i],0);
            map.put(nums[i],curr+1);
        }
    }
    
    public int showFirstUnique() {
        while(list.size()!=0&&map.getOrDefault(list.getFirst(),0)>1) list.removeFirst();   // lazy delete 因为，add的操作明显比showFirst的操作低得多
        return list.size()>0? list.getFirst():-1;
    }
    
    public void add(int value) {
        list.add(value);
        int curr=map.getOrDefault(value,0);
        map.put(value,curr+1);
    }
}









// 只用set 过滤后，仍然超时：

class FirstUnique {
    HashSet set=new HashSet();
    LinkedList<Integer> list=new LinkedList<Integer>();
    public FirstUnique(int[] nums) {
        for(int i=0;i<nums.length;i++){
           boolean isNew=set.add(nums[i]);
            if(isNew){
                   list.add(nums[i]);
            }else{
                    list.remove(new Integer(nums[i]));
            }
        }
    }
    public int showFirstUnique() {
        if(list.size()!=0){
           return list.getFirst();
        }
        return -1;
    }
    public void add(int value) {
            boolean isNew=set.add(value);
            if(isNew){
                   list.add(value);
            }else{
                   list.remove(new Integer(value));
            }
    }
}





加上set 过滤后，仍然超时

class FirstUnique {
    
    private class Node{
        int num;
        int count;
        public Node(int num, int count){
            this.num=num;
            this.count=count;
        }
    }
    HashSet set=new HashSet();
    HashMap<Integer, Node> map=new HashMap<Integer, Node>();
    LinkedList<Node> list=new LinkedList<Node>();
    
    public FirstUnique(int[] nums) {
        
        for(int i=0;i<nums.length;i++){
           boolean isNew=set.add(nums[i]);
            if(isNew){
                   Node node=new Node(nums[i],1);
                   list.add(node);
                   map.put(nums[i],node);
            }else{
                Node old=map.get(nums[i]);
                list.remove(old);
            }
        }
    }
    
    public int showFirstUnique() {
        if(list.size()!=0){
           return list.getFirst().num;
        }
        return -1;
    }
    
    public void add(int value) {
            boolean isNew=set.add(value);
            if(isNew){
                   Node node=new Node(value,1);
                   list.add(node);
                   map.put(value,node);
            }else{
                Node old=map.get(value);
                if(list.contains(old)){
                    list.remove(old);
                }
            }
    }
}




// 仍然超时：

class FirstUnique {
    
    private class Node{
        int num;
        int count;
        public Node(int num, int count){
            this.num=num;
            this.count=count;
        }
    }
    
    HashMap<Integer, Node> map=new HashMap<Integer, Node>();
    LinkedList<Node> list=new LinkedList<Node>();
    
    public FirstUnique(int[] nums) {
        for(int i=0;i<nums.length;i++){
            Node currNode=map.get(nums[i]);
            int currCount=currNode==null?0:currNode.count;
            if(currCount==0){
                   Node node=new Node(nums[i],currCount+1);
                   list.add(node);
                   map.put(nums[i],node);
            }else{
                Node old=map.get(nums[i]);
                list.remove(old);
            }
        }
    }
    
    public int showFirstUnique() {
        if(list.size()!=0){
           return list.getFirst().num;
        }
        return -1;
    }
    
    public void add(int value) {
            Node currNode=map.get(value);
            int currCount=currNode==null?0:currNode.count;
            if(currCount==0){
                   Node node=new Node(value,currCount+1);
                   list.add(node);
                   map.put(value,node);
            }else{
                Node old=map.get(value);
                if(list.contains(old)){
                    list.remove(old);
                }
            }
    }
}







class FirstUnique {
    LinkedHashMap<Integer, Integer> lmap=null;
    List<Integer> list=new ArrayList<Integer>();
    
    public FirstUnique(int[] nums) {
         lmap=new LinkedHashMap<Integer,Integer>(10000,0.75f,false); 
        
        for(int i=0;i<nums.length;i++){
            int curr=lmap.getOrDefault(nums[i],0);
            if(curr==0){
                lmap.put(nums[i],curr+1);
            }else{
                lmap.remove(nums[i]);
            }
        }
    }
    
    public int showFirstUnique() {

       for(Map.Entry<Integer, Integer> entry:lmap.entrySet()){
           return entry.getKey();
       }
       return -1;
    }
    
    public void add(int value) {
        int curr=lmap.getOrDefault(value,0);
        if(curr==0){
            lmap.put(value,curr+1);
        }else{
             lmap.remove(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */




WA:

class FirstUnique {
    HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
    List<Integer> list=new ArrayList<Integer>();
    PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
    
    public FirstUnique(int[] nums) {
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
            int curr=map.getOrDefault(nums[i],0);
            map.put(nums[i],curr+1);
        }
    }
    
    public int showFirstUnique() {
            for(int i=0;i<list.size();i++){
                int val=map.getOrDefault(list.get(i),0);
                if(val==1){
                     pq.add(list.get(i));
                }
            }
        
        if(!pq.isEmpty()){
            return pq.poll();
        }
    
        return -1;
    }
    
    public void add(int value) {
        list.add(value);
        int curr=map.getOrDefault(value,0);
        map.put(value,curr+1);
    }
}







7.57pm-8.10pm:

over time limit:

["FirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","showFirstUnique","showFirstUnique","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","showFirstUnique","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","add","add","showFirstUnique","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","showFirstUnique","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique","showFirstUnique","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","showFirstUnique","add","add","showFirstUnique","showFirstUnique","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","showFirstUnique","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","showFirstUnique","showFirstUnique","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","showFirstUnique","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","showFirstUnique","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","showFirstUnique","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","showFirstUnique","add","showFirstUnique","showFirstUnique","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","showFirstUnique","add","add","add","showFirstUnique","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","showFirstUnique","showFirstUnique","add","add","showFirstUnique","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","showFirstUnique","showFirstUnique","showFirstUnique","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","showFirstUnique","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","showFirstUnique","add","add","add","showFirstUnique","showFirstUnique","add","add","showFirstUnique","add","showFirstUnique","add","add","showFirstUnique","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","add","showFirstUnique","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","showFirstUnique","add","showFirstUnique"]
[[[760,607,127,131,896,403,136,14,222,735,774,430,166,215,885,797,582,666,774,390,547,907,51,20,340,746,174,513,642,210,928,529,303,857,533,714,340,979,770,476,808,621,5,534,62,191,655,132,212,468,922,411,861,257,830,137,308,89,688,797,496,325,295,687,656,183,730,350,813,614,586,43,609,226,608,661,820,609,918,451,633,607,82,160,240,208,361,947,711,808,479,511,412,900,887,393,580,575,560,483,2,999,48,728,522,496,318,923,449,334,200,37,449,788,166,508,706,978,658,880,614,179,659,777,274,137,603,371,857,360,549,889,638,852,679,183,133,270,653,960,77,16,165,354,916,916,803,163,393,518,596,314,898,104,494,941,628,305,334,366,747,279,893,643,625,384,40,940,747,279,714,990,480,382,720,197,978,824,934,969,682,173,537,716,66,715,971,173,651,429,107,553,518,364,558,258,380,369,727,371,827,256,9,845,350,768,623,21,361,949,486,329,147,506,64,294,824,728,865,819,373,502,771,676,78,248,643,586,342,151,245,684,246,86,912,947,581,676,612,334,196,588,929,199,894,702,752,677,959,3,579,181,971,461,338,969,927,399,201,381,772,211,142,978,98... 318692 more chars

class FirstUnique {
    HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
    List<Integer> list=new ArrayList<Integer>();
    
    public FirstUnique(int[] nums) {
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
            int curr=map.getOrDefault(nums[i],0);
            map.put(nums[i],curr+1);
        }
    }
    
    public int showFirstUnique() {
        for(int i=0;i<list.size();i++){
            int curr=map.getOrDefault(list.get(i),-1);
            if(curr==1) return list.get(i);
        }
        return -1;
    }
    
    public void add(int value) {
        list.add(value);
        int curr=map.getOrDefault(value,0);
        map.put(value,curr+1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */














class Node {
    int num, count;
    Node pre, next;
    Node(int num, int count) {
        this.num=num;
        this.count=count;
        pre = this;
        next = this;
    }
}


class FirstUnique {
    int count=0;
    HashMap<Integer, Node> map=new HashMap<Integer, Node>();
    private Node dummy;// dummy节点是一个冗余节点，dummy的next是链表的第一个节点，dummy的pre是链表的最后一个节点
    
    public FirstUnique(int[] nums) {
        dummy = new Node(0, 0);
        for(int i=0;i<nums.length;i++){
            Node currNode=map.get(nums[i]);
            int currCount=currNode==null?0:currNode.count;
            if(currCount==0){
                   Node node=new Node(nums[i],currCount+1);
                   add(node);
                   map.put(nums[i],node);
                   count++;
            }else{
                Node old=map.get(nums[i]);
                remove(old);
                count--;
            }
        }
    }
    
    public int showFirstUnique() {
        if(!=0){
           return dummy.next.num;
        }
        return -1;
    }
    
    public void add(int value) {
            Node currNode=map.get(value);
            int currCount=currNode==null?0:currNode.count;
            if(currCount==0){
                   Node node=new Node(value,currCount+1);
                   list.add(node);
                   map.put(value,node);
            }else{
                Node old=map.get(value);
                if(list.contains(old)){
                    list.remove(old);
                }
            }
    }


     /**
     * 在链表尾部添加新节点  @param node 新节点
     */
    private void add(Node node) {
        dummy.pre.next = node;
        node.pre = dummy.pre;
        node.next = dummy;
        dummy.pre = node;
    }
    /**
     * 从双向链表中删除该节点  @param node 要删除的节点
     */
    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

}





