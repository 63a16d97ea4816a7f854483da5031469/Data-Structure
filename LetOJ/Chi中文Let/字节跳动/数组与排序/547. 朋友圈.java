
/*
 * 
link: 
https://leetcode-cn.com/problems/friend-circles/

2020-7-18 at 11:57 am

547. 朋友圈
难度
中等

279

收藏

分享
切换为英文
关注
反馈
班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

示例 1:

输入: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
输出: 2 
说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
第2个学生自己在一个朋友圈。所以返回2。
示例 2:

输入: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
输出: 1
说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
注意：

N 在[1,200]的范围内。
对于所有学生，有M[i][i] = 1。
如果有M[i][j] = 1，则有M[j][i] = 1。

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

// DFS:


public class Solution {
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
// T: O(n^2)
// Space: O(n)

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/friend-circles/solution/peng-you-quan-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// BFS:

public class Solution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue < Integer > queue = new LinkedList < > ();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0)
                            queue.add(j);
                    }
                }
                count++;
            }
        }
        return count;
    }
}
// T: O(n^2)
// Space: O(n)

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/friend-circles/solution/peng-you-quan-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


//并查集：

public class Solution {
    int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }
}


// T: O(n^3)     并查集操作需要最坏 O(n) 的时间
// Space: O(n)

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/friend-circles/solution/peng-you-quan-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






//错误思路:

class Solution {
    int group=0;
    public int findCircleNum(int[][] M) {
        boolean[][] used=new boolean[M.length][M[0].length];
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                if(M[i][j]==1){
                    bfs(M, used, i,j);
                }
            }
        }
        return group;
    }

    public void  bfs(int[][] M, boolean[][] used, int x, int y){
        Queue<int[]> que=new LinkedList<int[]>();
        que.add(new int[]{x,y});
        if(used[x][y]) return;
        group++;
        while(!que.isEmpty()){
            int[] curr=que.poll();
            int dx=curr[0];
            int dy=curr[1];
            if(used[dx][dy]) continue;
            used[dx][dy]=true;

            if(dx+1<M.length&&!used[dx+1][dy]&&M[dx+1][dy]==1){
                que.add(new int[]{dx+1,dy});
            }

            if(dy+1<M.length&&!used[dx][dy+1]&&M[dx][dy+1]==1){
                que.add(new int[]{dx,dy+1});
            }

            if(dx-1>=0&&!used[dx-1][dy]&&M[dx-1][dy]==1){
                que.add(new int[]{dx-1,dy});
            }

            if(dy-1>=0&&!used[dx][dy-1]&&M[dx][dy-1]==1){
                que.add(new int[]{dx,dy-1});
            }
        }
    }
}




