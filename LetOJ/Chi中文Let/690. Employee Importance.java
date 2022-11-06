
/*
 * 
link: https://leetcode.com/problems/employee-importance/description/


DATE: 2022-November-05
TIME: 22:49:35

690. Employee Importance
Medium
1.8K
1.3K
Companies
You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.

You are given an array of employees employees where:

employees[i].id is the ID of the ith employee.
employees[i].importance is the importance value of the ith employee.
employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.

 

Example 1:


Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
Output: 11
Explanation: Employee 1 has an importance value of 5 and has two direct subordinates: employee 2 and employee 3.
They both have an importance value of 3.
Thus, the total importance value of employee 1 is 5 + 3 + 3 = 11.
Example 2:


Input: employees = [[1,2,[5]],[5,-3,[]]], id = 5
Output: -3
Explanation: Employee 5 has an importance value of -3 and has no direct subordinates.
Thus, the total importance value of employee 5 is -3.
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/


/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// 使用递归
class Solution {
    HashMap<Integer,Employee> map=new HashMap<>();
    int sum=0;
    public int getImportance(List<Employee> employees, int id) {
        
        for(Employee tmp:employees){
            map.put(tmp.id,tmp);
        }
        // 在这里不能用new int[], 只能用new Integer[]
        List<Integer> list=Arrays.asList(new Integer[]{id});
        sum=findSum(list);
     
        return sum;
    }

    public int findSum(List<Integer> arr){
        int curr=0;
        for(int id:arr){
            Employee e=map.get(id);
            curr+=e.importance;
            List<Integer> subList=e.subordinates;
            curr+=findSum(subList);
        }
        return curr;
    }


}


// 错误,因为有很多种子list的可能性
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map=new HashMap<>();
        
        for(Employee tmp:employees){
            map.put(tmp.id,tmp);
        }

        Employee e=map.get(id);
        int sum=0;
        List<Integer> subList=e.subordinates;
        sum+=e.importance;
        for(int tmp:subList){
            Employee employee=map.get(tmp);
            if(employee!=null)
            sum+=employee.importance;
            List<Integer> extraList=employee.subordinates;
            for(int t:extraList){
                Employee te=map.get(t);
                if(te!=null){
                    sum+=te.importance;
                }
            }
        }
        return sum;
    }
}



















