package solutions;

/*
    给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
    说明：
        num1 和 num2 的长度小于110。
        num1 和 num2 只包含数字 0-9。
        num1 和 num2 均不以零开头，除非是数字 0 本身。
        不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
*/

/**
 * @author Chand
 * @date 2019-03-21 14:15:17
 */
public class Q043_Multiply_Strings {
    public String multiply(String num1, String num2) {
        String result = "";
        int[] sumArr = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int item1 = num1.charAt(num1.length() - 1 - i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int item2 = num2.charAt(num2.length() - 1 - j) - '0';
                int value = item1 * item2 + sumArr[i + j];
                int carry = value / 10;
                int sum = value - carry * 10;
                sumArr[i + j] = sum;
                int k = 1;
                carry = sumArr[i + j + k] + carry;
                if(carry >= 10) {
                    sumArr[i + j + k] = carry - 10;
                    carry = 1;
                    while (i + j + k < sumArr.length - 1) {
                        k++;
                        carry = carry + sumArr[i + j + k];
                        if(carry < 10) {
                            sumArr[i + j + k] = carry;
                            break;
                        }
                        sumArr[i + j + k] = carry - 10;
                        carry = 1;
                    }
                } else {
                    sumArr[i + j + k] = carry;
                }
            }
        }
        boolean valid = false;
        for (int i = sumArr.length - 1; i >= 0; i--) {
            if(sumArr[i] != 0) {
                valid = true;
            }
            if (valid) {
                result = result + sumArr[i];
            }
        }
        return "".equals(result) ? "0" : result;
    }
}
