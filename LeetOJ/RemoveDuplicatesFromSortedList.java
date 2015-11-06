
/*
 * 
https://leetcode.com/problems/remove-duplicates-from-sorted-list/

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
    }
}
 *
 */

import java.util.*;

class ListNode {
	int val;
	ListNode next;
	ListNode() {
	}

	ListNode(int x) {
		val = x;
	}
}

// Given a sorted linked list, delete all duplicates such that each element
// appear only once.

public class RemoveDuplicatesFromSortedList {

	public static void main(String args[]) {
		ListNode root = new ListNode(1);
		 root.next=new ListNode(1);
		 root.next.next=new ListNode(1);
		// root.next.next=new ListNode(2);
		ListNode result = deleteDuplicates2(root);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}

	}
	
	
	/*
	 * Accepted.
	 * 
	 * 
	 */
	public static ListNode deleteDuplicates2(ListNode head) {

		if (head == null){
			return head;
		}
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		ListNode tmp = head;

		ListNode prev = null;

		while (tmp != null) {
			if (map.get(tmp.val) == null) {
				map.put(tmp.val, "");
				prev = tmp;
				// if this element existed before, then we need to delete it.
			} else {

				/*
				 * Three cases: (1) delete the head (2) delete the rear (3)
				 * delete the middle node
				 * 
				 */

				// if this one is head
				if (prev == null) {
					head = tmp.next;

					// if this one is not the head
				} else {

					if (tmp.next != null) {
						prev.next = tmp.next;
						
						//should not move this prev pointer as it that node is deleted.
//						prev = tmp;
					// it means it is the rear.
					} else {
						prev.next = null;
					}

				}

			}

			tmp = tmp.next;
		}

		return head;
	}

	
	
	

	
	/*
	 * 
Wrong Answer More Details 

Input:
[1,1,1]
Output:
[1,1]
Expected:
[1]

Reason:
should not move this prev pointer as it that node is deleted.
	 * 
	 */
	public static ListNode deleteDuplicates(ListNode head) {

		if (head == null){
			return head;
		}
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		ListNode tmp = head;

		ListNode prev = null;

		while (tmp != null) {
			if (map.get(tmp.val) == null) {
				map.put(tmp.val, "");
				prev = tmp;
				// if this element existed before, then we need to delete it.
			} else {

				/*
				 * Three cases: (1) delete the head (2) delete the rear (3)
				 * delete the middle node
				 * 
				 */

				// if this one is head
				if (prev == null) {
					head = tmp.next;

					// if this one is not the head
				} else {

					if (tmp.next != null) {
						prev.next = tmp.next;
						
						//should not move this prev pointer as it is deleted.
						prev = tmp;
					// it means it is the rear.
					} else {
						prev.next = null;
					}

				}

			}

			tmp = tmp.next;
		}

		return head;
	}

}
