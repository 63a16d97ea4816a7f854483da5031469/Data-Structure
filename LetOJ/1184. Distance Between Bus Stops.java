
/*
 * 
https://leetcode.com/problems/distance-between-bus-stops/


1184. Distance Between Bus Stops
Easy
606
62
Companies
A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.

The bus goes along both directions i.e. clockwise and counterclockwise.

Return the shortest distance between the given start and destination stops.

 

Example 1:



Input: distance = [1,2,3,4], start = 0, destination = 1
Output: 1
Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
 

Example 2:



Input: distance = [1,2,3,4], start = 0, destination = 2
Output: 3
Explanation: Distance between 0 and 2 is 3 or 7, minimum is 3.
 

Example 3:



Input: distance = [1,2,3,4], start = 0, destination = 3
Output: 4
Explanation: Distance between 0 and 3 is 6 or 4, minimum is 4.
 

Constraints:

1 <= n <= 10^4
distance.length == n
0 <= start, destination < n
0 <= distance[i] <= 10^4



对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        //易错,不能假设 start一定小于destination,所以要做一个预处理
        if(start>destination){
            int tmp=start;
            start=destination;
            destination=tmp;
        }

        HashMap<String,Integer> map=new HashMap<>();
        int n=distance.length;
        for(int i=0;i<n;i++){
            if(map.get(i+"->"+((i+1)%n))==null){
                map.put(i+"->"+((i+1)%n),distance[i]);
            }
            if(map.get(((i+1)%n)+"->"+i)==null){
                map.put(((i+1)%n)+"->"+i,distance[i]);
            }
        }

        int frontSum=0;
        for(int i=start;i<destination;i++){
            frontSum+=map.getOrDefault(i+"->"+(i+1),0);
        }

        int backSum=0;
        int dest=destination;
        while(dest%n!=start){
            // 易错,dest%n
            backSum+=map.getOrDefault((dest%n)+"->"+((dest+1)%n),0);
            dest++;
        }
        return Math.min(frontSum,backSum);
    }
}

















