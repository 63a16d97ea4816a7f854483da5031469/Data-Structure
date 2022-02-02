
/*
 * 
link: https://leetcode-cn.com/problems/smallest-k-lcci/

面试题 17.14. 最小K个数
难度
中等

176





设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。

示例：

输入： arr = [1,3,5,7,2,4,6,8], k = 4
输出： [1,2,3,4]
提示：

0 <= len(arr) <= 100000
0 <= k <= min(100000, len(arr))



2022-02-02 at 19:04
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

执行用时：
25 ms
, 在所有 Java 提交中击败了
17.95%
的用户

class Solution {
    public int[] smallestK(int[] arr, int k) {
        if(k==0) return new int[0];
        PriorityQueue<Integer> pq=new PriorityQueue<>(k,(o1,o2)->{
            return o2-o1;
        });

        for(int tmp:arr){
            if(pq.size()<k){
                pq.add(tmp);
            }else if(pq.peek()>tmp){
                pq.poll();
                pq.add(tmp);
            }
        }
        int[] result=new int[pq.size()];
        int index=pq.size()-1;
        while(!pq.isEmpty()){
            result[index--]=pq.poll();
        }
        return result;
    }
}



















