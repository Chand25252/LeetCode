package solutions;

/*
    编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
        +----+--------+
        | Id | Salary |
        +----+--------+
        | 1  | 100    |
        | 2  | 200    |
        | 3  | 300    |
        +----+--------+
    例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。
    如果不存在第二高的薪水，那么查询应返回 null。
        +---------------------+
        | SecondHighestSalary |
        +---------------------+
        | 200                 |
        +---------------------+
*/

/**
 * @author Chand
 * @date 2019-04-30 09:45:32
 */
public class Q176_Second_Highest_Salary {
    /*select max(salary) as SecondHighestSalary from Employee
    where salary <> (select max(salary) from Employee);*/
}
