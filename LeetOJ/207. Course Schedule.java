
/*
 * 
https://leetcode.com/problems/course-schedule/

207. Course Schedule
Medium

3202

164

Add to List

Share
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 

Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



class Solution {
    public boolean canFinish(int numCourses , int[][] prerequisites){
		List<Integer>[] graph = new List[numCourses];
//		Arrays.fill(graph , new ArrayList<>());
		//不能用Arrays.fill, 会导致填充同一个ArrayList
		for(int i = 0 ; i < graph.length ; i++){
			graph[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < prerequisites.length ; i++){
			graph[prerequisites[i][0]].add(prerequisites[i][1]);
		}
		/*
			以节点为研究对象, 每个节点有三种状态:
			0. 还未访问过
			1. 在路径中
			2. 完成所有路径
		 */
		byte[] states = new byte[numCourses];
		for(int i = 0 ; i < numCourses ; i++){//将主要逻辑放在dfs方法中
			if(loopV2(i , graph , states)){
				return false;
			}
		}
		return true;
	}
	
	//进入节点i
	private boolean loopV2(int i , List<Integer>[] graph , byte[] states){
		if(states[i] == 2) return false;//base case
		if(states[i] == 1) return true;
		states[i] = 1;
		for(int j = 0 ; j < graph[i].size() ; j++){
			if(loopV2(graph[i].get(j) , graph , states)){
				return true;
			}
		}
		states[i] = 2;
		return false;
	}
}



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            return false;
        }
        
        int len = prerequisites.length;
        
        if(numCourses == 0 || len == 0){
            return true;
        }
        
        int[] visit = new int[numCourses];
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] a: prerequisites){
            if(map.containsKey(a[1])){
                map.get(a[1]).add(a[0]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(a[0]);
                map.put(a[1], list);
            }
        }
        
        for(int i=0; i<numCourses; i++){
            if(!canFinishDFS(map, visit, i)){
                return false;
            }
        }
        return true;
    }
 
 
    private boolean canFinishDFS(Map<Integer, List<Integer>> map, int[] visit, int i){
        if(visit[i]==-1) 
            return false;
        if(visit[i]==1) 
            return true;

        visit[i]=-1;
        if(map.containsKey(i)){
            for(int j: map.get(i)){
                if(!canFinishDFS(map, visit, j)) 
                    return false;
            }
        }

        visit[i]=1;

        return true;
    }
}






class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] item: prerequisites) {
            // item[1]--> item[0]
            Set<Integer> nextSet = graph.get(item[1]);
            if(null == nextSet) {
                nextSet = new HashSet<>();
                graph.put(item[1], nextSet);
            }
            nextSet.add(item[0]);
        }
        int[] flag = new int[numCourses]; // 0: not visited;  1: visiting; 2: visited
        for(int i = 0; i < numCourses; ++i) {
            dfs(i, flag, graph);
        }
        for(int i = 0; i < numCourses; ++i) {
            if(!dfs(i, flag, graph)) {
                return false;
            }
        }
        return true;
    }
    boolean dfs(int i, int[] flag, Map<Integer, Set<Integer>> graph) {
        if(flag[i] == 1) return false;
        flag[i] = 1;
        Set<Integer> nextSet = graph.get(i);
        if(null != nextSet) {
            for(int next: nextSet) {
                if(!dfs(next, flag, graph)) {
                    return false;
                }
            }
        }
        flag[i] = 2; // after dfs, mark current node as visited
        return true;
    }
}














