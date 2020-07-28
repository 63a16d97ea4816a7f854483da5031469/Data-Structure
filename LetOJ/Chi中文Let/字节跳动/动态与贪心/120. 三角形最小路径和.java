
/*
 * 
link: 
https://leetcode-cn.com/problems/triangle/

2020-7-26 at 10:39 pm


120. 三角形最小路径和
难度
中等

545

收藏

分享
切换为英文
关注
反馈
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

 

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

 

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */





class Solution {
  //动态规划
  public int minimumTotal(List<List<Integer>> triangle) {
      int n=triangle.size();
      int[][] dp=new int[n][n];
      dp[0][0]=triangle.get(0).get(0);

      for(int i=1;i<n;i++){
          dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
          for(int j=1;j<i;j++){
              dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
          }
          dp[i][i]=dp[i-1][i-1]+triangle.get(i).get(i);
      }
      int minValue=dp[n-1][0];
      for(int i=1;i<dp[n-1].length;i++){
          minValue=Math.min(dp[n-1][i],minValue);
      }
      return minValue;
  }
}



//自上而下：
class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
      int n = triangle.size();
      int[][] f = new int[n][n];
      f[0][0] = triangle.get(0).get(0);
      for (int i = 1; i < n; ++i) {
          f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
          for (int j = 1; j < i; ++j) {
              f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
          }
          f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
      }
      int minTotal = f[n - 1][0];
      for (int i = 1; i < n; ++i) {
          minTotal = Math.min(minTotal, f[n - 1][i]);
      }
      return minTotal;
  }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/triangle/solution/san-jiao-xing-zui-xiao-lu-jing-he-by-leetcode-solu/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


//自下而上 
class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
      if(triangle==null || triangle.size()==0) {
          return 0;
      }
      int n = triangle.size();
      int m = triangle.get(n-1).size();
      int[][] dp = new int[n+1][m+1];
      //自下而上推到
      for(int i=n-1;i>=0;--i) {
          //对于三角形的每一行，从右向左计算
          for(int j=triangle.get(i).size()-1;j>=0;--j) {
              dp[i][j] = Math.min(dp[i+1][j+1],dp[i+1][j]) + triangle.get(i).get(j);
          }
      }
      //最终结果就保存在第一行第一列中
      return dp[0][0];
  }
}

// 作者：wang_ni_ma
// 链接：https://leetcode-cn.com/problems/triangle/solution/san-chong-jie-fa-duo-tu-xiang-jie-120-san-jiao-xin/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





//超时：
class Solution {
  //搜索算法 9.38am-10.30am
  int min=Integer.MAX_VALUE;
  public int minimumTotal(List<List<Integer>> triangle) {
      if(triangle==null||triangle.size()==0) return 0;
      dfs(triangle,0,0,new ArrayList<Integer>());
      return min;
  }
  public void dfs(List<List<Integer>> tri, int currLevel, int lastSelect, List<Integer> list){
      if(list.size()==tri.size()){
          //count the sum
          int sum=0;
          for(int tmp:list){
              // System.out.print(tmp+" ");
              sum+=tmp;
          }
          // System.out.println();
          min=Math.min(sum,min);
          return;
      }
      if(currLevel>tri.size()-1){
          return;
      }
      List<Integer> level=tri.get(currLevel);
      for(int i=0;i<level.size();i++){
          if(i-lastSelect>=0&&i-lastSelect<=1){
              list.add(level.get(i));
          }else{
              continue;
          }
          // for(int tmp:list){
          //     System.out.print(tmp+" ");
          // }
          // System.out.println();
      //选择同样下标
          dfs(tri,currLevel+1,i,list);
          if(list.size()>1)
          list.remove(list.size()-1); //回溯
      }
  }
}










