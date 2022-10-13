
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/

1436. Destination City
Easy

1127

60

Add to List

Share
You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.

 

Example 1:

Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo" 
Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
Example 2:

Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are: 
"D" -> "B" -> "C" -> "A". 
"B" -> "C" -> "A". 
"C" -> "A". 
"A". 
Clearly the destination city is "A".
Example 3:

Input: paths = [["A","Z"]]
Output: "Z"
 

Constraints:

1 <= paths.length <= 100
paths[i].length == 2
1 <= cityAi.length, cityBi.length <= 10
cityAi != cityBi
All strings consist of lowercase and uppercase English letters and the space character.

13 Oct 2022 at 19:28pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,String> outMap=new HashMap<String,String>();
        
        Set<String> allCity=new HashSet<String>();
        for(List<String> tmp: paths){
            String fromCity=tmp.get(0);
            String arrivalCity=tmp.get(1);
            allCity.add(fromCity);
            allCity.add(arrivalCity);
            outMap.put(fromCity,"exists");
        }
        
        for(String tmp:allCity){
            if(outMap.get(tmp)==null){
                return tmp;
            }
        }
        return "NOT_FOUND";
    }
}



















