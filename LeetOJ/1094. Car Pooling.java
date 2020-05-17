
/*
 * 
https://leetcode.com/problems/car-pooling/


1094. Car Pooling
Medium

438

20

Add to List

Share
You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)

Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.

Return true if and only if it is possible to pick up and drop off all passengers for all the given trips. 

 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
Example 3:

Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true
Example 4:

Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true
 
 

Constraints:

trips.length <= 1000
trips[i].length == 3
1 <= trips[i][0] <= 100
0 <= trips[i][1] < trips[i][2] <= 1000
1 <= capacity <= 100000

17 May 2020 at 2:33 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */






class Solution {
    //2.26pm-2.30pm
    public boolean carPooling(int[][] trips, int capacity) {
        //特殊情况下，直接返回
        if(trips.length == 0 || trips[0].length == 0) {
            return true;
        }
        if(trips.length == 1 && trips[0][0] <= capacity) {
            return true;
        }

        int[] record = new int[1001];
        for(int i = 0; i < trips.length; i++) {
            record[trips[i][1]] += (0 - trips[i][0]);
            record[trips[i][2]] += trips[i][0];
        }
        for(int j = 0; j < 1001; j++) {
            capacity += record[j];
            if(capacity < 0)
                return false;
        }
        return true;
    }
}

// 作者：dan-wei-xiang-liang-2
// 链接：https://leetcode-cn.com/problems/car-pooling/solution/yi-wei-shu-zu-qiu-he-qiu-jie-pin-che-wen-ti-by-dan/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

















