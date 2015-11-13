package ok;

/*
 * https://leetcode.com/problems/move-zeroes/
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

public class Solution {
    public void moveZeroes(int[] nums) {
        
    }
}

28 October 2015 at 12:30:06 pm

 * 
 */
public class MoveZeros {

	public static void main(String args[]) {

		int[] num = { 0, 0, 1 };

		moveZeroes4(num);
	}
	
	
	public static void moveZeroes4(int[] nums) {
		makeFirstBeRight4(0,nums);
		for (int tmp : nums)
			System.out.print(tmp + " ");
}



public static void makeFirstBeRight4(int begin, int[] nums) {
	
	/*
	 * Added this mark to terminate the useless all zero loop in advance
	 *  		
	 */

	
	//Do not use recursion method
//	// if the begin value is not zero
//	if (nums[begin] != 0 && begin + 1 < nums.length) {
//		makeFirstBeRight(begin + 1, nums);


	
	/*
	 * (1) Have one pointer to indicate the first zero index in the array
	 * (2) From the head, keep searching the zero until to the end of the array
	 * (3) Once find zero, then, move this zero to after its position's 
	 * first find's non-zero number's position
	 * 
	 */
	
	
	
	int p=begin;
	boolean stopflag=false;
	
	while(p!=nums.length-1&&!stopflag){
		for(int j=p;j<nums.length;j++){
			if(nums[j]==0) {
				p=j;
			break;
			}
		}
		
		//add one terminated condition
		//If cannot be able to find any 0 in the array, it is end.
		
		
		/*
Input:
[0,1,0,3,12]
Output:
[0,1,0,3,12]
Expected:
[1,3,12,0,0]

Reason: use below sentence, actually it has defect.
		 * 
		 * 		if(p==begin) return; 
		 */

		
		//if the nums[p]!=0 and p==begin, that means it did not find any zero in array. it should return.
		if(nums[p]!=0&&p==begin) return;
		
		//add one terminated condition
		//If the p is reach the end already, it should return.
		if(p==nums.length-1) return;
		
		stopflag=true;
		

		
		// p is the current found 0's position
		
		for (int i = p+1; i < nums.length; i++) {
			if (nums[i] != 0) {
				stopflag=false;
				nums[p] = nums[i];
				nums[i] = 0;
				break;
			}
		}	
	}

		//Do not use recursion method
//		if (begin + 1 < nums.length&&!mark)
//			makeFirstBeRight(begin + 1, nums);

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*
	 * maybe we can make the most use of below functions' feature:
	 * 
	 * indexOf lastIndexOf
	 * 
	 * maintain two pointers, one for pointing out the first 0 found by searching from the
	 * head, one for pointing out the last non-zero number found by searching from the end.
	 * 
	 *   IndexOf(0)       lastIndexOf(0)
	 * _____|_________________|______________
	 * 
	 * However, we cannot maintain two pointers, after each movement, the array's status is changed. 
	 * It is not easy to maintain two pointers. It will cost a lot of efforts.
	 * 
	 * To make it easier, we only maintain one pointer from one fixed direction.
	 * 
	 * Direction: From head.
	 * 
	 * 
	 * We all know Java contain the indexOf and lastIndexOf, so we can make the most use of it.
	 * 
	 * So we can use this to optimize previous method. 
	 * 
	 * 
	 * 
Time Limit Exceeded 
Last executed input:
[0,0]
	 * 
	 * 
	 */

	public static void moveZeroes3(int[] nums) {
			makeFirstBeRight3(0,nums);
			for (int tmp : nums)
				System.out.print(tmp + " ");
	}
	
 

	public static void makeFirstBeRight3(int begin, int[] nums) {
		
		/*
		 * Added this mark to terminate the useless all zero loop in advance
		 *  		
		 */

		
		//Do not use recursion method
//		// if the begin value is not zero
//		if (nums[begin] != 0 && begin + 1 < nums.length) {
//			makeFirstBeRight(begin + 1, nums);

 
		
		/*
		 * (1) Have one pointer to indicate the first zero index in the array
		 * (2) From the head, keep searching the zero until to the end of the array
		 * (3) Once find zero, then, move this zero to after its position's 
		 * first find's non-zero number's position
		 * 
		 */
		
		
		/*
Time Limit Exceeded 
Last executed input:
[0,0]

Reason:  The while terminated condition has defect. 
So when the input is 0,0. It will not terminated.



Input:
[2,1]
Output:
[1,0]
Expected:
[2,1]

Reason: the non-zero cases. Recursion can skip this cases however, 
if you do not use recursion, you need to consider this case.

Input:
[0,1,0,3,12]
Output:
[0,1,0,3,12]
Expected:
[1,3,12,0,0]

Reason: 

		 * 
		 * 
		 */
		
		
		int p=begin;
		boolean stopflag=false;
		
		while(p!=nums.length-1&&!stopflag){
			for(int j=p;j<nums.length;j++){
				if(nums[j]==0) {p=j;
				break;
				}
			}
			
			stopflag=true;
			
			// p is the current found 0's postion
			
			for (int i = p+1; i < nums.length; i++) {
				if (nums[i] != 0) {
					stopflag=false;
					nums[p] = nums[i];
					nums[i] = 0;
					break;
				}
			}
		
		
		}

			//Do not use recursion method
//			if (begin + 1 < nums.length&&!mark)
//				makeFirstBeRight(begin + 1, nums);

	}

	
	/*
	 * 
	 * Accepted:
	 * 
	 * 
	 * 
	 * If you cannot implement the most stupid method, that means you do not
	 * begin to think the question very carefully.
	 * 
	 * Implementing the stupid method is the first step to let you konw what you
	 * are doing. And you can hava a basic understanding about the thing you are
	 * doing.
	 * 
	 * You also can get at least some right results.
	 * 
	 * 
	 * When you begin to do the programming, considering the test cases first
	 * may give you a lot of help. Programming is not the most important thing,
	 * the most important thing is analysis.
	 * 
	 * 
	 * Do not allow to use extra array.
	 * 
	 * if do not care about the time complexity, how could you do ? The most
	 * stupid method:
	 * 
	 * Loop the array, if I can see the 0, and then move it to the end. ==> but
	 * after each movement, the array status is changed.
	 * 
	 * 
	 * given nums = [0, 1, 0, 3, 12], after calling your function, nums should
	 * be [1, 3, 12, 0, 0].
	 * 
	 * 
	 * Consider:
	 * 
	 * Input: [0,0,1] Output: [0,1,0] Expected: [1,0,0]
	 * 
	 * [] [1,2] [0,0,1]
	 * 
	 * 
	 * 
	 * 
	 * If you want to use recursion, you need to do the analysis:
	 * 
	 * each time, check the first number, see whether it is non-zero.
	 * 
	 * if it is zero, use one method until find the right non-zero to replace
	 * it. if non-zero, keep doing the same thing in substring(1,length)
	 * 
	 * You also need to think what should be the terminated condition.
	 * 
	 * 
	 * 
	 * In this solution, we just like 'one by one' check, actually, sometimes, we can jump.
	 * 
	 * 
	 */

	public static void moveZeroes2(int[] nums) {
		makeFirstBeRight(0, nums);

		for (int tmp : nums)
			System.out.print(tmp + " ");
	}

	public static void makeFirstBeRight(int begin, int[] nums) {
		
		boolean stopflag=true;  // when find out that all the following numbers are zero
		/*
		 * Added this mark to terminate the useless all zero loop in advance
		 *  		
		 */

		// if the begin value is not zero
		if (nums[begin] != 0 && begin + 1 < nums.length) {
			makeFirstBeRight(begin + 1, nums);

			// if the begin value is zero
		} else if (nums[begin] == 0) {
			for (int i = begin; i < nums.length; i++) {
				if (nums[i] != 0) {
					stopflag=false;   // Not all the following numbers are zero
					nums[begin] = nums[i];
					nums[i] = 0;
					break;
				}
			}

			if (begin + 1 < nums.length&&!stopflag)
				makeFirstBeRight(begin + 1, nums);
		}

	}

	// To be used to move the specific index element to the end of the array
	public static void moveZeroToArrayEnd(int index, int[] nums) {
		for (int i = index; i < nums.length - 1; i++) {

			/*
			 * 
			 * we can write like this in a very lazy way: int tmp=nums[i];
			 * nums[i]=nums[i+1]; nums[i+1]=tmp;
			 * 
			 * However, we already know one of swaping element is 0, so no need
			 * to copy 0 too many times. So we only need to move the i+1 element
			 * to i, and if we go to the end of the array, we set the element in
			 * the end of array to be 0.
			 * 
			 */
			nums[i] = nums[i + 1];
		}
		nums[nums.length - 1] = 0;
	}
	
	
	
	
	

	/*
	 * 
	 * if we allow to use extra array, how could you do it?
	 * 
	 */

	public static void moveZeroes(int[] nums) {

		int[] newnums = new int[nums.length];
		int p = 0; // acutally, you can use int p; however, to make sure
					// different compliers will be the same, better to use p=0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				newnums[p++] = nums[i];
			}
		}

		for (int tmp : newnums)
			System.out.print(tmp + "  ");
	}

}
