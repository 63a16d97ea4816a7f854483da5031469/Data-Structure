
/*
 * 

https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/

2400. Number of Ways to Reach a Position After Exactly k Steps
Medium

400

47

Add to List

Share
You are given two positive integers startPos and endPos. Initially, you are standing at position startPos on an infinite number line. With one step, you can move either one position to the left, or one position to the right.

Given a positive integer k, return the number of different ways to reach the position endPos starting from startPos, such that you perform exactly k steps. Since the answer may be very large, return it modulo 109 + 7.

Two ways are considered different if the order of the steps made is not exactly the same.

Note that the number line includes negative integers.

 

Example 1:

Input: startPos = 1, endPos = 2, k = 3
Output: 3
Explanation: We can reach position 2 from 1 in exactly 3 steps in three ways:
- 1 -> 2 -> 3 -> 2.
- 1 -> 2 -> 1 -> 2.
- 1 -> 0 -> 1 -> 2.
It can be proven that no other way is possible, so we return 3.
Example 2:

Input: startPos = 2, endPos = 5, k = 10
Output: 0
Explanation: It is impossible to reach position 5 from position 2 in exactly 10 steps.
 

Constraints:

1 <= startPos, endPos, k <= 1000


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


class Solution {
    
    private int mod = (int)1e9 + 7;
    //创建一个map，用于记忆化DFS
    //map中对应位置代表含义：Map<startPos , Map<k , ans>>
    private Map<Integer , Map<Integer , Integer>> map = new HashMap<>();
    public int numberOfWays(int startPos, int endPos, int k) {
        return dfs(startPos , endPos , k);
    }

    public int dfs(int curPos , int endPos , int k){
        if(k == 0){
            return curPos == endPos ? 1 : 0;
        }

        //当前curPos以及k的情况，之前是否也走过，走过的话直接取值即可
        if(map.containsKey(curPos) && map.get(curPos).containsKey(k)){
            return map.get(curPos).get(k);
        }

        //剪枝：如果剩余要走的路比k大，那么一定不会走到终点
        if(k < Math.abs(curPos - endPos)){
            return 0;
        }

        int left = dfs(curPos - 1 , endPos , k - 1);
        int right = dfs(curPos + 1 , endPos , k - 1);


        Map<Integer , Integer> m = new HashMap<>();
        m.put(k , (left+ right) % mod);
        map.put(curPos , m);

        return (left + right) % mod;
    }
}






















