
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
    }
}

20 November 2015 at 8:33:31 pm
 * 
 */


class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}


public class ReverseLinkedListII {
	
	public static void main(String args[]){
		ReverseLinkedListII rev=new ReverseLinkedListII();
		
//		ListNode head=new ListNode(1);
//		head.next=new ListNode(2);
//		head.next.next=new ListNode(3);
//		head.next.next.next=new ListNode(4);
//		head.next.next.next.next=new ListNode(5);
////		
		
		ListNode head=new ListNode(76);
		
		int[] arr={76,-68,99,14,95,0,6,-46,-1,97,-24,-74,38,71,-56,-51,89,-78,-40,43,11,-36,-24,-21,5,29,27,-27,81,-48,-87,6,-16,-89,-80,-72,-39,-24,-17,60,-28,9,86,60,-71,81,60,-83,53,-81,10,-87,-16,86,-8,39,15,69,62,-55,-79,75,1,-45,36,21,-16,47,47,17,7,69,-75,-58,29,-45,73,-12,-78,-25,-43,-17,-11,-9,-32,81,-71,33,50,92,28,21,16,-71,76,-48,0,-41,49,98,26,-45,66,52};
		System.out.println(arr.length);
		
		ListNode tmph=head;
		for(int tmp:arr){
			tmph.next=new ListNode(tmp);
			tmph=tmph.next;
		}
		
		ListNode root=rev.reverseBetween2(head, 65, 66);
		
		
		while(root!=null){
			System.out.print(root.val+" ");
			root=root.next;
		}
	}
	
	
	/*
	 * Accepted.
	 * 
	 */
	
	public ListNode reverseBetween2(ListNode head, int m, int n) {
		boolean flag = false;
		int position = 0;

		if (head == null)
			return head;

		ListNode curr = head;
		ListNode prev = null;
		ListNode nextNext = head.next;

		ListNode beginPrev = head;
		ListNode endNext = head;

		if (m == n)
			return head; // fixed the issue: [1,2,3] 1,1

		while (curr != null) {

			position++;
			nextNext = curr.next;

			if (m == position) {
				flag = true;
				if (prev != null) {
					beginPrev = prev;
				} else {
					beginPrev = null;
				}

				endNext = curr;

			}

			if (n == position) {
				flag = false;
 

				// it is in the head position.
				if (beginPrev == null) {
					head.next = null; // remove the next pointer of head.
					head = curr;
				} else {

					beginPrev.next = curr;
				}

				endNext.next = curr.next;

			}

			if ((flag && m != position) || (!flag && n == position)) {

				curr.next = prev;
				prev = curr;
				curr = nextNext;

			} else {

				prev = curr;

				curr = curr.next;
			}
		}

		return head;
	}
}



























