package solutions;


/*统计所有小于非负整数 n 的质数的数量。*/

/**
 * @author Chand
 * @Date: 2019-07-18 11:37:32
 */
public class Q204_Count_Primes {
    public int countPrimes(int n) {
        int result = 0;
        boolean[] p = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (p[i] == false) {
                result++;
                for (int j = 2; i * j < n; j++) {
                    p[i * j] = true;
                }
            }
        }
        return result;
    }
}
