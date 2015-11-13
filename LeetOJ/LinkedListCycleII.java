package ok;

/*
Linked List Cycle II
https://leetcode.com/problems/linked-list-cycle-ii/
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }

public class Solution {
    public ListNode detectCycle(ListNode head) {
        
    }
}

7 November 2015 at 8:54:22 pm

 * 
 * 
 */

import java.util.*;

//class ListNode {
//	int val;
//	ListNode next;
//
//	ListNode(int x) {
//		val = x;
//	}
//}

public class LinkedListCycleII {

	public static void main(String args[]) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
//		head.next.next = head;
		 head.next.next=new ListNode(0);
		 head.next.next.next=new ListNode(7);
		 head.next.next.next.next=new ListNode(-4);
		 head.next.next.next.next.next=head.next;
		
//	     ListNode head = new ListNode(-1);
//	     head.next=new ListNode(-7);
//	     head.next.next=new ListNode(7);
//	     head.next.next.next=new ListNode(-4);
//	     head.next.next.next.next=new ListNode(19);
	     /*
	      * 	    ListNode sLoop=head.next.next.next.next.next;
	     			sLoop=new ListNode(6);
	     			This means, you make null memory address=existing memory address.
	      * 
	      */
	     
//	     ListNode sLoop=head.next.next.next.next.next=new ListNode(6);
//	     sLoop.next=new ListNode(-9);
//	     sLoop.next.next=new ListNode(-5);
//	     sLoop.next.next.next=new ListNode(-2);
//	     sLoop.next.next.next.next=new ListNode(-5);
//	     sLoop.next.next.next.next.next=sLoop;

		
		
		
		System.out.println(detectCycle5(head).val);
	}
	
	
	/*
	 * 
	 * Accepted:
	 * 
	 */
	
	public static ListNode detectCycle5(ListNode head) {

		ListNode first = head, second = head;

		if (head == null)
			return null; // when head==null
		if (head.next == null)
			return null; // when only contain head node.
		if(head.next.next==head) return head;

		boolean adjustFlag = false;
		// when contain more than one node
 
		int meetTime=0;
 
		while (first!=null&&first.next != null) {
 
			if(!adjustFlag){
			first = first.next.next;
			second=second.next;
			}else{
				first=first.next;
				second=second.next;
			}
			if(first==second&&first!=null&&meetTime!=2){
				System.out.println("meet:"+first.val);
				meetTime++;
				if(meetTime==2) return second;	
				adjustFlag=true;
				second=head;
			}
 

		}

		return null;
	}
	
	
	/*
Wrong Answer More Details 

Input:
[-1,-7,7,-4,19,6,-9,-5,-2,-5]
tail connects to node index 6
Output:
tail connects to node index 1
Expected:
tail connects to node index 6
	 * 
	 * 
	 */
	
	public static ListNode detectCycle4(ListNode head) {

		ListNode first = head, second = head;

		if (head == null)
			return null; // when head==null
		if (head.next == null)
			return null; // when only contain head node.
//		if(head.next.next==head) return head;

		boolean adjustFlag = false;
		// when contain more than one node
 
		int meetTime=0;
		
		int count=0;

		while (first!=null&&first.next != null) {
 
			if(!adjustFlag){
			first = first.next.next;
			second=second.next;
			}else{
				first=first.next;
				second=second.next;
			}
			if(first==second&&first!=null&&meetTime!=2){
				System.out.println("meet:"+first.val);
				meetTime++;
				adjustFlag=true;
				second=head;
			}else if(meetTime==2) return second;
			/*
meet:6
meet:6
-7

That means first==second&&first!=null&&meetTime!=2 is executed twice

			 * 
			 */
		 
 
			count++;
 

		}

		return null;
	}
	
	
	
	
	
	/*
	 * Reason: should return the second, rather than the first.
	 * 
	 * Accepted:
	 * 
	 * 
	 */
	
	public static ListNode detectCycle3(ListNode head) {

		ListNode first = head, second = head;

		if (head == null)
			return null; // when head==null
		if (head.next == null)
			return null; // when only contain head node.
		

		first=first.next;

		while (first!=null&&first.next != null) {
			if(first==second) break;
			
			first=first.next.next;
			second=second.next;
 
		}
		
		
		if(first==second){
			second=head;
			while(first.next!=second){
				first=first.next;
				second=second.next;
			}
			
//			return first;    //Reason: should return the second, rather than the first.
			return second;
		}

		return null;
	}
	
	
	
	
	/*

Input:
[1,2]
Output:
[1,2] tail point to the index 1
Expect:
[1,2] tail point to the index 0

Reason: should return the second, rather than the first.
	 * 
	 * 
	 */
	public static ListNode detectCycle2(ListNode head) {

		ListNode first = head, second = head;

		if (head == null)
			return null; // when head==null
		if (head.next == null)
			return null; // when only contain head node.
		

		first=first.next;

		while (first!=null&&first.next != null) {
			if(first==second) break;
			
			first=first.next.next;
			second=second.next;
 
		}
		
		
		if(first==second){
			second=head;
			while(first.next!=second){
				first=first.next;
				second=second.next;
			}
			
			return first;
		}

		return null;
	}
	
	
/*
 * Wrong answer
 * 
 * 
 * Reason:
 *  The pointer need to go 2 nodes at a time, however, if using the below code, 
 *  faster pointer and the slow pointer will be overlap, and at that time the code
 *  check whether (slow==fast), it means fast pointer just go through the slow pointer's 
 *  position, they are already equal. This case will be regarded as "meet".
 * 
 * 
 */
	public static ListNode detectCycle(ListNode head) {

		ListNode first = head, second = head;

		if (head == null)
			return null; // when head==null
		if (head.next == null)
			return null; // when only contain head node.
		if(head.next.next==head) return head;

		boolean adjustFlag = false;
		// when contain more than one node
		int j = 0;
		int meetTime=0;

		while (first.next != null) {
 
			first = first.next;
			 System.out.print(first.val+" ");

			j++;
 

			if (!adjustFlag && j == 2) {
				j = 0;
				second = second.next;
//				 System.out.println("\nsecond:"+second.val+" ");
			} else if (adjustFlag) {
				second = second.next;
//				 System.out.println("\nsecond:"+second.val+" ");
			}
			

			
			if (first == second) {
				meetTime++;
				/*
				 * after the first meet, adjust the slow pointer and fast
				 * pointer: slow pointer: point to the head 
				 * fast pointer: start from the meet point with the same speed with slow pointer.
				 */
				if(meetTime==1){
				first=head;
				adjustFlag = true;
				}else if(meetTime==2){
					return first;
				}

			}
			

		}

		return null;
	}

	public static boolean hasCycle(ListNode head) {
		ListNode first = head, second = head;

		if (head == null)
			return false; // when head==null
		if (head.next == null)
			return false; // when only contain head node.

		// when contain more than one node
		int j = 0;
		while (first.next != null) {
			first = first.next;
			j++;
			if (j == 2) {
				j = 0;
				second = second.next;
			}
			if (first == second) {

				System.out.println("the node:" + first.val);

				return true;

			}

		}

		return false;
	}

}
