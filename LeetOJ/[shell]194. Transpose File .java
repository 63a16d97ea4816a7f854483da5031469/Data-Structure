
/*
 * 
https://leetcode.com/problems/transpose-file/


194. Transpose File
Medium

64

174

Add to List

Share
Given a text file file.txt, transpose its content.

You may assume that each row has the same number of columns and each field is separated by the ' ' character.

Example:

If file.txt has the following content:

name age
alice 21
ryan 30
Output the following:

name alice ryan
age 21 30

6 June 2020 at 12:02 am


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


 * 
 */



# Read from the file file.txt and print its transposed content to stdout.
awk '{
    for (i = 1; i <= NF; ++i) {
        if (NR == 1) s[i] = $i;
        else s[i] = s[i] " " $i;
    }
} END {
    for (i = 1; s[i] != ""; ++i) {
        print s[i];
    }
}' file.txt
// # ————————————————
// # 版权声明：本文为CSDN博主「繁城落叶」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// # 原文链接：https://blog.csdn.net/Leafage_M/article/details/77917726




















