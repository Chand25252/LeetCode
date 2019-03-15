package solutions;

/*
    给出一个32位的有符号整数，你需要将这个整数中每位上的数字进行反转。
*/

/**
 * @author Chand
 * @date 2019-03-06 22:21:31
 */
public class Q007_Reverse_Integer {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            return -reverse(-x);
        }
        int temp = x;
        Long newNum = 0L;
        while (temp > 0) {
            newNum = newNum * 10;
            newNum = newNum + temp % 10;
            temp = temp / 10;
        }
        if (newNum > Integer.MAX_VALUE) {
            newNum = 0L;
        }
        return newNum.intValue();
    }
}
