
/*
 * 
692. Top K Frequent Words
Medium

5285

277

Add to List

Share
Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 

Constraints:

1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]
 

Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?




DATE: 2022-October-14
TIME: 21:25:02

时间: 13分钟


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, List<String>> map=new HashMap<String,List<String>>();
        for(String tmp:words){
            List<String> list=map.getOrDefault(tmp,new ArrayList<String>());
            list.add(tmp);
            map.put(tmp,list);
        }
        PriorityQueue<Map.Entry<String,List<String>>> pq=new PriorityQueue<>((o1,o2)->{
            if(o2.getValue().size()==o1.getValue().size()){
                return o1.getKey().compareTo(o2.getKey());
            }else{
                return o2.getValue().size()-o1.getValue().size();
            }
        });

        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            pq.add(entry);
        }
        List<String> result=new ArrayList<String>();
        int count=0;
        while(count<k&&!pq.isEmpty()){
            Map.Entry<String,List<String>> entry=pq.poll();
                if(count>=k) break;
                result.add(entry.getKey());
                count++;
        }
        return result;
    }
}
Runtime: 12 ms, faster than 54.31% of Java online submissions for Top K Frequent Words.
Memory Usage: 46 MB, less than 6.77% of Java online submissions for Top K Frequent Words.




Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, List<String>> map=new HashMap<String,List<String>>();
        for(String tmp:words){
            List<String> list=map.getOrDefault(tmp,new ArrayList<String>());
            list.add(tmp);
            map.put(tmp,list);
        }

        HashMap<String,Integer> revMap=new HashMap<>();
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            revMap.put(entry.getKey(),entry.getValue().size());
        }

        PriorityQueue<String> pq=new PriorityQueue<>((o1,o2)->{
            if(revMap.get(o2)==revMap.get(o1)){
                return o2.compareTo(o1);
            }else{
                return revMap.get(o1)-revMap.get(o2);
            }
        });
        
        // 注意如果想要保持元素的顺序，必须使用List, Set是不保证顺序的
        // Set并不是无序的传统所说的Set无序指的是HashSet，它不能保证元素的添加顺序，更不能保证自然顺序，而Set的其他实现类是可以实现这两种顺序的。
        List<String> list=new ArrayList();
        for(String tmp:words){
            if(!list.contains(tmp)){
                list.add(tmp);
            }
            
        }
        
        //在这里遍历的时候，必须是去重过的
        for(String tmp:list){
            if(pq.size()<k){
               pq.add(tmp);
            }else{
                if(revMap.get(pq.peek())<revMap.get(tmp)){
                    pq.poll();
                    pq.add(tmp);
                }else if(revMap.get(pq.peek())==revMap.get(tmp)){ // 防止还没有插入进入pq，但是size相等情况下，需要判断字母顺序
                    if(pq.peek().compareTo(tmp)>0){
                        pq.poll();
                        pq.add(tmp);
                    }
                }
            }
        }
        LinkedList<String> result=new LinkedList<String>();
        while(pq.size()>k){
            pq.poll();
        }
        while(!pq.isEmpty()){
                result.addFirst(pq.poll());
        }
 
        return result;
    }
}

Runtime: 10 ms, faster than 73.08% of Java online submissions for Top K Frequent Words.
Memory Usage: 42.7 MB, less than 89.61% of Java online submissions for Top K Frequent Words.













===> 


Runtime: 15 ms, faster than 23.67% of Java online submissions for Top K Frequent Words.
Memory Usage: 45.7 MB, less than 17.87% of Java online submissions for Top K Frequent Words.

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, List<String>> map=new HashMap<String,List<String>>();
        for(String tmp:words){
            List<String> list=map.getOrDefault(tmp,new ArrayList<String>());
            list.add(tmp);
            map.put(tmp,list);
        }

        PriorityQueue<Map.Entry<String,List<String>>> pq=new PriorityQueue<>((o1,o2)->{
            if(o2.getValue().size()==o1.getValue().size()){
                return o2.getKey().compareTo(o1.getKey()); // 自然序
            }else{
                return o1.getValue().size()-o2.getValue().size();
            }
        });
        
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            if(pq.size()<k){
               pq.add(entry);
            }else{
                if(pq.peek().getValue().size()<entry.getValue().size()){
                    pq.poll();
                    pq.add(entry);
                }else if(pq.peek().getValue().size()==entry.getValue().size()){
                    if(pq.peek().getKey().compareTo(entry.getKey())>0){
                        pq.poll();
                        pq.add(entry);
                    }
                }
            }
        }
        LinkedList<String> result=new LinkedList<String>();
        while(pq.size()>k){
            pq.poll();
        }
        while(!pq.isEmpty()){
                result.addFirst(pq.poll().getKey());
        }
 
        return result;
    }
}






class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map=new HashMap<String,Integer>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String,Integer>> pq=new PriorityQueue<>((o1,o2)->{
            if(o2.getValue()==o1.getValue()){
                return o2.getKey().compareTo(o1.getKey()); // 自然序
            }else{
                return o1.getValue()-o2.getValue(); //使用的最小堆（注意，当只进入k个时候，就必须使用规则：求最大值用最小堆，求最小值用最大堆
            }
        });
        
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(pq.size()<k){
               pq.add(entry);
            }else{
                if(pq.peek().getValue()<entry.getValue()){
                    pq.poll();
                    pq.add(entry);
                }else if(pq.peek().getValue()==entry.getValue()){ // 处理没进入到pq时候，size相等，按字母序选择替换自然序靠前的
                    if(pq.peek().getKey().compareTo(entry.getKey())>0){
                        pq.poll();
                        pq.add(entry);
                    }
                }
            }
        }
        LinkedList<String> result=new LinkedList<String>();
        while(pq.size()>k){
            pq.poll();
        }
        while(!pq.isEmpty()){
                result.addFirst(pq.poll().getKey()); //因为使用最小堆，要对顺序进行逆转
        }
 
        return result;
    }
}







// 其他人的code(改进版):

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        //使用最大堆，使用自然序
        PriorityQueue<String> pq = new PriorityQueue<>(
                (o1, o2) -> map.get(o1).equals(map.get(o2)) ? o1.compareTo(o2) : map.get(o2) - map.get(o1));

        for (String word : map.keySet()) {
            pq.offer(word);
        }

        List<String> result = new ArrayList<>();
        for(int i=0;i<k;i++){
            result.add(pq.poll());
        }

        return result;
    }







