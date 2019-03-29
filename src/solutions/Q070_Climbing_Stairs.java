package solutions;

/*
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    注意：给定 n 是一个正整数。
*/

/**
 * @author Chand
 * @date 2019-03-29 17:55:20
 */
public class Q070_Climbing_Stairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int result = 2;
        int previous = 1;
        for (int i = 3; i < n; i++) {
            int temp = result;
            result = result + previous;
            previous = temp;
        }
        return result;
    }
}
