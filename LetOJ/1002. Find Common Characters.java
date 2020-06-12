
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


Easy

639

80

Add to List

Share
Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.

 

Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]
 

Note:

1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] is a lowercase letter


public class Solution {
    public List<String> commonChars(String[] A) {
        
    }
}

20 March 2020 at 8:33:31 pm
 * 
 */



class Solution {
    //11.35pm    end: 11:42pm
    public List<String> commonChars(String[] A) {
        int[][] arr=new int[A.length][26];
        
        for(int i=0;i<A.length;i++){
            for(char tmp:A[i].toCharArray()){
                arr[i][tmp-'a']++;
            }
        }
        
        List<String> list=new ArrayList<String>();
        
        for(int i=0;i<26;i++){
            int tmp_min=Integer.MAX_VALUE;
            for(int row=0;row<A.length;row++){
                  tmp_min=tmp_min>arr[row][i]?arr[row][i]:tmp_min;
            }
            
            for(int k=0;k<tmp_min;k++){
                list.add(((char)(i+'a'))+"");
            }
        }
        
        return list;
    }
}

















