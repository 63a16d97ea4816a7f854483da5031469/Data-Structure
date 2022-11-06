
/*
 * 
link: 


2022-02-02 at 19:04
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




//错误(因为不满足最近的陆地,dfs是会找到最远的):
class Solution {
    int max=0;
    public int maxDistance(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        boolean isFoundOne=false;
        boolean isFoundZero=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) {
                    isFoundOne=true;
                }else{
                    isFoundZero=true;
                    boolean[][] v=new boolean[m][n];
                    dfs(grid,new int[]{i,j},i,j,v);
                }
            }
        }
        if(!isFoundOne||!isFoundZero){
            return -1;
        }
        return max;
    }

    public void dfs(int[][] grid,int[] curr, int x, int y,boolean[][] v){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length){
            return;
        }
        if(grid[x][y]==1){
            max=Math.max(max,getDistinct(curr,x,y));
        }
        if(v[x][y]){
            return;
        }
        //避免再次回来
        v[x][y]=true;
        // dirs
        dfs(grid,curr,x+1,y,v);
        dfs(grid,curr,x-1,y,v);
        dfs(grid,curr,x,y+1,v);
        dfs(grid,curr,x,y-1,v);
    }
    public int getDistinct(int[] curr, int x,int y){
        return Math.abs(curr[0]-x)+Math.abs(curr[1]-y);
    }
}





//超出时间限制:
class Solution {
    int max=0;
    public int maxDistance(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        boolean isFoundOne=false;
        boolean isFoundZero=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) {
                    isFoundOne=true;
                }else{
                    isFoundZero=true;
                    bfs(grid,i,j);
                }
            }
        }
        if(!isFoundOne||!isFoundZero){
            return -1;
        }
        return max;
    }

    public void bfs(int[][] grid, int x, int y){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x,y});
        boolean[][] v=new boolean[grid.length][grid[0].length];
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int minDistinct=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] loc=queue.poll();
            int cx=loc[0];
            int cy=loc[1];

            if(cx<0||cx>=grid.length||
            cy<0||cy>=grid[0].length){
                continue;
            }
            if(v[cx][cy]){
                continue;
            }
            v[cx][cy]=true;
            if(grid[cx][cy]==1){
                minDistinct=Math.min(minDistinct, Math.abs(x-cx)+Math.abs(y-cy));
                 max=Math.max(minDistinct,max);
                 return;
            }

            // 继续向周围发散搜索,找到最近的1,并计算距离,退出
            for(int[] tmp:dirs){
                int newX=tmp[0]+cx;
                int newY=tmp[1]+cy;
                queue.add(new int[]{newX, newY});
            }
        }
        max=Math.max(minDistinct,max);
    }
    public int getDistinct(int[] curr, int x,int y){
        return Math.abs(curr[0]-x)+Math.abs(curr[1]-y);
    }
}



//超出时间限制
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    int n;
    int[][] grid;

    public int maxDistance(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, findNearestLand(i, j));
                }
            }
        }
        return ans;
    }

    public int findNearestLand(int x, int y) {
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{x, y, 0});
        vis[x][y] = true;
        while (!queue.isEmpty()) {
            int[] f = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int nx = f[0] + dx[i], ny = f[1] + dy[i];
                if (!(nx >= 0 && nx < n && ny >= 0 && ny < n)) {
                    continue;
                }
                if (!vis[nx][ny]) {
                    queue.offer(new int[]{nx, ny, f[2] + 1});
                    vis[nx][ny] = true;
                    if (grid[nx][ny] == 1) {
                        return f[2] + 1;
                    }
                }
            }
        }
        return -1;
    }
}


//动态规划解
class Solution {
    public int maxDistance(int[][] grid) {
        final int INF = 1000000;
        int n = grid.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                f[i][j] = grid[i][j] == 1 ? 0 : INF;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    continue;
                }
                if (i - 1 >= 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 1) {
                    continue;
                }
                if (i + 1 < n) {
                    f[i][j] = Math.min(f[i][j], f[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    f[i][j] = Math.min(f[i][j], f[i][j + 1] + 1);
                }
            }
        }

        int ans = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, f[i][j]);
                }
            }
        }

        if (ans == INF) {
            return -1;
        } else {
            return ans;
        }
    }
}

// 作者：力扣官方题解
// 链接：https://leetcode.cn/problems/as-far-from-land-as-possible/solutions/147423/di-tu-fen-xi-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



// 多源最短路,以陆地为源,以海洋为destination.
// 多源BFS,使用堆优化
class Solution {
    public int maxDistance(int[][] grid) {
        final int INF = 1000000;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = grid.length;
        int[][] d = new int[n][n];
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] status1, int[] status2) {
                return status1[0] - status2[0];
            }
        });

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                d[i][j] = INF;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                //以陆地为源
                if (grid[i][j] == 1) {
                    d[i][j] = 0;
                    queue.offer(new int[]{0, i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] f = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int nx = f[1] + dx[i], ny = f[2] + dy[i];
                if (!(nx >= 0 && nx < n && ny >= 0 && ny < n)) {
                    continue;
                }
                if (f[0] + 1 < d[nx][ny]) {
                    d[nx][ny] = f[0] + 1;
                    queue.offer(new int[]{d[nx][ny], nx, ny});
                }
            }
        }

        int ans = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, d[i][j]);
                }
            }
        }

        return ans == INF ? -1 : ans;
    }
}

// 作者：力扣官方题解
// 链接：https://leetcode.cn/problems/as-far-from-land-as-possible/solutions/147423/di-tu-fen-xi-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

