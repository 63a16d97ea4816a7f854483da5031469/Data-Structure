
/*
 * 
https://leetcode.com/problems/find-median-from-data-stream/


295. Find Median from Data Stream
Hard

2273

43

Add to List

Share
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 

Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




class MedianFinder {

    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());

    public void addNum(int n) {
        min.add(n);
        max.add(min.poll());
        if(min.size() < max.size()) {
            min.add(max.poll());
        }
    }

    public double findMedian() {
        if(min.size() == max.size()) {
            return (min.peek() + max.peek())/2.0;
        }
        else {
            return min.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */















// WA:
class MedianFinder {
    PriorityQueue<Integer> q1=new PriorityQueue(new Comparator<Integer>(){
        public int compare(Integer a, Integer b){
            return a-b;
        }
    });
     PriorityQueue<Integer> q2=new PriorityQueue(new Comparator<Integer>(){
        public int compare(Integer a, Integer b){
            return b-a;
        }
    });
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(q1.size()>q2.size()){
            q2.add(num);
        }else{
            q1.add(num);
        }
    }
    
    public double findMedian() {
        int n1=q1.size();
        int n2=q2.size();
        System.out.println(q1.peek()+" "+q2.peek());
        if((n1+n2)%2==0){
            return (double)(q1.peek()+q2.peek())/2;
        }else{
            return q2.peek()==null?q1.peek():q2.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */