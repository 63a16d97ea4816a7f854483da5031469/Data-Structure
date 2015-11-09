/*
 * 

https://leetcode.com/problems/single-number-ii/
 
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

public class Solution {
    public int singleNumber(int[] nums) {
        
    }
}
 * 
 */


/*
 * Get idea from the question called "Single Number"  XOR method
 * 
 * appearing three times.
 * 
 * That means you cannot only use XOR.
 * 
 * 
 * 3(appeared 3 times elements)+(appeared 1 time element)=XOR[2*(appeared 3 times elements)]+XOR(appeared 3 times elements+Single element)
 * 
 *  
 * 思考： 异或运算已经区分不出来了，同或运算呢？
 * 
 * 如何思考？－－》思考就是不要钻进死胡同中，要考虑相反的面，不同的特性的同类事情，组合使用的可能。 
 * XOR 异或: a^b        相异为1      
 * XNOR 同或：(each bit)^(each bit)^1 = one bit     相同为1
 * 
 1 0 1 0 1 1 0 0                                  1 0 1 0 1 1 0 0

^                                               同或运算

 0 0 0 0 1 1 1 1                       		      0 0 0 0 1 1 1 1


=1 0 1 0 0 0 1 1                              =   0 1 0 1 1 1 0 0




		2 XNOR 3 XNOR 2 == (2 XNOR 2) XNOR 3
Binary 10 XNOR 11 XNOR 10 == 10 XNOR 10 XNOR 11
  -->    10 10 == 11 11
  -->     11   ==  11

0 XNOR 0 XNOR 2
1 XNOR 2 ==> 1 XNOR 10 ==>10


 * 
 */

import java.util.*;

public class SingleNumberII {
	
	public static void main(String args[]){
		SingleNumberII s=new SingleNumberII();
 
//		int[] nums={2,2,2,3,3,3,432};
		int[] nums={5,2,5,2,5,2,31};
		
		System.out.println(s.singleNumber6(nums));
 
	}
 
	 
	//对于参考别人的代码，我们需要默写下来，以求理解和掌握。	方法一

//--------------------------------------------------------------------------------------------------------------------------------------------
	
	
	public int singleNumber5(int[] nums){

		int[] bitn=new int[32];
		int result=0;
		for(int i=0;i<32;i++){
		for(int j=0;j<nums.length;j++){
			if(((nums[j] >> i)&1)==1)
			//	bitn[i]+=(nums[j] >> i) & 1;
		    //  bitn[i]=bitn[i]%3
			// Convert two sentences to one below sentence.
	 			bitn[i]=(bitn[i]+1)%3;
			}
			result |=(bitn[i] << i);
		}
		return result;
	}

	
	
	
	 
	
	 
	
	 
	
	 
	
	 
	

//--------------------------------------------------------------------------------------------------------------------------------------------	 
	
	
	
	
//对于参考别人的代码，我们需要默写下来，以求理解和掌握。	 方法二

//--------------------------------------------------------------------------------------------------------------------------------------------
		
		
		
		
	public int singleNumber6(int[] nums){

		int ones=0,twos=0,threes=0;

		for(int i=0;i<nums.length;i++){
			twos|=ones & nums[i];
			ones^=nums[i];
			threes=ones&twos;

			ones&=~threes;
			twos&=~threes;
		}


	    return ones;
	}
		
		
		 
		
		 
		
		 
		
		 
		
		 
		

//--------------------------------------------------------------------------------------------------------------------------------------------	 	
	
	
	
	//This question I referenced to this website to solve:	
	
	//Ref: http://blog.csdn.net/fightforyourdream/article/details/14634123

	
	//Understand the bit operations:
	// XOR, XNOR, &(bit operations), |(bit operations).
	
	
	
	/*
	 * 
	 * An integer is represented as a sequence of bits in memory. For
	 * interaction with humans, the computer has do display it as decimal
	 * digits, but all the calculations are carried out as binary. 123 in
	 * decimal is stored as 1111011 in memory.
	 * 
	 * The & operator is a bitwise "And". The result is the bits that are turned
	 * on in both numbers. 1001 & 1100 = 1000, since only the first bit is
	 * turned on in both.
	 * 
	 * The | operator is a bitwise "Or". The result is the bits that are turned
	 * on in either of the numbers. 1001 | 1100 = 1101, since only the second
	 * bit from the right is zero in both.
	 * 
	 * There are also the ^ and ~ operators, that are bitwise "Xor" and bitwise
	 * "Not", respectively. Finally there are the <<, >> and >>> shift
	 * operators.
	 * 
	 */
	
	
	//对于参考别人的代码，我们需要默写下来，以求理解和掌握。	
	
	
	 // Time: O(n), space: O(1)  
    // 基本思想是每个数都可以表示成二进制形式，进而统计每个数在每一位出现的次数  
	public static int singleNumber2(int[] A) {
		// 创建一个长度为32的数组countsPerBit，
		// countsPerBit[i]表示A中所有数字在i位出现的次数
		int[] countsPerBit = new int[32];
		int result = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				if (((A[j] >> i) & 1) == 1) {

					System.out.println("Binary>>" + i + " " + Integer.toBinaryString((A[j] >> i)));
					System.out.println(">>" + i + " " + ((A[j] >> i) & 1));   // according to the & operation feature, use this to get the ith position's bit.

					countsPerBit[i] = (countsPerBit[i] + 1) % 3;
				} else {
					System.out.println("Binary>>" + i + " " + Integer.toBinaryString((A[j] >> i)));
					System.out.println(">>" + i + " " + ((A[j] >> i) & 1));  // according to the & operation feature, use this to get the ith position's bit.
				}

			}
			result |= (countsPerBit[i] << i);
			System.out.println("-------------------" + result + "-------------------------");
		}
		return result;
	}

    
	//http://www.acmerblog.com/leetcode-single-number-ii-5394.html
    // Accepted.
	
	/*
这个算法是有改进的空间的，可以使用掩码变量：

ones   代表第ith 位只出现一次的掩码变量
twos  代表第ith 位只出现两次次的掩码变量
threes  代表第ith 位只出现三次的掩码变量

假设在数组的开头连续出现3次5，则变化如下：
ones = 101
twos = 0
threes = 0
--------------
ones = 0
twos = 101
threes = 0
--------------
ones = 0
twos = 0
threes = 101
--------------
当第 ith 位出现3次时，我们就 ones  和 twos  的第 ith 位设置为0. 最终的答案就是 ones。


假设开头交叉出现101和10各三次：
101
10
101
10
10
101

ones = 101
twos = 0
threes = 0
--------------
ones = 0
twos = 101
threes = 0
--------------
ones = 0
twos = 0
threes = 101


  ones|twos|threes
	5 | 0 | 0
	0 | 5 | 0
	0 | 0 | 5
	
  101 | 0 | 0
  0 | 101 | 0
  0 | 0 | 101	

  ones|twos|threes
	5 | 0 | 0           5
	7 | 0 | 0           2
	2 | 5 | 0           5
	0 | 7 | 0           2
	0 | 2 | 5           5
	0 | 0 | 2           2


ones|twos|threes
  101 | 0 | 0
  111 | 0 | 0
  10 | 101 | 0
  0 | 111 | 0
  0 | 10 | 101
  0 | 0 | 10
  
	 * 
	 * 
	 */
	
//对于参考别人的代码，我们需要默写下来，以求理解和掌握。	
	public static int singleNumber3(int nums[]) {
		int ones = 0, twos = 0, threes = 0;
		
		System.out.println("ones|twos|threes");
		for (int i = 0; i < nums.length; i++) {
			twos |= ones & nums[i];   //this operation only adds values to 'twos' when ones variable(binary bit) is not '0'.
			ones ^= nums[i];   // this one is very important:  Twice XOR --->0   one XOR or Three times XOR ----> is equal to one time XOR. 
							   // If we only execute this sentence, you can see, it only add value into the 'ones'.
			threes = ones & twos;  //this operation only adds values to 'threes' when ones and twos variables(binary bit) are not '0'.
			System.out.println("Do not remove three:"+Integer.toBinaryString(ones)+" | "+Integer.toBinaryString(twos)+" | "+Integer.toBinaryString(threes));
			//当第 ith 位出现3次时，我们就 ones  和 twos 的第 ith 位设置为0. 最终的答案就是 ones。
			// 就相当于我们构造了一个 “出现三次”数的 浮动，当这个数我们确认为出现三次时候，它已经不重要了，我们需要清除掉它在三个变量（ones,twos）的影响。我们真正关注的是ones. twos和threes是我们的桥梁。
			// 5出现一次， 只出现在ones中，5出现两次，只出现twos中（因为ones 异或运算性质，归零），5出现三次，出现在ones，twos，three中，所以要对one，two清除 three当前值（binary bit只保留1）。
			//As one number appear 3 times, the same binary bit appeared in ones and twos, we need to remove these ones.
			//As we know all other numbers except for single number are appeared three times.
			
			ones &= ~threes;   
			twos &= ~threes;    
			System.out.println("  "+Integer.toBinaryString(ones)+" | "+Integer.toBinaryString(twos)+" | "+Integer.toBinaryString(threes));
		}
		return ones;

	}

/*
 * 
Do not remove three:101 | 0 | 0           5
  101 | 0 | 0        					   5
Do not remove three:111 | 0 | 0           2
  111 | 0 | 0           					2
Do not remove three:10 | 101 | 0           5
  10 | 101 | 0          					5
Do not remove three:0 | 111 | 0           2
  0 | 111 | 0           					2
Do not remove three:101 | 111 | 101           5        ===> clear "three" operation takes effect
  0 | 10 | 101         						  5
Do not remove three:10 | 10 | 10           2
  0 | 0 | 10        					   2
 * 
 * 	
 */
	
 
    //Implemented the XNOR:
    public int XNOR(int a,int b){

		String astr = Integer.toBinaryString(a);
		String bstr = Integer.toBinaryString(b);
		String result = "";
		int offset=Math.abs(astr.length()-bstr.length());
		Stack<String> stack=new Stack<String>();
		for (int i = Math.max(astr.length(), bstr.length())-1; i >=0; i--) {
			if (astr.length() >= bstr.length()) {
				if (i >= bstr.length()) {
					stack.push((((int) (astr.charAt(i))) ^ ((int) (bstr.charAt(i-offset))) ^ 1) + "");
				} else {
					stack.push(astr.charAt(i)+"");
				}
			} else {
				if (bstr.length() >= astr.length()) {
					if (i >= astr.length()) {
						stack.push((((int) (astr.charAt(i-offset))) ^ ((int) (bstr.charAt(i))) ^ 1) + "");
					} else {
						stack.push(bstr.charAt(i)+"");
					}
				}

			}

		}
		while(!stack.isEmpty()){
			result+=stack.pop();
		}
		return Integer.parseInt(result, 2);
    }
  
}

 



















