
/*
 * 

https://leetcode.com/problems/letter-combinations-of-a-phone-number/

 17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].


21 Feb 2021 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


 * 
 */


class Solution {
	List < String > result = new ArrayList < String > ();
	String[] mapArr = new String[] {
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
		if (digits == null || digits.length() == 0) {
			return result;
		}
		findAll(digits, 0, "", "");
		return result;
	}
	public void findAll(String digits, int index, String wholeStr, String nextStr) {
		wholeStr += nextStr;
		//结束条件 加入到最终结果集合
		if (wholeStr.length() == digits.length()) {
			result.add(wholeStr);
		}
		//防止超过边界
		if (index > digits.length() - 1) {
			return;
		}
		String curr = digits.charAt(index) + "";
		String word = mapArr[Integer.parseInt(curr)];
		for (int i = 0; i < word.length(); i++) {
			findAll(digits, index + 1, wholeStr, word.charAt(i) + "");
		}
	}
}


class Solution {
	List < String > result = new ArrayList < String > ();
	String[] mapArr = new String[] {
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
		if (digits == null || digits.length() == 0) {
			return result;
		}
		findAll(digits, 0, "");
		return result;
	}
	public void findAll(String digits, int index, String wholeStr) {
		
		//结束条件 加入到最终结果集合
		if (wholeStr.length() == digits.length()) {
			result.add(wholeStr);
		}
		//防止超过边界
		if (index > digits.length() - 1) {
			return;
		}
		String curr = digits.charAt(index) + "";
		String word = mapArr[Integer.parseInt(curr)];
		for (int i = 0; i < word.length(); i++) {
			findAll(digits, index + 1, wholeStr +word.charAt(i));
		}
	}
}



class Solution {
    HashMap<Integer, String> map;
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        dfs(digits, 0, new StringBuilder(), ans);
        return ans;
    }
    
    private void dfs(String digits, int i, StringBuilder sb, List<String> ans){
        if(i == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(i) - '0');
        for(int j = 0; j < letters.length(); j++){
            sb.append(letters.charAt(j));
            dfs(digits, i+1, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}



class Solution {
    HashMap<Integer, String> map;
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        dfs(digits, 0, new StringBuilder(), ans);
        return ans;
    }
    
    private void dfs(String digits, int i, StringBuilder sb, List<String> ans){
        if(i == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(i) - 48);
        for(int j = 0; j < letters.length(); j++){
            sb.append(letters.charAt(j));
            dfs(digits, i+1, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}











