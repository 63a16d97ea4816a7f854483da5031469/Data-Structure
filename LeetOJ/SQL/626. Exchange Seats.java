
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
    }
}

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



Analysis
In order to exchange seats, we can exchange id and then order by id. If origin id is odd, add 1 as new id, otherwise minus 1 as new id. But if the table has odd number of records, the id of last record will not change. As a result, we need to count how many records the table has and store it in a temp table first:

1
(SELECT COUNT(*) AS cnt FROM seat) AS t
Then use IF() function to change id. If total number of records in the table is odd and id equals to the total number, do not change id and return origin id directly:

1
2
SELECT IF(cnt % 2 = 1 AND id = cnt, id, IF()) AS id, student FROM seat,
(SELECT COUNT(*) AS cnt FROM seat) AS t
If the table has even number of records or the id is the last one, check whether id is even or odd. If odd, add 1 as new id, otherwise minus 1 as new id:

1
2
SELECT IF(cnt % 2 = 1 AND id = cnt, id, IF(id % 2 = 1, id + 1, id - 1)) AS id, student FROM seat,
(SELECT COUNT(*) AS cnt FROM seat) AS t
Sort by id finally:

1
2
3
SELECT IF(cnt % 2 = 1 AND id = cnt, id, IF(id % 2 = 1, id + 1, id - 1)) AS id, student FROM seat,
(SELECT COUNT(*) AS cnt FROM seat) AS t
ORDER BY id;
Solution
1
2
3
SELECT IF(cnt % 2 = 1 AND id = cnt, id, IF(id % 2 = 1, id + 1, id - 1)) AS id, student FROM seat,
(SELECT COUNT(*) AS cnt FROM seat) AS t
ORDER BY id;


Link




















