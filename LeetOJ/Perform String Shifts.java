
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


Perform String Shifts
Solution
You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

direction can be 0 (for left shift) or 1 (for right shift). 
amount is the amount by which string s is to be shifted.
A left shift by 1 means remove the first character of s and append it to the end.
Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations.

 

Example 1:

Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"
Explanation: 
[0,1] means shift to left by 1. "abc" -> "bca"
[1,2] means shift to right by 2. "bca" -> "cab"
Example 2:

Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
Output: "efgabcd"
Explanation:  
[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 

Constraints:

1 <= s.length <= 100
s only contains lower case English letters.
1 <= shift.length <= 100
shift[i].length == 2
0 <= shift[i][0] <= 1
0 <= shift[i][1] <= 100
   Hide Hint #1  
Intuitively performing all shift operations is acceptable due to the constraints.
   Hide Hint #2  
You may notice that left shift cancels the right shift, so count the total left shift times (may be negative if the final result is right shift), and perform it once.


12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

基础扎实要牢固，对linkedlist的操作，是解决这个题目的关键。

注意规律，左右shift其实是可以互相抵消的，没注意到这个规律。

 * 
 */


AC

class Solution {
    //8.48am-8.54am
    public String stringShift(String s, int[][] shift) {
        if(s.length()==0) return s;
        
        
        LinkedList<Character> list=new LinkedList<Character>();
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }
        for(int i=0;i<shift.length;i++){
            int dir=shift[i][0];
            int amt=shift[i][1];
            
            for(int k=0;k<amt;k++){
                if(dir==0){
                    //左
                    list.addLast(list.removeFirst());
                }else{
                    //右
                    list.addFirst(list.removeLast());
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }
        
        return sb.toString();
    }
}



















