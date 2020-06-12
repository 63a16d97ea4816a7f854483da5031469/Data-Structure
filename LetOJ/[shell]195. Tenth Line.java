
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


// AC:
# Read from the file file.txt and output the tenth line to stdout.
awk '{if(NR == 10) print $0}' file.txt




解法一：

awk '{if(NR == 10) print $0}' file.txt
 

我们也可以用更简洁的写法来打印出第十行如下：



解法二：

awk 'NR == 10' file.txt
 

我们也可以使用流编辑工具sed来做，关于sed的讲解可以参见这个帖子。-n默认表示打印所有行，p限定了具体打印的行数：


解法三：

sed -n 10p file.txt



我们也可以使用tail和head关键字来打印，关于tail和head的用法详解请参见这个帖子。其中head表示从头开始打印，tail表示从结尾开始打印，-你表示根据文件行数进行打印，一些区别与联系请见下列例子：

tail -n 3 file.txt: 打印file文件的最后三行内容　　　　　　

tail -n +3 file.txt： 从file文件第三行开始打印所有内容

head -n 3 file.txt： 打印file文件的前三行

head -n -3 file.txt： 打印file文件除了最后三行的所有内容

至于竖杠|为管道命令，讲解参见这个帖子，用法: command 1 | command 2 他的功能是把第一个命令command1执行的结果作为command 2的输入传给command 2。了解了这些知识，那么下面一行命令就很好理解了，首先输入file文件从第十行开始的所有内容，然后将输出内容的第一行打印出来即为第十行：

 

解法四：

tail -n +10 file.txt | head -n 1
 

下面这种方法跟上面刚好相反，先输出file文件的前十行，然后从输出的第十行开始打印，那么也能正好打印第十行的内容：

 

解法五：

head -n 10 file.txt | tail -n +10
 







grep -oE '[a-z]+' words.txt | sort | uniq -c | sort -r | awk '{print $2" "$1}'


cat words.txt | tr -s ' ' '\n'| sort | uniq -c | sort -r | awk '{print $2, $1}'



