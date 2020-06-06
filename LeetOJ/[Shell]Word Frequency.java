
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/

192. Word Frequency
Medium

200

137

Add to List

Share
Write a bash script to calculate the frequency of each word in a text file words.txt.

For simplicity sake, you may assume:

words.txt contains only lowercase characters and space ' ' characters.
Each word must consist of lowercase characters only.
Words are separated by one or more whitespace characters.
Example:

Assume that words.txt has the following content:

the day is sunny the the
the sunny is is
Your script should output the following, sorted by descending frequency:

the 4
is 3
sunny 2
day 1
Note:

Don't worry about handling ties, it is guaranteed that each word's frequency count is unique.
Could you write it in one-line using Unix pipes?

6 June 2020 at 11:55 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



# Read from the file words.txt and output the word frequency list to stdout.
awk '{
    for (i = 1; i <= NF; ++i) ++s[$i];
} END {
    for (i in s) print i, s[i];
}' words.txt | sort -nr -k 2




grep -oE '[a-z]+' words.txt | sort | uniq -c | sort -r | awk '{print $2" "$1}'


cat words.txt | tr -s ' ' '\n'| sort | uniq -c | sort -r | awk '{print $2, $1}'







解法一：

grep -oE '[a-z]+' words.txt | sort | uniq -c | sort -nr | awk '{print $2" "$1}' 
 

 

下面这种方法用的关键字是tr命令，该命令主要用来进行字符替换或者大小写替换，详解请参见这个帖子。后面紧跟的-s参数表示如果发现连续的字符，就把它们缩减为1个，而后面的‘ ’和‘\n'就是空格和回车，意思是把所有的空格都换成回车，那么第一段命令tr -s ' ' '\n' < words.txt 就好理解了，将单词之间的空格都换成回车，跟上面的第一段实现的作用相同，后面就完全一样了，参见上面的讲解：

 

解法二：

tr -s ' ' '\n' < words.txt | sort | uniq -c | sort -nr | awk '{print $2, $1}'
 

 

下面这种方法就没有用管道命令进行一行写法了，而是使用了强大的文本分析工具awk进行写类C的代码来实现，这种写法在之前的那道Transpose File已经讲解过了，这里就不多说了，最后要注意的是sort命令的参数-nr -k 2表示按第二列的降序数值排列：

 

解法三：

awk '{
    for (i = 1; i <= NF; ++i) ++s[$i];
} END {
    for (i in s) print i, s[i];
}' words.txt | sort -nr -k 2
 









