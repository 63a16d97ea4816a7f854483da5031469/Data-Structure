
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


K-th Symbol in Grammar
Solution
On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).

Examples:
Input: N = 1, K = 1
Output: 0

Input: N = 2, K = 1
Output: 0

Input: N = 2, K = 2
Output: 1

Input: N = 4, K = 5
Output: 1

Explanation:
row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001
Note:

N will be an integer in the range [1, 30].
K will be an integer in the range [1, 2^(N-1)].


11 April 2020 at 6.06 pm
 * 
 */














超时:

Submission Result: Memory Limit Exceeded More Details 
Last executed input:
30
434991989



class Solution {
    //5.51pm-6.06pm
        String s="0";
    public int kthGrammar(int N, int K) {
     
        if(N==1 && K==1)  return 0;
        
        for(int i=1;i<=N;i++){
            StringBuilder sb=new StringBuilder();
            for(char c:s.toCharArray()){
                if(c=='0'){
                    sb.append("01");
                }else if(c=='1'){
                    sb.append("10");
                }else{
                    sb.append(c+"");
                }
            }
            s=sb.toString();
        }
        
       return  Integer.valueOf(s.charAt(K-1)+"");
       
    }
 
    
}



















