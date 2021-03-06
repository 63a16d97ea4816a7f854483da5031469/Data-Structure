
/*
 * 
https://leetcode.com/problems/rank-scores/

178. Rank Scores
Medium

690

112

Add to List

Share
SQL Schema
Write a SQL query to rank scores. If there is a tie between two scores, both should have the same ranking. Note that after a tie, the next ranking number should be the next consecutive integer value. In other words, there should be no "holes" between ranks.

+----+-------+
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
For example, given the above Scores table, your query should generate the following report (order by highest score):

+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+


12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




# https://nifannn.github.io/2017/10/27/SQL-Notes-Leetcode-178-Rank-Scores/

SELECT s.Score, COUNT(t.Score) AS 'Rank' FROM
(SELECT DISTINCT Score FROM Scores) AS t, Scores AS s
WHERE s.Score <= t.Score
GROUP BY s.Id, s.Score
ORDER BY s.Score DESC;

# SELECT s.Score, COUNT(t.Score) AS 'Rank' FROM (SELECT DISTINCT Score FROM Scores) AS t, Scores AS s WHERE s.Score <= t.Score GROUP BY s.Id, s.Score;

# {"headers": ["Score", "Rank"], "values": [[3.50, 4], [3.65, 3], [3.65, 3], [4.00, 1], [3.85, 2], [4.00, 1]]}

# SELECT s.Id, s.Score, t.Score FROM
# (SELECT DISTINCT Score FROM Scores) AS t, Scores AS s 
# WHERE s.Score <= t.Score 

# {"headers": ["Id", "Score", "Score"], "values": [[1, 3.50, 3.50], [1, 3.50, 3.65], [2, 3.65, 3.65], [6, 3.65, 3.65], [1, 3.50, 4.00], [2, 3.65, 4.00], [3, 4.00, 4.00], [4, 3.85, 4.00], [5, 4.00, 4.00], [6, 3.65, 4.00], [1, 3.50, 3.85], [2, 3.65, 3.85], [4, 3.85, 3.85], [6, 3.65, 3.85]]}



# SELECT s.Score, t.Score FROM
# (SELECT DISTINCT Score FROM Scores) AS t, Scores AS s
# WHERE s.Score <= t.Score;

# {"headers": ["Score", "Score"], "values": [[3.50, 3.50], [3.50, 3.65], [3.65, 3.65], [3.65, 3.65], [3.50, 4.00], [3.65, 4.00], [4.00, 4.00], [3.85, 4.00], [4.00, 4.00], [3.65, 4.00], [3.50, 3.85], [3.65, 3.85], [3.85, 3.85], [3.65, 3.85]]}













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
















