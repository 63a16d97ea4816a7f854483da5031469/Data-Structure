
/*
 * 
https://leetcode.com/problems/power-of-two/

231. Power of Two
Easy

773

184

Add to List

Share
Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false
12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */

// AC 5years ago：
public class Solution {
    public boolean isPowerOfTwo(int n) {
 	
			
	    	if(n==0) return false;
	    	if(n==1) return true;
	    	
	    	long curr=1;
	    	long prev=1;
	    	while(true){
	    		prev=curr;
 
	    		curr=curr<<1;
	    		
	    		if(curr==n) {
 
	    			return true;

	    		}
	    		if(prev<n&&curr>n) {
 
	    		return false;
	    		}

	    	}
    }
}

// 通过：
class Solution {
    public boolean isPowerOfTwo(int x) {
        if (x <= 0) {
            return false;
        }
        while (x % 2 == 0) {
            x /= 2;
        }
        return x == 1;
    }
}


// 超时
class Solution {
    public boolean isPowerOfTwo(int n) {
        int curr=1;
        while(curr<=n){
            if(curr==n){
                return true;
            }else{
                curr=curr*2;
            }
        }
        return false;
    }
}

// 改写，通过：因为之前的超时，是因为溢出导致的
class Solution {
    public boolean isPowerOfTwo(int n) {
        int curr=1;
        while(curr<=n&&curr>0){
            if(curr==n){
                return true;
            }else{
                curr=curr*2;
            }
        }
        return false;
    }
}


// 改写
class Solution {
    public boolean isPowerOfTwo(int n) {
        int curr=1;
        while(curr<=n){
            if(curr==n){
                return true;
            }else{
                curr=1 << curr;
            }
        }
        return false;
    }
}


1073741825

1
2
4
8
16
32
64
128
256
512
1024
2048
4096
8192
16384
32768
65536
131072
262144
524288
1048576
2097152
4194304
8388608
16777216
33554432
67108864
134217728
268435456
536870912
1073741824
-2147483648

 超时是因为溢出


// 改写  Accepted:
class Solution {
    public boolean isPowerOfTwo(int n) {
        long curr=1;
        int count=0;
        while(curr<=n){
            if(curr==n){
                return true;
            }else{
                curr=1 << count;
                // System.out.println(curr);
            }
            count++;
            if(count>31) return false;
        }
        return false;
    }
}





// 利用移位运算，来计算int 32位的所有可能

class Solution {
    public boolean isPowerOfTwo(int n) {
        int i = 1;
        int count = 0;
        while(count < 31) {
            if(i << count == n) {
                return true;
            }
            count++;
        }
        return false;
    }
}

// 时间复杂度
// O(32)

// 空间复杂度
// O(1)



// 位操作
// 这个题目也可以位操作一步解决， 但是这里其实需要一点证明；
// 正向的当然好理解， 需要反向证明一下， 为什么 (n&(n-1)) == 0就表示是2的指数？

public boolean isPowerOfTwo(int n) {
    return n > 0 && ((n&(n-1)) == 0);
}



// 与（&），按位或（|），按位异或（^），按位取反（~）





/*
@author :yinzhengjie
Blog:http://www.cnblogs.com/yinzhengjie/tag/Java%E5%9F%BA%E7%A1%80/
EMAIL:y1053419035@qq.com
*/

public class bitwise{
    public static void main(String[] args){
        int a = 10;
        int b = 20;
        int c = a & b;
        System.out.println("c==" + c);            //c == 0
        /**
            a变量的值10，它对应的二进制形式为：
            00000000 00000000 00000000 00001010
            a变量的值20，它对应的二进制形式为：
            00000000 00000000 00000000 00010100
    按位与&
    --------------------------------------------
            00000000 00000000 00000000 00000000
        */


        c = a | b;
        /**
            a变量的值10，它对应的二进制形式为：
            00000000 00000000 00000000 00001010
            a变量的值20，它对应的二进制形式为：
            00000000 00000000 00000000 00010100
    按位或|
    --------------------------------------------
            00000000 00000000 00000000 00011110
        */
        System.out.println("c==" + c);            //c == 30

        c = a ^ b;
        /**
            a变量的值10，它对应的二进制形式为：
            00000000 00000000 00000000 00001010
            a变量的值20，它对应的二进制形式为：
            00000000 00000000 00000000 00010100
    按位异或^
    --------------------------------------------
            00000000 00000000 00000000 00011110
        */
        System.out.println("c==" + c);            //c == 30


        c = ~a;
        /**
            a变量的值10，它对应的二进制形式为：
            00000000 00000000 00000000 00001010
    按位取反（~）
    --------------------------------------------
            11111111 11111111 11111111 11110101
        */
        System.out.println("c==" + c);            c == -11


    }
}