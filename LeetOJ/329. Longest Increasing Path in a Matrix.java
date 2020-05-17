
/*
 * 
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/


329. Longest Increasing Path in a Matrix
Hard

1705

32

Add to List

Share
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

16 May 2020 at 11:16 pm




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




public class Solution {
    int []dx = { 1 , -1, 0 , 0  };
    int []dy = { 0 , 0 , 1 , -1 };
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dis = new int [m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs( i, j, m, n, matrix, dis));
            }
        }
        return ans;
    }
 
    int dfs(int x, int y, int m,int n,int[][] matrix, int[][] dis) {
        if (dis[x][y] != 0) return dis[x][y];
 
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && matrix[nx][ny] > matrix[x][y]) {
                dis[x][y] = Math.max(dis[x][y], dfs(nx, ny, m, n, matrix, dis));
            }
        }
        return ++dis[x][y];
    }
}







// C++:
// 这道题给我们一个二维数组，让我们求矩阵中最长的递增路径，规定我们只能上下左右行走，不能走斜线或者是超过了边界。那么这道题的解法要用递归和DP来解，用DP的原因是为了提高效率，避免重复运算。我们需要维护一个二维动态数组dp，其中dp[i][j]表示数组中以(i,j)为起点的最长递增路径的长度，初始将dp数组都赋为0，当我们用递归调用时，遇到某个位置(x, y), 如果dp[x][y]不为0的话，我们直接返回dp[x][y]即可，不需要重复计算。我们需要以数组中每个位置都为起点调用递归来做，比较找出最大值。在以一个位置为起点用DFS搜索时，对其四个相邻位置进行判断，如果相邻位置的值大于上一个位置，则对相邻位置继续调用递归，并更新一个最大值，搜素完成后返回即可


class Solution {
    public:
        vector<vector<int>> dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int longestIncreasingPath(vector<vector<int>>& matrix) {
            if (matrix.empty() || matrix[0].empty()) return 0;
            int res = 1, m = matrix.size(), n = matrix[0].size();
            vector<vector<int>> dp(m, vector<int>(n, 0));
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    res = max(res, dfs(matrix, dp, i, j));
                }
            }
            return res;
        }
        int dfs(vector<vector<int>> &matrix, vector<vector<int>> &dp, int i, int j) {
            if (dp[i][j]) return dp[i][j];
            int mx = 1, m = matrix.size(), n = matrix[0].size();
            for (auto a : dirs) {
                int x = i + a[0], y = j + a[1];
                if (x < 0 || x >= m || y < 0 |a| y >= n || matrix[x][y] <= matrix[i][j]) continue;
                int len = 1 + dfs(matrix, dp, x, y);
                mx = max(mx, len);
            }
            dp[i][j] = mx;
            return mx;
        }
    };


    // 下面再来看一种BFS的解法，需要用queue来辅助遍历，我们还是需要dp数组来减少重复运算。遍历数组中的每个数字，跟上面的解法一样，把每个遍历到的点都当作BFS遍历的起始点，需要优化的是，如果当前点的dp值大于0了，说明当前点已经计算过了，我们直接跳过。否则就新建一个queue，然后把当前点的坐标加进去，再用一个变量cnt，初始化为1，表示当前点为起点的递增长度，然后进入while循环，然后cnt自增1，这里先自增1没有关系，因为只有当周围有合法的点时候才会用cnt来更新。由于当前结点周围四个相邻点距当前点距离都一样，所以采用类似二叉树层序遍历的方式，先出当前queue的长度，然后遍历跟长度相同的次数，取出queue中的首元素，对周围四个点进行遍历，计算出相邻点的坐标后，要进行合法性检查，横纵坐标不能越界，且相邻点的值要大于当前点的值，并且相邻点点dp值要小于cnt，才有更新的必要。用cnt来更新dp[x][y]，并用cnt来更新结果res，然后把相邻点排入queue中继续循环即可，参见代码如下：


    class Solution {
        public:
            int longestIncreasingPath(vector<vector<int>>& matrix) {
                if (matrix.empty() || matrix[0].empty()) return 0;
                int m = matrix.size(), n = matrix[0].size(), res = 1;
                vector<vector<int>> dirs{{0,-1},{-1,0},{0,1},{1,0}};
                vector<vector<int>> dp(m, vector<int>(n, 0));
                for (int i = 0; i < m; ++i) {
                    for (int j = 0; j < n; ++j ) {
                        if (dp[i][j] > 0) continue;
                        queue<pair<int, int>> q{{{i, j}}};
                        int cnt = 1;
                        while (!q.empty()) {
                            ++cnt;
                            int len = q.size();
                            for (int k = 0; k < len; ++k) {
                                auto t = q.front(); q.pop();
                                for (auto dir : dirs) {
                                    int x = t.first + dir[0], y = t.second + dir[1];
                                    if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[t.first][t.second] || cnt <= dp[x][y]) continue;
                                    dp[x][y] = cnt;
                                    res = max(res, cnt);
                                    q.push({x, y});
                                }
                            }
                        }
                    }
                }
                return res;
            }
        };
















