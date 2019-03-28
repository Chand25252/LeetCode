package solutions;

/*
    给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
    最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
    你可以假设除了整数 0 之外，这个整数不会以零开头。
*/

/**
 * @author Chand
 * @date 2019-03-28 17:42:41
 */
public class Q066_Plus_One {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = i == digits.length - 1 ? digits[i] + 1 : digits[i] + carry;
            if (sum < 10) {
                digits[i] = sum;
                carry = 0;
                break;
            }
            digits[i] = sum % 10;
            carry = 1;
        }
        if (carry == 0) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
    }
}
