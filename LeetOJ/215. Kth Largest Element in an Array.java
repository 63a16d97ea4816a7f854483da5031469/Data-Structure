
/*
 * 
https://leetcode.com/problems/kth-largest-element-in-an-array/

215. Kth Largest Element in an Array
Medium

3150

222

Add to List

Share
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.


5 April 2020 at 5.54pm-6.02pm 尝试使用堆来解决



https://aaronice.gitbook.io/system-design/

https://aaronice.gitbook.io/lintcode/

https://aaronice.gitbook.io/lintcode/problem-solving-summary/java-interview-tips/data-structures-in-java

https://github.com/aaronice/CS-Notes


学习英语的工具：
https://elsaspeak.com/en/

 * 
 */



class Solution {
    //5.54pm-6.02pm 尝试使用堆来解决
    public int findKthLargest(int[] nums, int k) {
       
        PriorityQueue<Integer> que=new PriorityQueue<>(k);
        
        for(int i=0;i<k;i++){
            //将k个压入
            que.add(nums[i]);
        }
        
        for(int i=k;i<nums.length;i++){
            
            if(!que.isEmpty()){
                int top=que.peek();
                if(nums[i]>top){
                    que.poll();
                    que.add(nums[i]);
                }
            }
            
        }
        return que.peek();
    }
}


// // 默认实现了一个最小堆。
// Queue<Integer> priorityQueue = new PriorityQueue<>(); 

// // 实现最大堆
// Queue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
 
//             @Override
//             public int compare(ListNode o1, ListNode o2) {
//                 return o1.val-o2.val;
//             }
 
//         });
// ————————————————
// 版权声明：本文为CSDN博主「早起的鸟儿有虫吃h」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/u013383813/article/details/82926786







class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int indexOfKthLargest = nums.length - k;
        while (left <= right) {
            int pivot = partition(nums, left, right);
            if (pivot == indexOfKthLargest) {
                return nums[pivot];
            } else if (pivot > indexOfKthLargest) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return 0;
    }
    
    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        int j = start;
        while (j < end) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
                j++;
            } else {
                j++;
            }
        }
        swap(nums, i, end);
        
        return i;
    }
    
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}







class Solution {
    public:
        int findKthLargest(vector<int>& nums, int k) {
            int left = 0, right = nums.size() - 1;
            while (true) {
                int pos = partition(nums, left, right);
                if (pos == k - 1) return nums[pos];
                if (pos > k - 1) right = pos - 1;
                else left = pos + 1;
            }
        }
        int partition(vector<int>& nums, int left, int right) {
            int pivot = nums[left], l = left + 1, r = right;
            while (l <= r) {
                if (nums[l] < pivot && nums[r] > pivot) {
                    swap(nums[l++], nums[r--]);
                }
                if (nums[l] >= pivot) ++l;
                if (nums[r] <= pivot) --r;
            }
            swap(nums[left], nums[r]);
            return r;
        }
    };




