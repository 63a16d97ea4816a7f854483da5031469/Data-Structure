
/*
 * 
link: 
https://leetcode-cn.com/problems/course-schedule-iv/

2020-8-26 at 5:28 pm

1462. 课程安排 IV
难度
中等

23

收藏

分享
切换为英文
关注
反馈
你总共需要上 n 门课，课程编号依次为 0 到 n-1 。

有的课会有直接的先修课程，比如如果想上课程 0 ，你必须先上课程 1 ，那么会以 [1,0] 数对的形式给出先修课程数对。

给你课程总数 n 和一个直接先修课程数对列表 prerequisite 和一个查询对列表 queries 。

对于每个查询对 queries[i] ，请判断 queries[i][0] 是否是 queries[i][1] 的先修课程。

请返回一个布尔值列表，列表中每个元素依次分别对应 queries 每个查询对的判断结果。

注意：如果课程 a 是课程 b 的先修课程且课程 b 是课程 c 的先修课程，那么课程 a 也是课程 c 的先修课程。

 

示例 1：



输入：n = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
输出：[false,true]
解释：课程 0 不是课程 1 的先修课程，但课程 1 是课程 0 的先修课程。
示例 2：

输入：n = 2, prerequisites = [], queries = [[1,0],[0,1]]
输出：[false,false]
解释：没有先修课程对，所以每门课程之间是独立的。
示例 3：



输入：n = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
输出：[true,true]
示例 4：

输入：n = 3, prerequisites = [[1,0],[2,0]], queries = [[0,1],[2,0]]
输出：[false,true]
示例 5：

输入：n = 5, prerequisites = [[0,1],[1,2],[2,3],[3,4]], queries = [[0,4],[4,0],[1,3],[3,0]]
输出：[true,false,true,false]
 

提示：

2 <= n <= 100
0 <= prerequisite.length <= (n * (n - 1) / 2)
0 <= prerequisite[i][0], prerequisite[i][1] < n
prerequisite[i][0] != prerequisite[i][1]
先修课程图中没有环。
先修课程图中没有重复的边。
1 <= queries.length <= 10^4
queries[i][0] != queries[i][1]



对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */





class Solution {
    List<List<Integer>> adj;
    Boolean[][] memo;
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        adj=new ArrayList<List<Integer>>();
        memo=new Boolean[n][n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] tmp:prerequisites){
            adj.get(tmp[0]).add(tmp[1]);
            memo[tmp[0]][tmp[1]]=true;
        }
        List<Boolean> ans=new ArrayList<Boolean>();
        for(int[] check:queries){
            //dfs 判断
            ans.add(dfs(check[0],check[1]));
        }
        return ans;
    }

    public boolean dfs(int start, int end){
        if(memo[start][end]!=null) return memo[start][end];
        if(start==end) return memo[start][end]=true;
        for(Integer i:adj.get(start)){
            if(dfs(i,end)){
                return memo[start][end]=true;
            }
        }
        return memo[start][end]=false;
    }
}




class Solution {
    Boolean[][]memo;
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj=new ArrayList(n);
        for(int i=0;i<n;i++)
            adj.add(new ArrayList());
        for(int[] ar:prerequisites)
        {
            adj.get(ar[0]).add(ar[1]);
        }
        List<Boolean> re=new ArrayList();
        memo=new Boolean[n+1][n+1];
        for(int[] ar:queries)
        {
            re.add(dfs(adj,ar[0],ar[1]));
        }
        return re;
    }
    
    boolean dfs(List<List<Integer>> adj,int n,int m)
    {
        if(memo[n][m]!=null)
            return memo[n][m];
        if(m==n)
            return memo[n][m]=true;
        for(Integer i:adj.get(n))
            if(dfs(adj,i,m))
                return memo[n][m]=true;
        return memo[n][m]=false;
    }
}


class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Set<Integer>[] pre = new Set[n];
        boolean[][] graph = new boolean[n][n];
        for(int[] item:prerequisites){
            graph[item[1]][item[0]] = true;
        }
        for(int i=0; i<n; i++) dfs(pre,graph,i,n);
        List<Boolean> ans = new ArrayList<>(queries.length);
        for(int[] query:queries){
            ans.add(pre[query[1]].contains(query[0]));
        }
        return ans;
    }

    private void dfs(Set<Integer>[] pre, boolean[][] graph, int curr, int n){
        if(pre[curr]!=null) return;
        Set<Integer> set=new HashSet<>();
        for(int i=0; i<n; i++){
            if(graph[curr][i]) {
                set.add(i);
                if (pre[i] == null) dfs(pre, graph, i, n);
                set.addAll(pre[i]);
            }
        }
        pre[curr] = set;
    }
}



public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
    //生成有向图，p[0]表示源，p[1]表示终
    // Map<Integer, Set<Integer>> key是p[0] value是p[1]，但可能存在多个
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] p : prerequisites) {
        Set<Integer> set = map.getOrDefault(p[0], new HashSet<>());
        set.add(p[1]);
        map.put(p[0], set);
    }
    //定义两个顶点是否能形成路径，可达，候选列表
    Set<String> candidates = new HashSet<>();
    for (int i = 0; i < n; i++) {
        bfs(map, i, n, candidates);
    }
    //开始进行筛选
    List<Boolean> res = new ArrayList<>();
    for (int[] q : queries) {
        if (candidates.contains(q[0] + "->" + q[1])) res.add(true);
        else res.add(false);
    }
    return res;
}

/**
 * @param map        有向图的map
 * @param i          当前遍历到的节点，或者说课程，节点索引与课程 一一对应
 * @param n          总的课程数
 * @param candidates 候选列表
 */
private void bfs(Map<Integer, Set<Integer>> map, int i, int n, Set<String> candidates) {
    Queue<Integer> queue = new LinkedList<>();//queue
    boolean[] visited = new boolean[n];//所有课程是否被访问过
    if (!map.containsKey(i)) return;//如果没有以当前课程作为源的，不会形成
    queue.offer(i);//加入到queue中
    visited[i] = true;//标记被访问过
    while (!queue.isEmpty()) {
        int curr = queue.poll();//弹出当前的i并生成它的邻接的点
        Set<Integer> nexts = map.get(curr);
        if (nexts != null) {//没有邻接的点时，不遍历
            for (int next : nexts) {
                if (!visited[next]) {//被访问过，也不再遍历
                    candidates.add(i + "->" + next);//生成
                    visited[next] = true;//标记被访问
                    queue.offer(next);//进queue
                }
            }
        }
    }
}

// 作者：a-fei-8
// 链接：https://leetcode-cn.com/problems/course-schedule-iv/solution/ke-cheng-biao-san-jian-ke-fan-wai-pian-zhi-ke-chen/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        int G[][] = new int[n][n];
        for(int i=0;i<prerequisites.length;i++){
            G[prerequisites[i][0]][prerequisites[i][1]]=1;
        }
        for(int k=0;k<G.length;k++){
            for(int i=0;i<G.length;i++){
                for(int j=0;j<G.length;j++){
                    if (G[i][k]==1 && G[k][j]==1){
                        G[i][j]=1;
                    }
                }
            }
        }
        
        for(int i=0;i<queries.length;i++) {
            int a= queries[i][0];
            int b= queries[i][1];
            if(G[a][b]==1){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}




class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, 
    		int[][] queries) {
    	//建图
    	List<Integer>[] graph = getGraph(n, prerequisites);
    	//topology
    	boolean[][] pre = topology(n, graph);
    	//查询
    	return check(pre, queries);
    }

	private List<Boolean> check(boolean[][] pre, int[][] queries) {
		List<Boolean> isPreList = new ArrayList<Boolean>();
		for (int[] query : queries) {
			int before = query[0];
			int course = query[1];
			isPreList.add(pre[before][course]);
		}
		return isPreList;
	}

	private boolean[][] topology(int n, List<Integer>[] graph) {
		boolean[][] pre = new boolean[n][n];
		//求入度表
		int[] indegree = getIndegree(n, graph);
		//Topo
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int v = 0; v < n; v++) 
			if(indegree[v] == 0)
				queue.add(v);
		
		while(!queue.isEmpty()){
			int v = queue.poll();
			for (Integer w : graph[v]) {
				pre[v][w] = true;
				for (int u = 0; u < n; u++)
					if(pre[u][v])
						pre[u][w] = true;
				indegree[w]--;
				if(indegree[w] == 0)
					queue.add(w);
			}
		}
		
		return pre;
	}

	private int[] getIndegree(int n, List<Integer>[] graph) {
		int[] indegree = new int[n];
		for (int v = 0; v < n; v++) {
			for (Integer w : graph[v]) {
				indegree[w]++;
			}
		}
		return indegree;
	}

	private List<Integer>[] getGraph(int n, int[][] prerequisites) {
		List<Integer>[] graph = new List[n];
		for (int v = 0; v < graph.length; v++) 
			graph[v] = new ArrayList<Integer>();
		
		for (int[] pre : prerequisites) {
			int v = pre[0];
			int w = pre[1];
			graph[v].add(w);
		}
		return graph;
	} 
}


class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> dependenceMap = new HashMap<>(prerequisites.length);
        for (int[] item : prerequisites) {
            dependenceMap.computeIfAbsent(item[1], k -> new HashSet<>(n)).add(item[0]);
        }
        Set<Integer> scanned = new HashSet<>(prerequisites.length);
        for (int[] item : prerequisites) {
            dfs(dependenceMap, scanned, dependenceMap.get(item[1]), item[0]);
            scanned.add(item[1]);
        }
        List<Boolean> result = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            result.add(dependenceMap.containsKey(query[1]) && dependenceMap.get(query[1]).contains(query[0]));
        }
        return result;
    }

    void dfs(Map<Integer, Set<Integer>> dependenceMap, Set<Integer> scanned, Set<Integer> sourceSet, int target) {
        if (scanned.contains(target)) {
            sourceSet.addAll(dependenceMap.get(target));
            return;
        }
        Set<Integer> set = dependenceMap.get(target);
        if (set != null) {
            for (int i : set) {
                sourceSet.add(i);
                dfs(dependenceMap, scanned, sourceSet, i);
            }
        }
    }

}




//超时：

class Solution {
    //5.09pm-5.29pm  
    List<List<Integer>> adj;

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        adj=new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] tmp:prerequisites){
            adj.get(tmp[0]).add(tmp[1]);
        }
        List<Boolean> ans=new ArrayList<Boolean>();
        for(int[] check:queries){
            //dfs 判断
            ans.add(dfs(n, prerequisites,check[0],check[1]));
        }
        return ans;
    }

    public boolean dfs(int n,int[][] pre, int start, int end){
        if(start==end) return true;
        for(int[] tmp:pre){
            if(tmp[0]!=start) continue;
            if(start==tmp[0]&&end==tmp[1]) return true;
            if(dfs(n,pre,tmp[1],end)){
                return true;
            }
        }
        return false;
    }
}


