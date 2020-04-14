
/*
 * 
https://leetcode.com/problems/last-stone-weight/

1046. Last Stone Weight
Easy

466

23

Add to List

Share
We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

 

Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 

Note:

1 <= stones.length <= 30
1 <= stones[i] <= 1000

12 April 2020 at 5.34pm-5.41pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:

使用LinkedList和sort函数简化

从这道题目学到了什么，哪些地方需要提升? :

键盘指法需要提升，感觉不是很准确，思路其实挺清楚的。一些不好的指法习惯需要消除。

 * 
 */


使用最大堆：

class Solution {
    //2.52pm-2.56pm
    public int lastStoneWeight(int[] stones) {
        
        if(stones.length==1) return stones[0];
        
        PriorityQueue<Integer> que=new PriorityQueue<Integer>(stones.length, new Comparator<Integer>(){
            
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });
        
        for(int i=0;i<stones.length;i++){
            que.add(stones[i]);
        }
        
        int x=0;
        int y=0;
            
        while(que.size()>=2){
            y=que.poll();
            x=que.poll();
            que.add(y-x);
        }
        return que.poll();
    }
}



不使用最大堆：

class Solution {
    //5.34pm-5.41pm
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        
        LinkedList<Integer> list=new LinkedList<Integer>();
        
        for(int stone:stones){
            list.add(stone);
        }
        
        while(list.size()>=2){
            
            int y=list.removeLast();
            int x=list.removeLast();
            
            if(x==y) {
                list.add(0);
            }else{
                list.add(y-x);
            }
            Collections.sort(list);
        }
        return list.get(0);
    }
}





















