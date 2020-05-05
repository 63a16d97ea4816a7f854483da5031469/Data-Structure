
/*
 * 
https://leetcode.com/problems/jewels-and-stones/


Jewels and Stones
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.

12 April 2020 at 3.36 pm

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


 * 
 */








class Solution {
    //3.35pm-3.43pm AC
    public int numJewelsInStones(String J, String S) {
        if(J.length()==0) return 0;
        
        char[] typeArr=J.toCharArray();
        int count=0;
        for(int i=0;i<typeArr.length;i++){
            int oriLen=S.length();
            //remove this character
            S=S.replaceAll(typeArr[i]+"","");
            int currLen=S.length();
            count+=oriLen-currLen;
        }
        
        return count;
    }
}



















