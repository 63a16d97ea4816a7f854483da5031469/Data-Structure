
/*
 * 
https://leetcode.com/problems/group-anagrams/description/

49. Group Anagrams
Medium

3024

166

Add to List

Share
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.

9 April 2020 at 9.40am
 * 
 */



class Solution {
    //9.44am-9.52am AC
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<String,List<String>>();
        
        for(int i=0;i<strs.length;i++){
            String tmp=strs[i];
            
          String fixed_str=getSortedStr(tmp);
            
            if(map.get(fixed_str)==null){
                List<String> list=new ArrayList<String>();
                list.add(tmp);
                map.put(fixed_str, list);
            }else{
                List<String> list=map.get(fixed_str);
                list.add(tmp);
                map.put(fixed_str,list);
            }
        } 
        
        List<List<String>> result=new ArrayList<List<String>>();
        
        for(Map.Entry<String, List<String>> tmp:map.entrySet()){
            result.add(tmp.getValue());
        }
        
      return result;
    } 
        
        String getSortedStr(String s){
            char[] sc=s.toCharArray();
            Arrays.sort(sc);
            StringBuilder sb=new StringBuilder();
            for(char c:sc){
                sb.append(c+"");
            }
            return sb.toString();
        }
        
}




















