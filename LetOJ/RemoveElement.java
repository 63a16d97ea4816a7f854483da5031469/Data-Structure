
package ok;
/*


https://leetcode.com/problems/remove-element/

Given an array and a value, remove all instances of that value in place and return the new length.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.

public class Solution {
    public int removeElement(int[] nums, int val) {
        
    }
}


7 November 2015 at 8:53:49 pm
 * 
 */
import java.util.*;
public class RemoveElement {

	public static void main(String args[]){
		int[] arr={4,5,2,1,3,4,5,6,9,21};
		System.out.println(removeElement3(arr,4));
	}
	
	
	/*
	 * Use two pointers indeed can solve this issue.
	 * 
	 * 
	 */
    public static int removeElement3(int[] nums, int val) {
		   int i=0;
		    int j=0;
		 
		    while(j < nums.length){
		        if(nums[j] != val){
		            nums[i] = nums[j];
		            i++; 
		        }
		 
		        j++;
		    }
		 
		    return i;
	}
	
    
    /*
     * Cannot understand what does the question mean.
     * 
     * 
     */
    public static int removeElement2(int[] nums, int val) {
        int result=0;
        ArrayList<Integer> list=new ArrayList<Integer>();
    	for(int tmp:nums){
    		if(tmp==val) continue;
    		list.add(tmp);
//    		result++;
    	}
    	
    	int[] newArr=new int[list.size()];
    	for(int i=0;i<newArr.length;i++){
    		newArr[i]=list.get(i);
    		result++;
    	}
    	nums=newArr;
    	return result;
    }
	
	
	/*
Submission Result: Wrong Answer More Details 

Input:
[4,5]
4
Output:
[4]
Expected:
[5]


Reason: At first, I did not understand what does the question mean.

After it shown wrong, I got to know that maybe I also need to do 
something about the array itself.


	 * 
	 */
	
    public static int removeElement(int[] nums, int val) {
        int result=0;
    	for(int tmp:nums){
    		if(tmp==val) continue;
    		result++;
    	}
    	return result;
    }
	
}
