
/*
 * 
https://leetcode.com/problems/k-closest-points-to-origin/

973. K Closest Points to Origin
Medium

1517

107

Add to List

Share
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 

Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000

30 May 2020 at 11:58 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */






class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // max heap by distance 
        PriorityQueue<int[]> pq = new PriorityQueue<>(k+1, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return  (b[0]*b[0]+b[1]*b[1])-(a[0]*a[0] + a[1]*a[1]);
            }    
        });
        for(int[] point: points) {
            pq.add(point);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int[][] list = new int[pq.size()][2];
        int i = 0;
        while(pq.size() > 0) {
            list[i++] = pq.poll();
        }
        return list;
    }
}




// 最快解法  

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0) {
            return points;
        }
        
        int n = points.length;
        quickSelect(points, K - 1, 0, n - 1);
        
        int[][] results = new int[K][2];
        for (int i = 0; i < K; i++) {
            results[i] = points[i];
        }
        return results;
    }
    
    private void quickSelect(int[][] points, int K, int start, int end) {
        int left = start, right = end;
        int pivot = distance(points[left + (right - left) / 2]);
        while (left <= right) {
            while (left <= right && distance(points[left]) < pivot) {
                left++;
            }
            while (left <= right && distance(points[right]) > pivot) {
                right--;
            }
            if (left <= right) {
                int[] temp = points[left];
                points[left] = points[right];
                points[right] = temp;
                left++;
                right--;
            }
        }
        if (K >= left) {
            quickSelect(points, K, left, end);
        } else if (K <= right) {
            quickSelect(points, K, start, right);
        }
    }
    
    private int distance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}










