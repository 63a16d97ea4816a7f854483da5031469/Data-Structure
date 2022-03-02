
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




自己写的:

易错点： 

LRU:
双向链表的头部，存的是 最新访问 的 
双向链表的尾部，存的是 最旧访问 的

 1. 在Get方法里面，要有moveToHead(DLinkedNode node); 不能忘记。
 2. 在Put方法里面，分两种情况，一种是HashMap从来没有这个key的情况，在头部添加（头部永远是最新），然后判断是否达到最大capacity，如果超过，去掉最后一个尾巴值，并去掉其HashMap存的key。
 另一个种是HashMap有这个key，更新值value，并将该node，moveToHead(node);
 3. 不要忘记几个操作： 在头部添加节点 addNode(node)，在尾部删除节点 removeTail(node)，把节点放到头部第一个moveToHead(node)，删除节点 removeNode(node);


 (即便不会，也可以写最简单的linkedlist那种偷懒写法).


class LRUCache {
    int capacity;
    DlinkNode dummyHead;
    DlinkNode dummyTail;
    HashMap<Integer, DlinkNode> map;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        dummyHead=new DlinkNode();
        dummyTail=new DlinkNode();
        dummyHead.next=dummyTail;
        dummyTail.pre=dummyHead;
        map=new HashMap<Integer, DlinkNode>();
    }
    public void removeNode(DlinkNode node){
        node.pre.next=node.next;
        node.next.pre=node.pre; 
    }

    public void addNodeToHead(DlinkNode node){
        node.next=dummyHead.next;
        dummyHead.next.pre=node;
        dummyHead.next=node;
        node.pre=dummyHead; //忘记了这一句
    }

    public DlinkNode removeTail(){
        DlinkNode preNode=dummyTail.pre;
        dummyTail.pre=preNode.pre;
        preNode.pre.next=dummyTail; //忘记了这一句
        return preNode;
    }

    public void moveTohead(DlinkNode node){
        removeNode(node);
        addNodeToHead(node);
    }

    public int get(int key) {
        if(map.containsKey(key)){
            DlinkNode node=map.get(key);
            moveTohead(node);
            return node.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            DlinkNode node=map.get(key);
            node.value=value;
            map.put(key,node);
            moveTohead(node);
        }else{
            // not existed before
            DlinkNode newNode=new DlinkNode(key,value);
            if(map.size()==capacity){
                DlinkNode old=removeTail();
                // update the map;
                map.remove(old.key);
            }
            addNodeToHead(newNode);
            map.put(key,newNode);
        }
    }

    
}
class DlinkNode{
    int key;
    int value;
    DlinkNode pre;
    DlinkNode next;
    public DlinkNode(int key, int value)
    {
        this.key=key;
        this.value=value;
    }
    public DlinkNode(){

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
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
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;   
        pre.next = next;
        next.pre = pre;
    }
    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }
    // pop the current tail. 
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }
    private Hashtable < Integer, DLinkedNode >
        cache = new Hashtable < Integer, DLinkedNode > ();
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
        if (node == null) {
            return -1; // should raise exception here.
        }
        // move the accessed node to the head;
        this.moveToHead(node);
        return node.value;
    }
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            ++count;
            if (count > capacity) {
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
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

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/lru-cache/solution/lruhuan-cun-ji-zhi-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



// 作者：icecrea
// 链接：https://leetcode-cn.com/problems/lru-cache/solution/san-chong-fang-fa-dai-ni-shou-si-lrusuan-fa-javaba/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class LRUCache {
    private LinkedHashMap<Integer,Integer> lru;
    private final int CAPACITY;
    public LRUCache(int capacity) {
         CAPACITY = capacity;
         lru = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true) {
             protected boolean removeEldestEntry(Map.Entry eldest) 
                { 
                    return size() > CAPACITY; 
                } 
        }; 
        
         
    }
    
    public int get(int key) {
        return lru.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        lru.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */




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









/*
  使用linkedlist的时候的LRU （不同于双链表的实现）：
  取元素的时候： 如果存在过，就应当将该元素提到对首，如果没有存在过，就应当返回-1
  存元素的时候： 如果元素存在过，就要删除原先位置的元素，就要生成一个新Node放到队首，并且取代Map元素中存的旧的Node。
*/



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




//没写完:
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











import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * 在链头放最久未被使用的元素，链尾放刚刚添加或访问的元素
 */
class LRUCache {
    class Node {
        int key, value;
        Node pre, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = this;
            next = this;
        }
    }
    private final int capacity;// LRU Cache的容量
    private Node dummy;// dummy节点是一个冗余节点，dummy的next是链表的第一个节点，dummy的pre是链表的最后一个节点
    private Map<Integer, Node> map;//保存key-Node对，Node是双向链表节点
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy = new Node(0, 0);
        map = new ConcurrentHashMap<>();
    }
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        remove(node);
        add(node);
        return node.value;
    }
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            if (map.size() >= capacity) {
                map.remove(dummy.next.key);
                remove(dummy.next);
            }
            node = new Node(key, value);
            map.put(key, node);
            add(node);
        } else {
            map.remove(node.key);
            remove(node);
            node = new Node(key, value);
            map.put(key, node);
            add(node);
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
// ————————————————
// 版权声明：本文为CSDN博主「LoneRanger66」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/csdlwzy/article/details/95635083