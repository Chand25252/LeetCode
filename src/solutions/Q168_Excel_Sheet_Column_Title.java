package solutions;

/*
    给定一个正整数，返回它在 Excel 表中相对应的列名称。
    例如，
        1 -> A
        2 -> B
        3 -> C
        ...
        26 -> Z
        27 -> AA
        28 -> AB
*/

/**
 * @author Chand
 * @date 2019-04-29 14:44:33
 */
public class Q168_Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
        String result = "";
        while (n > 26) {
            int temp = (n - 1) % 26;
            n = (n - 1) / 26;
            result = (char) ('A' + temp) + result;
        }
        result = (char) ('A' + n - 1) + result;
        return result;
    }
}
