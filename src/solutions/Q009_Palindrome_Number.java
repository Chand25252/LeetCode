package solutions;

/*
    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
*/

/**
 * @author Chand
 * @date 2019-03-08 22:13:47
 */
public class Q009_Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int result = 0;
        while (temp > 0) {
            result = result * 10;
            result = result + temp % 10;
            temp = temp / 10;
        }
        return result == x;
    }
}
