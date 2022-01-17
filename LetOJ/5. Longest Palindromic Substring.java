
/*
 * 
https://leetcode.com/problems/longest-palindromic-substring/


5. Longest Palindromic Substring
Medium

6202

503

Add to List

Share
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


这个方法最优：

class Solution {
    public String longestPalindrome(String s) {
        String max = "";
        for(int i=0;i<s.length();i++){
            String s1 = extend(s,i,i), s2 = extend(s,i,i+1); //s2 focuses on midpoint betweek 2 letters in case of even letters
            if(max.length() < Math.max(s1.length(),s2.length()))
                max = s1.length() > s2.length() ? s1 : s2;
        }
        return max;
    }
    
    private String extend(String s, int l, int r){

        while(l >= 0 && r < s.length()){
            if(s.charAt(l) != s.charAt(r))
                break;
            l--;r++;
        }
        return s.substring(l+1,r); //handle the extra decrement in the while loop
    }
}













class Solution {
    // 	作者：windliang
    // 链接：https://www.zhihu.com/question/37289584/answer/465656849
    // 来源：知乎
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); //从一个字符扩展
            int len2 = expandAroundCenter(s, i, i + 1); //从两个字符之间扩展
            int len = Math.max(len1, len2);
            //根据 i 和 len 求得字符串的相应下标
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    }


// 暴力破解法：

class Solution {
    //https://blog.csdn.net/tingting256/article/details/50449929
  /**对每一个字母，都查找最大的回文串的长度，left，right分别表示回文串的起始位置*/
	public String longestPalindrome(String s) {
        if(s.length()==0) return "";
		int start = 0, end = 0;
		int maxLen = 1;
		for (int i = 0; i < s.length(); i++) {
			int left = i;
			int right = i;
			while (left > -1 && right < s.length()
					&& s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			if (maxLen < right - left + 1) {
				maxLen = right - left + 1;
				start = left + 1;
				end = right - 1;
			}
			/**字符串长度为偶数*/
			left = i;
			right = i + 1;
			while (left > -1 && right < s.length()
					&& s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			if (maxLen < right - left + 1) {
				maxLen = right - left + 1;
				start = left + 1;
				end = right - 1;
			}
 
		}
		return s.substring(start, end + 1);
	}
}






动态规划解决此题
dp[i][j] 表示的是 i 到 j这段是不是回文子串，dp没什么好说的，能画出二维dp表，能搞清计算顺序就ok。 

    /**
     * 方法二: 动态规划
     */
    class Solution {
        
 // http://www.wld5.com/string/14290.html
            public String longestPalindrome(String s) {
                if(s == null || s.length() < 2) return s;
                boolean[][] dp = new boolean[s.length()][s.length()];
                int row = 0,col = 0;
                for(int i = s.length() - 2; i >= 0; i--){
                    for(int j = i + 1; j <= s.length() - 1; j++){
                        if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])){
                            dp[i][j] = true;
                            if(j - i + 1 >  col - row + 1){
                                row = i;
                                col = j;
                            }
                        }
        
                    }
                }
                return s.substring(row,col+1);
            }
        
        }












====> 有问题的解法：

class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        String tmpS=s;
        if(s.length()%2==0){
            s=tmpS.substring(0,tmpS.length()/2);
            s+="*";
            s+=tmpS.substring(tmpS.length()/2,tmpS.length());
        }
        System.out.println(s);
        int max=0;
        int maxIndex=0;
        for(int i=0;i<s.length();i++){
            int curr=0;
            for(int j=1;j<=s.length()/2;j++){
                
                if(i-j>=0&&i+j<=s.length()-1){
                    if((i-j)!=(i+j)&&s.charAt(i-j)==s.charAt(i+j)){
                        System.out.println(s.charAt(i-j)+" "+s.charAt(i+j));
                        curr++;
                                max=Math.max(curr,max);
                                if(max==curr){
                                    System.out.println(i+" "+j);
                                    maxIndex=i;
                                }
                    }
                }else{
                    break;
                }
            }
        }
     
        LinkedList<String> list=new LinkedList<String>();
        list.add(String.valueOf(s.charAt(maxIndex)));
        for(int i=1;i<=max;i++){
            list.addFirst(String.valueOf(s.charAt(maxIndex-i)));
            list.addLast(String.valueOf(s.charAt(maxIndex+i)));
        }
        StringBuffer sb=new StringBuffer();
        for(String tmp:list){
            sb.append(tmp);
        }
        return sb.toString().replace("*","");
    }
}

