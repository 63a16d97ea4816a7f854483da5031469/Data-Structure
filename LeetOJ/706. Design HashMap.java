
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


706. Design HashMap
Easy

744

94

Add to List

Share
Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 

Note:

All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.


17 May 2020 at 5:10 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */








class MyHashMap {
    Node[] arr;
    int size=10000;
    /** Initialize your data structure here. */
    public MyHashMap() {
        arr=new Node[size];
        for(int i=0;i<size;i++){
            arr[i]=new Node(-1,1);
        }
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node p=findNode(key);
        if(p.next==null){
            p.next=new Node(key,value);
        }else{
            //update the value;
            p.next.value=value;
        }
    }
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
       Node p=findNode(key);
       if(p.next==null) return -1;
       return p.next.value;
    }
    public Node findNode(int key){
        int hash_index=getHash(key);
        Node p=arr[hash_index];
        while(p.next!=null&&p.next.key!=key){ //非常重要的一句，注意是p.next.key!=key
            p=p.next;
        }
        return p;
    }
    public int getHash(int key){
        return key % size;
    }
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Node p=findNode(key);
        if(p.next==null) return;
        p.next=p.next.next;
    }
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */















