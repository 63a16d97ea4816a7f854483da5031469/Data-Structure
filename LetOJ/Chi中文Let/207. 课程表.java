
/*
 * 
link: 
https://leetcode-cn.com/problems/course-schedule/

2020-8-26 at 11:21 am

207. 课程表
难度
中等

540

收藏

分享
切换为英文
关注
反馈
你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]

给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？

 

示例 1:

输入: 2, [[1,0]] 
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 

提示：

输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
1 <= numCourses <= 10^5


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        // Get the indegree and adjacency of every course.
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            // 学习cp[0]课程前,你需要先学习课程cp[1]
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);
        // BFS TopSort.
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre))
                if(--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }
}

// 作者：jyd
// 链接：https://leetcode-cn.com/problems/course-schedule/solution/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] indegrees = new int[numCourses];
    for (int[] p : prerequisites) {
        indegrees[p[0]]++;
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < indegrees.length; i++) {
        if (indegrees[i] == 0) queue.offer(i);
    }
    while (!queue.isEmpty()) {
        int pre = queue.poll();
        numCourses--;
        for (int[] p : prerequisites) {
            if (p[1] != pre) continue;
            indegrees[p[0]]--;
            if (indegrees[p[0]] == 0) queue.offer(p[0]);
        }
    }
    return numCourses == 0;
}

// 作者：a-fei-8
// 链接：https://leetcode-cn.com/problems/course-schedule/solution/ke-cheng-biao-san-jian-ke-zhi-ke-cheng-biao-iladyb/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         int[][] adjacency = new int[numCourses][numCourses];
         int[] flags = new int[numCourses];
         for (int[] p : prerequisites) {
             adjacency[p[1]][p[0]] = 1;  //标记所有的已有的边，注意是从p[1]->p[0]的这个方向
         }
         for (int i = 0; i < numCourses; i++) {
             if (!canFinish1stDFS(adjacency, flags, i)) {
                 return false;
             }
         }
         return true;
     }
 
     private boolean canFinish1stDFS(int[][] adjacency, int[] flags, int i) {
         if (flags[i] == 1) return false;
         if (flags[i] == -1) return true;
         
         //正在访问标志
         flags[i] = 1;
         //注意这种邻接矩阵的表达方式，以及如何在这种矩阵上做DFS
         for (int j = 0; j < adjacency.length; j++) {
             if (adjacency[i][j] == 1 && !canFinish1stDFS(adjacency, flags, j)) {
                 return false;
             }
         }
         flags[i] = -1;
         return true;
     }
 }
 
 // 作者：a-fei-8
 // 链接：https://leetcode-cn.com/problems/course-schedule/solution/ke-cheng-biao-san-jian-ke-zhi-ke-cheng-biao-iladyb/
 // 来源：力扣（LeetCode）
 // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 






//错误，无法通过：

class Solution {
    //10.58am-
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] courses=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int[] conditions=prerequisites[i];
            courses[conditions[0]]++;
        }
        boolean isfindZero=false;
        for(int i=0;i<numCourses;i++){
            if(courses[i]==0) 
            isfindZero=true;
        }
        return isfindZero;
    }
}



//错误，无法通过case:
//
// 3
// [[1,0],[0,2],[2,1]]
// 把问题想得太简单。刚开始忽略了有多个key，对应多个value的情况，后面这个case是忽略了可以绕一个圈回来有环

// 其实这个题目是看 入度和出度的，或者是检测环的

class Solution {
    //10.58am-11.22am
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<String,List<String>> map=new HashMap<String,List<String>>();
        for(int i=0;i<prerequisites.length;i++){
            int[] condition=prerequisites[i];
            List<String> list=map.getOrDefault(condition[1]+"",new ArrayList<String>());
            list.add(condition[0]+"");
            map.put(condition[1]+"",list);
        }
        //check whether has cycle
        for(int i=0;i<numCourses;i++){
            String key=i+"";
            List<String> list=map.getOrDefault(key, new ArrayList<String>());
            for(String tmp:list){
                List<String> anotherList=map.getOrDefault(tmp, new ArrayList<String>());
                for(String anotherTmp:anotherList){
                    if(key.equals(anotherTmp)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}






