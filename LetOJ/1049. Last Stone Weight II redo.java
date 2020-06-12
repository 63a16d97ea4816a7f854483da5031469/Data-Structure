
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




class Solution {
    //5.44pm-5.54pm
    
    //转化成背包问题，就是我有 N个数，然后，我有一个sum/2的背包，石头不可以拆分，问我能否在这个状态下，取到最大的value

// #问题可以等效为，一个数组分成两部分，使这两部分的和尽可能的接近
// #问题可以进一步化为，从一个数组取出一些数，使他们的和尽可能接近整体的1/2
// #问题进一步化为，从一个数组取出一些数，在不大于sum/2的情况下，尽可能的大#动态规划，dp[i][j]表示 数组 前i 个数 在不大于j的情况下 组合可能的最大值。试一试
// #dp[i][j] dp[i+1][j]的关系：dp[i+1][j]=max(dp[i][j],stones[i+1]+dp[i][j-stones[i]]) 到了第i+1个的时候判断用不用i+1这个数
// #dp[i][j]=max(dp[i-1][j],stones[i]+dp[i-1][j-stones[i]])
// #dp[i][j-n]和 dp[i][j]的关系 在从小到大的石头中，判断 取当前这块 和 dp[i][j-stone[i]]这两个循环比较取最大值

// 作者：wangyaqi
// 链接：https://leetcode-cn.com/problems/last-stone-weight-ii/solution/pythondong-tai-gui-hua-by-wangyaqi/

// 普通01背包


    public int lastStoneWeightII(int[] stones) {
        
        int sum=0;
        for(int stone:stones){
            sum+=stone;
        }
        
         int[][] dp=new int[stones.length+1][sum/2+1];
        
        for(int i=1;i<stones.length+1;i++){
            for(int j=1;j<sum/2+1;j++){
                if(stones[i-1]<=j){
                    //如果能装下，并且没有超过j的量
                     dp[i][j]= Math.max(dp[i-1][j], dp[i-1][j-stones[i-1]]+stones[i-1]);
                }else{
                    //如果装不下，那么就只能等于上次的值
                    dp[i][j]=dp[i-1][j];
                }
               
            }
        }
         
 
        return sum-2* dp[stones.length][sum/2];
        
    }
}

// 作者：user2928m
// 链接：https://leetcode-cn.com/problems/last-stone-weight-ii/solution/java-01bei-bao-he-ta-de-kong-jian-you-hua-by-user2/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






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

















