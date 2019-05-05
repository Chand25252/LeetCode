package solutions;

/*
    编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
*/

/**
 * @author Chand
 * @date 2019-05-05 16:55:58
 */
public class Q191_Number_of_1_Bits {
    public int hammingWeight(int n) {
        int result = 0;
        for(int i = 0; i <= 31; i++){
            if ((1 & (n >> i)) == 1) {
                result++;
            }
        }
        return result;
    }
}
