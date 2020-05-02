
/*
 * 
https://leetcode.com/problems/consecutive-numbers/

180. Consecutive Numbers
Medium

391

93

Add to List

Share
SQL Schema
Write a SQL query to find all numbers that appear at least three times consecutively.

+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.

+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+

2 May 2020 at 4.24 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :
这道题目一看是 at least 3 容易想错为使用 group by Having count(*)>3


 * 
 */




SELECT DISTINCT l1.Num AS ConsecutiveNums FROM
Logs AS l1, Logs AS l2, Logs AS l3
WHERE l1.Num = l2.Num AND l2.Num = l3.Num AND
l1.Id = l2.Id - 1 AND l2.Id = l3.Id - 1;



// 不可以删掉 Distinct,如果删掉会出现下面的错误:


// Wrong Answer
// Details 
// Input
// {"headers": {"Logs": ["Id", "Num"]}, "rows": {"Logs": [[1, 3], [2, 3], [3, 3], [4, 3]]}}
// Output
// {"headers": ["ConsecutiveNums"], "values": [[3], [3]]}
// Expected
// {"headers":["ConsecutiveNums"],"values":[[3]]}














