package solutions;

/*
    将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z字形排列。
*/

/**
 * @author Chand
 * @date 2019-03-05 14:52:06
 */
public class Q006_ZigZag_Conversion {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        String result = "";
        int turn = numRows * 2 - 2;
        String[] resultArr = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            resultArr[i] = "";
        }
        for (int i = 0; i < s.length(); i++) {
            int temp = i % turn;
            if (temp < numRows) {
                resultArr[temp] += s.charAt(i);
            } else {
                resultArr[turn - temp] += s.charAt(i);
            }
        }
        for (String str : resultArr) {
            if (!str.isEmpty()) {
                result += str;
            }
        }
        return result;
    }
}
