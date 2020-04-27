
/*
 * 
https://leetcode.com/problems/maximal-square/

221. Maximal Square
Medium

2400

62

Add to List

Share
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
	public int maximalSquare(char[][] matrix) {
		int max = 0;
		if (matrix == null) return 0;
		if (matrix.length == 0) return 0; //这一句很关键，否则空数组[]，会出错
		int m = matrix.length, n = matrix[0].length; //这一句，必须有上面那句保护，否则遇到[]会出错
		if (m == 0 && n == 0) return 0;
		// 上面三句可以被替换为这句： if (matrix.length == 0 || matrix[0].length == 0) return 0;

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i<= m; i++) {
			for (int j = 1; j<= n; j++) {
                //注意matric是从(0,0)开始，dp是从(1,1)开始
				dp[i][j] = matrix[i - 1][j - 1] == '1' ? Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1 : 0; //注意这里三个数取最小值的写法，另外，只有1的时候，我们才做这个运算，否则为0
				max = Math.max(max, dp[i][j]); //将最大值存起来，因为这个是求最大的正方形，最大的值不在m,n 位置
			}
		}
		return max * max;
	}
}








public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        // 第一列赋值
        for(int i = 0; i < m; i++){
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }
        // 第一行赋值
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(max, dp[0][i]);
        }
        // 递推
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = matrix[i][j] == '1' ? Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}





https://www.cnblogs.com/slontia/p/8709200.html

通过不断的尝试，在以1为点的范围内，进行一个矩形的伸展：

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int row = matrix.size();
        int max_a = 0;
        for (int i = 0; i < row; i++) {
            int col = matrix[i].size();
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] - '0') {
                    int a;
                    for (a = 1; i + a < row && j + a < col; a++) { // overflow judge
                        int off_x, off_y;
                        // go through in 'L' shape
                        for (off_x = 0; off_x < a + 1 && matrix[i + a][j + off_x] - '0'; off_x++);
                        if (off_x < a + 1) {
                            break;
                        }
                        for (off_y = 0; off_y < a + 1 && matrix[i + off_y][j + a] - '0'; off_y++);
                        if (off_y < a + 1) {
                            break;
                        }
                    }
                    
                    if (a > max_a) {
                        max_a = a;
                    }
                }
            }
        }
        return max_a * max_a;
    }
};


// https://blog.csdn.net/katrina95/article/details/79125096

// 解法：动态规划，新建一个m+1, n+1大小的dp矩阵，然后从（1，1）点开始填数，原矩阵从（0，0）开始遍历，当原矩阵中的数为1时，
// 我们更新dp矩阵的数字为左上角的三个数字的最小值+1，dp矩阵中存的数字为构成一个squre的边长大小，每次更新dp矩阵的某个数值时都update一下最长length，
// 填完dp矩阵后输出边长的平方即可。
// ————————————————
// 版权声明：本文为CSDN博主「katrina95」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/katrina95/article/details/79125096

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, length = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                    if (dp[i][j] > length) {
                        length = dp[i][j];
                    }
                }
            }
        }
        return length * length;
    }
}








题意理解错了，写成了寻找最大的1的面积:

class Solution {
    //3.31pm-3.50pm (write finish)
    //BFS
    int max=0;
    public int maximalSquare(char[][] matrix) {
        
        boolean[][] used=new boolean[matrix.length][matrix[0].length];
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1' &&!used[i][j]){
                    //only 1 will do the bfs
                    bfs(matrix, used, i, j);
                }
            }
        }
        return max;
    }
    
    void bfs(char[][] matrix, boolean[][] used, int x, int y){
        
        Queue<int[]> que=new LinkedList<>();
        //put the first element into the queque
        que.add(new int[]{x, y});
        int count=0;
        
        while(!que.isEmpty()){
            
            int[] head=que.poll();
            int dx=head[0];
            int dy=head[1];
         
            //bfs to the nearby ones
            // (-1,0)
            if(dx-1>=0&&!used[dx-1][dy] && matrix[dx-1][dy]=='1'){
                que.add(new int[]{dx-1,dy});
                used[dx-1][dy]=true;
                count++;
            }
            
            // (1,0)
            if(dx+1<matrix.length&&!used[dx+1][dy]&& matrix[dx+1][dy]=='1'){
                que.add(new int[]{dx+1,dy});
                used[dx+1][dy]=true;
                count++;
            }
            // (-1,0)
            if(dy-1>=0&&!used[dx][dy-1]&& matrix[dx][dy-1]=='1'){
                que.add(new int[]{dx,dy-1});
                used[dx][dy-1]=true;
                count++;
            }
            
            //(1,0)
            if(dy+1<matrix[0].length&&!used[dx][dy+1]&& matrix[dx][dy+1]=='1'){
                que.add(new int[]{dx,dy+1});
                used[dx][dy+1]=true;
                count++;
            }
        }
        
        max=Math.max(max, count);
    }
}
