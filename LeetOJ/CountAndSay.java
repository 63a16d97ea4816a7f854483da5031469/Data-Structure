package ok;
/*
 * 
 * https://leetcode.com/problems/count-and-say/
 * 
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

f(1), f(f(1)), f(f(2))
1,  2,         3

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

public class Solution {
    public String countAndSay(int n) {
        
    }
}

4 November 2015 at 7:31:32 pm

 * 
 */
 


/*
 * 这是一个简单题目，这个解法很单纯，
 * 就是数数，讲array第一个设值为第一个字母，
 * 然后，开始逐个数数。
 * 先手写几个例子，发觉应该是又规律的，
 * 后来用简单方法打印出序列，分析规律。
 * 最后写出程序
 * 
 */

public class CountAndSay {
	
	public static void main(String args[]){
		int n=1000;
		for(int i=0;i<n;i++)
		System.out.println(i+" "+countAndSay2(i));
		
		
	}
	
		
 /*
  * Accepted.
  * 
  * 
  */
	
    public static String countAndSay2(int n) {
    	if(n==1) return "1";
    
    	String tmp="1";
    	for(int i=1;i<n;i++){
    		tmp=countSay2(tmp);

    	}
    	
    	return tmp;
    	
    }
	
	
	//adjust the input parameter' type to String
    public static String countSay2(String n) {
 

        String result="";
        char[] charN=n.toCharArray();

 

        char prev=charN[0];
        int count=0;
        
        for(int i=0;i<charN.length;i++){
        	if(prev!=charN[i]){
        		result+=count+""+prev;
        		prev=charN[i];
        		count=1;
        	}else{
        		count++;
        	}
        	
        }
//        result+=count+prev;   //output: 3+49    49 is the char's Decimal representation (byte type)
        result+=count+""+prev;
        
    	return result;
    }
	
	
	
	
    
    
    
    
    
    
    
	
	
	
	/*
	 * 
	public static void main(String args[]){
		int n=1000;
		for(int i=0;i<n;i++)
		System.out.println(i+" "+countAndSay(i));
	}
	
Output:	
0 1
1 1
2 11
3 21
4 1211
5 111221
6 312211
7 13112221
8 1113213211
9 31131211131221
10 13211311123113112211

 * 
 */
 
		
		// 		System.out.println(countAndSay(00));
		/*
		 * 	Because it is Integer, so 00 would be 0.
		 * 
		 * 
		 * how about negative number?
		 * 
		 * 
		 */    
    
    
    
    
	
	/*
	 * 
Runtime Error More Details 

Runtime Error Message:
Line 7: java.lang.NumberFormatException: For input string: "13211311123113112211"
Last executed input:
11

	 * 
	 */
	
    public static String countAndSay(int n) {
    	if(n==1) return "1";
    
    	String tmp="1";
    	for(int i=1;i<n;i++){
    		tmp=countSay(Long.parseLong(tmp));

    	}
    	
    	return tmp;
    	
    }
	
	
	
    public static String countSay(long n) {
    	
 
        String sN=n+"";
        String result="";
        char[] charN=sN.toCharArray();

        
//        int prev=charN[0];
//        int count=0;
        /*
         *  int prev=charN[0];   // it means the charN[0] will be convert to Decimal representation (byte type) ---> a number
         *  Take care what you are writing when you are using the char type
         *  
         * 
         */

        char prev=charN[0];
        int count=0;
        
        for(int i=0;i<charN.length;i++){
//        	System.out.println(charN[i]+""+prev);
        	
        	if(prev!=charN[i]){
        		result+=count+""+prev;
        		prev=charN[i];
        		count=1;
        	}else{
        		count++;
        	}
        	
        }
//        result+=count+prev;   //output: 3+49    49 is the char's Decimal representation (byte type)
        result+=count+""+prev;
        
    	return result;
    }
}

















