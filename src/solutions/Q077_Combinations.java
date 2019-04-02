package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
*/

/**
 * @author Chand
 * @date 2019-04-02 16:00:38
 */
public class Q077_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        if (k != 0 && k <= n) {
            List<Integer> result = new ArrayList<>();
            partition(results, result, 1, n, k);
        }
        return results;
    }

    private void partition(List<List<Integer>> results, List<Integer> result, int i, int n, int k) {
        if (result.size() == k) {
            results.add(result);
            return;
        }
        while (i <= n) {
            List<Integer> temp = new ArrayList<>(result);
            temp.add(i);
            partition(results, temp, i + 1, n, k);
            i++;
        }
    }
}
