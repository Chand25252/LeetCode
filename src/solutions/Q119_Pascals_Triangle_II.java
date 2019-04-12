package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
    在杨辉三角中，每个数是它左上方和右上方的数的和。
    进阶：
        你可以优化你的算法到 O(k) 空间复杂度吗？
*/

/**
 * @author Chand
 * @date 2019-04-12 17:41:16
 */
public class Q119_Pascals_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                int value;
                if (j == 0 || j == i) {
                    value = 1;
                } else {
                    value = temp + result.get(j);
                    temp = result.get(j);
                }
                if (result.size() <= j) {
                    result.add(value);
                } else {
                    result.set(j, value);
                }
            }
        }
        return result;
    }
}
