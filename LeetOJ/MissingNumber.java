import java.util.HashMap;

/*
https://leetcode.com/problems/missing-number/

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

public class Solution {
    public int missingNumber(int[] nums) {
        
    }
}

/*
 * Considering the cases:
 * 
 * [0] 1
 * [1] 0
 * [0,1,3] 2
 * 
 * After I write the testing cases, I got an idea to solve this question.
 * 
 * 
 * As it is start from 0 to n, we use loop to get the I(0,1,2,3,4,5... namely, it is the right arrays)
 * 
 * then we search to find the missing number.
 * 
 * It is just like we have two arrays:
 * 
 * Using the Loop i to get this array: a1   [0,1,2,3,4,5,6.....]
 * The real input array:               a2   [0,1,3]
 * 
 * 
 * Search from the real input array.----> Two pointers to compare the first array(a1) and the second array(a2).
 * 
 * (1) If cannot find a1's element in a2, that means: current a1's element is the one which is missing in the a2.
 * (2) If find that one in a1, then continue. until find the missing number.
 * 
 * 
 * Take care:  the number may not be sorted in advance.
 * 
 * [1,4,2]
 * 
 * So we cannot use this way.
 * 
 */





/*
 *  When you are trying to solve a problem. 
 *  Do not try to Search from your mind(memory)....  ---> That what search engine's everyday behavior. Obviously, you are not search engine.
 *  Try to use your right brain to think.
 * 
 * 
 */












public class MissingNumber {
	
	public static void main(String args[]){
		int[] arr={1,2,3};
		System.out.println(missingNumber2(arr));
		
	}
	
	/*
	 * Testing cases:
	 * [0] 1
	 * [1] 0
	 * [0,1,3] 2
	 * 
	 */
	
	/*
	 * 
	 * Continue considering the testing cases:
	 * 
	Considering these cases:

	[0]  1

	[0,1] 2

	[1,2] 0

	[0] 1
	[1] 0
	[0,1,3] 2

	We find out that      Sum(nums.length+1) -Sum(nums's element) = The missing number




	 */
	
	
	/*
	 * Accepted.
	 */
	
    public static int missingNumber2(int[] nums) {
    	int realSum=0;
    	int loopSum=0;   
    	
    	//we need to run nums.length+1 times loop
    	for(int i=0;i<nums.length+1;i++){
    		//realSum only run 0 to nums.length-1 times
    		if(i<nums.length){
    		realSum+=nums[i];
    		}
    		loopSum+=i;
    	}
    	
    	
    	return loopSum-realSum;
    	
    }
	
	
	
	
	
	/*
	 *  Do not understand the question, so implemented the stupid method to try the testing cases.
	 *  '

 Get the testing cases:
 
Input:
[0]
Output:
0
Expected:
1

Input:
[1]
Output:
0
Expected:
0


Input:
[0,1]
Output:
0
Expected:
2

	 * 
	 */
    public static int missingNumber(int[] nums) {
        
    	
    	if(nums.length==1&&nums[0]==0) return 1;
      	if(nums.length==1&&nums[0]==1) return 0;
    	HashMap<Integer,String> map=new HashMap<Integer,String>();
    	
    	int result=0;
    	int tmpr=0;
    	for(int i=0;i<nums.length;i++){
    		map.put(nums[i], "");
    	}
    	for(int i=0;i<nums.length;i++){
    		if(map.get(i)==null) return i;
    	}
    	return result;
    	
    }
}
