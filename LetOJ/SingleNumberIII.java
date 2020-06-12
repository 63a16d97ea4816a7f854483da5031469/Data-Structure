package ok;

/*

https://leetcode.com/problems/single-number-iii/

Given an array of numbers nums, in which exactly two elements appear only once and 
all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?









public class Solution {
    public int[] singleNumber(int[] nums) {
        
    }
}

3  11  
5  101

 * 
 * 
 */

public class SingleNumberIII {
	public static void main(String args[]){
		SingleNumberIII iii=new SingleNumberIII();
		int[] nums={1,2,1,2,3,5,0,0};
//		System.out.println(iii.singleNumber(nums));
		int[] result=iii.singleNumber(nums);
		
		
		for(int tmp:result)
			System.out.println(tmp);
	}
	
	
	//reference to:
	//https://leetcode.com/discuss/67701/simple-solution-in-java

	/*
	 * 
	 * 
	 * 两种由原码求补码的方式：
	 * 
	 * （一）：ones'
	 * complement：这种表示法中，正数保持不变（因为这个方案就是要解决有效地将减法运算变成加负数的运算，所以，正数不需要变动，这里的反，
	 * 就是相对于正数的二进制形式来说的），负数用公式 [1]
	 * （n为将符号位算在内的位数）计算。可以形象的将对应的正数的二进制形式的各个位取反即可。(这里和得到反码的步骤不一样。反码，补码，
	 * 都是从原码开始操作得到。这里是从正数开始操作得到。但两者除了计算的起点不同，最终得到的编码形式是这样的。为了区别操作过程的不同，故仍然采用英文名。
	 * ) 用四位二进制数做例子。那么-7的二进制（0111）各各位取反得到其ones
	 * complement数（1000）。就是其中最左边的一位为符号位。N=7 ,n=4,带入公式，得 =-7以及其二进制形式，过程如下：
	 * 
	 * 
	 * （二）：twos complement：由于上面一种表示法 [1] (n为将符号位算在内的位数） 观察公式，twos
	 * complement数，相当于ones complement 数+1. 下面用4位二进制数来做例子： 2^{4}= 10000 2^{4}=
	 * 10000 减7 - 0111 减负7 - 1001
	 * 
	 * 
	 * 令lowbit = xor & -xor，lowbit的含义为xor从低位向高位，第一个非0位所对应的数字
	 * 
	 * 例如假设xor = 6（二进制：0110），则-xor为（二进制：1010，-6的补码，two's complement）
	 * 
	 * 则lowbit = 2（二进制：0010）
	 * 
	 * 根据异或运算的性质，“同0异1”
	 * 
	 * 记只出现一次的两个数字分别为a与b
	 * 
	 * 可知a & lowbit与b & lowbit的结果一定不同
	 * 
	 * 通过这种方式，即可将a与b拆分开
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	  public int[] singleNumber(int[] nums) {

          int xorOfArray = 0; //Used to filter divide the array into two group...

          for(int i = 0 ; i < nums.length ; i++)
          {
                xorOfArray = xorOfArray ^ nums[i];
          }

//          System.out.println("Xor of array is "+xorOfArray);

          int mask = xorOfArray & ~(xorOfArray - 1); // Unset all the bits except right most...
          
          System.out.println("Xor of array is "+xorOfArray+" "+~(xorOfArray-1));  //Xor of array is 6 -6
          
          
          // The feature is:   xorOfArray= a^b       That means a and b of lowbit must be different (otherwise, the value should be 0).
          // The same number will be group into the ( nums[i] & mask ) == 0 or ( nums[i] & mask ) != 0, But they will be 0 finally.
          // So use this way, we can distinguish these two numbers.
          
//          int mask=xorOfArray & ~xorOfArray;  // this sentence is not right. Cannot get the right numbers.
          int xorOfZeroBit = 0,xorOfOneBit = 0;

          for(int i = 0 ; i < nums.length ; i++)
          {
              if( ( nums[i] & mask ) == 0 ) 
              {
                  xorOfZeroBit = xorOfZeroBit ^ nums[i];
              }
              else
              {
                  xorOfOneBit = xorOfOneBit ^ nums[i];
              }
          }

          int result[] = new int[]{xorOfOneBit,xorOfZeroBit};
          return result;
      }
 
	
	
	
	
	
 
	
	public int getResult(int[] nums){
		int result=nums[0];
		
		for(int i=1;i<nums.length;i++){
			    result^=nums[i];
		}
		return result;
	}
	
	
	
	
	//Switch a and b variable without using extra variable.	
//	int a = 3;
//	int b = 2;
//	a = a ^ b;
//	b = a ^ b;  //----> b= a^b^b ===> b=a
//	a = a ^ b;  //----> a= a^a^b ===> a=b
//	System.out.println(a + " " + b);
	
}















