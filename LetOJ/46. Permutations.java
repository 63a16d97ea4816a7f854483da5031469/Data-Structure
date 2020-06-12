
/*
 * 
https://leetcode.com/problems/permutations/


46. Permutations
Medium

3228

95

Add to List

Share
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

29 March 2020 at 4.26pm - 4.46pm
 * 
 */






class Solution {

	//4.26pm - 4.46pm
	List < List < Integer >> list = new ArrayList < List < Integer >> ();

	public List < List < Integer >> permute(int[] nums) {

		findPermute(nums, 0, nums.length - 1);

		return list;
	}

	void findPermute(int[] nums, int start, int to) {

		//结束超过的case
		if (start > to) {
			return;
		}

		//结束条件
		if (start == to) {
			List < Integer > pass = new ArrayList < Integer > ();

			for (int tmp: nums) {
				pass.add(tmp);
			}
			list.add(pass);
		}

		//dfs的外层遍历是为了，完成所有的扫描
		for (int i = start; i < nums.length; i++) {

			swap(nums, start, i);
			//内层的递归要往下一状态延伸，dfs的核心
			findPermute(nums, start + 1, to);
			swap(nums, start, i);
		}

	}

	void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}


















