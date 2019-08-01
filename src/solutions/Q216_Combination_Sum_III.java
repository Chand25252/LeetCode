package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
    说明：
        所有数字都是正整数。
        解集不能包含重复的组合。 
*/

/**
 * @author Chand
 * @Date: 2019-07-30 15:41:34
 */
public class Q216_Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        if (k <= 0 || k > 9 || n > 45 || n <= 0) {
            return results;
        }
        if (n > k * (19 - k) / 2) {
            return results;
        }
        List<Integer> item = new ArrayList<>();
        getItem(results, item, 1, k, n);
        return results;
    }

    private void getItem(List<List<Integer>> results, List<Integer> item, int i, int k, int n) {
        if (item.size() == k) {
            if (n == 0) {
                results.add(item);
            }
            return;
        }
        for (int j = i; j < 10 && j <= n; j++) {
            item.add(j);
            getItem(results, new ArrayList<>(item), j + 1, k, n - j);
            item.remove(item.size() - 1);
        }
    }
}
