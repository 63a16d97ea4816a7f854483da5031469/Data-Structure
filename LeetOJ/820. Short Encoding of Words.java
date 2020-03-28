
/*
 * 
https://leetcode.com/problems/short-encoding-of-words/


820. Short Encoding of Words
Medium

217

55

Add to List

Share
Given a list of words, we may encode it by writing a reference string S and a list of indexes A.

For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].

Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.

What is the length of the shortest reference string S possible that encodes the given words?

Example:

Input: words = ["time", "me", "bell"]
Output: 10
Explanation: S = "time#bell#" and indexes = [0, 2, 5].
 

Note:

1 <= words.length <= 2000.
1 <= words[i].length <= 7.
Each word has only lowercase letters.

28 March 2020 at 8:33:31 pm
 * 
 */




class Solution {
    //4.04pm - 4.16
    /*
    如果只有一个单词，就是特例，这个特例直接返回单词长度加#就可以了
    
    如果有多个单词，
    
    有一个特殊情况就是，某个单词可能是前面已经压缩单词的子集，这种情况，要能区分的话，要所有集合长度小于这个单词子集的index的长度，例如2要大于所有#集合长度，否则你无法区分是从集合中recover还是从字母中recover
    
    */
    
    //看了题解，这个题目的关键是，如果有重复的部分，要去掉重复的单词，然后按照正常的计算长度的方法来解就可以了，为了提高效率使用了hashSet，在开始的阶段去重了一下。
    
    public int minimumLengthEncoding(String[] words) {
        
        HashSet<String> set=new HashSet(Arrays.asList(words));
        
        for(String word:words){
            for(int i=1;i<word.length();i++){
                set.remove(word.substring(i));
            }
        }
        
        int ans=0;
        for(Iterator<String> it=set.iterator();it.hasNext();){
            String word=it.next();
            ans+=word.length()+1;
        }
        
        return ans;
    }
}




















