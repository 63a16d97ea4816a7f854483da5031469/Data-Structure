
/*
 * 
link: https://leetcode-cn.com/problems/min-stack/

155. 最小栈
难度
简单

1157

收藏

分享
切换为英文
接收动态
反馈
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。
 

示例:

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 

提示：

pop、top 和 getMin 操作总是在 非空栈 上调用。

2022-02-03 at 23:16
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

数据栈+最小栈
这道题标准的解法是用两个栈，一个存放数据，一个存放当前最小值，空间换时间。
把两个栈封装在一个栈中，其中的一个栈存放正常的元素，另一个栈 minStack 只存当前最小值。
push：数据栈正常操作。比较当前元素和最小栈minStack的栈顶，比栈顶还小则进栈，否则push原栈顶。
pop：数据栈正常操作。最小栈minStack也pop
getMin：直接返回最小栈栈顶

push，pop，top，getMin 时间复杂度都是 O(1)，空间复杂度 O(n)

这里还可以有个优化，最小栈并不和数据栈同步更新，只是每次push遇到小于等于栈顶的才放入。pop时如果出栈的数据就是最小栈栈顶最小栈，则最小栈也pop。

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack=new Stack<Integer>();
        minStack=new Stack<Integer>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            minStack.push(val);
        }else{
            if(minStack.peek()>val){
                minStack.push(val);
            }else{
                minStack.push(minStack.peek());
            }
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        return stack.peek();
    }
    
    public int getMin() {
        if(minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}



http://masikkk.com/article/LeetCode.155.MinStack/

栈+最小堆(优先队列)
没想到很好的思路，用 栈 + 优先队列（最小堆） 实现的。

push 优先队列offer O(logn)
pop 优先队列remove(x) O(n)
top O(1)
getMin O(1)
空间复杂度 O(n)


private static class MinStack {
    private Deque<Integer> stack;
    private PriorityQueue<Integer> priorityQueue;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        // 优先队列，小顶堆，堆顶永远是最小值
        priorityQueue = new PriorityQueue<>();
    }
    public void push(int x) {
        stack.push(x);
        priorityQueue.offer(x);
    }
    public void pop() {
        Integer i = stack.pop();
        // remove(x) 的时间复杂度为O(n)
        priorityQueue.remove(i);
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return priorityQueue.peek();
    }
}


https://github.com/azl397985856/leetcode/blob/master/problems/155.min-stack.md

关键点

最小栈存储的不应该是真实值，而是真实值和min的差值
top的时候涉及到对数据的还原，这里千万注意是上一个最小值


是否有更高效的算法呢？答案是有的。

我们每次入栈的时候，保存的不再是真正的数字，而是它与当前最小值的差（当前元素没有入栈的时候的最小值）。 这样我们pop和top的时候拿到栈顶元素再加上上一个最小值即可。 另外我们在push和pop的时候去更新min，这样getMin的时候就简单了，直接返回min。

注意上面加粗的“上一个”，不是“当前的最小值”
经过上面的分析，问题的关键转化为“如何求得上一个最小值”，解决这个的关键点在于利用min。

pop或者top的时候：

如果栈顶元素小于0，说明栈顶是当前最小的元素，它出栈会对min造成影响，我们需要去更新min。 上一个最小的是“min - 栈顶元素”,我们需要将上一个最小值更新为当前的最小值
因为栈顶元素入栈的时候的通过 栈顶元素 = 真实值 - 上一个最小的元素 得到的， 而真实值 = min， 因此可以得出上一个最小的元素 = 真实值 -栈顶元素
如果栈顶元素大于0，说明它对最小值没有影响，上一个最小值就是上上个最小值。


class MinStack {
    long min;
    Stack<Long> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        }
        else {
            stack.push(x - min);
            if (x < min)
                min = x;
        }
    }
    
    public void pop() {
        long p = stack.pop();
        
        if (p < 0) {
            // if (p < 0), the popped value is the min
            // Recall p is added by this statement: stack.push(x - min);
            // So, p = x - old_min
            // old_min = x - p
            // again, if (p < 0), x is the min so:
            // old_min = min - p
            min = min - p;
        }
    }
    
    public int top() {
        long p = stack.peek();
        
        if (p < 0) {
            return (int) min;
        }
        else {
            // p = x - min
            // x = p + min
            return (int) (p + min);
        }
    }
    
    public int getMin() {
        return (int) min;    
    }
}




