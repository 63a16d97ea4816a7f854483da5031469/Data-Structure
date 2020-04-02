
/*
 * 
https://leetcode.com/problems/word-ladder/


717. 1-bit and 2-bit Characters
Easy

351

904

Add to List

Share
We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).

Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.

Example 1:

Input: 
bits = [1, 0, 0]
Output: True
Explanation: 
The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
Example 2:

Input: 
bits = [1, 1, 1, 0]
Output: False
Explanation: 
The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
Note:

1 <= len(bits) <= 1000.
bits[i] is always 0 or 1.

31 March 2020 at 12:00 pm
 * 
 */












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



















