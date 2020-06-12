package ok;
/*
 * https://leetcode.com/problems/linked-list-cycle/
 Given a linked list, determine if it has a cycle in it.

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
    public boolean hasCycle(ListNode head) {
        
    }
}

7 November 2015 at 8:54:25 pm
 * 
 */

import java.util.*;

//class ListNode{
//	int val;
//	ListNode next;
//	ListNode(int x){val=x;next=null;}
//}


public class LinkedListCycle {

	public static void main(String args[]){
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
//		head.next.next.next=head;
		head.next.next.next=null;
		System.out.println(hasCycle(head));
	}



	/*
		Accepted.
	*/
	public static boolean hasCycle2(ListNode head){
		ListNode fast=head;
		ListNode slow=head;

		if(head==null) return false;
		if(head.next==null) return false;

		while(fast!=null){

			if(fast.next!=null)
				fast=fast.next.next;
			else{
				fast=fast.next;
			}

			slow=slow.next;

			if(fast==slow) return true;

		}

	return false;
	}




	
	
	/*
	 * 
	 * Accepted:
	 * 
	 */
	
	public static boolean hasCycle(ListNode head){
		ListNode first=head,second=head;
		
		if(head==null) return false;  // when head==null
		if(head.next==null) return false; // when only contain head node.
		
		// when contain more than one node
		int j=0;
		while(first.next!=null){
			first=first.next;
			j++;
			if(j==2){
				j=0;
				second=second.next;
			}
			if(first==second) return true;
			
		}
		
		return false;
	}
	
}
