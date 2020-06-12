
/*
 * 
https://leetcode.com/problems/sort-array-by-parity/


905. Sort Array By Parity
Easy

816

70

Add to List

Share
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




class Solution {
    //10.43pm-10.45pm
    public int[] sortArrayByParity(int[] A) {
        LinkedList<Integer> list=new LinkedList<Integer>();
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                list.addFirst(A[i]);
            }else{
                list.addLast(A[i]);
            }
        }
        int[] arr=new int[A.length];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
}



















