
/*
 * 
https://leetcode.com/problems/reconstruct-itinerary/


332. Reconstruct Itinerary
Medium

1799

966

Add to List

Share
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
One must use all the tickets once and only once.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.

30 June 2020 at 12:00 am


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */












class Solution {
    //11.35pm-
    HashMap<String,String> map=new HashMap<String,String>();
    List<String> startedPoint=new ArrayList<String>();
    List<String> result=new ArrayList<String>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Character[] c=new Character[26];
        for(List<String> list:tickets){
            for(int i=0;i<list.size();i++){
                startedPoint.add(list.get(0));
                map.put(list.get(0),list.get(1));
            }
        }
        
        List<List<String>> loopResult=new ArrayList<List<String>>();
        for(int i=0;i<startedPoint.size();i++){
            List<String> tmpList=new ArrayList<String>();
            HashMap<String,String> copyMap=new HashMap<String,String>(map);
            String curr=startedPoint.get(i);
            tmpList.add(curr);
            while(copyMap.size()>0){
                String savedDest=copyMap.get(curr);
                // System.out.println(curr+" "+savedDest);
                if(savedDest!=null){
                    tmpList.add(savedDest);
                    copyMap.remove(curr);
                    curr=savedDest;
                    if(copyMap.size()==0){
                        loopResult.add(new ArrayList<String>(tmpList));
                    }
                }else{
                    break;
                }
            }
        }
        
        if(loopResult.size()>1){
            List<String> return_list=null;
            int lexicalNum=Integer.MAX_VALUE;
          
           for(List<String> list:loopResult){
              int tmpValue=0;
               for(String tmp:list){
                   for(int i=0;i<tmp.length();i++){
                       tmpValue+=tmp.charAt(i)-'A';
                   }
                   if(tmpValue<lexicalNum){
                       lexicalNum=Math.min(tmpValue,lexicalNum);
                       return_list=list;
                   }
               }
           }
            return return_list;
        }
        // System.out.println(loopResult.size());
        
        return loopResult.get(0);
    }
}











