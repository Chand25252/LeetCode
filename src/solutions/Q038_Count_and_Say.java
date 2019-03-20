package solutions;

/*
    报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。
    其前五项如下：
        1.1
        2.11
        3.21
        4.1211
        5.111221
    说明：
        1 被读作  "one 1"  ("一个一") , 即 11。
        11 被读作 "two 1s" ("两个一"）, 即 21。
        21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
    给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
    注意：整数顺序将表示为一个字符串。
*/

/**
 * @author Chand
 * @date 2019-03-20 10:41:25
 */
public class Q038_Count_and_Say {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String result = "1";
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            char ch = result.charAt(0);
            String temp = "";
            for(int j = 0; j < result.length(); j++) {
                if(ch == result.charAt(j)) {
                    sum++;
                } else {
                    temp = temp + sum + ch;
                    sum = 1;
                    ch = result.charAt(j);
                }
            }
            if (sum != 0) {
                temp = temp + sum + ch;
            }
            result = temp;
        }
        return result;
    }
}
