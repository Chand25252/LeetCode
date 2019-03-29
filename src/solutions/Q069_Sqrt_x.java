package solutions;

/*
    实现 int sqrt(int x) 函数。
    计算并返回 x 的平方根，其中 x 是非负整数。
    由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
*/

/**
 * @author Chand
 * @date 2019-03-29 17:35:59
 */
public class Q069_Sqrt_x {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        if (x == 2) {
            return 1;
        }
        int left = 0;
        int right = x;
        while(left < right) {
            int mid = (left + right) / 2;
            if (Math.pow(mid, 2) == x) {
                return mid;
            }
            if (Math.pow(mid, 2) < x) {
                if (Math.pow(mid + 1, 2) >= x) {
                    return mid;
                }
                left = mid;
            }
            if (Math.pow(mid, 2) > x) {
                if (Math.pow(mid - 1, 2) <= x) {
                    return mid - 1;
                }
                right = mid;
            }
        }
        return left;
    }
}
