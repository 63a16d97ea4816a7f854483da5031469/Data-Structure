
/*
 * 
https://leetcode.com/problems/top-k-frequent-elements/


347. Top K Frequent Elements
Medium

2591

185

Add to List

Share
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





class Solution {
    //一个思路是：使用优先级队列，做一个独特的数据结构，然后排序进去，最大堆
    //
    public List<Integer> topKFrequent(int[] nums, int k) {
        
    }
}


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         int n = nums.length;
        HashMap<Integer, Integer> h = new HashMap();
          
        for(int p=0;p<nums.length;p++){
              int i=nums[p];
              if (h.containsKey(i))
                h.put(i, h.get(i) + 1);
            else
                h.put(i, 1);
        }
          

        List<Integer>[] fc = new ArrayList[n + 1];
        for (int i : h.keySet()) {
            int f = h.get(i);       //System.out.println(f + " times of " + i);
            if (fc[f] == null) fc[f] = new ArrayList();
            fc[f].add(i);
        }

        List<Integer> ans = new ArrayList();
        for (int i = n, j = 0; k > 0; k--) {
            for (; fc[i] == null || j == fc[i].size(); j = 0, i--);
            ans.add(fc[i].get(j++));
        }
        
        int[] returnArr=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            returnArr[i]=ans.get(i);
        }

        return returnArr;
    }
}



class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            } else if (entry.getValue() > pq.peek().getValue()) {
                pq.poll();
                pq.offer(entry);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : pq) {
            result.add(entry.getKey());
        }
        
        int[] arr=new int[result.size()];
        for(int i=0;i<result.size();i++){
            arr[i]=result.get(i);
        }

        return arr;
    }
}
// ————————————————
// 版权声明：本文为CSDN博主「liuchongee」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/liuchonge/article/details/60583712
}






















