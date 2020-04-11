
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







package leetcode;
 
public class K_th_Symbol_in_Grammar_779 {
 
	public int kthGrammar(int N, int K) {
		if(K==1){
			return 0;
		}
		if(K==2){
			return 1;
		}
		if(K%2==1){
			return kthGrammar(-1, (K+1)/2);
		}
		else{
			return 1-kthGrammar(-1, K/2);
		}
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		K_th_Symbol_in_Grammar_779 k=new K_th_Symbol_in_Grammar_779();
		System.out.println(k.kthGrammar(30, 434991989));	
	}
 

————————————————
版权声明：本文为CSDN博主「huanghanqian」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/huanghanqian/article/details/79254001





采用hashmap来加速，仍然不行：

class Solution {
    //5.51pm-6.06pm
    //6.09pm-6.20pm
    
        String s="0";
    HashMap<String, String> map=new HashMap<String,String>();
//     public int kthGrammar(int N, int K) {
     
//         if(N==1 && K==1)  return 0;
        
//         for(int i=1;i<=N;i++){
//             StringBuilder sb=new StringBuilder();
//             for(char c:s.toCharArray()){
//                 if(c=='0'){
//                     sb.append("01");
//                 }else if(c=='1'){
//                     sb.append("10");
//                 }else{
//                     sb.append(c+"");
//                 }
//             }
//             s=sb.toString();
//         }
        
//        return  Integer.valueOf(s.charAt(K-1)+"");
       
//     }
    
       public int kthGrammar(int N, int K) {
           
           for(int i=1;i<=N;i++){
              s= getNextStr(s);
           }
           
          return  Integer.valueOf(s.charAt(K-1)+"");

       }
    
    String getNextStr(String s){
        
        char c=s.charAt(0);
        
        if(s.length()==1){
            if(c=='0') return "01";
            else if(c=='1') return "10";
            else return c+"";
        }
    
        if(c=='0'){
            
            if(map.get(s.substring(1))==null){
                return "01"+getNextStr(s.substring(1)); 
            }else{
                return "01"+map.get(s.substring(1));
            }
            
            
        }else if(c=='1'){
            if(map.get(s.substring(1))==null){
                return "10"+getNextStr(s.substring(1)); 
            }else{
                return "10"+map.get(s.substring(1));
            }
        }else{
            if(map.get(s.substring(1))==null){
                return ""+getNextStr(s.substring(1)); 
            }else{
                return ""+map.get(s.substring(1));
            }
        }
    }
 
    
}



超时：

Submission Result: Time Limit Exceeded More Details 
Last executed input:
30
434991989

class Solution {
    //5.51pm-6.06pm
    //6.09pm-6.20pm
    
        String s="0";
//     public int kthGrammar(int N, int K) {
     
//         if(N==1 && K==1)  return 0;
        
//         for(int i=1;i<=N;i++){
//             StringBuilder sb=new StringBuilder();
//             for(char c:s.toCharArray()){
//                 if(c=='0'){
//                     sb.append("01");
//                 }else if(c=='1'){
//                     sb.append("10");
//                 }else{
//                     sb.append(c+"");
//                 }
//             }
//             s=sb.toString();
//         }
        
//        return  Integer.valueOf(s.charAt(K-1)+"");
       
//     }
    
       public int kthGrammar(int N, int K) {
           
           for(int i=1;i<=N;i++){
              s= getNextStr(s);
           }
           
          return  Integer.valueOf(s.charAt(K-1)+"");

       }
    
    String getNextStr(String s){
        
        char c=s.charAt(0);
        
        if(s.length()==1){
            if(c=='0') return "01";
            else if(c=='1') return "10";
            else return c+"";
        }
    
        if(c=='0'){
            return "01"+getNextStr(s.substring(1));
        }else if(c=='1'){
            return "10"+getNextStr(s.substring(1));
        }else{
             return c+getNextStr(s.substring(1));
        }
    }
 
    
}



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



















