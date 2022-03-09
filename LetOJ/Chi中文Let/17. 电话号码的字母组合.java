
/*
 * 
link: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/

17. 电话号码的字母组合

17. 电话号码的字母组合
难度
中等

1688





给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



 

示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]
 

提示：

0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。

2022-01-17 at 19:04
 

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode-solutio/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



import java.util.ArrayList;
import java.util.List;

public class Solution17_1 {

    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<String>();
        if(digits.equals(""))
            return res;

        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s){

        if(index == digits.length()){
            res.add(s);
            return;
        }

        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for(int i = 0 ; i < letters.length() ; i ++){
            findCombination(digits, index+1, s + letters.charAt(i));
        }

        return;
    }

}

// 作者：li-xin-lei
// 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/leetcode-17-letter-combinations-of-a-phone-number-/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




class Solution {
    String[] mappingArr=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> result=null;
    public List<String> letterCombinations(String digits) {
        result=new ArrayList<String>();
        if(digits.equals("")) return result;
        findAll(digits, 0, "");
        return result;
    }
    public void findAll(String digits, int index, String s){
        if(index==digits.length()){
            result.add(s);
            return;
        }
        Character c=digits.charAt(index);
        int mapIndex=Integer.parseInt(c+"");
        String mapped=mappingArr[mapIndex];
        for(int i=0;i<mapped.length();i++){
            findAll(digits,index+1,s+mapped.charAt(i));
        }
    }
}




class Solution {
    Map<String, String[]> map = new HashMap<>(){{
        put("2", new String[]{"a", "b", "c"});
        put("3", new String[]{"d", "e", "f"});
        put("4", new String[]{"g", "h", "i"});
        put("5", new String[]{"j", "k", "l"});
        put("6", new String[]{"m", "n", "o"});
        put("7", new String[]{"p", "q", "r", "s"});
        put("8", new String[]{"t", "u", "v"});
        put("9", new String[]{"w", "x", "y", "z"});
    }};
    public List<String> letterCombinations(String ds) {
        int n = ds.length();
        List<String> ans = new ArrayList<>();
        if (n == 0) return ans;
        StringBuilder sb = new StringBuilder();
        dfs(ds, 0, n, sb, ans);
        return ans;
    }
    void dfs(String ds, int i, int n, StringBuilder sb, List<String> ans) {
        if (i == n) {
            ans.add(sb.toString());
            return;
        } 
        String key = ds.substring(i, i + 1);
        String[] all = map.get(key);
        for (String item : all) {
            sb.append(item);
            dfs(ds, i + 1, n, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
            //或者 sb.delete(sb.toString().length()-1,sb.toString().length());
        }
    }
}

// 作者：AC_OIer
// 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/shua-chuan-lc-dfs-hui-su-jie-fa-by-ac_oi-qa02/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。







