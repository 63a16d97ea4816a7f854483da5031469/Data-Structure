
/*
 * 
https://leetcode.com/problems/insert-delete-getrandom-o1/


380. Insert Delete GetRandom O(1)
Medium

2249

144

Add to List

Share
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();

12 June 2020 at 11:45 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


// 最快答案:
class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }    
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int index = map.remove(val);
            int lastElement = list.get(list.size() - 1);
            if(lastElement != val) {
                list.set(index, lastElement);
                map.put(lastElement, index);
            }
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

// 0 -> 0



// 次快答案:

class RandomizedSet {

    private HashMap<Integer, Integer> valueToIndex = new HashMap<>();
    private HashMap<Integer, Integer> indexToValue = new HashMap<>();
    private int nextIndex = 0;
    private Random random = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)) {
            return false;
        }
        valueToIndex.put(val, nextIndex);
        indexToValue.put(nextIndex, val);
        nextIndex++;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer index = valueToIndex.remove(val);
        if (index != null) {
            indexToValue.remove(index);
            nextIndex--;
            // shift the last one into the empty slot if it wasn't last already
            if (index != nextIndex) {
                Integer lastValue = indexToValue.remove(nextIndex);
                indexToValue.put(index, lastValue);
                valueToIndex.put(lastValue, index);
            }
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int r = random.nextInt(nextIndex);
        return indexToValue.get(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */




class RandomizedSet {
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> idxMap = new HashMap<>();
    Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (idxMap.containsKey(val)) {
            return false;
        }
        list.add(val);
        idxMap.put(val, idxMap.size());
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!idxMap.containsKey(val)) {
            return false;
        }
         
        int indexRemove = idxMap.get(val);
        int tail = list.get(list.size() - 1);
         
        swap(indexRemove, list.size() - 1);
        idxMap.put(tail, indexRemove);
        list.remove(list.size() - 1);
        idxMap.remove(val);
         
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if (idxMap.isEmpty()) {
            return 0;
        }
  
        int rid = random.nextInt(idxMap.size());
        return list.get(rid);
    }
    private void swap(int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */






// import java.util.*;
class RandomizedSet {
    //11.21pm-11.44pm
    /** Initialize your data structure here. */
    HashMap<Integer, Integer> map=null;
    List<Integer> list=null;
    public RandomizedSet() {
        map=new HashMap<Integer, Integer>();
        list=new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.get(val)==null){
            map.put(val,99);
            list.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.get(val)!=null){
            map.put(val,null);
            list.remove(new Integer(val));
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random ran=new Random();
        int selected=ran.nextInt(list.size());
        // System.out.println(selected);
        int val=list.get(selected);
        return val;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */



















