
/*
 * 
1578. Minimum Time to Make Rope Colorful
Medium

2592

72

Add to List

Share
Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.

Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.

Return the minimum time Bob needs to make the rope colorful.

 

Example 1:


Input: colors = "abaac", neededTime = [1,2,3,4,5]
Output: 3
Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
Bob can remove the blue balloon at index 2. This takes 3 seconds.
There are no longer two consecutive balloons of the same color. Total time = 3.
Example 2:


Input: colors = "abc", neededTime = [1,2,3]
Output: 0
Explanation: The rope is already colorful. Bob does not need to remove any balloons from the rope.
Example 3:


Input: colors = "aabaa", neededTime = [1,2,3,4,1]
Output: 2
Explanation: Bob will remove the ballons at indices 0 and 4. Each ballon takes 1 second to remove.
There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.
 

Constraints:

n == colors.length == neededTime.length
1 <= n <= 105
1 <= neededTime[i] <= 104
colors contains only lowercase English letters.

DATE: 2022-October-16
TIME: 14:23:40


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */

//将复杂问题，永远分解为相邻两个气球的选择问题
//同时注意，如果选择了后面的最小值，要交换位置，因为要维持下一组也是在剩下的选择中选

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i=0,j=1;
        int n=colors.length();
        int total=0;
        while(i<n&&j<n&&i<j){
            if(colors.charAt(i)==colors.charAt(j)){
                if(neededTime[i]>neededTime[j]){
                   swap(neededTime,i,j);
                }
                total+=Math.min(neededTime[i],neededTime[j]);
            }
            i++;
            j++;
        }
        return total;
    }
    
    public void swap(int[] neededTime, int i, int j){
        int tmp=neededTime[i];
        neededTime[i]=neededTime[j];
        neededTime[j]=tmp;
    }
}




















