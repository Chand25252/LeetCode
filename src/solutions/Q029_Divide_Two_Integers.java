package solutions;


/*
    给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
    返回被除数 dividend 除以除数 divisor 得到的商。
    说明:
        被除数和除数均为 32 位有符号整数。
        除数不为 0。
        假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2的31次方,  2的31次方 − 1]。
        本题中，如果除法结果溢出，则返回 2的31次方 − 1。
*/

/**
 * @author Chand
 * @date 2019-03-19 11:18:15
 */
public class Q029_Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
        int flag = 1;
        boolean mark = false;
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : 0 - dividend;
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            dividend++;
            mark = true;
        }
        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            flag = 1;
        } else {
            flag = -1;
        }
        dividend = dividend < 0 ? 0 - dividend : dividend;
        divisor = divisor < 0 ? 0 - divisor : divisor;
        int result = 0;
        while (dividend >= divisor) {
            dividend = dividend - divisor;
            result++;
        }
        if (mark && dividend + 1 == divisor) {
            result++;
        }
        return flag == 1 ? result : 0 - result;
    }
}
