package solutions;

/*
    给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
*/

/**
 * @author Chand
 * @date 2019-03-10 09:27:29
 */
public class Q012_Integer_to_Roman {

    public String intToRoman(int num) {
        int arr[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String str[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            while (num >= arr[i]) {
                num = num - arr[i];
                result = result + str[i];
            }
        }
        return result;
    }
}
