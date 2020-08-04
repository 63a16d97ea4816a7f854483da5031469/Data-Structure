
/*
 * 
link: 
https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/

2020-8-4 at 8:16 am

剑指 Offer 59 - I. 滑动窗口的最大值
难度
简单

80

给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 

提示：

你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




class Solution {
    //8.16am-8.29am
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0||k==0) return new int[]{};
        int max=0;
        if(k>=nums.length){
            for(int i=0;i<nums.length;i++){
                max=Math.max(nums[i],max);
            }
            return new int[]{max};
        }
    int[] ans=new int[nums.length-k+1];
    int count=0;
    for(int i=0;i<nums.length-k+1;i++){
        int tmpMax=Integer.MIN_VALUE; // [1,-1] 1
        // System.out.println(nums[i]);
        for(int r=i;r<k+i;r++){
            tmpMax=Math.max(nums[r],tmpMax);
        }
        ans[count++]=tmpMax;
    }
    return ans;
    }
}


class Solution {
    int maxIndex = -1;
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            result[i] = findMax(nums, i, k);
        }
        return result;
    }
    int findMax(int[] nums, int i, int k) {
        if (maxIndex >= i && maxIndex < i + k && nums[maxIndex] > nums[i + k - 1]) return nums[maxIndex];
        maxIndex = i;
        for (int p = i;p < i + k; p++) {
            if (nums[p] > nums[maxIndex]) maxIndex = p;
        }
        return nums[maxIndex];
    }
}


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        //暴力搜索方法
        // if(nums.length==0||k==0)return new int[]{};
        // int index=0;
        // int[] res=new int[nums.length-k+1];

        // for(int i=0;i<nums.length-k+1;i++){
        //      int temp=nums[i];
        //      for(int j=i+1;j<i+k;j++){
        //          if(temp<nums[j]){
        //              temp=nums[j];
        //          } 
        //      }
        //      res[index++]=temp;
        // }
        // return res;

        //单调双向队列法
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        if(nums==null||nums.length==0) return new int[0];
        LinkedList<Integer> queue=new LinkedList<>();
        int[] res=new int[nums.length-k+1];

        for(int i=0;i<nums.length;i++){
            while(!queue.isEmpty()&&nums[queue.peekLast()]<nums[i]){ //当前数子比队尾元素大，
                //弹出队尾，一直到 队列保持 单调递减
                queue.pollLast();//删除队尾
            }
            queue.offerLast(i);//索引下标放在队尾
            //检查有效性，是否在滑动窗口中:队首元素是否在 l~R的窗口中，R=i,l=R-k;
            if(queue.peekFirst()<=i-k){//队首元素不在窗口中
               queue.pollFirst();//删除队首
            }
            //写入结果：队首即为本次滑动窗口的最大值
            if(i>=k-1){
                res[i-k+1]=nums[queue.peekFirst()];
            }
        }
        return res;




    }
}


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++) { // 未形成窗口
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for(int i = k; i < nums.length; i++) { // 形成窗口后
            if(deque.peekFirst() == nums[i - k])
                deque.removeFirst();//去除重复的
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0 || k == 0)return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res=new int[nums.length-k+1];

        for(int j = 0, i = 1 - k; j < nums.length; i++, j++){
            if(i > 0 && deque.peekFirst() == nums[i - 1]) deque.removeFirst();

            while(!deque.isEmpty() && deque.peekLast() < nums[j])  deque.removeLast(); 
            deque.addLast(nums[j]);

            if(i >= 0)res[i] = deque.peekFirst();
            
        }
        return res;
    }
}











