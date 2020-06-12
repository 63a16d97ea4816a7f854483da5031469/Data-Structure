package ok;
//Min Stack
//https://leetcode.com/problems/min-stack/

/*
 * 
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.


 class MinStack {
 public void push(int x) {

 }

 public void pop() {

 }

 public int top() {

 }

 public int getMin() {

 }
 }

31 October 2015 at 8:47:52 pm

 * 
 */

/*
 * 
 In Java. The int data type is a 32-bit signed two's complement integer. It has a minimum value of -2,147,483,648 and a maximum value of 2,147,483,647 

 long: The long data type is a 64-bit two's complement integer. The signed long has a minimum value of -Math(2,63) and a maximum value of Math(2,63)-1. In Java SE 8 and later, 
 you can use the long data type to represent an unsigned 64-bit long, which has a minimum value of 0 and a maximum value of Math(2,64)-1.
 * 
 * 
 */
import java.util.*;

public class MinStack {

	
	/*
	 * 
	 * Accepted.
	 * 
	 * Take care when you control the status.
	 * 
	 * min Value should be updated according to the latest stack's values.
	 * 
	 */
	
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	int min = (int) (Math.pow(2, 32) - 1);

	public void push(int x) {
		s1.push(x);
		
		if(!s2.isEmpty()) min=getMin();
		
		if (min > x) {
			min = x;
		}

		s2.push(min);

	}

	public void pop() {
		s1.pop();
		s2.pop();
		//if the statck is empty, should reset the min value to maximum.
		if(s2.isEmpty()){
		 min = (int) (Math.pow(2, 32) - 1);	
		}
	}

	public int top() {
		return s1.peek();
	}

	public int getMin() {
		return s2.peek();
	}	
	
	
	
	
	
	
	/*
	 *
Wrong Answer More Details 

Input:
push(-10),push(14),getMin,getMin,push(-20),getMin,getMin,top,getMin,pop,push(10),push(-7),getMin,push(-7),pop,top,getMin,pop
Output:
[-10,-10,-20,-20,-20,-20,-20,-7,-20]
Expected:
[-10,-10,-20,-20,-20,-20,-10,-7,-10]

Reason:
min Value should be updated according to the latest stack's values.

	 * 
	 */
//	Stack<Integer> s1 = new Stack<Integer>();
//	Stack<Integer> s2 = new Stack<Integer>();
//	long min = (int) (Math.pow(2, 64) - 1);
//
//	public void push(int x) {
//		s1.push(x);
//		if (min > x) {
//			min = x;
//		}
//
//		s2.push((int) min);
//
//	}
//
//	public void pop() {
//		s1.pop();
//		s2.pop();
//		//if the statck is empty, should reset the min value to maximum.
//		if(s2.isEmpty()){
//		 min = (int) (Math.pow(2, 64) - 1);	
//		}
//	}
//
//	public int top() {
//		return s1.peek();
//	}
//
//	public int getMin() {
//		return s2.peek();
//	}	
//	
//	
	
	
	/*
	 * 
Wrong Answer More Details 

Input:
push(2147483646),push(2147483646),push(2147483647),top,pop,getMin,pop,getMin,pop,push(2147483647),top,getMin,push(-2147483648),top,getMin,pop,getMin
Output:
[2147483647,2147483646,2147483646,2147483647,2147483646,-2147483648,-2147483648,2147483646]
Expected:
[2147483647,2147483646,2147483646,2147483647,2147483647,-2147483648,-2147483648,2147483647]

Reason: when the stack2 becomes empty, you did not reset the min to maximum value.
	 * 
	 */
//	Stack<Integer> s1 = new Stack<Integer>();
//	Stack<Integer> s2 = new Stack<Integer>();
//	int min = (int) (Math.pow(2, 32) - 1);
//
//	public void push(int x) {
//		s1.push(x);
//		if (min > x) {
//			min = x;
//		}
//
//		s2.push(min);
//
//	}
//
//	public void pop() {
//		s1.pop();
//		s2.pop();
//	}
//
//	public int top() {
//		return s1.peek();
//	}
//
//	public int getMin() {
//		return s2.peek();
//	}

	/*
	 * Submission Result: Wrong Answer More Details
	 * 
	 * Input:
	 * push(2147483646),push(2147483646),push(2147483647),top,pop,getMin,pop
	 * ,getMin
	 * ,pop,push(2147483647),top,getMin,push(-2147483648),top,getMin,pop,getMin
	 * Output:
	 * [2147483647,99999999,99999999,2147483647,99999999,-2147483648,-2147483648
	 * ,99999999] Expected:
	 * [2147483647,2147483646,2147483646,2147483647,2147483647
	 * ,-2147483648,-2147483648,2147483647]
	 */
	// Stack<Integer> s1=new Stack<Integer>();
	// Stack<Integer> s2=new Stack<Integer>();
	// int min=99999999;
	// public void push(int x) {
	// s1.push(x);
	// if(min>x){
	// min=x;}
	//
	// s2.push(min);
	//
	// }
	//
	// public void pop() {
	// s1.pop();
	// s2.pop();
	// }
	//
	// public int top() {
	// return s1.peek();
	// }
	//
	// public int getMin() {
	// return s2.peek();
	// }
	//

}
