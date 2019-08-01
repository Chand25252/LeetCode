package solutions;

/*给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。*/

/**
 * @author Chand
 * @Date: 2019-06-25 14:10:11
 */
public class Q201_Bitwise_AND_of_Numbers_Range {
    public int rangeBitwiseAnd(int m, int n) {
        int i;
        for (i = n; i > m;) {
            i &= (i - 1);
            if (i == 0) {
                return 0;
            }
        }
        return i;
    }
}
