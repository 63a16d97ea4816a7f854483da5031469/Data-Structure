/*
https://leetcode.com/problems/palindrome-linked-list/

Given a singly linked list, determine if it is a palindrome(回文).

Follow up:
Could you do it in O(n) time and O(1) space?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 
public class Solution {
    public boolean isPalindrome(ListNode head) {
        
    }
}
 * 
 * 
 */

/*
 * 
 * Palindrome is a very common question in interviews.
 * 
 * 
 * Definition:
 * A palindrome is a word, phrase, number, or other sequence 
 * of characters which reads the same backward or forward.
 * 
 */

import java.util.*;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}


public class PalindromeLinkedList {
	
	public static void main(String args[]){
		PalindromeLinkedList l=new PalindromeLinkedList();
		//12321
		//121
		
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(2);
		head.next.next.next=new ListNode(1);
		
//		ListNode head=new ListNode(1);
//		head.next=new ListNode(2);
//		head.next.next=new ListNode(3);
//		head.next.next.next=new ListNode(2);
//		head.next.next.next.next=new ListNode(1);
		
		
		System.out.println(l.isPalindrome4(head));
	}
	
	
	
	/*
	 * Accepted.
	 * 
	 * 
	 */
	
	public boolean isPalindrome4(ListNode head) {

		if (head==null) return true;
		
		/*
		 * one pointer use normal speed. step by step to reach the end. another
		 * pointer use 0.5 speed of normal pointer.
		 * 
		 */
 

		ListNode fast = head;
		ListNode slow = head;

//		int count = 0;
 
		//if you want to use pointer's value, you need to check whether it is null at first.
		while (fast!=null&&fast.next != null) {
 

	   //You can use another way to do below logic:
//			if (count == 2) {
//				slowStr += slow.val;
//				slow = slow.next;
//				count = 0;
//			}

//			count++;
			if(fast.next!=null)
			fast = fast.next.next;
			
			slow=slow.next;

		}
		
 

 
		//Time Complexity  0.5(n)
		//reverse the half list

		/*
		 * 
Wrong Answer More Details 

Input:
[1,2,2,1]
Output:
false
Expected:
true


Reason: need to remove the first node's next pointer.
		 * 
		 */		
		
		ListNode nextNext=slow.next;
		//!!!!!!! need to remove the first node's next pointer. !!!!!!!!!!!
		slow.next=null;
		
		//should begin from the slow.next to reverse the list
		while(nextNext!=null){
			ListNode tmp=slow;
			slow=nextNext;

			nextNext=nextNext.next;
			slow.next=tmp;
		}

		
		//if you want to use pointer's value, you need to check whether it is null at first.
		while(head!=null&&slow!=null&&head!=slow){
			if(head.val!=slow.val) return false;
			head=head.next;
			slow=slow.next;
		}
		
		return true;
 
	}
	
	
	
	
	
	//reference to the link: http://www.programcreek.com/2014/07/leetcode-palindrome-linked-list-java/
	
	
	/*
	 * Considering the follow testing cases:
	 * 
	 * 11
	 * 121
	 * 12321
	 * 
	 * 
	 */
	
	
	public boolean isPalindrome3(ListNode head) {

		if (head==null) return true;
		
		/*
		 * one pointer use normal speed. step by step to reach the end. another
		 * pointer use 0.5 speed of normal pointer.
		 * 
		 */
 

		ListNode fast = head;
		ListNode slow = head;

//		int count = 0;
 
		//if you want to use pointer's value, you need to check whether it is null at first.
		while (fast!=null&&fast.next != null) {
 

	   //You can use another way to do below logic:
//			if (count == 2) {
//				slowStr += slow.val;
//				slow = slow.next;
//				count = 0;
//			}

//			count++;
			if(fast.next!=null)
			fast = fast.next.next;
			
			slow=slow.next;

		}
		
 
		ListNode nextNext=slow.next;
 
		//Time Complexity  0.5(n)
		//reverse the half list
		
		//should begin from the slow.next to reverse the list
		while(nextNext!=null){
			ListNode tmp=slow;
			slow=nextNext;
			nextNext=nextNext.next;
			slow.next=tmp;
		}
		/*
		 * 
Wrong Answer More Details 

Input:
[1,2,2,1]
Output:
false
Expected:
true
		 * 
		 */
		
		//if you want to use pointer's value, you need to check whether it is null at first.
		while(head!=null&&slow!=null&&head!=slow){
			if(head.val!=slow.val) return false;
			head=head.next;
			slow=slow.next;
		}
		
		return true;
 
	}
	
	
	
	
	
	
	/*
	 * Do analysis about the testing cases:
		//12321
		//121
		Because we need to check the half of the linked list(the feature of Palindrome), 
		I come up with the fast and slow pointer about Linked List.
		
		Inspiration：If you want to use some features, you need to be very familar with it. 
		So that when you are thinking how to solve a problem, you will come up with them.
		
		I cannot find a way to limit the space useage to O(1)
		
	 * 
	 */
	
	public boolean isPalindrome2(ListNode head) {

		/*
		 * one pointer use normal speed. step by step to reach the end. another
		 * pointer use 0.5 speed of normal pointer.
		 * 
		 */

		ListNode normal = head;
		ListNode slow = head;

		int count = 0;
		String slowStr = "";
		String normalStr = "";

		while (normal != null) {

			normalStr += normal.val;

			if (count == 2) {
				slowStr += slow.val;
				slow = slow.next;
				count = 0;
			}

			count++;
			normal = normal.next;

		}
		slowStr += slow.val;
		System.out.println(slowStr + " " + normalStr);

		return slowStr.equals(normalStr.subSequence(0, slowStr.length()));
	}
	
	
	/*
	 * Could we do it without considering the time and space limitation?
	 * 
	 */
	public boolean isPalindrome(ListNode head){
		
		if(head==null) return false;
		
		Stack<Integer> s=new Stack<Integer>();
		
		ListNode tmp = head;
		String wholeStr = "";

		while (tmp != null) {
			wholeStr += tmp.val;
			s.push(tmp.val);
			tmp = tmp.next;
		}

		String secStr = "";
		while (!s.isEmpty()) {
			secStr += s.pop();
		}
		
		return wholeStr.equals(secStr);
	}
	

}
