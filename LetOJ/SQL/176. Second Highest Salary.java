
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


176. Second Highest Salary
Easy

711

393

Add to List

Share
SQL Schema
Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */

// Solution 2:

SELECT 
(SELECT DISTINCT Salary FROM Employee 
 ORDER BY Salary DESC LIMIT 1 OFFSET 1) 
AS SecondHighestSalary;


// Accepted
// Runtime: 117 ms
Your input
{"headers": {"Employee": ["Id", "Salary"]}, "rows": {"Employee": [[1, 100]]}}
Output
{"headers": ["SecondHighestSalary"], "values": [[null]]}
Diff
Expected
{"headers": ["SecondHighestSalary"], "values": [[null]]}


SELECT MAX(Salary) AS SecondHighestSalary FROM Employee 
WHERE Salary < (SELECT MAX(Salary) FROM Employee);




Your input
{"headers": {"Employee": ["Id", "Salary"]}, "rows": {"Employee": [[1, 100]]}}
Output
{"headers": ["SecondHighestSalary"], "values": []}
Diff
Expected
{"headers": ["SecondHighestSalary"], "values": [[null]]}


# Write your MySQL query statement below

select Salary as SecondHighestSalary from Employee 
where Salary < (select Max(Salary) from Employee) 
order by Salary DESC 
limit 1;

















