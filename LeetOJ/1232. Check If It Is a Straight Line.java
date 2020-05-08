
/*
 * 
https://leetcode.com/problems/check-if-it-is-a-straight-line/

1232. Check If It Is a Straight Line
Easy

183

24

Add to List

Share
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.

8 May 2020 at 4.01 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



class Solution {
    //3.44pm-4.00pm
    public boolean checkStraightLine(int[][] coordinates) {
        
        int dvalue=-999;
        for(int i=1;i<coordinates.length;i++){
            int x=coordinates[0][0];
            int y=coordinates[0][1];

            int dx=coordinates[i][0];
            int dy=coordinates[i][1];
            
            if(dy-y!=0&&dvalue==-999){
                dvalue=(dx-x)/(dy-y);
            }else if(dy-y!=0&&(dx-x)/(dy-y)!=dvalue){
                return false;
            }else if(dy-y==0){
                //to check whether all the y is equal
                        for(int j=0;j<coordinates.length-1;j++){
                            if(coordinates[j][1]!=coordinates[j+1][1]){
                                return false;
                            }
                        }
                return true;
            }
        }
        return true;
    }
}




















