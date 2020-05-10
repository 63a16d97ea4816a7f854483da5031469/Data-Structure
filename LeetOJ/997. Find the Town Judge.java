
/*
 * 
https://leetcode.com/problems/find-the-town-judge/


997. Find the Town Judge
Easy

569

62

Add to List

Share
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 

Note:

1 <= N <= 1000
trust.length <= 10000
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N

10 May 2020 at 5.57 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



// 速度最快解法:
class Solution {
    public int findJudge(int N, int[][] trust) {
         if(trust.length<  N-1){
            return -1;
        }
        
        int [] inEdges = new int[N+1];
        int [] outEdges =new int[N+1];
        for(int[] relation :trust){
            outEdges[relation[0]]++;
            inEdges[relation[1]]++;
        }
        for (int i = 1; i <= N; i++) {
        if (inEdges[i] == N - 1 && outEdges[i] == 0) {
            return i;
        }
    }
        return -1;
       
    }
}



class Solution {
    public int findJudge(int N, int[][] trust) 
	{
    	int[] count = new int[N];
        int[] trusted = new int[N]; 
        
        for(int i = 0; i < trust.length; i++)
        {
            int a = trust[i][0]; 
            int b = trust[i][1];
            count[a - 1]++;
            trusted[b - 1]++;
        }
        
        for(int i = 0; i < N; i++)
        {
            if(count[i] == 0 && trusted[i] == N - 1)
            {
                return i + 1;
            }    
        }
        return -1;
	}
}


class Solution {
    //5.45pm-5.57pm AC
    public int findJudge(int N, int[][] trust) {
        if(trust.length==0) return N;  // 1 []
        HashMap<Integer, HashSet<Integer>> map=new HashMap<Integer, HashSet<Integer>>();
        for(int i=0;i<trust.length;i++){
            int from=trust[i][0];
            int to=trust[i][1];
            HashSet<Integer> set=map.getOrDefault(to,new HashSet<Integer>());
            set.add(from);
            map.put(to,set);
        }
        for(Map.Entry<Integer,HashSet<Integer>> entry:map.entrySet()){
           HashSet set=entry.getValue();
           if(set.size()==N-1){
               int possibleInt=entry.getKey();
               boolean isFindInOtherList=false;
               for(Map.Entry<Integer,HashSet<Integer>> secEntry:map.entrySet()){
                   if(secEntry.getValue().contains(possibleInt)){
                       isFindInOtherList=true;
                       break;
                   }
               }
               if(!isFindInOtherList){
                   return entry.getKey();
               }
           }
        }
        return -1;
    }
}
















