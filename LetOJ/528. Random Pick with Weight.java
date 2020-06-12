
/*
 * 
https://leetcode.com/problems/random-pick-with-weight/

528. Random Pick with Weight
Medium

702

2108

Add to List

Share
Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.



06 June 2020 at 9.49 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */







class Solution {
    //(wsum, index)
    TreeMap<Integer, Integer> map;
    public Solution(int[] w) {
        map = new TreeMap();
        map.put(w[0], 0);
        for(int i = 1; i < w.length; i++){
            w[i] += w[i - 1];
            map.put(w[i], i);
        }
    }
    
    public int pickIndex() {
        Random rand = new Random();
        int target = rand.nextInt(map.lastKey());
        return map.higherEntry(target).getValue();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */





class Solution {
    int totalCount; //纪录权重和
    int[] cumSum; //权重权重累加数组
    Random rand = new Random();
    public Solution(int[] w) {
        cumSum = new int[w.length];
        for(int i = 0; i < w.length; i++){
            if(i == 0)
                cumSum[i] = w[i];
            else
                cumSum[i] = w[i] + cumSum[i-1];
        }
        totalCount = cumSum[cumSum.length-1];
    }
    
    public int pickIndex() {
        //从区间[1, totalCount]中返回一个随机值，查找该随机值在前缀数组中的位置
        int randIndex = rand.nextInt(totalCount) + 1;
        return binarySearch(cumSum, randIndex);
    }

    private int binarySearch(int[] cumSum, int x){
        int lo = 0;
        int hi = cumSum.length-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(cumSum[mid] == x)
                return mid;
            else if(cumSum[mid] < x){
            //可以肯定, 此时x的对应下标一定大于mid, 所以在[mid+1, hi)中搜索
                lo = mid+1;
            }
            else
            //x的对应下标可能等于mid, 先在[lo, mid-1)中搜索, 如果搜索不到, 则while循环退出, 返回hi即可
                hi = mid-1;
        }
        return lo;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */











