
/*
 * 
link: 
https://leetcode-cn.com/problems/top-k-frequent-elements/

2020-8-26 at 10:39 pm
2022-02-02 a 18:19

347. 前 K 个高频元素
难度
中等

442

给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
 

提示：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




//基于桶排序求解「前 K 个高频元素」
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
               map.put(num, map.get(num) + 1);
             } else {
                map.put(num, 1);
             }
        }
        
        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] listArr = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(listArr[i] == null){
               listArr[i] = new ArrayList();
            } 
            listArr[i].add(key);
        }
        
        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i = listArr.length - 1;i >= 0 && res.size() < k;i--){
            if(listArr[i] == null) continue;
            res.addAll(listArr[i]);
        }
        int[] ans=new int[res.size()];
        for(int i=0;i<k;i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}
//T(O(n))
//S(O(n))

// 作者：MisterBooo
// 链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/leetcode-di-347-hao-wen-ti-qian-k-ge-gao-pin-yuan-/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer>[] res = new List[nums.length+1];
        for(int key : map.keySet()){
            int i = map.get(key);
            if(res[i] == null){
               res[i] = new ArrayList();
            } 
            res[i].add(key);
        }
        int[] ans=new int[k];
        int index=0;
        for(int i=nums.length;i>=0;i--){
            if(res[i]!=null){
                for(int a:res[i]){
                    if(index<k){
                      ans[index]=a;
                      index++;
                    }
                }
               
            }
        }
        return ans;

    }
}
//T O(N);
//S O(N);

//自己写了一遍：
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int tmp:nums){
            map.put(tmp,map.getOrDefault(tmp,0)+1);
        }
        List<Integer>[] listArr=new List[nums.length+1];
        for(int key:map.keySet()){
            int i=map.get(key);
            if(listArr[i]==null){
                listArr[i]=new ArrayList<Integer>();
            }
            listArr[i].add(key);
        }
        int[] ans=new int[k];
        int idx=0;
        for(int i=listArr.length-1;i>=0 && idx<k;i--){
            if(listArr[i]!=null){
                for(int j=0;j<listArr[i].size() && idx<k;j++){
                    ans[idx++]=listArr[i].get(j);
                }
            }
        }
        return ans;
    }
}


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int curFreq = map.getOrDefault(num, 0);
            map.put(num, curFreq + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] == null) {
                continue;
            }
            if (bucket[i].size() <= k - result.size()) {
                result.addAll(bucket[i]);
            } else {
                result.addAll(bucket[i].subList(0, k - result.size()));
            }
        }
        int[] array = new int[k];
        for (int i = 0; i < k; i++) {
            array[i] = result.get(i);
        }
        return array;
    }
}
//T O(N);
//S O(N);



class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((x, y) -> (map.get(y) - map.get(x)));
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i:map.keySet()) {
            q.add(i);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }
        return res;
    }
}
//T (O(nlogN))
//S (O(n))




class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
               map.put(num, map.get(num) + 1);
             } else {
                map.put(num, 1);
             }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }
}
//T (O(nlogK))
//S (O(n))

// 作者：MisterBooo
// 链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/leetcode-di-347-hao-wen-ti-qian-k-ge-gao-pin-yuan-/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





// ===> 自己写的:

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(k,(o1,o2)->{
            return o1.getValue()-o2.getValue();
        });
        //构造频率map
        for(int tmp:nums){
           map.put(tmp,map.getOrDefault(tmp,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(pq.size()<k){
                pq.add(entry);
            }else{
                if(pq.peek().getValue()<entry.getValue()){
                    pq.poll();
                    pq.add(entry);
                }
            }
        }
        int[] result=new int[pq.size()];
        int index=0;
        while(!pq.isEmpty()){
            result[index++]=pq.poll().getKey();
        }

        return result;
    }
}




//基于桶排序求解「前 K 个高频元素」
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
               map.put(num, map.get(num) + 1);
             } else {
                map.put(num, 1);
             }
        }
        
        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
               list[i] = new ArrayList();
            } 
            list[i].add(key);
        }
        
        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
            if(list[i] == null) continue;
            res.addAll(list[i]);
        }
        return res;
    }
}



// 作者：cxywushixiong
// 链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/leetcode-di-347-hao-wen-ti-qian-k-ge-gao-pin-yuan-/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。














import java.util.Map.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        List<java.util.Map.Entry<Integer,Integer>> list=new ArrayList<>();
        for(Entry<Integer,Integer> entry:map.entrySet()){
            list.add(entry);
        }
        Collections.sort(list,(o1, o2)->{
            return o2.getValue()-o1.getValue();
        });
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=list.get(i).getKey();
        }
        return result;
    }
}



class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<java.util.Map.Entry<Integer,Integer>> queue=new PriorityQueue<>((o1,o2)->{
            return o2.getValue()-o1.getValue();
        });

        for(java.util.Map.Entry entry:map.entrySet()){
            queue.add(entry);
        }
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=queue.poll().getKey();
        }
       
        return result;
    }
}



class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        // 桶排序
        List<List<Integer>> bucket=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            bucket.add(new ArrayList<Integer>());
        }

        for(java.util.Map.Entry<Integer,Integer> entry:map.entrySet()){
            // ArrayList是从0开始的，所以要减一
            List<Integer> saved=bucket.get(entry.getValue()-1); 
            if(!saved.contains(entry.getKey())){
                saved.add(entry.getKey());
            }
        }

        int[] result=new int[k];
        int index=0;
        for(int i=nums.length-1;i>=0&&index<k;i--){  
            List<Integer> saved=bucket.get(i);
                for(int o:saved){
                    result[index++]=o;
                }
        }
       
        return result;
    }
}
