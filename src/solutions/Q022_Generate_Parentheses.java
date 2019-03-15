package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
*/

/**
 * @author Chand
 * @date 2019-03-15 16:22:16
 */
public class Q022_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        partition(result, "", 0, 0 , n);
        return result;
    }

    private void partition(List<String> result, String item, int i, int j, int n) {
        if(i < n){
            partition(result, item + "(", i + 1, j, n);
        }
        if(j < n && j < i && i > 0){
            partition(result, item + ")", i, j + 1, n);
        }
        if(i + j == n * 2) {
            result.add(item);
        }
    }
}
