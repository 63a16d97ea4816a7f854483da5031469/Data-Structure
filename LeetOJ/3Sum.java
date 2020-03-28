
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


3Sum

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }

public class Solution {
	public List < List < Integer >> threeSum(int[] nums) {
    
    }
}

27 Mar 2020 10.12pm
 * 
 */


class Solution {
	public List < List < Integer >> threeSum(int[] nums) {

		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>> ();

		for (int i = 0; i < nums.length; i++) {

			//已经排过序了，如果第一个数大于0必然不能结果为0，跳过
			if (nums[i] > 0) {
				break;
			}

			//如果i大于0，看跟前数是否一致，如果一致则有可能导致重复，所以跳过
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			//凑这三个数，不能随便的for循环，每次按照位置+1，因为那样会漏掉case
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {

				int sum = nums[i] + nums[left] + nums[right];

				//根据sum的情况进行讨论
				if (sum == 0) {

					// List < Integer > tmp = new ArrayList < Integer > ();
					// tmp.add(nums[i]);
					// tmp.add(nums[left]);
					// tmp.add(nums[right]);
                    
                     list.add(Arrays.asList(nums[i],nums[left],nums[right]));

					// Collections.sort(tmp);
 

					//跳过left将要走的路上跟其相同的
					while (left<right && nums[left] == nums[left + 1]) {
						left++;
					}
					//跳过right将要走的路上相同的
					while (left<right && nums[right] == nums[right - 1]) {
						right--;
					}
                    
                    //不要忘记移动左右下标
                    left++;
                    right--;

				} else if (sum > 0) {
					right--;
				} else if (sum < 0) {
					left++;
				}
			}
		}

		return list;
	}
}






















