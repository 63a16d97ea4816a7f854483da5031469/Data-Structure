
/*
 * 
https://leetcode.com/problems/lucky-numbers-in-a-matrix/

1380. Lucky Numbers in a Matrix
Easy

135

14

Add to List

Share
Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

 

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 10^5.
All elements in the matrix are distinct.

3 May 2020 at 5.07 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




class Solution {
    //4.51pm-5.07pm
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list=new ArrayList<Integer>();
        if(matrix.length==0) return list;
   
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(isLuckyNum(matrix,i,j)){
                    list.add(matrix[i][j]);
                }
            }
        }
        
        return list;
    }
    
    boolean isLuckyNum(int[][] matrix,int x, int y){
        int curr=matrix[x][y];
        
        int max=curr;
        for(int i=0;i<matrix.length;i++){
            //min in the row
            max=Math.max(matrix[i][y],max);
        }
        
        //if the matrix[0].length is 0.

        if(matrix[0].length==0){
            return max==curr;
        }
        
        int min=curr;
        for(int i=0;i<matrix[0].length;i++){
            //max in the col
            min=Math.min(matrix[x][i],min);
        }
        
        return min==curr && max==curr;
    }
}



















