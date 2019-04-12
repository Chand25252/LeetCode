package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
    在杨辉三角中，每个数是它左上方和右上方的数的和。
*/

/**
 * @author Chand
 * @date 2019-04-12 17:14:13
 */
public class Q118_Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> result = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    result.add(1);
                } else {
                    List<Integer> temp = results.get(i - 1);
                    result.add(temp.get(j - 1) + temp.get(j));
                }
            }
            results.add(result);
        }
        return results;
    }
}
