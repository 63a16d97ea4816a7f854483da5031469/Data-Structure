
/*
 * 
https://leetcode.com/problems/two-best-non-overlapping-events/

2054. Two Best Non-Overlapping Events
Medium

541

12

Add to List

Share
You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei]. The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei. You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.

Return this maximum sum.

Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts and the other ends at the same time. More specifically, if you attend an event with end time t, the next event must start at or after t + 1.

 

Example 1:


Input: events = [[1,3,2],[4,5,2],[2,4,3]]
Output: 4
Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.
Example 2:

Example 1 Diagram
Input: events = [[1,3,2],[4,5,2],[1,5,5]]
Output: 5
Explanation: Choose event 2 for a sum of 5.
Example 3:


Input: events = [[1,5,3],[1,5,1],[6,6,5]]
Output: 8
Explanation: Choose events 0 and 2 for a sum of 3 + 5 = 8.
 

Constraints:

2 <= events.length <= 105
events[i].length == 3
1 <= startTimei <= endTimei <= 109
1 <= valuei <= 106


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


// Time Limit Exceeded:

class Solution {
    int max=0;
    public int maxTwoEvents(int[][] events) {
        List<Course> list=new ArrayList<Course>();
        for(int i=0;i<events.length;i++){
            Course c=new Course(events[i][0],events[i][1],events[i][2]);
            list.add(c);
        }
        Collections.sort(list,(o1,o2)->{
            return o1.start-o2.start;
        });      
        
        // for(Course tmp:list){
        //     System.out.println(tmp.start+" ");
        // }
        dfs(list,0,0,0,new ArrayList<Course>());
        
        
        return max;
    }
    
    public void dfs(List<Course> l, int index, int lastEnd, int v, List<Course> include){
        if(index==l.size()||include.size()==2){
            // for(int i=0;i<include.size();i++){
            //     System.out.print("[v] "+include.get(i).value+" ");
            // }
            // System.out.println();
                max=Math.max(max,v);
                if(include.size()==2){
                    include.remove(include.size()-1);
                }
                return;
            }
            
        
        Course curr=l.get(index);
        if(lastEnd<curr.start){
            List<Course> list=new ArrayList<Course>(include);
            list.add(curr);
                dfs(l,index,curr.end,v+curr.value,list);
            
        }
        dfs(l,index+1,lastEnd,v,include);
    }
    
    private class Course{
        public int start;
        public int end;
        public int value;
        
        public Course(int s, int e, int v){
            start=s;
            end=e;
            value=v;
        }
    }
}






class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int ans = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int max = 0;
        for (int i = 0; i < events.length; i++) {
            int[] e = events[i];
            int start = e[0], end = e[1], value = e[2];
            while (!queue.isEmpty() && queue.peek()[0] < start) {
                int[] cur = queue.poll();
                max = Math.max(max, cur[1]);
            }
            ans = Math.max(value + max, ans);
            queue.add(new int[] { end, value });
        }
        return ans;
    }
} 

// 对任意 i 位置的任务，能产生的最大value是之前出现过的结束时间在当前开始时间之前的任务中，最大收益 + 当前收益。

// 排序， 起始时间有序，起始时间在 i 位置后边的任务，其结束时间也一定是在当前之后。
// 优先级队列，i位置之前出现的任务，其结束时间未必在 i 位置开始时间之前，通过优先级队列，按照结束时间组织小根堆，结算当前位置之前，先检查结束时间，满足小于当前时间的结束时间，都要poll出堆并结算之前的最大值。
// 二维双排 48.17% 没必要 排开始时间就行，一维单排 60.73%

// 作者：瓦片
// 链接：https://leetcode.cn/problems/two-best-non-overlapping-events/solutions/1494160/2054-liang-ge-zui-hao-de-bu-zhong-die-hu-mnvn/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



// 如果不限制选择次数的话，就是典型的二分优化DP，参见 1235. 规划兼职工作
 // 这题稍微变通一下就行
// 1235. 规划兼职工作
// https://leetcode-cn.com/problems/maximum-profit-in-job-scheduling/

class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        // 根据结束时间排序
        Arrays.sort(events, Comparator.comparingInt(e -> e[1]));
        /*
         f[i] 表示 0 ~ i 范围内选一个的最大价值,
              很明显 f[i] = max(f[i-1], events[i][2])
         g[i] 表示 0 ~ i 范围内选两个的最大价值
              使用二分找到 结束时间 小于 当前开始时间 的最大下标j，
              g[i] = max(g[i-1], f[j] + events[i][2])
         */
        int[] f = new int[n], g = new int[n];
        for (int i = 0; i < n; ++i) {
            int low = 0, high = i - 1;
            while (low <= high) {
                int mid = low + high >>> 1;
                if (events[mid][1] >= events[i][0]) high = mid - 1;
                else low = mid + 1;
            }
            f[i] = events[i][2];
            if (high > -1) g[i] = f[high] + events[i][2];
            if (i > 0) {
                f[i] = Math.max(f[i], f[i - 1]);
                g[i] = Math.max(g[i], g[i - 1]);
            }
        }
        return Math.max(f[n - 1], g[n - 1]);
    }
}

作者：verygoodlee
链接：https://leetcode.cn/problems/two-best-non-overlapping-events/solutions/1077639/pai-xu-dong-tai-gui-hua-er-fen-by-verygo-ptd9/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。







1.按照开始时间排序
 2.记录每个事件之后的最大值，使用nextBig数组
 3.从前开始遍历，二分查找到下一个时间允许事件的索引，判断是否大于max并更新
 （这里nextBig数组多申请一个长度，是为了方便二分查找，如果event没有下一个时间允许的event，那么其返回结果越界，刚好对应nextBig[nextI]为0）



    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        int[] nextBig = new int[events.length + 1];
        for (int i = events.length - 1; i >= 0; i--) {
            nextBig[i] = Math.max(nextBig[i + 1], events[i][2]);
        }
        int max = 0;
        for (int i = 0; i < events.length; i++) {
            int nextI = binarySearch(events, events[i][1]);
            int sum = events[i][2] + nextBig[nextI];
            if (sum > max)
                max = sum;
        }
        return max;
    }
    private int binarySearch(int[][] events, int end) {
        int left = 0, right = events.length;
        while (left < right){
            int mid = (left + right) >> 1;
            if (events[mid][0] <= end){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

作者：JasonLoong
链接：https://leetcode.cn/problems/two-best-non-overlapping-events/solutions/1075290/javapai-xu-er-fen-sou-suo-by-jasonloong-bz71/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



