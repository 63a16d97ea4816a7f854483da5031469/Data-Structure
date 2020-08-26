
/*
 * 
link: 
https://leetcode-cn.com/problems/course-schedule-ii/

2020-8-26 at 3:49 pm

210. 课程表 II
难度
中等

250

收藏

分享
切换为英文
关注
反馈
现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。

可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。

示例 1:

输入: 2, [[1,0]] 
输出: [0,1]
解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
示例 2:

输入: 4, [[1,0],[2,0],[3,1],[3,2]]
输出: [0,1,2,3] or [0,2,1,3]
解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
说明:

输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
提示:

这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
拓扑排序也可以通过 BFS 完成。


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */











class Solution {
    // 存储有向图
    List<List<Integer>> edges;
    // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
    int[] visited;
    // 用数组来模拟栈，下标 n-1 为栈底，0 为栈顶
    int[] result;
    // 判断有向图中是否有环
    boolean valid = true;
    // 栈下标
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[0];
        }
        // 如果没有环，那么就有拓扑排序
        return result;
    }

    public void dfs(int u) {
        // 将节点标记为「搜索中」
        visited[u] = 1;
        // 搜索其相邻节点
        // 只要发现有环，立刻停止搜索
        for (int v: edges.get(u)) {
            // 如果「未搜索」那么搜索相邻节点
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            }
            // 如果「搜索中」说明找到了环
            else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        // 将节点标记为「已完成」
        visited[u] = 2;
        // 将节点入栈
        result[index--] = u;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/course-schedule-ii/solution/ke-cheng-biao-ii-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



















class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(whetherhasCycle(numCourses,prerequisites)){
            return new int[]{};
        }
        //if has the solution
        List<Integer> ans=new ArrayList<Integer>();
        int[] inDegree=new int[numCourses];
        for(int[] tmp:prerequisites){
            inDegree[tmp[0]]++;
        }

        boolean[] flag=new boolean[numCourses];
        for(int i=0;i<inDegree.length;i++){
            dfs(numCourses,prerequisites,i,flag,ans);
        }
        int[] result=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i]=ans.get(i);
        }
        return result;
    }

    public void dfs(int numCourses, int[][] matrix, int start, boolean[] visit, List<Integer> result){
        if(visit[start]) return;
        visit[start]=true; //mark the visit.
        result.add(start);
        for(int[] tmp:matrix){
            //go for the next path
            if(tmp[1]!=start){
                continue;
            }
            dfs(numCourses,matrix,tmp[0],visit,result);
        }
    }

    public boolean whetherhasCycle(int numCourses, int[][] rules){
        int[] inDegree=new int[numCourses];
        for(int[] tmp:rules){
            inDegree[tmp[0]]++;
        }
        Queue<Integer> que=new LinkedList<Integer>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0) que.add(i);
        }
        while(!que.isEmpty()){
            int pre=que.poll();
            numCourses--;
            for(int[] tmp:rules){
                if(pre!=tmp[1]){
                    continue;
                }
                if(--inDegree[tmp[0]]==0) que.add(tmp[0]);
            }
        }
        return numCourses!=0;
    }
}