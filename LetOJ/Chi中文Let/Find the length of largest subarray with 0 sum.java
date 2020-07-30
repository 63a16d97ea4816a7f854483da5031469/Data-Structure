
/*
 * 
link: 
https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/

2020-7-30 at 1:50 pm

Find the length of largest subarray with 0 sum

Given an array of integers, find the length of the longest sub-array with sum equals to 0.

Examples :

Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
Output: 5
Explanation: The longest sub-array with 
elements summing up-to 0 is {-2, 2, -8, 1, 7}

Input: arr[] = {1, 2, 3}
Output: 0
Explanation:There is no subarray with 0 sum

Input:  arr[] = {1, 0, 3}
Output:  1
Explanation: The longest sub-array with 
elements summing up-to 0 is {0}

对题目易错地方进行总结:

对题目的实现思路进行几句话总结:

从这道题目学到了什么，哪些地方需要提升? :

 * 
 */


// Java code to find the largest subarray 
// with 0 sum 
class GFG { 
	// Returns length of the largest subarray 
	// with 0 sum 
	static int maxLen(int arr[], int n) 
	{ 
		int max_len = 0; 

		// Pick a starting point 
		for (int i = 0; i < n; i++) { 
			// Initialize curr_sum for every 
			// starting point 
			int curr_sum = 0; 

			// try all subarrays starting with 'i' 
			for (int j = i; j < n; j++) { 
				curr_sum += arr[j]; 

				// If curr_sum becomes 0, then update 
				// max_len 
				if (curr_sum == 0) 
					max_len = Math.max(max_len, j - i + 1); 
			} 
		} 
		return max_len; 
	} 

	public static void main(String args[]) 
	{ 
		int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 }; 
		int n = arr.length; 
		System.out.println("Length of the longest 0 sum "
						+ "subarray is " + maxLen(arr, n)); 
	} 
}




// A Java program to find maximum length subarray with 0 sum 
import java.util.HashMap; 

class MaxLenZeroSumSub { 

	// Returns length of the maximum length subarray with 0 sum 
	static int maxLen(int arr[]) 
	{ 
		// Creates an empty hashMap hM 
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>(); 

		int sum = 0; // Initialize sum of elements 
		int max_len = 0; // Initialize result 

		// Traverse through the given array 
		for (int i = 0; i < arr.length; i++) { 
			// Add current element to sum 
			sum += arr[i]; 

			if (arr[i] == 0 && max_len == 0) 
				max_len = 1; 

			if (sum == 0) 
				max_len = i + 1; 

			// Look this sum in hash table 
			Integer prev_i = hM.get(sum); 

			// If this sum is seen before, then update max_len 
			// if required 
			if (prev_i != null) 
				max_len = Math.max(max_len, i - prev_i); 
			else // Else put this sum in hash table 
				hM.put(sum, i); 
		} 

		return max_len; 
	} 

	// Drive method 
	public static void main(String arg[]) 
	{ 
		int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 }; 
		System.out.println("Length of the longest 0 sum subarray is "
						+ maxLen(arr)); 
	} 
}
















