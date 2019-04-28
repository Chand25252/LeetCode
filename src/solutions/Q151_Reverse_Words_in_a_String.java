package solutions;

import java.util.Stack;

/*
    给定一个字符串，逐个翻转字符串中的每个单词。
    说明：
        无空格字符构成一个单词。
        输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
        如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
*/

/**
 * @author Chand
 * @date 2019-04-28 09:44:55
 */
public class Q151_Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0 || "".equals(s.trim())) {
            return "";
        }
        String result = "";
        Stack<String> strStack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        char[] chArr = s.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] == ' ') {
                if (temp.length() != 0) {
                    strStack.push(temp.toString());
                    temp = new StringBuilder();
                }
                continue;
            }
            temp.append(chArr[i]);
            if (i == chArr.length - 1) {
                strStack.push(temp.toString());
            }
        }
        while (!strStack.isEmpty()) {
            String str = strStack.pop();
            result = result + str;
            result = strStack.isEmpty() ? result : result + " ";

        }
        return result;
    }

}
