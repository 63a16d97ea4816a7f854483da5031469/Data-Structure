
/*
 * 
https://leetcode.com/problems/valid-phone-numbers/

193. Valid Phone Numbers
Easy

151

375

Add to List

Share
Given a text file file.txt that contains list of phone numbers (one per line), write a one liner bash script to print all valid phone numbers.

You may assume that a valid phone number must appear in one of the following two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx. (x means a digit)

You may also assume each line in the text file must not contain leading or trailing white spaces.

Example:

Assume that file.txt has the following content:

987-123-4567
123 456 7890
(123) 456-7890
Your script should output the following valid phone numbers:

987-123-4567
(123) 456-7890

6 June 2020 at 11:56 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




这道题让我们验证数字串是否为正确的电话号码的格式，而且规定了正确的格式只有两种(xxx) xxx-xxxx or xxx-xxx-xxxx，那么我们可以看出来区别就是在前几个字符，而后八个字符都相同。这题有多种解法，我们首先来看使用awk命令的解法，关于awk的介绍可以参见这个帖子。这道题是难点是如何写匹配的正则表达式，关于Bash脚本的正则表达式讲解请参见这个贴子。那么首先来看‘/.../'表示中间的是要匹配的正则表达式，然后脱字符^匹配一行的开头，美元符$在正则表达式中匹配行尾，然后再看中间的部分，[0-9]{3}表示匹配三个数字，圆括号括起一组正则表达式. 它和"|"操作符或在用expr进行子字符串提取(substring extraction)一起使用很有用。那么([0-9]{3}-|[0−9]3就可以理解了，它匹配了xxx-和(xxx) 这两种形式的字符串，然后后面的就好理解了，匹配xxx-xxxx这样的字符串，参见代码如下：


解法一:

awk '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/' file.txt
 

下面来看使用sed命令的解法，关于sed的讲解可以参见这个帖子。那么我们先来看后面的两个参数，-n表示关闭默认输出，默认将自动打印所有行，这样就不会打印出不符合要求的数字串了。-r表示支持扩展正则+ ? () {} |。后面的正则表达式和上面都相同，就是后面多了一个p，在用sed时，p和-n合用，表示打印某一行，这样才能把符合要求的行打印出来：

 

解法二：AC

sed -n -r '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/p' file.txt
 

再来看使用grep命令的做法，关于grep的讲解可以参见这个帖子。我没有查到那个-P参数的用法，有没有大神来点拨一下，后面的正则表达式思路根上面的相同，只不过用d{3}来表示[0-9]{3}，道理都一样，参见代码如下：

 

解法三：

grep -P '^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$' file.txt




















