
/*
 * 
https://leetcode.com/problems/rotate-string/

796. Rotate String
Easy

621

49

Add to List

Share
We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
Note:

A and B will have length at most 100.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

刚开始想着是复杂的思路，就是map所有的character，然后shift那个字母试试。绕远了。。。
其实观察，无论如何，单向移动，肯定可以重叠，如果他们真的是shift得来的。


 * 
 */

AC:
class Solution {
    //9.55am-10.05am
    public boolean rotateString(String A, String B) {
        if(A.equals("")&&B.equals("")) return true;
        if(A.length()!=B.length()) return false;
        
        LinkedList<Character> list=new LinkedList<Character>();
        
   
        for(int i=0;i<A.length();i++){
            list.add(A.charAt(i));
        }
        
        //固定一个，另一个旋转
        
        for(int i=1;i<=A.length();i++){
            list.addFirst(list.removeLast());
            
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<list.size();j++){
                sb.append(list.get(j)+"");
            }
            
            if(sb.toString().equals(B)){
                return true;
            }
        }
        
        return false;
    }
}



















