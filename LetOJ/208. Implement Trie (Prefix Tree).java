
/*
 * 
https://leetcode.com/problems/implement-trie-prefix-tree/


208. Implement Trie (Prefix Tree)
Medium

2636

45

Add to List

Share
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




//最精简版本：
class Trie {
    private Trie[] children = new Trie[26];
    boolean isEnd = false;
    public Trie() {}
    
    public void insert(String word) {
        Trie tmp = this;
        for (char i : word.toCharArray()) {
            if (tmp.children[i-'a'] == null) {
                tmp.children[i-'a'] = new Trie();
            }
            tmp = tmp.children[i-'a'];
        }
        tmp.isEnd = true;
    }
    public boolean search(String word) {
        Trie tmp = this;
        for (char i : word.toCharArray()) {
            if (tmp.children[i-'a'] == null) {
                return false;
            }
            tmp = tmp.children[i-'a'];
        }
        return tmp.isEnd ? true : false;
    }
    public boolean startsWith(String prefix) {
        Trie tmp = this;
        for (char i : prefix.toCharArray()) {
            if (tmp.children[i-'a'] == null) {
                return false;
            }
            tmp = tmp.children[i-'a'];
        }
        return true;
    }
}

// 作者：Guilong
// 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/jing-jian-javashi-xian-by-guilong/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。







// https://blog.csdn.net/weixin_37608065/article/details/69803190
class TrieNode
{
    TrieNode[] children = new TrieNode[26];
    boolean mark;
    char c;
    public TrieNode(){}
    public TrieNode(char c)
    {
        this.c = c;
    }
}

public class Trie
{
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() 
    {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) 
    {
        TrieNode p = root;
        for(int i=0; i<word.length(); ++i)
        {
            char c = word.charAt(i);
            if(p.children[c-'a']==null)
                p.children[c-'a'] = new TrieNode(c);
            p = p.children[c-'a'];
        }
        p.mark = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) 
    {
        TrieNode p = root;
        for(int i=0; i<word.length(); ++i)
        {
            char c = word.charAt(i);
            if(p.children[c-'a']==null)
                return false;
            p = p.children[c-'a'];
        }
        return p.mark;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) 
    {
        TrieNode p = root;
        for(int i=0; i<prefix.length(); ++i)
        {
            char c = prefix.charAt(i);
            p = p.children[c-'a'];
            if(p==null)
                return false;
        }
        return true;
    }
}

/**
* Your Trie object will be instantiated and called as such:
* Trie obj = new Trie();
* obj.insert(word);
* boolean param_2 = obj.search(word);
* boolean param_3 = obj.startsWith(prefix);
*/














// http://www.noteanddata.com/leetcode-208-Implement-Trie-Prefix-Tree-java-solution-note.html


class Trie {
    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node(' ', false);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(null == node.children[index]) {
                node.children[index] = new Node(ch, false);
            }
            node = node.children[index];

            if(i == word.length()-1) {
                node.isend = true;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(null == node.children[index]) {
                return false;
            }
            node = node.children[index];
        }
        return node.isend;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i = 0; i < prefix.length(); ++i) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if(null == node.children[index]) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
    
    static class Node {
        private char ch;
        private boolean isend;
        private Node[] children;
        public Node(char ch, boolean isend) {
            this.ch = ch;
            this.isend = isend;
            this.children = new Node[26];
        }
    }
}

