
/*
 * 
link: 


2020-8-11 at 11:57 pm


剑指 Offer 09. 用两个栈实现队列
难度
简单

103

收藏

分享
切换为英文
关注
反馈
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

 

示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
提示：

1 <= values <= 10000
最多会对 appendTail、deleteHead 进行 10000 次调用

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

class CQueue {
    Stack<Integer> firstStack;
    Stack<Integer> secondStack;
   public CQueue() {
      firstStack=new Stack<Integer>();
      secondStack=new Stack<Integer>();
   }
   
   public void appendTail(int value) {
       firstStack.push(value);
   }
   
   public int deleteHead() {
           if(!secondStack.isEmpty()){
               return secondStack.pop();
           }else{
               while(!firstStack.isEmpty()){
                   secondStack.push(firstStack.pop());
               }
           }
           if(secondStack.isEmpty()) return -1;
       return secondStack.pop();
   }
}

/**
* Your CQueue object will be instantiated and called as such:
* CQueue obj = new CQueue();
* obj.appendTail(value);
* int param_2 = obj.deleteHead();
*/






















