
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


705. Design HashSet
Easy

290

68

Add to List

Share
Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)

Note:

All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.



23 May 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


//7.03pm-7.05pm 使用了其他内建的lib:
class MyHashSet {
    LinkedList<Integer> list=null;
    /** Initialize your data structure here. */
    public MyHashSet() {
        list=new LinkedList<Integer>();
    }
    
    public void add(int key) {
        if(!list.contains(key)){
            list.add(key);
        }
    }
    
    public void remove(int key) {
        if(list.contains(key)){
            list.remove(new Integer(key));
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return list.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */






class MyHashSet {
    
    boolean[] arr = new boolean[100];// start with 100 elements for fast initialization
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        if(key>=arr.length) // if array is too small to accomodate key, extend it.
            extend(key);
        arr[key]=true;
    }
    
    public void remove(int key) {
        if(key>=arr.length) // if array is too small to accomodate key, extend it.
            extend(key);
        arr[key]=false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(key>=arr.length) // key cannot be in array if array's length < key
            return false;
        return arr[key]==true;
    }
    
    public void extend(int key){
        arr= Arrays.copyOf(arr, key+2);   
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */



// Beats 100% Real Java Solution (Not boolean array)

/*
All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
*/

class MyHashSet {
    private int buckets = 1000;
    private int itemsPerBucket = 1001;
    private boolean[][] table;
    /** Initialize your data structure here. */
    public MyHashSet() {
        table = new boolean[buckets][];
    }
    public int hash(int key) {
        return key % buckets;
    }
    public int pos(int key) {
        return key / buckets;
    }
    public void add(int key) {
        int hashkey = hash(key);
        
        if (table[hashkey] == null) {
            table[hashkey] = new boolean[itemsPerBucket];
        }
        table[hashkey][pos(key)] = true;
    }
    public void remove(int key) {
        int hashkey = hash(key);

        if (table[hashkey] != null)
            table[hashkey][pos(key)] = false;
    }
    /** Returns true if this set did not already contain the specified element */
    public boolean contains(int key) {
        int hashkey = hash(key);
        return table[hashkey] != null && table[hashkey][pos(key)];
    }
}






class MyHashSet {
    /** Initialize your data structure here. */
    int removed = Integer.MAX_VALUE;
    int [] elements;
    int size ;
    public MyHashSet() {
        elements = new int [100000];
        for(int k =0; k<elements.length;k++)
            elements[k] = removed;
    }
    public int hash(int key){
        return Math.abs(key)%elements.length;
    }
    public void rehash(){
        int [] old = elements;
        
        elements = new int [2*old.length];
        size=0;
        for(int k =0; k<elements.length;k++)
            elements[k] = removed;
        for(int value : old){
            if(value != removed)
                add(value);
        }
    }
    public void add(int key) {
        if((double) size/elements.length>=0.75)
            rehash();
        if(!contains(key)){
        
        int h = hash(key);
        while(elements[h] !=key && elements [h]!= removed)
            h = (h+1)%elements.length;
        if(elements[h]!= key){
            size++;
            elements[h] =key;
        }
        }
    }
    
    public void remove(int key) {
        if(contains(key)){
        int h = hash(key);
        while(elements[h] != key && elements[h] != removed)
            h = (h+1)%elements.length;
        if(elements [h] == key){
            elements [h] = removed;
            size--;
        }
    }
    } 
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);
        while(elements[h] != removed  && elements[h] != key ){
            
            h = (h+1)%elements.length;
        }
        if(elements[h] == key)
                return true;
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

