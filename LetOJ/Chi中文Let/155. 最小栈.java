
/*
 * 
link: 
https://leetcode-cn.com/problems/min-stack/

2020-7-28 at 8:36 am


155. 最小栈
难度
简单

620

收藏

分享
切换为英文
关注
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

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




class MinStack {

    Stack<Integer> minStack=null;   
    Stack<Integer> stack=null;
    /** initialize your data structure here. */
    public MinStack() {
            minStack=new Stack<Integer>();
            stack=new Stack<Integer>();
    }
    public void push(int x) {
        if(minStack.isEmpty()){
            minStack.push(x);
        }else{
            int value=Math.min(minStack.peek(),x);
            minStack.push(value);
        }
        stack.push(x);
    }
    public void pop() {
        if(!minStack.isEmpty()){
            minStack.pop();
        }
        if(!stack.isEmpty()){
            stack.pop();
        }
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

















