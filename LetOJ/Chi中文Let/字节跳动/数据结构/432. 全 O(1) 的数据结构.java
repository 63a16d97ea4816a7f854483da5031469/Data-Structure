
/*
 * 
link: 
https://leetcode-cn.com/problems/all-oone-data-structure/

2020-7-19 at 9:41 pm

432. 全 O(1) 的数据结构
难度
困难

55

收藏

分享
切换为英文
关注
反馈
请你实现一个数据结构支持以下操作：

Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否则使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串"" 。
GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 

挑战：

你能够以 O(1) 的时间复杂度实现所有操作吗？



对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */








class AllOne {

    //设计思路：
    // 1.外层哈希表<key,Node>，通过key找到key所在的层
    // 2.层与层之间是双向链表，有头尾哨兵节点，保持层从头到尾值是升序
    // 3.层保存着一个val，和值为val的key集合

    class Node {
        int val;
        Set<String> keys;
        Node prev, next;
        public Node(int val) {
            this.val = val;
            keys = new HashSet<>();
        }
    }
    //将节点newNode插在原节点node前
    public void insertPre(Node node, Node newNode) {
        newNode.prev = node.prev;
        newNode.next = node;
        node.prev.next = newNode;
        node.prev = newNode;
    }
    //将节点newNode插在原节点node后
    public void insertPost(Node node, Node newNode) {
        newNode.prev = node;
        newNode.next = node.next;
        node.next.prev = newNode;
        node.next = newNode;
    }
    //删除节点
    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    Node head, tail;
    //将key映射到key所在的层
    HashMap<String, Node> map;



    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<String, Node>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int num = node.val;
            //1.key无需到下一层的情况
            if (node.keys.size() == 1 && node.next.val != num + 1) {
                node.val = num + 1;
            }
            //2.key要到下一层的情况：有下一层；无下一层
            else {
                node.keys.remove(key);
                Node newNode = node.next;
                if (newNode.val != num + 1) {
                    newNode = new Node(num + 1);
                    //因为是升序的，所以一定出入到post
                    insertPost(node, newNode);
                }
                newNode.keys.add(key);
                map.put(key, newNode);

                //注意这个处理：
                if (node.keys.isEmpty()) {
                    deleteNode(node);
                }
            }
        } else {
            //由于dec(key)的规则要求，最小层的val必然大于等于1
            Node node = head.next;
            if (node.val != 1) {
                node = new Node( 1);
                insertPost(head, node);
            }
            node.keys.add(key);
            map.put(key, node);
        }
    }


    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }
        Node node = map.get(key);
        int num = node.val;
        //1.当前层只有该key
        if (node.keys.size() == 1) {
            //如果当前层为1，则减去后，需要删除整层，因为按要求最小值为>=1 (规则： 如果这个 key 的值是 1，那么把他从数据结构中移除掉。)
            if (num-- == 1) {
                deleteNode(node);
                map.remove(key);
            } else {
                //如果跟前面的层的值相等，则合并
                if (node.prev.val == num) {
                    node.prev.keys.add(key);
                    deleteNode(node);
                    map.put(key, node.prev);
                } else {
                    //如果跟前面层的值不等，则独立为一层
                    node.val = num;
                }
            }
        }
        //2.当前层不止有该key
        else {
            node.keys.remove(key);
            if (num-- == 1) {
                map.remove(key);   //删该值only  (规则： 如果这个 key 的值是 1，那么把他从数据结构中移除掉。)
            } else {
                Node newNode = node.prev;
                if (newNode.val != num) {
                    newNode = new Node(num);
                    insertPre(node, newNode);
                }
                newNode.keys.add(key);
                map.put(key, newNode);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        Node maxNode = tail.prev;
        return maxNode.keys.isEmpty() ? "" : maxNode.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        Node minNode = head.next;
        return minNode.keys.isEmpty() ? "" : minNode.keys.iterator().next();
    }
}

// 作者：iridescent-aries
// 链接：https://leetcode-cn.com/problems/all-oone-data-structure/solution/java-an-valzhi-fen-ceng-cun-chu-key-by-iridescent-/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。










class AllOne {

    class Node{
        int value;
        String key;
        Node pre;
        Node next;
        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    HashMap<String, Node> map = new HashMap<>();
    
    Node head;
    Node tail;
    /** Initialize your data structure here. */
    public AllOne() {
        head = new Node("", -1);
        tail = new Node("", -1);
        head.next = tail;
        tail.pre = head;
    }
    
    // 将src插入到des的前面
    public void insertPre(Node src, Node des) {
        Node temp = des.pre;
        temp.next = src;
        src.pre = temp;
        des.pre = src;
        src.next = des;
    }
    
    // 将src插入到des的后面
    public void insertNext(Node src, Node des) {
        Node temp = des.next;
        temp.pre = src;
        src.next = temp;
        des.next = src;
        src.pre = des;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        // 如果map中包含key,找到key对应的node
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value ++;
            // 找到大于等于它的第一个Node,插入到其前面
            if(node.next != tail) {
                Node temp = node.next;
                while(temp!=tail && temp.value<node.value) {
                    temp = temp.next;
                }
                // 连接node断开处前面的和后面的节点
                node.pre.next = node.next;
                node.next.pre = node.pre;
                // 将node插入到temp的前面
                insertPre(node, temp);
            }
          
        } else {
            // 如果map中不包含key,则直接创建一个node插入到head的后面，同时将key记录到map中
            Node node = new Node(key, 1);
            map.put(key, node);
            insertNext(node, head);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        // map中包含key,不包含的话不管了
        if(map.containsKey(key)) {
            Node node = map.get(key);
            // 如果key对应的node值为1，则从链表中移除节点，map中也移除该key
            if(node.value == 1) {
              node.pre.next = node.next;
              node.next.pre = node.pre;  
              map.remove(key);
            } else {
              // 如果key对应的node值不为1，则向前寻找到它前方的第一个小于它的节点temp，插入到temp后方
              node.value --;
              if(node.pre != head) {
                Node temp = node.pre;
                while(temp!=head && temp.value>node.value) {
                    temp = temp.pre;
                }
                // 连接断开处的
                node.pre.next = node.next;
                node.next.pre = node.pre;
                // 插入到temp后方
                insertNext(node, temp);
                
              }
                
            }
            
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.pre.key;
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next.key;
    }
}

// 作者：echoyu
// 链接：https://leetcode-cn.com/problems/all-oone-data-structure/solution/javayi-dong-ti-jie-shuang-xiang-lian-biao-hashmap-/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



















