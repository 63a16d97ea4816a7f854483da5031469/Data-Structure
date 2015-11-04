/*
https://leetcode.com/problems/reverse-integer/

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

public class Solution {
    public int reverse(int x) {
        
    }
}
 * 
 * 
 */
import java.util.*;
public class ReverseInteger {

	public static void main(String args[]){
		System.out.println(reverse2(1563847412));
	}
	
	
	
	/*
	 * Accepted:
	 * 
	 * This requirement is hidden in the hint of question.
	 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
	 * 
	 * 
	 */
	
	
    public static int reverse2(int x) {
        if((Math.abs(x)+"").length()==1) return x;
    	List<Integer> list=new ArrayList<Integer>();    	
    	long result=0;
    	
//    	boolean flag=x>0?true:false;
    	
    	while(x!=0){
    	 list.add(x%10);
    	 x/=10;
    	}
    	
    	for(int tmp:list){
    		System.out.print(tmp+" ");
    	}
    	System.out.println();
    	
    	for(int i=0;i<list.size();i++){
    		result+=list.get(i)*Math.pow(10,list.size()-i-1);
    		
    		System.out.print(list.size()-i-1+" ");
    	}
    	
    	/*
    	 * Consider one issue: if the number is 100, then reverse it. The result should be 001?
    	 * 
    	 */
    	
    	
    	// Need to consider overflow(上溢) and underflow(下溢) at the same time.
//    	if(result>Math.pow(2, 32)-1) return 0;
    	
    	/*
    	 * Java int:
    	 *  Minimum value is - 2,147,483,648.(-2^31) Maximum value is 2,147,483,647(inclusive).(2^31 -1)
    	 * 
    	 */
    	if(result>Math.pow(2, 31)-1||result<-Math.pow(2, 31)) return 0;
    	
    	System.out.println(result);
    	
    	return (int)result;
    }
	
	
	
	
	
	/*
	 * 
Wrong Answer More Details 

Input:
1534236469
Output:
2147483647

Reason: int overflow


According to hint:

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

	 * 
	 */
	
    public static int reverse(int x) {
        if((Math.abs(x)+"").length()==1) return x;
    	List<Integer> list=new ArrayList<Integer>();    	
    	int result=0;
    	
//    	boolean flag=x>0?true:false;
    	
    	while(x!=0){
    	 list.add(x%10);
    	 x/=10;
    	}
    	
    	for(int tmp:list){
    		System.out.print(tmp+" ");
    	}
    	System.out.println();
    	
    	for(int i=0;i<list.size();i++){
    		result+=list.get(i)*Math.pow(10,list.size()-i-1);
    		
    		System.out.print(list.size()-i-1+" ");
    	}
    	
    	/*
    	 * Consider one issue: if the number is 100, then reverse it. The result should be 001?
    	 * 
    	 */
    	
    	System.out.println(result);
    	
    	return result;
    }
	
}
