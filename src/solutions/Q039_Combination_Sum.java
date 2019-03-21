package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    candidates 中的数字可以无限制重复被选取。
    说明：
        所有数字（包括 target）都是正整数。
        解集不能包含重复的组合。
*/

/**
 * @author Chand
 * @date 2019-03-20 16:47:03
 */
public class Q039_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(candidates);
        partition(results, result, candidates, target, 0, 0);
        return results;
    }

    private void partition(List<List<Integer>> results, List<Integer> result, int[] candidates, int target, int sum, int i) {
        if (sum == target) {
            results.add(result);
            return;
        }
        for (int j = i; j < candidates.length && sum < target; j++) {
            List<Integer> temp = new ArrayList<>(result);
            temp.add(candidates[j]);
            partition(results, temp, candidates, target, sum + candidates[j], j);
        }
    }
}
