package solutions;

/*
    给定一个整数 n，返回 n! 结果尾数中零的数量。
    说明: 你算法的时间复杂度应为 O(log n) 。
*/

/**
 * @author Chand
 * @date 2019-04-29 15:50:43
 */
public class Q172_Factorial_Trailing_Zeroes {
    public int trailingZeroes(int n) {
        int result = 0;
        while (n >= 5) {
            n = n / 5;
            result += n;
        }
        return result;
    }
}
