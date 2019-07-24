package solutions;

import java.util.HashSet;
import java.util.Set;

/*
    编写一个算法来判断一个数是不是“快乐数”。
    一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
    如果可以变为 1，那么这个数就是快乐数。
*/

/**
 * @author Chand
 * @Date: 2019-06-27 10:09:53
 */
public class Q202_Happy_Number {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        int sum = 0;
        while (!s.contains(sum)) {
            if (sum == 1) {
                return true;
            }
            s.add(sum);
            sum = getSum(n);
            n = sum;
        }
        return false;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n >= 10) {
            int num = (n % 10);
            sum += num * num;
            n = n / 10;
        }
        sum += n * n;
        return sum;
    }
}
