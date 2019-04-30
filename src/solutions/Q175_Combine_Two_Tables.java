package solutions;

/*
    表1: Person
        +-------------+---------+
        | 列名         | 类型     |
        +-------------+---------+
        | PersonId    | int     |
        | FirstName   | varchar |
        | LastName    | varchar |
        +-------------+---------+
        PersonId 是上表主键
    表2: Address
        +-------------+---------+
        | 列名         | 类型    |
        +-------------+---------+
        | AddressId   | int     |
        | PersonId    | int     |
        | City        | varchar |
        | State       | varchar |
        +-------------+---------+
        AddressId 是上表主键
    编写一个 SQL 查询，满足条件：
        无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：
        FirstName, LastName, City, State
*/

/**
 * @author Chand
 * @date 2019-04-30 09:41:00
 */
public class Q175_Combine_Two_Tables {
//    select t1.FirstName, t1.LastName, t2.City, t2.State
//    from Person t1
//    left join Address t2 on t1.PersonId = t2.PersonId;
}
