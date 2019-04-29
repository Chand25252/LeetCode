package solutions;

/*
    给定一个Excel表格中的列名称，返回其相应的列序号。
    例如，
        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28

*/

/**
 * @author Chand
 * @date 2019-04-29 15:07:42
 */
public class Q171_Excel_Sheet_Column_Number {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int value = s.charAt(i) - 'A' + 1;
            result += value * Math.pow(26, s.length() - i - 1);
        }
        return result;
    }
}
