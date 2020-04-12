
/*
 * 
https://leetcode.com/problems/last-stone-weight-ii/

1049. Last Stone Weight II
Medium

418

20

Add to List

Share
We have a collection of rocks, each rock has a positive integer weight.

Each turn, we choose any two rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the smallest possible weight of this stone (the weight is 0 if there are no stones left.)

 

Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We can combine 2 and 4 to get 2 so the array converts to [2,7,1,8,1] then,
we can combine 7 and 8 to get 1 so the array converts to [2,1,1,1] then,
we can combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we can combine 1 and 1 to get 0 so the array converts to [1] then that's the optimal value.
 

Note:

1 <= stones.length <= 30
1 <= stones[i] <= 100

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


 * 
 */







Submission Detail
74 / 82 test cases passed.
Status: Wrong Answer
Submitted: 0 minutes ago
Input:
[31,26,33,21,40]
Output:
9
Expected:
5


class Solution {
    //5.44pm-5.54pm
    public int lastStoneWeightII(int[] stones) {
        
        Arrays.sort(stones);
        LinkedList<Integer> list=new LinkedList<Integer>();
        for(int i=0;i<stones.length;i++){
            list.add(stones[i]);
        }
        while(list.size()>=2){
            
            int y=list.removeLast();
             int x=-1;
            
            //binarySeach to find the closet one
            for(int i=0;i<list.getLast()-list.getFirst();i++){
              int result=Collections.binarySearch(list,y-i);
                if(result>=0){
                    x=list.remove(result);
                    break;
                }
            }
            if(x==-1){
                x=list.removeLast();
            }
            
            list.add(y-x);
             
            Collections.sort(list);
        }
        
        return list.get(0);
    }
 
}

















