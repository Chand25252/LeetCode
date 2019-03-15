package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    说明: 你可以任意选择答案输出的顺序。
*/

/**
 * @author Chand
 * @date 2019-03-15 10:40:23
 */
public class Q017_Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        String[][] str = {
                {},
                {},
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"},
                {"j", "k", "l"},
                {"m", "n", "o"},
                {"p", "q", "r", "s"},
                {"t", "u", "v"},
                {"w", "x", "y", "z"}
        };
        for (int i = 0; i < digits.length(); i++) {
            int index = Integer.parseInt(String.valueOf(digits.charAt(i)));
            if(index == 0 || index == 1) {
                continue;
            }
            List<String> oldStr = result;
            List<String> newStr = new ArrayList<>();
            for(int j = 0; j < str[index].length; j++) {
                newStr.add(str[index][j]);
            }
            if(result.size() == 0) {
                result = newStr;
                continue;
            }
            result = new ArrayList<>();
            for(String oldItem : oldStr) {
                for(String newItem : newStr) {
                    result.add(oldItem + newItem);
                }
            }
        }
        return result;
    }
}
