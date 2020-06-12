
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/

17. Letter Combinations of a Phone Number
Medium

3311

376

Add to List

Share
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
29 March 2020 at 2.45pm - 3.13p
 * 
 */






class Solution {
	//2.45pm - 3.13pm (看完题解后，回忆书写)
	List < String > list = new ArrayList < String > ();
	String[] d = new String[] {
		"",
		"",
		"abc",
		"def",
		"ghi",
		"jkl",
		"mno",
		"pqrs",
		"tuv",
		"wxyz"
	};
	public List < String > letterCombinations(String digits) {

		//需要处理特殊输入，为空的时候
		if (digits.length() == 0) {
			return list;
		}

		findAll(digits, 0, "", "");
		return list;

	}

	void findAll(String digits, int index, String pass, String cpass) {

		pass += cpass;

		//结束条件 2
		if (pass.length() == digits.length()) {
			list.add(pass + "");
		}

		//结束条件
		if (index > digits.length() - 1) {
			return;
		}

		char digitalNumber = digits.charAt(index);

		String mapStr = d[Integer.parseInt(digitalNumber + "")];
		char[] arr = mapStr.toCharArray();
		for (char c: arr) {
			findAll(digits, index + 1, pass, c + "");
		}
	}

}



















