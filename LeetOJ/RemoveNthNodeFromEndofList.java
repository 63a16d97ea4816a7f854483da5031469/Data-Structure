/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
    }
}

 * 
 */










/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
   
Note:
Given n will always be valid.
Try to do this in one pass.


Considering the cases:

Delete Head:
1  n=1
1,2 n=2

Delete Rear:
1, n=1
1->2 n=1

Delete middle node:
1->2->3->4->5, and n = 2.


 * 
 * 
 */

import java.util.*;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}


public class RemoveNthNodeFromEndofList {

	public static void main(String args[]) {
		
		RemoveNthNodeFromEndofList removeNode=new RemoveNthNodeFromEndofList();
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
//		head.next.next=new ListNode(3);
		
		
		ListNode result=removeNode.removeNthFromEnd(head, 1);

		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}
		
		
	}
	
	/*
	 * Accepted.
	 * 
	 * 
	 */

	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null)
			return head;

		ListNode curr = head;
		HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
		int length = 0;
		while (curr != null) {
			// all the node is put in the 1,2,3,4...  to distinguish the 0 case.
			map.put(length+1, curr);
			curr = curr.next;
			length++;
		}

		int position = length-n;
		ListNode prevNode = map.get(position);
		// if the position+1 is not existed, then it will be null.
		ListNode deletedNode = map.get(position + 1); 

		/*
		 * Considering three cases:
		 * (1) the deleted Node is the head.
		 * (2) the deleted Node is in the middle.
		 * (3) the deleted Node is in the rear.
		 * 
		 */
		
		//if the prevNode is 0, it means it is in the head. 
		//we need to adjust the Head pointer.
		if(prevNode==null){
			
			if(head!=null){
			head=head.next;
			}
 
		//if it is not in the head position, it should be in the middle or in the rear
		}else{

		//if the deletedNode is not null, we delete the node in two cases.
		//(1) it is in the middle.
		//(2) it is in the rear.
		if (deletedNode != null) {
			prevNode.next = deletedNode.next;
			// if it is the rear, delete the current Node--->no need to use the "by pass" way.
		} else {
			prevNode.next = null;
		}

		
		}
		
		
		return head;
	}

}


















