package ok;
//https://leetcode.com/problems/single-number/

/*
 * 
 Given an array of integers, every element appears twice except for one.
 Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. 
 Could you implement it without using extra memory?

public class Solution {
    public int singleNumber(int[] nums) {
        
    }
}
7 November 2015 at 11:44:28 pm
 * 
 */

import java.util.*;
public class SingleNumber {
	public static void main(String args[]){
		int[] nums={1,1,0};
		System.out.println(singleNumber2(nums));
 
	}
	
	
	
	/*
	 * 
	 *  I tried the testing cases:
Your input

[1,2,1]
Your answer

2
Expected answer

2

That means the number is not sorted.




 *  realSum= Sum(real input elements);        realSum=2*(appeared 2 times' elements)+(appeared 1 time's element)     
 *  
 *     Could we use some way to   remove   2*(appeared 2 times' elements)  or (appeared 1 time's element)    within linear runtime complexity. 
 *     
 *     We must loop the element----
 *     
 *     +, - , *, /
 *     
 *     

Considering testing cases:

'+' method /2:

[1,2,1]    2        -----> 1+2+1=4    4/2=2        ===> (1+1)/2+2/2
[1,1,2,2,3]  3  -----> 1+1+2+2+3=9   9/2=4....1    ===> (1+1+2+2)/2+3/2

[1,1,2,2,7]  7  -----> 1+1+2+2+7=13   13/2=6....1    ===> (1+1+2+2)/2+7/2

[1,1,2,2,11]  11  -----> 1+1+2+2+11=17   17/2=8....1    ===> (1+1+2+2)/2+17/2

 
'+' method / '*' method:
 
 
2a+2b+c
---------
a*a*b*b*c


'*' method and Math.pow(a,b) method:

	loop:   a*a*b*b*c
	
  Math.pow(a,0.5)*Math.pow(b,0.5)*Math.pow(a,0.5)*Math.pow(b,0.5)*Math.pow(c,0.5) =a*b*Math.pow(c,0.5)
  
  
  a*a*b*b*c/a*b*Math.pow(c,0.5)=a*b*Math.pow(c,0.5)
  
  
  what kind of operation works for appeared twice elements but does not work for only appeared one time element?
  
  
  + and -     what if, if we put + for one and - for another.
  
  正号和负号，可以相互抵消，如果我们每隔一个数交换一下负号  ＋，－，＋，－，因为数组一定是奇数，出现两次的数一定会倍消掉,或者保留下来＝＝＝》无法达到目的
  枚举cases:
  [a,a,b]  -->[a,-a,b]
  [a,b,a]  -->[a,-b,a]
  [b,a,a]  -->[b,-a,a]
  
  
  [a,a,b,b,c]--->[a,-a,b,-b,c]
  [c,a,a,b,b]--->[c,-a,a,-b,b]
  [a,c,a,b,b]--->[a,-c,a,-b,b]
  


'/' method:

a/a=1 b/b=1

'/' achieve the purpose  remove   2*(appeared 2 times' elements) 

a/b/a/b/c

[1,2,1]   1/2/1 =1/2
[1,1,2,2,3]   1/1/2/2/3=1/3
[1,1,2,2,7]  1/1/2/2/7=1/7
[2,3,2,3,9] 2/3/2/3/9=1/9

 Math.pow(1/9,-1)=9

This question inspires me that:

解决这个问题，启发我们，做事情，首先考虑 现在的数据，是怎样的结构？－－》 现在结构＝出现两次的元素＋出现一次的元素
那么，我们初步的目标，要分离他们＝＝》 就是要用某一种方法，移除其中一部分，进而得到另一部分。这是我们的总体目标。
考虑到在O(n)下实施我们的目标，而且不能用额外的空间，应该是某种运算方法，这样就进一步缩小了我们的思考范围。

通过细化思考，
'/' 达成了我们的这一目的,出发的交换性，促使了 a/b/a/b/c = a/a/b/b/c

In order to solve the problem, we should establish the purpose.

our purpose:   Could we use some way to   remove   2*(appeared 2 times' elements)  or (appeared 1 time's element)    within linear runtime complexity.  




最后，想到XOR运算， 问题是，XOR运算满足交换律吗？在不使用搜索引擎的前提下，书写几个例子: 必须使用二进制，按位XOR

XOR
0 0 || 0
1 1 || 0
1 0 || 1

		(1 XOR 2) XOR 1 == (1 XOR 1) XOR 2  ??   
Binary  0 XOR 10 XOR 0 == (0 XOR 0) XOR 10

		2 XOR 3 XOR 2 == (2 XOR 2) XOR 3
Binary 10 XOR 11 XOR 10 == 10 XOR 10 XOR 11
  -->    01 10 == 00 11
  -->     11   ==  11


	 * 
	 * 
	 */
	
	
	/*
	 * Using the XOR operation
	 * 
	 * Accepted.
	 * 
	 */
 
    public static int singleNumber2(int[] nums) {
    	
//    	if(nums==null) return -1;
 
    	int result=nums[0];
 
    	for(int i=1;i<nums.length;i++){
    		result=result^nums[i];
    	}
 
    	return result;
    }
	
	
	
	
	
	/*
	 * 2(a+b+c+d...+n)-(a+a+b+b+c+d+d....+n+n)=c
	 * 
	 * c is that single number
	 * 
	 * Accepted.
	 * 
	 * Warning: For this one, I used two extra memory.
	 * 
	 * 
	 */
	
    public static int singleNumber(int[] nums) {
        
    	int result=0;
    	int doubleSumResult=0;
    	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    	for(int tmp:nums){
    		if(map.get(tmp)==null){
    			doubleSumResult+=tmp*2;
    			map.put(tmp, 1);
    		}
    		result+=tmp;
    	}
    	result=doubleSumResult-result;
    	
    	return result;
    }
	
}
