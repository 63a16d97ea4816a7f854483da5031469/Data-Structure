
/*
 * 
link: 
https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/

2020-8-1 at 10:41 pm

剑指 Offer 04. 二维数组中的查找
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 

示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。

 

限制：

0 <= n <= 1000

0 <= m <= 1000

 

作者：画手大鹏
链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/xs5w4d/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        if(matrix[0].length==0) return false;
        int row=matrix.length;
        int col=matrix[0].length;
        int select=matrix[0][col-1];
        int i=0;
        int j=col-1;
        while(i<row&&j>=0){
            select=matrix[i][j];
            if(target==select){
                return true;
            }else if(target>select){
                i++;
            }else if(target<select){
                j--;
            }
        }
        return false;
    }
}





















