package solutions;

/*
    实现 pow(x, n) ，即计算 x 的 n 次幂函数。
    说明:
        -100.0 < x < 100.0
        n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
*/

/**
 * @author Chand
 * @date 2019-03-25 16:14:57
 */
public class Q050_Pow_x_n {
    public double myPow(double x, int n) {
        double result = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if ((i & 1) == 1) {
                result *= x;
            }
            x *= x;
        }
        return n > 0 ? result : 1 / result;
    }
}
