package solutions;

/*
    给定两个二进制字符串，返回他们的和（用二进制表示）。
    输入为非空字符串且只包含数字 1 和 0。
*/

/**
 * @author Chand
 * @date 2019-03-28 18:12:57
 */
public class Q067_Add_Binary {
    public String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length()) + 1;
        char[] result = new char[length];
        int i = a.length() - 1;
        int j = b.length() - 1;
        char carry = '0';
        while (i >= 0 || j >= 0) {
            char ch1 = i < 0 ? '0' : a.charAt(i);
            char ch2 = j < 0 ? '0' : b.charAt(j);
            if (ch1 == '0' && ch2 == '0') {
                result[length - 1] = carry;
                carry = '0';
                i--;
                j--;
                length--;
                continue;
            }
            if (ch1 == '1' && ch2 == '1') {
                result[length - 1] = carry;
                carry = '1';
                i--;
                j--;
                length--;
                continue;
            }
            result[length - 1] = carry == '1' ? '0' : '1';
            i--;
            j--;
            length--;
        }
        if (carry == '1') {
            result[0] = '1';
        }
        return String.valueOf(result).trim();
    }
}
