
/*
 * 
https://leetcode.com/problems/lru-cache/

146. LRU Cache
Medium

5248

234

Add to List

Share
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache(capacity); //capacity

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





import java.util.Hashtable;


public class LRUCache {

class DLinkedNode {
  int key;
  int value;
  DLinkedNode pre;
  DLinkedNode next;
}

/**
 * Always add the new node right after head;
 */
private void addNode(DLinkedNode node) {
    
  node.pre = head;
  node.next = head.next;

  head.next.pre = node;
  head.next = node;
}

/**
 * Remove an existing node from the linked list.
 */
private void removeNode(DLinkedNode node){
  DLinkedNode pre = node.pre;
  DLinkedNode next = node.next;

  pre.next = next;
  next.pre = pre;
}

/**
 * Move certain node in between to the head.
 */
private void moveToHead(DLinkedNode node){
  this.removeNode(node);
  this.addNode(node);
}

// pop the current tail. 
private DLinkedNode popTail(){
  DLinkedNode res = tail.pre;
  this.removeNode(res);
  return res;
}

private Hashtable<Integer, DLinkedNode> 
  cache = new Hashtable<Integer, DLinkedNode>();
private int count;
private int capacity;
private DLinkedNode head, tail;

public LRUCache(int capacity) {
  this.count = 0;
  this.capacity = capacity;

  head = new DLinkedNode();
  head.pre = null;

  tail = new DLinkedNode();
  tail.next = null;

  head.next = tail;
  tail.pre = head;
}

public int get(int key) {

  DLinkedNode node = cache.get(key);
  if(node == null){
    return -1; // should raise exception here.
  }

  // move the accessed node to the head;
  this.moveToHead(node);

  return node.value;
}


public void put(int key, int value) {
  DLinkedNode node = cache.get(key);

  if(node == null){

    DLinkedNode newNode = new DLinkedNode();
    newNode.key = key;
    newNode.value = value;

    this.cache.put(key, newNode);
    this.addNode(newNode);

    ++count;

    if(count > capacity){
      // pop the tail
      DLinkedNode tail = this.popTail();
      this.cache.remove(tail.key);
      --count;
    }
  }else{
    // update the value.
    node.value = value;
    this.moveToHead(node);
  }
}

}





//有头指针，有尾部指针的design:

class LRUCache {
    class Node {
        Node next;
        Node prev;
        int value;
        int key;
        Node(int key, int value) {
            this.key=key;
            this.value=value;
        }
    }

    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node==null)
            return -1;
        
        updateHead(node);
        return node.value;
    }
    
    private void updateHead(Node node) {
        if(node==head)
            return;
        Node prev = node.prev;
        Node next = node.next;
        
        if(node == tail) 
            tail=prev;

        prev.next=next;
        if(next!=null)
            next.prev=prev;

        node.next=head;
        head.prev=node;
        head=node;
    }
    
    public void put(int key, int value) {
        if(map.get(key) != null) {
            if(map.get(key) != head) {
                Node node = map.get(key);
                updateHead(node);
            }
            map.get(key).value=value;
        }
        else {
            Node node = new Node(key, value);
            map.put(key,node);
            node.next=head;
            if(head==null) {
                tail=node;
            }
            else {
                head.prev=node;
            }
            head=node;
            if(map.size() > capacity) {
                map.remove(tail.key);
                tail.prev.next=null;
                tail=tail.prev;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */















这个画图画，动画的好：  
https://leetcode-cn.com/problems/lru-cache/solution/ha-xi-biao-shuang-xiang-lian-biao-java-by-liweiw-2/


LRU:
双向链表的头部，存的是 最新访问 的 
双向链表的尾部，存的是 最旧访问 的



public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    LRULinkedHashMap(int capacity) {
        // 初始大小，0.75是装载因子，true是表示按照访问时间排序
        super(capacity, 0.75f, true);
        //传入指定的缓存最大容量
        this.capacity = capacity;
    }

    /**
     * 实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}

// 作者：icecrea
// 链接：https://leetcode-cn.com/problems/lru-cache/solution/san-chong-fang-fa-dai-ni-shou-si-lrusuan-fa-javaba/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




// 使用java   LinkedHashMap 来构建：

class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
}

/**
 * LRUCache 对象会以如下语句构造和调用:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/lru-cache/solution/lru-huan-cun-ji-zhi-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。













//  使用java内置的linkedList来进行书写:

class LRUCache {
    class Node{
        int key;
        int val;
        public Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> map=new HashMap<Integer, Node>();
    private LinkedList<Node> list=new LinkedList<Node>();
    public LRUCache(int capacity) {
        //init
        this.capacity=capacity;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            //存在过，就提到队首
            Node old=map.get(key);
            list.remove(old);
            Node newNode=new Node(old.key,old.val);
            list.addFirst(newNode);
            map.put(newNode.key, newNode);
            return old.val;
        }
        return -1;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
             //存在过，提到队首
            Node old=map.get(key);
            list.remove(old);
            Node newNode=new Node(old.key,value);
            list.addFirst(newNode);
            map.put(newNode.key,newNode);
        }else{
             if(list.size()==capacity){
                 //达到最大值，需要删除元素，再添加
                Node old=list.removeLast();
                map.remove(old.key); //非常容易忘记的一句
             }
            //never existed before, insert
            Node curr=new Node(key, value);
            map.put(key, curr);
            //insert to head
            list.addFirst(curr);
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */







//使用内建函数：

class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
}

/**
 * LRUCache 对象会以如下语句构造和调用:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/lru-cache/solution/lru-huan-cun-ji-zhi-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





class LRUCache {
    
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    
    private int capacity=10;
    private HashMap<Integer, Node> map=new HashMap<Integer, Node>();
    private Node head=null;
    
    public LRUCache(int capacity) {
        //init
        this.capacity=capacity;
    }
    
    public int get(int key) {
        
        if(map.containsKey(key)){
            //Change this one to be the head
            
            return map.get(key);
        }
        
        
        return -1;
    }
    
    public void put(int key, int value) {
        //first node
        if(head==null){
            Node curr=new Node(key, value);
            map.put(key, curr);
            head=curr;
            return;
        }
        
        //existed before, change the position
        if(map.containsKey(key)){
            Node old=map.get(key);
            
            Node preNode=old.prev;
            
            
            
        }else{
            //never existed before, insert
            Node curr=new Node(key, value);
            map.put(key, curr);
            
            //insert to head
        }
        
     
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */