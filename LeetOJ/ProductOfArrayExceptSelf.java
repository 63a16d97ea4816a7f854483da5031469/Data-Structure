/*
 * https://leetcode.com/problems/product-of-array-except-self/
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        
    }
}
 * 
 */















public class ProductOfArrayExceptSelf {
	
	
	public static void main(String args[]){
		ProductOfArrayExceptSelf s=new ProductOfArrayExceptSelf();
		int[] nums={1,2,3,4};
		int[] result=s.productExceptSelf22(nums);
		for(int tmp:result)
			System.out.println(tmp);
	}
	
	//As you reference to other people's code, you need to rewrite it:
	//method 1:
//-------------------------------------------------------------------------------------------------------------------
	
	
	
	public int[] productExceptSelf11(int[] nums) {

		int[] result=new int[nums.length];

		int[] t1=new int[nums.length];
		int[] t2=new int[nums.length];

		t1[0]=1;
		t2[nums.length-1]=1;
		
	//from the left to right
		
		//you need to be careful about the boundary ---> end boundary   it is nums.length-1 as you used the t1[i+1]
		for(int i=0;i<nums.length-1;i++){
			t1[i+1]=t1[i]*nums[i];
		}


	//from the right to left
		//you need to be careful about the boundary ---> end boundary   it is i>0 as you used the t2[i-1]
		for(int i=nums.length-1;i>0;i--){
			t2[i-1]=t2[i]*nums[i];
		}


		for(int i=0;i<nums.length;i++){
			result[i]=t1[i]*t2[i];
		}


		return result;
	}

	
	
	
	
	
//-------------------------------------------------------------------------------------------------------------------	
	

	//method 2:
//-------------------------------------------------------------------------------------------------------------------
	
	
	
	

public int[] productExceptSelf22(int[] nums) {

	int[] result=new int[nums.length];

	result[nums.length-1]=1;

	for(int i=nums.length-2;i>=0;i--){
		result[i]=result[i+1]*nums[i+1];
	}

	int left=1;
	for(int i=0;i<nums.length;i++)
	{
		result[i]*=left;
		left*=nums[i];

	}
	
	return result; 

}
	
	
	
	
//-------------------------------------------------------------------------------------------------------------------	
		
			
	
	
//reference to the link: http://www.programcreek.com/2014/07/leetcode-product-of-array-except-self-java/
	
	public int[] productExceptSelf3(int[] nums) {
	    int[] result = new int[nums.length];
	    result[result.length-1] = 1;
	 
	    for(int i=nums.length-2; i>=0; i--) {
	        result[i] = result[i+1] * nums[i+1];
	    }
	 
	    int left = 1;
	    for(int i=0; i<nums.length; i++) {
	        result[i] *= left;
	        left *= nums[i];
	    }
	 
	    return result;
	}


//reference to the link: http://www.programcreek.com/2014/07/leetcode-product-of-array-except-self-java/
	
/*

[1,2,3,4]
 
t1[1, 1, 2, 6]
t2[24, 12, 4, 1]

 */
	
	public int[] productExceptSelf2(int[] nums) {
	    int[] result = new int[nums.length];
	 
	    int[] t1 = new int[nums.length];
	    int[] t2 = new int[nums.length];
	 
	    t1[0]=1;
	    t2[nums.length-1]=1;
	 
	    //scan from left to right
	    for(int i=0; i<nums.length-1; i++){
	        t1[i+1] = nums[i] * t1[i];
	    }

	 
	    //scan from right to left
	    for(int i=nums.length-1; i>0; i--){
	        t2[i-1] = t2[i] * nums[i];
	    }
	 
	    //multiply
	    for(int i=0; i<nums.length; i++){
	        result[i] = t1[i] * t2[i];
	    }
	 

	    return result;
	}

	
	
	
//    public int[] productExceptSelf(int[] nums) {
//        int[] result=new int[nums.length];
//        
//        for(int i=0;i<nums.length;i++){
//        	
//        }
//        
//    	return result; 
//    }

}














