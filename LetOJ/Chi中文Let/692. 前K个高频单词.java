
/*
 * 
link: 

692. 前K个高频单词

2022-02-02 at 19:04

692. 前K个高频单词
难度
中等

425

收藏

分享
切换为英文
接收动态
反馈
给一非空的单词列表，返回前 k 个出现次数最多的单词。

返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。

示例 1：

输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
输出: ["i", "love"]
解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。
 

示例 2：

输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
输出: ["the", "is", "sunny", "day"]
解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
    出现次数依次为 4, 3, 2 和 1 次。
 

注意：

假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
输入的单词均由小写字母组成。
 

扩展练习：

尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。


刚看到想到的思路是什么？：

使用堆排序

意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:

这个要求返回的集合是有序的，这个跟Top K之前的那个问题有一定区别，而且这个是二维度的


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


执行用时：
8 ms
, 在所有 Java 提交中击败了
13.46%
的用户:


class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map=new HashMap<String, Integer>();
        PriorityQueue<Map.Entry<String,Integer>> pq=new PriorityQueue<>(k,(o1,o2)->{
            if(o1.getValue()!=o2.getValue()){
                return o1.getValue()-o2.getValue();
            }else{
                return o2.getKey().compareTo(o1.getKey());
            }
        });

        for(String tmp:words){
            map.put(tmp,map.getOrDefault(tmp,0)+1);
        }
        List<String> keyList=new ArrayList<>();

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            keyList.add(entry.getKey());
        }
        Collections.sort(keyList, (o1,o2)->{
            return o1.compareTo(o2);
        });
        
        for(String tmp:keyList){
            Integer value=map.get(tmp);
            if(pq.size()<k){
                pq.add(new java.util.AbstractMap.SimpleEntry<String,Integer>(tmp,value));
            }else{
                if(pq.peek().getValue()<value){
                    pq.poll();
                    pq.add(new java.util.AbstractMap.SimpleEntry<String,Integer>(tmp,value));
                }
            }
        }

        List<String> result=new ArrayList<String>();
        Map.Entry<String, Integer> last=pq.peek();
        while(pq.size()>0){
            result.add(pq.poll().getKey());
        }
        // 因为是最小的在上面，因此要进行倒序，并且值不相等
        Collections.reverse(result);

        return result;
    }
}



["i","love","leetcode","i","love","coding"]
2



["the","day","is","sunny","the","the","the","sunny","is","is"]
4



["i","love","leetcode","i","love","coding"]
3




class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> rec = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        Collections.sort(rec, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
        return rec.subList(0, k);
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/top-k-frequent-words/solution/qian-kge-gao-pin-dan-ci-by-leetcode-solu-3qk0/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。







class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        // PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
        //     public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
        //         return entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
        //     }
        // });
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>((o1,o2)->{
                return o1.getValue() == o2.getValue() ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();
        });

        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> ret = new ArrayList<String>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/top-k-frequent-words/solution/qian-kge-gao-pin-dan-ci-by-leetcode-solu-3qk0/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




// 借助TreeMap:

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
    HashMap<String, Integer> map = new HashMap<>();
    TreeMap<java.util.Map.Entry<String, Integer>, String> treemap =
        new TreeMap<>(
            (o1, o2) -> {
              if (o1.getValue() == o2.getValue()) {
                return o1.getKey().compareTo(o2.getKey());
              } else {
                return o2.getValue() - o1.getValue();
              }
            });
    for (String tmp : words) {
      map.put(tmp, map.getOrDefault(tmp, 0) + 1);
    }
    for (java.util.Map.Entry<String, Integer> tmp : map.entrySet()) {
      treemap.put(tmp, "");
    }

    List<String> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      result.add(treemap.pollFirstEntry().getKey().getKey());
    }
    return result;
  }
}




