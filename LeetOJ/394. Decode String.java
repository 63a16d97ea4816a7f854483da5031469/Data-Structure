
/*
 * 
https://leetcode.com/problems/decode-string/

394. Decode String
Medium

2606

131

Add to List

Share
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

12 April 2020 at 11.52 am
 * 
 */



class Solution {
    //11.23pm- 11.52pm
    //3.02pm-
    public String decodeString(String s) {
        char[] c=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        
        Stack<Integer> stackNum=new Stack<Integer>();
        Stack<String>  stackStr=new Stack<String>();
        
        int idx=0;
        int currNum=0;
        String currRes="";
        
        while(idx<s.length()){
            
            char tmpchar=c[idx];
            
            if(Character.isDigit(tmpchar)){
                while(Character.isDigit(s.charAt(idx))){
                     currNum=(s.charAt(idx++)-'0')+10*currNum;
                }
            }else if(tmpchar=='['){
                
                stackNum.push(currNum);
                currNum=0;
                
                stackStr.push(currRes);
                currRes="";
                
                idx++;
                
            }else if(tmpchar==']'){
                
//                 int n=stackNum.pop();
//                 String tmpStr=stackStr.pop();
//                 System.out.println(tmpStr+" "+n);
//                 for(int i=0;i<n;i++){
//                     currRes+=tmpStr;
//                 }
//                 idx++;
                StringBuilder temp = 
				new StringBuilder(stackStr.pop());
			
                int repeatTimes = stackNum.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currRes);
                }
                currRes = temp.toString();
                idx++;
         
                
            }else{
                currRes+=c[idx++]; 
            }
        }
        return currRes;
    }
}


错误的实现：

class Solution {
    //11.23pm- 11.52pm
    //3.02pm-
    public String decodeString(String s) {
        char[] c=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        
        Stack<Integer> stackNum=new Stack<Integer>();
        Stack<String>  stackStr=new Stack<String>();
        
        int idx=0;
        int currNum=0;
        String currRes="";
        
        while(idx<s.length()){
            
            char tmpchar=c[idx];
            
            if(Character.isDigit(tmpchar)){
                while(Character.isDigit(s.charAt(idx))){
                     currNum=(s.charAt(idx++)-'0')+10*currNum;
                }
            }else if(tmpchar=='['){
                
                stackNum.push(currNum);
                currNum=0;
                
                stackStr.push(currRes);
                currRes="";
                
                idx++;
                
            }else if(tmpchar==']'){
                
                int n=stackNum.pop();
                String tmpStr=stackStr.pop();
                System.out.println(tmpStr+" "+n);
                for(int i=0;i<n;i++){
                    currRes+=tmpStr;
                }
                idx++;
                
            }else{
                currRes+=c[idx++];
        
            }
        }
        return currRes;
    }
}




Wrong Answer
Details 
Input
"3[a2[c]]"
stdout
2 c 6
3 a2[c 6

Output
"a2[ca2[ca2[ccc"
Expected
"accaccacc"

class Solution {
    //11.23pm- 11.52pm
    public String decodeString(String s) {
        
        char[] c=s.toCharArray();
        
        StringBuilder sb=new StringBuilder();
        
        int lastRight=c.length-1;
        
        for(int i=c.length-1;i>=0;i--){
            if(c[i]==']') {
                 lastRight=i;
                 continue;
            }else  if(c[i]=='['){
                int t=i-1;
                if(t<0) continue;
                while( t>=0 && '0'<=c[t] && c[t]<='9'){
                    t--;
                }
                //Get the number
                String num="";
                for(int k=t+1;k<i;k++){
                    num+=c[k];
                }
                int n=Integer.parseInt(num);
      
                String tmp=s.substring(i+1,lastRight);
                System.out.println(n+" "+tmp+" "+lastRight);
                for(int j=1;j<=n;j++){
                       for(int g=tmp.length()-1;g>=0;g--){
                          sb.append(tmp.charAt(g));
                        }
                }
                // i=t;
            }
            
        }
        String tmp=sb.toString();
        sb=new StringBuilder();
        for(int i=tmp.length()-1;i>=0;i--){
            sb.append(tmp.charAt(i));
        }
        
        return sb.toString();
    }
}













