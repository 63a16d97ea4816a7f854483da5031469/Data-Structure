
/*
 * 
link: 
https://leetcode-cn.com/problems/permutation-in-string/

2020-7-12 at 12:11 am

7567. 字符串的排列
难度
中等


给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

示例1:

输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").
 

示例2:

输入: s1= "ab" s2 = "eidboaoo"
输出: False
 

注意：

输入的字符串只包含小写字母
两个字符串的长度都在 [1, 10,000] 之间



对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++)
            s1map[s1.charAt(i) - 'a']++;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }
    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/permutation-in-string/solution/zi-fu-chuan-de-pai-lie-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





//构造滑动窗口：

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }
    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Arr=new int[26];
        for(int i=0;i<s1.length();i++){
            s1Arr[s1.charAt(i)-'a']++;
        }
        
        for(int i=0;i<=s2.length()-s1.length();i++){
            int[] s2Arr=new int[26];
            for(int j=0;j<s1.length();j++){
                s2Arr[s2.charAt(i+j)-'a']++;
            }
            if(isMatch(s1Arr,s2Arr)){
                return true;
            }
        }
        return false;
    }
    public boolean isMatch(int[] s1Arr, int[] s2Arr){
        for(int i=0;i<26;i++){
            if(s1Arr[i]!=s2Arr[i]) return false;
        }
        return true;
    }
}


// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/permutation-in-string/solution/zi-fu-chuan-de-pai-lie-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




// 为此，我们维护一个 
// count
// count 变量，该变量存储字符数（26个字母表中的数字），这些字符在 smap1
// s1 中具有相同的出现频率，当前窗口在 smap2 s2 中。当我们滑动窗口时，如果扣除最后一个元素并添加新元素导致任何字符的新频率匹配，我们将 count 递增1.如果不是，我们保持 
// count 完整。但是，如果添加频率相同的字符（添加和删除之前）相同的字符，现在会导致频率不匹配，这会通过递减相同的 
// count 变量来考虑。如果在移动窗口后，
// count 的计算结果为26，则表示所有字符的频率完全匹配。所以，我们立即返回一个True。

//优化：

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i])
                count++;
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r])
                count++;
            else if (s2map[r] == s1map[r] + 1) //对之前相等的，要减掉count
                count--;
            s2map[l]--;
            if (s2map[l] == s1map[l])
                count++;
            else if (s2map[l] == s1map[l] - 1) //对之前相等的，要减掉count
                count--;
        }
        return count == 26;
    }
}

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/permutation-in-string/solution/zi-fu-chuan-de-pai-lie-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。