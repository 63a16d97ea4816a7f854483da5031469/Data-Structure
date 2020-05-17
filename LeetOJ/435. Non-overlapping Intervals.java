
/*
 * 
https://leetcode.com/problems/non-overlapping-intervals/


435. Non-overlapping Intervals
Medium

890

30

Add to List

Share
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 

Example 1:

Input: [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:

Input: [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:

Input: [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 

Note:

You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.


17 May 2020 at 12:45 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



// Java 8:
Arrays.sort(intervals,(int[] a, int[] b) -> {
    return a[1]-b[1];
});

class Solution {
    //12.22pm-12.42pm
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0) return 0;
        // Arrays.sort(intervals, new Comparator<int[]>(){
        //     public int compare(int[] a, int[] b){
        //         return a[1]-b[1];
        //     }
        // });
        Arrays.sort(intervals,(int[] a, int[] b) -> {
            return a[1]-b[1];
        });
        int[] last=intervals[0];
        int ans=0;
        for(int i=1;i<intervals.length;i++){
            if(last[1]>intervals[i][0]){
                ans++;
                //选最小的end的那个区间，删除最长的end的那个区间 （last指向谁，实际上就是保留谁做下一比较）
                if(last[1]>intervals[i][1]){
                     last=intervals[i];
                }
            }else{
                last=intervals[i];
            }
        }
        return ans;
    }
}




class Solution {
    //12.22pm-12.42pm
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){  //更开始在这里卡壳了，不知道如何写 2d arr的自定义比较方法
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }
        });
        int[] last=intervals[0];
        int ans=0;
        for(int i=1;i<intervals.length;i++){
            if(last[1]>intervals[i][0]){
                ans++;
                //选最小的end的那个区间，删除最长的end的那个区间 （last指向谁，实际上就是保留谁做下一比较）
                if(last[1]>intervals[i][1]){
                     last=intervals[i];
                }
            }else{
                last=intervals[i];
            }
        }
        return ans;
    }
}





