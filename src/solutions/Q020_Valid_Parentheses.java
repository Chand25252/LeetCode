package solutions;


import java.util.Stack;

/*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串。
*/

/**
 * @author Chand
 * @date 2019-03-15 14:01:25
 */
public class Q020_Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if ('(' == ch || '[' == ch || '{' == ch) {
                st.push(ch);
            } else {
                if(st.isEmpty()) {
                    return false;
                }
                char lch = st.peek();
                if ((')' == ch && '(' == lch) || (']' == ch && '[' == lch) || ('}' == ch && '{' == lch)) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty() ? true : false;
    }
}
