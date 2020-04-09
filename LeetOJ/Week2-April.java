
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/

Middle of the Linked List
Solution
Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Note:

The number of nodes in the given list will be between 1 and 100.

9 April 2020 at 6.37pm
 * 
 */



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //6.34pm-6.36pm
    public ListNode middleNode(ListNode head) {
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        
        return slow;
    }
}




Backspace String Compare
Solution
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?


class Solution {
    //6.38pm- 6.43pm
    public boolean backspaceCompare(String S, String T) {
        
        return getFinalStr(S).equals(getFinalStr(T));
        
    }
    
    String getFinalStr(String s){
        
        if(s.length()==0) return s;
        Stack<Character> stack=new Stack<Character>();
        
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)=='#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(s.charAt(i)!='#'){
                stack.push(s.charAt(i));
            }
        }
        
        String str="";
        
        while(!stack.isEmpty()){
            str+=stack.pop();
        }
        return str;
    }
}





















