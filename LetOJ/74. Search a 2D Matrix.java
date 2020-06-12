
/*
 * 
https://leetcode.com/problems/search-a-2d-matrix/


74. Search a 2D Matrix
Medium

1507

149

Add to List

Share
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

3 May 2020 at 6:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


class Solution {
    //9.44pm-10.06pm
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0) return false; // []
        int n=matrix[0].length;
        if(n==0) return false;  // [[]]
        int[] colArr=new int[m];
        for(int i=0;i<m;i++){
            colArr[i]=matrix[i][n-1];
        }
        int selectedRow=binarySearch(colArr, target);
        int foundIndexOnRow=binarySearch(matrix[selectedRow],target);
        return matrix[selectedRow][foundIndexOnRow]==target?true:false;
    }
    int binarySearch(int[] arr, int target){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid=(right+left)>>1;
            if(target==arr[mid]){
                return mid;
            }else if(target<arr[mid]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return right;
    }
}


//  AC: 

class Solution {
    //9.44pm-10.06pm
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0) return false; // []
        int n=matrix[0].length;
        if(n==0) return false;  // [[]]
        
        int[] colArr=new int[m];
        for(int i=0;i<m;i++){
            colArr[i]=matrix[i][n-1];
        }
        // System.out.println(Arrays.toString(colArr));
        int selectedRow=binarySearch(colArr, target);
        // System.out.println(selectedRow);
        
        int foundIndexOnRow=binarySearch(matrix[selectedRow],target);
        
        return matrix[selectedRow][foundIndexOnRow]==target?true:false;
    }
    
    int binarySearch(int[] arr, int target){
        int left=0;
        int right=arr.length-1;
        
        while(left<right){
            int mid=left+(right-left)/2;
            if(target==arr[mid]){
                return mid;
            }else if(target<arr[mid]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return right;
    }
}





















