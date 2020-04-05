
/*
 * 
https://leetcode.com/problems/expressive-words/

809. Expressive Words
Medium

219

634

Add to List

Share
Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".

For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.

For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.

Given a list of query words, return the number of words that are stretchy. 

 

Example:
Input: 
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 

Notes:

0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.
S and all words in words consist only of lowercase letters

5 April 2020 at 3.32pm - 4.10pm
 * 
 */






顺序存储S的不同子串，匹配word的不同子串:

Runtime: 6 ms, faster than 17.67% of Java online submissions for Expressive Words.
Memory Usage: 39.8 MB, less than 5.88% of Java online submissions for Expressive Words.


class Solution {
   
//     S = "heeellooo"
//     words = ["hello", "hi", "helo"]

// list==>  h,eee,ll,ooo,


    public int expressiveWords(String S, String[] words) {
        
        //list: h, eee, ll, ooo
        ArrayList<String> list = new ArrayList<>();
        int i = 0, start = 0;
        for (; i < S.length() - 1; i++) {
            if (S.charAt(i) != S.charAt(i + 1)) {
                String s = S.substring(start, i + 1);
                list.add(s);
                start = i + 1;
            }
        }
        //add last string 
        list.add(S.substring(start, i + 1));
    
    
        int result = 0;
        for (String word : words) {
            boolean flag = true;
            int j = 0;

            //检查子串是否配对
            for (i = 0, start = 0; i < word.length() - 1; i++) {
    
                if (j > list.size()) {
                    flag = false;
                    break;
                }
                //如果相等，则继续前进，知道不等
                if (word.charAt(i) != word.charAt(i + 1)) {
                    String s = word.substring(start, i + 1);
                    if (list.get(j).indexOf(s) == -1) {
                        flag = false;
                        break;
                    }
    
                    //如果小于3，那么一定要全部相等，如果不等说明不行.
                    if (list.get(j).length() < 3 && (list.get(j).length() != s.length())) {
                        flag = false;
                        break;
                    }
                    //从不等的下一个位开始，其实就是跳到了下一个不一样片段的开始.
                    start = i + 1;
                    j++;
                }
            }
            
            
            if (flag) {
                String s = word.substring(start, i + 1);
                if (list.size() - 1 == j && // j equals index of list，
                        list.get(j).indexOf(s) != -1 && //s is substring of list's element
                        (list.get(j).length() >= 3 // 大于3，随便子串的长度是多少
                                || (list.get(j).length() == s.length() //小于，必须长度相等
                        ))) {
                    result++;
                }
            }
        }
        return result;
    }
    
    // 作者：maybrittnelson
    // 链接：https://leetcode-cn.com/problems/expressive-words/solution/lian-shi-shun-xu-cun-chu-sde-bu-tong-zi-chuan-pi-p/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 
}






比较相同字母组的长度：
我们首先将 S 拆分成若干组相同的字母，并存储每组字母的长度。例如当 S 为 abbcccddddaaaaa 时，可以得到 5 组字母，它们分别为 abcda，长度为 [1, 2, 3, 4, 5]。

对于 words 中的每个单词 word，如果它可以扩张得到 S，那么它必须和 S 有相同的字母组。对于每一组字母，假设 S 中有 c1 个，word 中有 c2 个，那么会有下面几种情况：

如果 c1 < c2，那么 word 不能扩张得到 S；

如果 c1 >= 3，那么只要添加 c1 - c2 个字母即可；

如果 c1 < 3，由于在扩张时至少需要添加到 3 个字母，所以此时不能添加字母，必须有 c1 == c2。

如果 word 的包含的字母组中的每个字母都满足上述情况，那么 word 可以扩张得到 S。

作者：LeetCode
链接：https://leetcode-cn.com/problems/expressive-words/solution/qing-gan-feng-fu-de-wen-zi-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class Solution {
    
    //这是一个分类讨论法，但是关键在于思路清晰，另外构造出了RLE结构
    
    public int expressiveWords(String S, String[] words) {
        RLE R = new RLE(S);
        int ans = 0;

        search: for (String word: words) {
            RLE R2 = new RLE(word);
            if (!R.key.equals(R2.key)) continue;
            for (int i = 0; i < R.counts.size(); ++i) {
                int c1 = R.counts.get(i);
                int c2 = R2.counts.get(i);
                if (c1 < 3 && c1 != c2 || c1 < c2)
                    continue search;
            }
            ans++;
        }
        return ans;
    }
}

class RLE {
    String key;
    List<Integer> counts;

    public RLE(String S) {
        StringBuilder sb = new StringBuilder();
        counts = new ArrayList();

        char[] ca = S.toCharArray();
        int N = ca.length;
        int prev = -1;
        for (int i = 0; i < N; ++i) {
            if (i == N-1 || ca[i] != ca[i+1]) {
                sb.append(ca[i]);
                counts.add(i - prev);
                prev = i;
            }
        }

        key = sb.toString();
    }
}

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/expressive-words/solution/qing-gan-feng-fu-de-wen-zi-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



"zz zzz yy yyy"
["zzyy","zy","zyy"]




错误答案：错在把问题想得太简单：错在，没想到压缩不唯一，因为压缩”失真了“（只能看到骨架，不能看到变形体）

zzzzzyyyyy (z,5) (y,5)
zzyy  (z,2)  (y,2)
zy   (z,1) (y,1)
zyy  (z,1) (y,2)


"zzzzzyyyyy"
["zzyy","zy","zyy"]

Output:
1
Expected:
3

class Solution {
    //3.32pm - 4.10pm
    //思路，DFS搜索
    //另一个思路，对S，以及给的word都进行压缩：将>=3个字母的character都压到一个，如果在压缩后，还能够匹配的，就说明是由word而产生的
    // hello
    public int expressiveWords(String S, String[] words) {
        int count=0;
        String newstr=removeDuplicated(S);
        for(String str:words){
            if(removeDuplicated(str).equals(newstr)){
                count++;
            }
        }
        // return 1;
        return count;
    }
    
    
    String removeDuplicated(String str){
        
        char[] arr=str.toCharArray();
        //hashSet 没有顺序
        // HashSet<Character> set=new HashSet<>();
        Stack<Character> stack=new Stack<Character>();
        int repcount=1;
        
        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }else{
                System.out.println(repcount+" "+(char)stack.peek()+" "+arr[i]);
                if((char)stack.peek()==arr[i]){
                    repcount++;
                    stack.push(arr[i]);
                }else if((char)stack.peek()!=arr[i]){
                    stack.push(arr[i]);
                    repcount=1;
                }
                 
                if((char)stack.peek()==arr[i] && repcount>=3){
                    //pop 2
            
                    stack.pop();
                    stack.pop();
                    repcount=1;
                }
                
            }
            
        }        
  
        String curr="";
        for(Character c:stack){
            curr+=c;
        }
        
        // System.out.println(curr);
        return curr;
    }
}




















