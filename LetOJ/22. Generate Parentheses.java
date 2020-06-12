
/*
 * 
https://leetcode.com/problems/generate-parentheses/

22. Generate Parentheses
Medium

4338

235

Add to List

Share
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]


29 March 2020 at 4.52pm - 5.21pm
 * 
 */





class Solution {
    //4.52pm - 5.21pm
    
    char[] d=new char[]{'(',')'};
    List<String> list=new ArrayList<String>();
    
    public List<String> generateParenthesis(int n) {
        
        if(n==0) return list;
        
        generate(0,n*2,"");
          
        return list;
    }
    //我把这个问题看成一共有2*n层的每次，选择 左括号 和 右括号 的问题
    void generate(int start, int n, String s){
        
        if(start==n){
            
            if(is_valid(s))
            list.add(new String(s));
            return;
        }
        
        for(int i=0;i<2;i++){
            s+=d[i];
            generate(start+1,n,s);
            //恢复状态，因为还要继续遍历接下来的可能选择
            s=s.substring(0,s.length()-1);
        }
        
        
        
    }
    
    boolean is_valid(String s){
        
        Stack<Character> stack=new Stack<Character>();
         //对于如何判断是valid的符号，不太熟练
        for(char tmp:s.toCharArray()){
            if(!stack.isEmpty()){
                char top=stack.peek();

                if(top=='(' && tmp==')'){
                    stack.pop();
                }else{
                    stack.push(tmp);
                }
            }else{
                stack.push(tmp);
            }
        }
        
        if(stack.isEmpty()) return true;
        
        return false;
    }
    
}


















