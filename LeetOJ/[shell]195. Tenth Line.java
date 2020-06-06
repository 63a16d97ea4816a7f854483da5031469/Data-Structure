
/*
 * 
https://leetcode.com/problems/tenth-line/


195. Tenth Line
Easy

163

184

Add to List

Share
Given a text file file.txt, print just the 10th line of the file.

Example:

Assume that file.txt has the following content:

Line 1
Line 2
Line 3
Line 4
Line 5
Line 6
Line 7
Line 8
Line 9
Line 10
Your script should output the tenth line, which is:

Line 10
Note:
1. If the file contains less than 10 lines, what should you output?
2. There's at least three different solutions. Try to explore all possibilities.

6 June 2020 at 11:50 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



# Read from the file file.txt and output the tenth line to stdout.
awk '{if(NR == 10) print $0}' file.txt




















