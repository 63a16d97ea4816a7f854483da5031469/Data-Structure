
/*
 * 
https://leetcode.com/problems/find-the-winner-of-an-array-game/

1535. Find the Winner of an Array Game
Medium

507

26

Add to List

Share
Given an integer array arr of distinct integers and an integer k.

A game will be played between the first two elements of the array (i.e. arr[0] and arr[1]). In each round of the game, we compare arr[0] with arr[1], the larger integer wins and remains at position 0, and the smaller integer moves to the end of the array. The game ends when an integer wins k consecutive rounds.

Return the integer which will win the game.

It is guaranteed that there will be a winner of the game.

 

Example 1:

Input: arr = [2,1,3,5,4,6,7], k = 2
Output: 5
Explanation: Let's see the rounds of the game:
Round |       arr       | winner | win_count
  1   | [2,1,3,5,4,6,7] | 2      | 1
  2   | [2,3,5,4,6,7,1] | 3      | 1
  3   | [3,5,4,6,7,1,2] | 5      | 1
  4   | [5,4,6,7,1,2,3] | 5      | 2
So we can see that 4 rounds will be played and 5 is the winner because it wins 2 consecutive games.
Example 2:

Input: arr = [3,2,1], k = 10
Output: 3
Explanation: 3 will win the first 10 rounds consecutively.
 

Constraints:

2 <= arr.length <= 105
1 <= arr[i] <= 106
arr contains distinct integers.
1 <= k <= 109


DATE: 2022-October-13
TIME: 22:36:26

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


Time Limit Exceeded
Details 
Last executed input
[1,11,22,33,44,55,66,77,88,99]
1000000000

class Solution {
    public int getWinner(int[] arr, int k) {
        LinkedList<Integer> list=new LinkedList<Integer>();
        for(int tmp:arr){
            list.add(tmp);
        }
        int win=0;
        int winner=9999999;
        while(win<k){
            int first=list.get(0);
            int second=list.get(1);
            
            if(first>second){
                // first one win;
                // move the second one to the end of the list
                list.remove(1);
                list.addLast(second);
            }else{
                // second one win;
                // move the second one to the first position, move the first one to the end;
                list.remove(1);
                list.remove(0);
                list.addFirst(second);
                list.addLast(first);
            }
            int currWinner=list.get(0);
            if(winner==9999999){
                win++;
            }else if(winner==currWinner){
                win++;
            }else{
                //reset to 0
                win=1;
            }
            
            if(win==k){
                // meet the k requirement
                return currWinner;
            }
            winner=currWinner;
        }
        return -1;
    }
}




改进，成功 (对于整个数组的最大值，终止无意义的继续比较，直接返回最大值):
class Solution {
    public int getWinner(int[] arr, int k) {
            LinkedList<Integer> list=new LinkedList<Integer>();
            int maxValue=Integer.MIN_VALUE;
            for(int tmp:arr){
                maxValue=Math.max(tmp,maxValue);
                list.add(tmp);
            }
            int win=0;
            int winner=9999999;
            while(win<k){
                int first=list.get(0);
                int second=list.get(1);

                if(first>second){
                    // first one win;
                    // move the second one to the end of the list
                    list.remove(1);
                    list.addLast(second);
                }else{
                    // second one win;
                    // move the second one to the first position, move the first one to the end;
                    list.remove(1);
                    list.remove(0);
                    list.addFirst(second);
                    list.addLast(first);
                }
                int currWinner=list.get(0);
                if(winner==9999999){
                    win++;
                }else if(winner==currWinner){
                    win++;
                }else{
                    //reset to 0
                    win=1;
                }

                if(maxValue==currWinner){
                    // if it is the maxValue, can skip to return the value
                    return currWinner;
                }

                if(win==k){
                    // meet the k requirement
                    return currWinner;
                }
                winner=currWinner;
            }
            return -1;
        }
}







