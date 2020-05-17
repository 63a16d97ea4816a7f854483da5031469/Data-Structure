
/*
 * 
https://leetcode.com/problems/peeking-iterator/


284. Peeking Iterator
Medium

443

300

Add to List

Share
Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

Example:

Assume that the iterator is initialized to the beginning of the list: [1,2,3].

Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after that still return 2. 
You call next() the final time and it returns 3, the last element. 
Calling hasNext() after that should return false.
Follow up: How would you extend your design to be generic and work with all types, not just integer?

17 May 2020 at 4:34 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iter;
    // 相当于与赌一个peek, 存在本地，hasNext(). next()都会判断这个peek的值
    private Integer peek = null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // 完全利用iterator预先读出一个next，保存在peek中，
        // 之后的next(), 优先返回peek,然后peek
        if (iterator != null && iterator.hasNext()) {
            peek = iterator.next();
        }
	    iter = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    // As per the Java Iterator specs, we should throw a NoSuchElementException. if the next element doesn't exist.
        // if (peek == null) {
        //     throw new NoSuchElementException();
        // }
        Integer res = peek;
        peek = null;
        if (iter.hasNext()) {
            peek = iter.next();
        }
        return res;
	}

	@Override
	public boolean hasNext() {
	    return peek != null;
	}
}






// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    //4.28pm-4.33pm AC
    LinkedList<Integer> que=new LinkedList<Integer>();
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    while(iterator.hasNext()){
            que.add(iterator.next());
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(que.isEmpty()) return null;
        return que.peekFirst();
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(que.isEmpty()) return null;
        return que.removeFirst();
	}
	
	@Override
	public boolean hasNext() {
	    return !que.isEmpty();
	}
}












