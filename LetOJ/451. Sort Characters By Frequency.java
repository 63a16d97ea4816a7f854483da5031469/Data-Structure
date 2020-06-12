
/*
 * 
https://leetcode.com/problems/sort-characters-by-frequency/


451. Sort Characters By Frequency
Medium

1429

117

Add to List

Share
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

23 May 2020 at 5:48 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b)->b.getValue()-a.getValue());
        queue.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry entry = queue.poll();
            for (int i = 0; i < (int)entry.getValue(); i++) sb.append(entry.getKey());
        }
        
        return sb.toString();
    }
}



// Bucket Sort

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        
        List<Character>[] buckets = new ArrayList[s.length()+1];
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            int i = entry.getValue();
            if (buckets[i] == null) buckets[i] = new ArrayList<>();
            buckets[i].add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i >= 0; i--) {
            if (buckets[i] != null && buckets[i].size() > 0) {
                for (Character ch: buckets[i]) {
                    for (int j = i; j > 0; j--) sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}













class Solution {
    public String frequencySort(String s) {
            char[] arr = s.toCharArray();

            // bucket sort
            int[] count = new int[256];
            for(char c : arr) count[c]++;

            // count values and their corresponding letters
            Map<Integer, List<Character>> map = new HashMap<>();
            for(int i = 0; i < 256; i++){
                if(count[i] == 0) continue;
                int cnt = count[i];
                if(!map.containsKey(cnt)){
                    map.put(cnt, new ArrayList<Character>());
                }
                map.get(cnt).add((char)i);
            }

            // loop throught possible count values
            StringBuilder sb = new StringBuilder();
            for(int cnt = arr.length; cnt > 0; cnt--){ 
                if(!map.containsKey(cnt)) continue;
                List<Character> list = map.get(cnt);
                for(Character c: list){
                    for(int i = 0; i < cnt; i++){
                        sb.append(c);
                    }
                }
            }
            return sb.toString();
        }
}