
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


// 最快方法：
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        int len = points.length;
        int left = 0;
        int right = len - 1;
        
        while(left <= right){
            int partitionIndex = partition(points,left,right);
            if(partitionIndex == K){
                break;
            }
            if(partitionIndex < K){
                left = partitionIndex + 1;
            }else{
                right = partitionIndex - 1;
            }
        }
        
        return Arrays.copyOfRange(points,0,K);
    }
    
    public int partition(int[][] points,int left,int right){
        int[] pivot = points[left];
        
        while(left < right){            
            while(left < right && compare(points[right],pivot) <= 0) right--;
            points[left] = points[right];
            while(left < right && compare(points[left],pivot) >= 0) left++;
            points[right] = points[left];
        }
        points[left] = pivot;
        
        return left;
    }
    
    public int compare(int[] point1,int[] point2){
        return (point2[1] * point2[1] + point2[0] * point2[0]) - point1[1] * point1[1] - point1[0] * point1[0];
    }
}




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



/*
1.create  a priority queue whcih store ED 
2.remove all ele till size of heap is k using heap.poll()
3.convert heap of size k to array 
4.return array 

*/




class Solution {
    public int[][] kClosest(int[][] points, int K) {
   
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1]);
     
    /*
    concider given points here and it will be added in PQ as below 
    
    first b=[1,3] compared with a=[0,0] so sqrt(10)-sqrt(0) will return +ve so [1,3] will take 1st pos
    sec   b=[-2,2] compared with a=[1,3] so sqrt(8)-sqrt(10) will return -ve so [-2,2] take 1st pos
    and [1,3] moved to second pos means in front 
    
    as k value is 1 and heap has 2 ele so heap.poll remove [1,3] and keep [-2,2]
   
   
   */
   
       for(int[] point : points) {
           heap.add(point);
           if(heap.size() > K)
               heap.poll();
       }
   
       return heap.toArray(new int[0][0]);
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









// Quick Select:


public class Solution {
    public int findKthSmallest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        int len = nums.length;
        
        return quickSelect(nums, k, 0, len - 1);
    }
    
    private int quickSelect(int[] nums, int k, int start, int end) {
        
        //Choose a pivot randomly
        Random rand = new Random();
        int index = rand.nextInt(end - start + 1) + start;
        int pivot = nums[index];
        swap(nums, index, end);
        
        int left = start, right = end;
        
        while(left < right) {
            if (nums[left++] >= pivot) {
                swap(nums, --left, --right);
            }
        }
        //left is now pointing to the first number that is greater than or equal to the pivot
        swap(nums, left, end);
        
        //m is the number of numbers that is smaller than pivot
        int m = left - start;
        
        if (m == k - 1) { //in order to find the kth smallest number, there must be k - 1 number smaller than it 
            return pivot;
        }
        else if (k <= m) { //target is in the left subarray
            return quickSelect(nums, k, start, left - 1);
        }
        else { 
            //target is in the right subarray, but need to update k 
            //Since we have discarded m numbers smaller than it which is in the right subarray
            return quickSelect(nums, k - m, left, end);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}