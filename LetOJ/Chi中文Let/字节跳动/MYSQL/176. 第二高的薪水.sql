
/*
 * 
link: 


2020-7-1 at 8:33 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


// 方法二：使用 IFNULL 和 LIMIT 子句
// 解决 “NULL” 问题的另一种方法是使用 “IFNULL” 函数，如下所示。
// MySQL

SELECT
    IFNULL(
      (SELECT DISTINCT Salary
       FROM Employee
       ORDER BY Salary DESC
        LIMIT 1 OFFSET 1),
    NULL) AS SecondHighestSalary

作者：LeetCode
链接：https://leetcode-cn.com/problems/second-highest-salary/solution/di-er-gao-de-xin-shui-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/second-highest-salary/solution/di-er-gao-de-xin-shui-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// //在NUll的时候错误：
// // {"headers": {"Employee": ["Id", "Salary"]}, "rows": {"Employee": [[1, 100]]}}

// # Write your MySQL query statement below
// select Salary as SecondHighestSalary from Employee order by Salary DESC limit 1,1


// SELECT DISTINCT
//     Salary AS SecondHighestSalary
// FROM
//     Employee
// ORDER BY Salary DESC
// LIMIT 1 OFFSET 1
















