package solutions;

/*
    编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。
        +----+--------+
        | Id | Salary |
        +----+--------+
        | 1  | 100    |
        | 2  | 200    |
        | 3  | 300    |
        +----+--------+
    例如上述 Employee 表，n = 2 时，应返回第二高的薪水 200。如果不存在第 n 高的薪水，那么查询应返回 null。
        +------------------------+
        | getNthHighestSalary(2) |
        +------------------------+
        | 200                    |
        +------------------------+
*/

/**
 * @author Chand
 * @date 2019-04-30 10:14:55
 */
public class Q177_Nth_Highest_Salary {
//    CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
//    BEGIN
//    set N = N - 1;
//    RETURN (
//      # Write your MySQL query statement below.
//            select t.Salary from (select distinct Salary from Employee) t order by t.Salary desc limit N, 1
//            );
//    END
}
