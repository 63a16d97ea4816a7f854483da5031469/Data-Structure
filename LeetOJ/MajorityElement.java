package ok;


/*
 * 
https://leetcode.com/problems/majority-element/

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

public class Solution {
    public int majorityElement(int[] nums) {
        
    }
}

30 October 2015 at 2:26:08 pm

 * 
 */
import java.util.*;

public class MajorityElement {

	public static void main(String args[]) {
		int[] myarr = { 2 };
		System.out.println(majorityElement(myarr));
	}

	/*
	 * 
	 * Accepted:
	 * 
	 */
	public static int majorityElement(int[] nums) {

		int majorN = -1;
		int maxOcc = -1;
		int curr = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int tmp : nums) {
			if (map.get(tmp) == null) {
				map.put(tmp, 1);
				curr = 1;
			} else {
				curr = map.get(tmp);
				map.put(tmp, curr + 1);
				curr++;
			}
			if (maxOcc < curr) {
				majorN = tmp;
				maxOcc = curr;
			}
		}

		return majorN;

	}

}
