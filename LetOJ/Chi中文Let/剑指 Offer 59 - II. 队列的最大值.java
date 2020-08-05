
/*
 * 
link: 


2020-8-4 at 9:33 am

剑指 Offer 59 - II. 队列的最大值
难度
中等

130





请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

若队列为空，pop_front 和 max_value 需要返回 -1

示例 1：

输入: 
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
示例 2：

输入: 
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



思路和剑指Offer59-2基本完全一致。
这里仅仅对涉及到的知识点进行复习：

ArrayList是顺序结构，所以定位很快，但插入，删除数据慢。
LinkedList 是链表结构，定位慢，但插入，删除数据快。

ArrayList实现了List接口，常见方法有：
add(); contains(); get(); indexOf():定位对象所处的位置; remove(); size(); toArray(); toString();//转换为字符串

LinkedList也实现了List接口外，可以实现上述ArrayList中的常用方法，此外：
1.LinkedList还实现了双向链表结构Deque，可以很方便的在头尾插入删除数据。
LinkedList<class> link = new LinkedList<>();
常用方法：addFirst(); addLast(); getFirst(); getLast(); removeFirst(); removeLast();

2.LinkedList除了实现了List和Deque外，还实现了Queue接口(队列),Queue是先进先出队列 FIFO。
Queue<class> queue = new LinkedList<>();
常用方法：poll()取出第一个元素; peek()查看第一个元素; offer()在最后添加元素,可用add()替换;

先进后出FILO Stack栈：
Stack<class> stack = new Stack<>();
常用方法：push();可用add();代替 pop();输出末尾的元素相当于LinkedList中的removeLast(); peek();查看最后一个元素，相当于getLast();

作者：mo-fei-25
链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-ii-javashi-xian-yuan-li-he-mian-shi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 * 
 */

















public class MaxQueue {

    Queue<Integer> queue;
    LinkedList<Integer> max;
    public MaxQueue() {
        queue = new LinkedList<>();
        max = new LinkedList<>();//LinkedList是双端链表
    }
    
    public int max_value() {
        return max.size()==0?-1:max.getFirst();
    }
    
    public void push_back(int value) {
        queue.add(value);
        while(max.size()!=0&&max.getLast()<value){//注意：这里第二个判断条件不能带等号，即max中对于当前queue中的具有相同值的元素会全部存储，而不是存储最近的那个。
            max.removeLast();
        }
        max.add(value);
    }
    
    public int pop_front() {
        if(max.size()!=0&&queue.peek().equals(max.getFirst()))//Integer类型的值的比较不能直接使用==
            max.removeFirst();
        return queue.size()==0?-1:queue.poll();
    }

}


    
    /**
     * Your MaxQueue object will be instantiated and called as such:
     * MaxQueue obj = new MaxQueue();
     * int param_1 = obj.max_value();
     * obj.push_back(value);
     * int param_3 = obj.pop_front();
     */
// 作者：mo-fei-25
// 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-ii-javashi-xian-yuan-li-he-mian-shi/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





//自己写的，还没有写完：
//9.23am-
class MaxQueue {
    int max=Integer.MIN_VALUE;
    public MaxQueue() {
        LinkedList<Integer> que=new LinkedList<Integer>();
        LinkedList<Integer> maxQue=new LinkedList<Integer>();
    }
    
    public int max_value() {
        if(!maxQue.isEmpty())
        {
            return maxQue.peek();
        }
        return -1;
    }
    
    public void push_back(int value) {
        if(value>max){
            max=value; //update the max
        }
        if(!maxQue.isEmpty()&&value>maxQue.peek()){
            maxQue.add(value);
        }else if(maxQue.isEmpty()){
            maxQue.add(value);
        }else if(maxQue.peek()>=value){
            maxQue.add(maxQue.peek());
        }
        que.add(value);
    }
    
    public int pop_front() {
        if(!maxQue.isEmpty){
            int value=maxQue.pollFirst();
            if(value==max){
                
            }
        }
        if(!que.isEmpty()){
            return que.pollFirst();
        }
        return -1;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */