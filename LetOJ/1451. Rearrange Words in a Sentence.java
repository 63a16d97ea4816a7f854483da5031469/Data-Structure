
/*
 * 
https://leetcode.com/problems/rearrange-words-in-a-sentence/

Given a sentence text (A sentence is a string of space-separated words) in the following format:

First letter is in upper case.
Each word in text are separated by a single space.
Your task is to rearrange the words in text such that all words are rearranged in an increasing order of their lengths. If two words have the same length, arrange them in their original order.

Return the new text following the format shown above.

 

Example 1:

Input: text = "Leetcode is cool"
Output: "Is cool leetcode"
Explanation: There are 3 words, "Leetcode" of length 8, "is" of length 2 and "cool" of length 4.
Output is ordered by length and the new first word starts with capital letter.
Example 2:

Input: text = "Keep calm and code on"
Output: "On and keep calm code"
Explanation: Output is ordered as follows:
"On" 2 letters.
"and" 3 letters.
"keep" 4 letters in case of tie order by position in original text.
"calm" 4 letters.
"code" 4 letters.
Example 3:

Input: text = "To be or not to be"
Output: "To be or to be not"
 

Constraints:

text begins with a capital letter and then contains lowercase letters and single space between words.
1 <= text.length <= 10^5

DATE: 2022-October-13
TIME: 20:39:10



对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


错误解：

这个没法过：

Input: text = "To be or not to be"
Output: "To be or to be not"

class Solution {
    public String arrangeWords(String text) {
        PriorityQueue<String> pq=new PriorityQueue<>((o1,o2)->{
            if(o1.length()==o2.length()){
                return -1;
            }else{
                return o1.length()-o2.length();
            }
        });
        
        String[] arr=text.split(" ");
        for(String tmp:arr){
            pq.add(tmp);
        }
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            if(sb.toString().length()==0){
                String tmp=pq.poll();
                String first=tmp.substring(0,1).toUpperCase();
                String last="";
                if(tmp.length()>1){
                   last=tmp.substring(1);
                }
                
                sb.append(first+last);  
            }else{
                sb.append(pq.poll().toLowerCase());  
            }
          
          if(!pq.isEmpty()){
              sb.append(" ");
          }
        }
        return sb.toString();
     }
}




桶排序：

22分钟26秒

空间复杂度: O(n)
时间复杂度： O(n)
class Solution {
    public String arrangeWords(String text) {
        String[] arr=text.split(" ");
        int max=0;
        //find the max bucket number
        for(String tmp:arr){
            max=Math.max(tmp.length(),max);
        }
        List<String>[] b=new ArrayList[max+1];
        
        for(int i=0;i<=max;i++){
            b[i]=new ArrayList<String>();
        }
        
        for(String tmp:arr){
            List<String> list=b[tmp.length()];
            list.add(tmp);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=max;i++){
            List<String> list=b[i];
            if(list==null||list.size()==0) continue;
            for(int j=0;j<=list.size()-1;j++){
                String tmp=list.get(j);
                if(sb.toString().length()==0){
                    String front=tmp.substring(0,1).toUpperCase();
                    String last="";
                    if(tmp.length()>1){
                        last=tmp.substring(1);
                    }
                    sb.append(front+last.toLowerCase());
                }else{
                    sb.append(list.get(j).toLowerCase());
                }
                sb.append(" ");
            }
        }
        String result=sb.toString();
        if(result.length()>1){
            result=result.substring(0,result.length()-1);
        }
        return result;  
     }
}





import java.util.StringJoiner;
class Solution {
    public String arrangeWords(String text) {
        text = (char) (text.charAt(0) - 'A' + 'a') + text.substring(1);
        String[] words = text.split(" ");
        Map<Integer, List<String>> map = new HashMap<>();
        Set<Integer> lens = new HashSet<>();
        for (String w : words) {
            int len = w.length();
            if (lens.add(len)) {
                map.computeIfAbsent(len, key -> {
                    List<String> list = new ArrayList<>();
                    list.add(w);
                    return list;
                });
            } else {
                map.computeIfPresent(len, (a, b) ->
                {
                    b.add(w);
                    return b;
                });
            }
        }
        List<Integer> lenList = new ArrayList<>(lens);
        Collections.sort(lenList);
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < lenList.size(); i++) {
            List<String> list = map.get(lenList.get(i));
            for (String word : list) {
                sj.add(word);
            }
        }
        String ans = sj.toString();
        return (char) (ans.charAt(0) - 'a' + 'A') + ans.substring(1);
    }
}

作者：瓦片
链接：https://leetcode.cn/problems/rearrange-words-in-a-sentence/solutions/1888331/java-1451-zhong-xin-pai-lie-ju-zi-zhong-1jp28/










