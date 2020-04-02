
/*
 * 
https://leetcode.com/problems/word-ladder/


127. Word Ladder
Medium

2570

1030

Add to List

Share
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

31 March 2020 at 12:00 pm
 * 
 */


看题解写了一种方法，BFS的思路.很经典


class Solution {
    // 12.28pm-

    // 思路：这是一个搜索问题，每次遍历整个list，去选择字典中，可以只变一个字母的解，然后变成那个字母，去下一层，如果能够在下一层继续找到一个字母转换的自己，则继续下一层，如果下一层没有任何可以一个字母转换的，则返回，说明无解，如果有则继续尝试，直至找到endWord，搜索所有可能的解，如果全部搜索结束，则说明无解

     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0
				|| beginWord.length() != endWord.length())
			return 0;
         
		// 此题关键是去重，还有去除和beginWord，相同的单词
		Set<String> set = new HashSet<String>(wordList);
		if (set.contains(beginWord))
			set.remove(beginWord);
         
		Queue<String> wordQueue = new LinkedList<String>();
         
		int level = 1; // the start string already count for 1
		int curnum = 1;// the candidate num on current level
		int nextnum = 0;// counter for next level
		// 或者使用map记录层数
		// Map<String, Integer> map = new HashMap<String, Integer>();
		// map.put(beginWord, 1);
		wordQueue.add(beginWord);
 
		while (!wordQueue.isEmpty()) {
			String word = wordQueue.poll();
			curnum--;
			// int curLevel = map.get(word);
			for (int i = 0; i < word.length(); i++) {
				char[] wordunit = word.toCharArray();
				for (char j = 'a'; j <= 'z'; j++) {
					wordunit[i] = j;
					String temp = new String(wordunit);
 
					if (set.contains(temp)) {
						if (temp.equals(endWord))
							// return curLevel + 1;
							return level + 1;
						// map.put(temp, curLevel + 1);
						nextnum++;
						wordQueue.add(temp);
						set.remove(temp);
					}
				}
			}
			if (curnum == 0) {
				curnum = nextnum;
				nextnum = 0;
				level++;
			}
		}
		return 0;
	}
 

}







Time Limit Exceeded

"qa"
"sq"
["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"]

class Solution {
	//12.28pm-

	// 思路：这是一个搜索问题，每次遍历整个list，去选择字典中，可以只变一个字母的解，然后变成那个字母，去下一层，如果能够在下一层继续找到一个字母转换的自己，则继续下一层，如果下一层没有任何可以一个字母转换的，则返回，说明无解，如果有则继续尝试，直至找到endWord，搜索所有可能的解，如果全部搜索结束，则说明无解

    List<Integer> list=new ArrayList<Integer>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 如果不存在endword则不可能有解
        if (!wordList.contains(endWord))
            return 0;

        // "hot"
        // "dog"
        // ["hot","dog"]

        int[] used = new int[wordList.size()];

        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(beginWord)) {
                used[i] = 1;
            }
        }

        list.add(findPath(beginWord, endWord, beginWord, wordList, 0, used));

        int min=Integer.MAX_VALUE;

        for(int i=0;i<list.size();i++){
            // System.out.println(list.get(i));
            if(list.get(i)!=0){
                min=Math.min(min,list.get(i));
            }
        }

        return min!=Integer.MAX_VALUE?min:0;
    }

    int findPath(String beginWord, String endWord, String currWord, List<String> wordList, int count, int[] used) {

        // System.out.println(Arrays.toString(used));

        // if the first start curr string is equal to the existing work
        if (currWord.equals(endWord)) {
            count++;
            return count;
            // return count;
        }

        count++;

        // 找到这一层所有的一个字母可以转换到达的选择，然后遍历这些选择，进入下一层

        List<String> currList = new LinkedList<String>();
        for (int i = 0; i < wordList.size(); i++) {
            String loopWord = wordList.get(i);

            // 跳过已经使用过的字典里面的元素
            if (used[i] == 1)
                continue;

            if (isOnlyOneCharChange(currWord, loopWord)) {
                currList.add(loopWord);
            } else {
                // System.out.println(currWord + " " + loopWord + " over 1");
            }
        }

        // for (String tmp : currList) {
        //     System.out.println(tmp);
        // }

        // System.out.println(">>>>> " + currWord + " " + count);
        // System.out.println("***********************");

        // 如果没有任何一个word是一个字符改变能够到达的，结束
        if (currList.size() == 0) {
            // System.out.println(">>>>> 0 list");
            return 0;
        }

        // System.out.print(currList.size() + " " + count + " ");
        // 收集到该层所有的可能,并进行dfs遍历，继续下一层的这个逻辑
        for (int i = 0; i < currList.size(); i++) {
            // 跳过已经使用过的字典里面的元素

            String curr = currList.get(i);
            int tmp = wordList.indexOf(curr);

            if (used[tmp] == 1)
                continue;

            // 开始dfs的一些条件
            used[tmp] = 1;

            int newCount = findPath(beginWord, endWord, curr, wordList, count, used);
            
            if (newCount > 0) {
                list.add(newCount);
            }
            
            //回复状态
            
            used[tmp]=0;
            
            
        }

        // System.out.println("no result");

        return 0;

    }

    boolean isOnlyOneCharChange(String curr, String next) {
        int count = 0;
        for (int i = 0; i < curr.length(); i++) {

            // System.out.println("char: " + curr.charAt(i) + " " + next.charAt(i));

            if (curr.charAt(i) != next.charAt(i)) {
                count++;
                if (count > 1)
                    return false;
            }
        }
        return true;
    }


}



















