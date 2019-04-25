package solutions;

import java.util.Stack;

/*
    根据逆波兰表示法，求表达式的值。
    有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
    说明：
        整数除法只保留整数部分。
        给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
*/

/**
 * @author Chand
 * @date 2019-04-25 17:57:34
 */
public class Q150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String str : tokens) {
            String i, j;
            switch(str) {
                case "+" :
                    j = stack.pop();
                    i = stack.pop();
                    String sum = String.valueOf(Integer.valueOf(i) + Integer.valueOf(j));
                    stack.push(sum);
                    break;
                case "-" :
                    j = stack.pop();
                    i = stack.pop();
                    String difference = String.valueOf(Integer.valueOf(i) - Integer.valueOf(j));
                    stack.push(difference);
                    break;
                case "*" :
                    j = stack.pop();
                    i = stack.pop();
                    String product  = String.valueOf(Integer.valueOf(i) * Integer.valueOf(j));
                    stack.push(product);
                    break;
                case "/" :
                    j = stack.pop();
                    i = stack.pop();
                    String quotient  = String.valueOf(Integer.valueOf(i) / Integer.valueOf(j));
                    stack.push(quotient);
                    break;
                default:
                    stack.push(str);
                    break;
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
