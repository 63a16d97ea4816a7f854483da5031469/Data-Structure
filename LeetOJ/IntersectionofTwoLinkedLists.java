package ok;




/*
https://leetcode.com/problems/intersection-of-two-linked-lists/

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
    }
}


 * 
 * 
 */


/*
 * 
Considering the test cases:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

And come up with that the feature is :  if I search from the end side of both Lists, it should be easier.


As the mentioned above: The linked lists must retain their original structure after the function returns.  ===> so should not reverse the lists.


Using two strings,
record the list1 and list2's words.

Then loop from the end point of two lists, search the common characters:
(1) One of the lists reach the head(no intersection) but could not find common node
(2) Have common nodes but could not find more nodes which contain the same values(find intersection).
 * 
 */

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}


public class IntersectionofTwoLinkedLists {
	
	public static void main(String args[]){
		IntersectionofTwoLinkedLists i=new IntersectionofTwoLinkedLists();
	    ListNode headA=new ListNode(1);
	    headA.next=new ListNode(2);
	    headA.next.next=new ListNode(3);
	    headA.next.next.next=new ListNode(4);
	    headA.next.next.next.next=new ListNode(5);
	    headA.next.next.next.next.next=new ListNode(6);
	    ListNode tmp=headA.next.next.next.next.next;
	    tmp.next=new ListNode(7);
	    tmp.next.next=new ListNode(8);
	    tmp.next.next.next=new ListNode(9);
	    tmp.next.next.next.next=new ListNode(10);
	    tmp.next.next.next.next.next=new ListNode(11);
	    tmp.next.next.next.next.next.next=new ListNode(12);
	    tmp.next.next.next.next.next.next.next=new ListNode(13);
		
//		ListNode headB=new ListNode(2);
//		headB.next=new ListNode(3);
//		headB.next.next=new ListNode(4);
//		headB.next.next.next=new ListNode(5);
		
	    ListNode headB=new ListNode(1);
	    headB.next=new ListNode(2);
	    headB.next.next=new ListNode(3);
	    headB.next.next.next=new ListNode(4);
	    headB.next.next.next.next=new ListNode(5);
	    headB.next.next.next.next.next=new ListNode(6);
	    tmp=headB.next.next.next.next.next;
	    tmp.next=new ListNode(7);
	    tmp.next.next=new ListNode(8);
	    tmp.next.next.next=new ListNode(9);
	    tmp.next.next.next.next=new ListNode(10);
	    tmp.next.next.next.next.next=new ListNode(11);
	    tmp.next.next.next.next.next.next=new ListNode(12);
	    tmp.next.next.next.next.next.next.next=new ListNode(13);
		
		
		ListNode l=i.getIntersectionNode2(headA, headB);
		System.out.println(l.val);
		
	}
	
	
	//as you reference to other people's code, you need to rewrite by yourself.
	//Accepted.
	//-----------------------------------------------------------------------------
	
	
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		int lenA=0;
		int lenB=0;

		ListNode tmpA=headA;
		ListNode tmpB=headB;

		while(tmpA!=null){
			lenA++;
			tmpA=tmpA.next;
		}

		while(tmpB!=null){
			lenB++;
			tmpB=tmpB.next;
		}

		int diff=0;

		ListNode p1=headA;
		ListNode p2=headB;

		if(lenA-lenB>0){
			diff=lenA-lenB;
			for(int i=0;i<diff;i++){
				p1=p1.next;
			}
		}else{
			diff=lenB-lenA;
			for(int i=0;i<diff;i++){
				p2=p2.next;
			}
		}

		while(p1!=null&&p2!=null){

			if(p1.val==p2.val){
				return p1;
			}else{

			}
			p1=p1.next;
			p2=p2.next;

		}

		return null;
	}

	
	
	
	//-----------------------------------------------------------------------------
	
	
	
	
	
	
	/*
	 * reference to the link: http://www.programcreek.com/2014/02/leetcode-intersection-of-two-linked-lists-java/
	 * 
	 * First calculate the length of two lists and find the difference. 
	 * Then start from the longer list at the diff offset, iterate though 2 lists and find the node.
	 * 
	 * 
	 * //Actually do not think the question is too complex. It will not contain only one same value node.
	 * 
	 */
	
	public class Solution {
	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        int len1 = 0;
	        int len2 = 0;
	        ListNode p1=headA, p2=headB;
	        if (p1 == null || p2 == null)
	            return null;
	 
	        while(p1 != null){
	            len1++;
	            p1 = p1.next;
	        }
	        while(p2 !=null){
	            len2++;
	            p2 = p2.next;
	        }
	 
	        int diff = 0;
	        p1=headA;
	        p2=headB;
	 
	        if(len1 > len2){
	            diff = len1-len2;
	            int i=0;
	            while(i<diff){
	                p1 = p1.next;
	                i++;
	            }
	        }else{
	            diff = len2-len1;
	            int i=0;
	            while(i<diff){
	                p2 = p2.next;
	                i++;
	            }
	        }
	 
	        while(p1 != null && p2 != null){
	            if(p1.val == p2.val){
	                return p1;               //Actually do not think the question is too complex. It will not contain only one same value node.
	            }else{
	 
	            }
	            p1 = p1.next;
	            p2 = p2.next;
	        }
	 
	        return null;
	    }
	}
	
	
	
	
	/*
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3

a1 - a2 - c1 - c2 - c3
b1 - b2 - b3 - c1 - c2 - c3

reverse the lists. Search from the end.
Then revert the changes.

Do not judge, just do it.

	 * 
	 * 
	 */
	
	
	
	/*
	 * 
Input:
Intersected at '1': [1,2,3,4,5,6,7,8,9,10,11,12,13]
[1,2,3,4,5,6,7,8,9,10,11,12,13]
Output:
No intersection, ERROR: linked structure was modified.     //Actually, I tested in local machine, it returns 1;
Expected:
Intersected at '1'
	 * 
	 */
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
 
    	
    	if(headA==null||headB==null) return null;
    	
    	headA=reverseList(headA);
    	headB=reverseList(headB);
    	
    	ListNode commonNode=null;
    	
    	ListNode tmpA=headA;
    	ListNode tmpB=headB;
    	
    	//get the common Intersection node
    	while(tmpA!=null&&tmpB!=null){
    		
    		if(tmpA.val==tmpB.val){
    			commonNode=tmpA;
    			tmpA=tmpA.next;
    			tmpB=tmpB.next;
    		}else{
    			break;
    		}
    		
    		
    	}
    	
    	
    	//Reverse the list again to recover the structure of lists.
     
    	headA=reverseList(headA);
    	headB=reverseList(headB);

    	return commonNode;
    }
    
    
    public ListNode reverseList(ListNode head){
    	
    	//need return head otherwise, after the function is over, the head will be released.


        ListNode nextnextA=head.next;
        ListNode nextA=head.next;


        head.next=null;    // cut the first node's next point
        while(nextA!=null){
          
          if(nextnextA!=null){
          nextnextA=nextnextA.next;   // save the next.next
          }
          
          nextA.next=head;   // reverse the ListNode
          head=nextA; // jump to next node (already adjusted the next pointer)
          nextA=nextnextA; //jump to next unset node
        
        }
        return head;
    }
    
}










































