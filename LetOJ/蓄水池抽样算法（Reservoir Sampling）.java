
/*
 * 
https://www.jianshu.com/p/7a9ea6ece2af



6 June 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


 * 
 */




// 蓄水池抽样算法（Reservoir Sampling）


int[] reservoir = new int[m];

// init
for (int i = 0; i < reservoir.length; i++)
{
    reservoir[i] = dataStream[i];
}

for (int i = m; i < dataStream.length; i++)
{
    // 随机获得一个[0, i]内的随机整数
    int d = rand.nextInt(i + 1);
    // 如果随机整数落在[0, m-1]范围内，则替换蓄水池中的元素
    if (d < m)
    {
        reservoir[d] = dataStream[i];
    }
}







/*

题目：查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩

 

这里提到平均分 ，要用到avg  按照学生分组，再求平均分，这里应该是考察group by 与聚合函数的使用  大于60分应该是按照分组后筛选的结果要用having

group by 与聚合函数  having 的使用 上篇博客已经写过

于是写的sql于下：

   SELECT studentid,AVG(score) AS a FROM student_score GROUP BY studentid HAVING a>60

要查询完整的学生信息，应该是要与学生表student 进行join：

 

完整的sql:

 SELECT b.id, b.stdentname,a FROM student AS b JOIN
      (SELECT studentid,AVG(score) AS a FROM student_score GROUP BY studentid HAVING a>60)c
ON b.id = c.studentid


*/







