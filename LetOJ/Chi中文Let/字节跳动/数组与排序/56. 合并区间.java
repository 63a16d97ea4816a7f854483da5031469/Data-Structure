
/*
 * 
link: 
https://leetcode-cn.com/problems/merge-intervals/

2020-7-18 at 5:28 pm

56. 合并区间
难度
中等

507

收藏

分享
切换为英文
关注
反馈
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




// 输入:
// [[1,4],[2,3]]
// 输出
// [[1,3]]
// 预期结果
// [[1,4]]




class Solution {
    //5.28pm-5.42pm AC
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(intervals.length,(int[] a, int[] b)->a[0]-b[0]);
        for(int i=0;i<intervals.length;i++){
            pq.add(intervals[i]);
        }
       List<int[]> result=new ArrayList<int[]>();
       int[] left=pq.poll();
       result.add(left);
       while(!pq.isEmpty()){
           int[] right=pq.poll();
           if(left[1]<right[0]){
               left=right;
               result.add(left);
           }else{
               if(left[1]<right[1]){
                result.remove(result.size()-1);
                int[] tmp=new int[]{left[0],right[1]};
                result.add(tmp);
                left=tmp;
               }
           }
       }
       int[][] ans=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            ans[i][0]=result.get(i)[0];
            ans[i][1]=result.get(i)[1];
        }
        return ans;
    }
}

//T: O(nlog(n))
//S: O(n)






class Solution {
    //5.43pm-5.53pm
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        Arrays.sort(intervals,(int[] a, int[] b)->a[0]-b[0]);
   
       List<int[]> result=new ArrayList<int[]>();
       int[] left=intervals[0];
       result.add(left);
       for(int i=1;i<intervals.length;i++){
           int[] right=intervals[i];
           if(left[1]<right[0]){
               left=right;
               result.add(left);
           }else{
               if(left[1]<right[1]){
                result.remove(result.size()-1);
                int[] tmp=new int[]{left[0],right[1]};
                result.add(tmp);
                left=tmp;
               }
           }
       }
       int[][] ans=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            ans[i][0]=result.get(i)[0];
            ans[i][1]=result.get(i)[1];
        }
        return ans;
    }
}


//T: O(n^2);
//S: O(n)




