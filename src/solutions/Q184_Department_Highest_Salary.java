package solutions;

/*
    Employee 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id。
        +----+-------+--------+--------------+
        | Id | Name  | Salary | DepartmentId |
        +----+-------+--------+--------------+
        | 1  | Joe   | 70000  | 1            |
        | 2  | Henry | 80000  | 2            |
        | 3  | Sam   | 60000  | 2            |
        | 4  | Max   | 90000  | 1            |
        +----+-------+--------+--------------+
    Department 表包含公司所有部门的信息。
        +----+----------+
        | Id | Name     |
        +----+----------+
        | 1  | IT       |
        | 2  | Sales    |
        +----+----------+
    编写一个 SQL 查询，找出每个部门工资最高的员工。
    例如，根据上述给定的表格，Max 在 IT 部门有最高工资，Henry 在 Sales 部门有最高工资。
        +------------+----------+--------+
        | Department | Employee | Salary |
        +------------+----------+--------+
        | IT         | Max      | 90000  |
        | Sales      | Henry    | 80000  |
        +------------+----------+--------+
*/

/**
 * @author Chand
 * @date 2019-04-30 15:05:32
 */
public class Q184_Department_Highest_Salary {
//    select t2.Name as `Department`, t1.Name as `Employee`, t1.Salary as `Salary`
//    from Employee t1
//    inner join Department t2 on t1.DepartmentId = t2.Id
//    where t1.Salary = (select Max(Salary) from Employee where DepartmentId = t2.Id);
}
