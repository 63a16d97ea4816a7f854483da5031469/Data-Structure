
/*
 * 
https://leetcode.com/problems/exchange-seats/


626. Exchange Seats
Medium

282

226

Add to List

Share
SQL Schema
Mary is a teacher in a middle school and she has a table seat storing students' names and their corresponding seat ids.

The column id is continuous increment.
 

Mary wants to change seats for the adjacent students.
 

Can you write a SQL query to output the result for Mary?
 

+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Abbot   |
|    2    | Doris   |
|    3    | Emerson |
|    4    | Green   |
|    5    | Jeames  |
+---------+---------+
For the sample input, the output is:
 

+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Doris   |
|    2    | Abbot   |
|    3    | Green   |
|    4    | Emerson |
|    5    | Jeames  |
+---------+---------+
Note:
If the number of students is odd, there is no need to change the last one's seat.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



Analysis
For a score, its rank is the number of scores in the Scores table without duplicates that is larger than or equal to the score. Take above table as example, there are six scores, 3.50, 3.65, 4.00, 3.85, 4.00 and 3.65. The distinct scores are 3.50, 3.65, 3.85 and 4.00. For a score of 4.00, only 4.00 ≥ 4.00, so the rank is 1. Similarly, for a score of 3.65, 4.00 ≥ 3.65, 3.85 ≥ 3.65, 3.65 ≥ 3.65, therefore, the rank is 3.

First, we need to get all distinct scores:

1
SELECT DISTINCT Score FROM Scores;
Assuming that we call the table of distinct scores t, next we can fully join t and Scores and filter scores in t that is larger than or equal to each score in Scores:

1
2
3
SELECT s.Score, t.Score FROM
(SELECT DISTINCT Score FROM Scores) AS t, Scores AS s
WHERE s.Score <= t.Score;
For each score in Scores, count how many scores in t are larger than or equal to it:

1
2
3
4
SELECT s.Score, COUNT(t.Score) AS Rank FROM
(SELECT DISTINCT Score FROM Scores) AS t, Scores AS s
WHERE s.Score <= t.Score
GROUP BY s.Id, s.Score;
Finally, sort by score in descending order:

1
2
3
4
5
SELECT s.Score, COUNT(t.Score) AS Rank FROM
(SELECT DISTINCT Score FROM Scores) AS t, Scores AS s
WHERE s.Score <= t.Score
GROUP BY s.Id, s.Score
ORDER BY s.Score DESC;
Solution
1
2
3
4
5
SELECT s.Score, COUNT(t.Score) AS Rank FROM
(SELECT DISTINCT Score FROM Scores) AS t, Scores AS s
WHERE s.Score <= t.Score
GROUP BY s.Id, s.Score
ORDER BY s.Score DESC;
Link



















