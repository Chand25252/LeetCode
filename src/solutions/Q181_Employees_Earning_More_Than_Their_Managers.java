package solutions;

/*
    Employee 表包含所有员工，他们的经理也属于员工。每个员工都有一个 Id，此外还有一列对应员工的经理的 Id。
        +----+-------+--------+-----------+
        | Id | Name  | Salary | ManagerId |
        +----+-------+--------+-----------+
        | 1  | Joe   | 70000  | 3         |
        | 2  | Henry | 80000  | 4         |
        | 3  | Sam   | 60000  | NULL      |
        | 4  | Max   | 90000  | NULL      |
        +----+-------+--------+-----------+
    给定 Employee 表，编写一个 SQL 查询，该查询可以获取收入超过他们经理的员工的姓名。
    在上面的表格中，Joe 是唯一一个收入超过他的经理的员工。
        +----------+
        | Employee |
        +----------+
        | Joe      |
        +----------+
*/

/**
 * @author Chand
 * @date 2019-04-30 14:43:16
 */
public class Q181_Employees_Earning_More_Than_Their_Managers {
//    select t.Name as `Employee` from Employee t
//    where t.ManagerId is not null
//    and t.Salary > (select Salary from Employee where Id = t.ManagerId);
}
