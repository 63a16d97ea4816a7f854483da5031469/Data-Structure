/*
 * 
https://leetcode.com/problems/implement-stack-using-queues/


Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
Update (2015-06-11):
The class name of the Java function had been updated to MyStack instead of Stack.


class MyStack {
    // Push element x onto stack.
    public void push(int x) {
        
    }

    // Removes the element on top of the stack.
    public void pop() {
        
    }

    // Get the top element.
    public int top() {
        
    }

    // Return whether the stack is empty.
    public boolean empty() {
        
    }
}


 * 
 * 
 */
import java.util.*;
public class ImplementStackUsingQueues {
	
	
	
	public static void main(String args[]){
		
		ImplementStackUsingQueues que=new ImplementStackUsingQueues();
		que.push(1);
//		que.push(2);
 
//		que.top();
//		que.pop();

		que.pop();
		que.empty();
		
	}
	

	
	/*
	 * 
	 * Accepted.
	 * 
	 */
	
		LinkedList<Integer> l1=new LinkedList<Integer>();
		LinkedList<Integer> l2=new LinkedList<Integer>();
		
	   public void push(int x) {
		   
		   //always from l1, add elements
	       l1.addLast(x);
	   }

	   // Removes the element on top of the stack.
	   public void pop() {
		   
			
			
		   //handle only contain one element's case.
//		   if(l1.size()==1) l1.removeFirst();
		   
		   int length=l1.size();
		   
	       for(int i=0;i<length-1;i++){
	       int removeValue=l1.removeFirst();
	       l2.addLast(removeValue);	
//	       System.out.println("remove:"+removeValue);
	       }

//	       l1.removeFirst();
	       
	       LinkedList<Integer> tmp=l1;
	       l1=l2;
	       l2=tmp;
	       
	       //always from l2 remove elements
	       l2.removeFirst();
	   }

	   // Get the top element.
	   public int top() {
//	       System.out.println("top:"+l1.getLast());
	       return l1.getLast();
	   }

	   // Return whether the stack is empty.
	   public boolean empty() {
//		   System.out.println(l1.isEmpty()&&l2.isEmpty());
	       return (l1.isEmpty()&&l2.isEmpty());
	   }
		
	
	
	
 /*
  * 
 Wrong Answer More Details 

Input:
push(1),pop,empty
Output:
["false"]
Expected:
["true"]

Reason:
one sentence should not be deleted.
  * 
  */
//	LinkedList<Integer> l1=new LinkedList<Integer>();
//	LinkedList<Integer> l2=new LinkedList<Integer>();
//	
//   public void push(int x) {
//       l1.addLast(x);
//   }
//
//   // Removes the element on top of the stack.
//   public void pop() {
//	   
//	
//	   
//	   int length=l1.size();
//	   
//       for(int i=0;i<length-1;i++){
//       int removeValue=l1.removeFirst();
//       l2.addLast(removeValue);	
////       System.out.println("remove:"+removeValue);
//       }
//
//       LinkedList<Integer> tmp=l1;
//       l1=l2;
//       l2=tmp;
//       
////       System.out.println("pop:"+l2.removeFirst());  //The sentence should not be deleted.
//   }
//
//   // Get the top element.
//   public int top() {
////       System.out.println("top:"+l1.getLast());
//       return l1.getLast();
//   }
//
//   // Return whether the stack is empty.
//   public boolean empty() {
//       return (l1.isEmpty()&&l2.isEmpty());
//   }
//	
	
	
	
	
	
	/*
	 * Standard Queue:  remove element from head and add element from end.
	 * 
	 * 
	 * If we use two queues, what should we do?



Input:
push(1),push(2),push(3),top,pop,top,pop,top,empty,pop,empty
Output:
["3","1","3","false","true"]
Expected:
["3","2","1","false","true"]


	 * 
	 */
//	LinkedList<Integer> l1=new LinkedList<Integer>();
//	LinkedList<Integer> l2=new LinkedList<Integer>();
//	
//    public void push(int x) {
//        l1.addLast(x);
//    }
//
//    // Removes the element on top of the stack.
//    public void pop() {
    	
        /*
         * 
         * Because you are deleting the element in l1,
         * 
         * So li.size() is changing:
         * 
top:3
3  //l1.size())
remove:1
2  //l1.size())
remove:2
1  //l1.size())

         * 
         */
//        for(int i=0;i<l1.size();i++){
//        	System.out.println(l1.size());
//        	int removeValue=l1.removeFirst();
//        l2.addLast(removeValue);	
//        System.out.println("remove:"+removeValue);
//        }
// 
//        LinkedList<Integer> tmp=l1;
//        l1=l2;
//        l2=tmp;
//        
//        System.out.println(l1.removeFirst());
//    }
//
//    // Get the top element.
//    public int top() {
//        System.out.println("top:"+l1.getLast());
//        return l1.getLast();
//    }
//
//    // Return whether the stack is empty.
//    public boolean empty() {
//        return (l1.isEmpty()&&l2.isEmpty());
//    }
//	
	
	
	
	
	/*
	 * 
	 * Accepted.
	 * 
	 */
//	LinkedList<Integer> que=new LinkedList<Integer>();
//    public void push(int x) {
//        que.addLast(x);
//    }
//
//    // Removes the element on top of the stack.
//    public void pop() {
//        que.removeLast();
//    }
//
//    // Get the top element.
//    public int top() {
//        return que.getLast();
//    }
//
//    // Return whether the stack is empty.
//    public boolean empty() {
//        return que.isEmpty();
//    }
//	
	
	
	
	
	
	

    
}
