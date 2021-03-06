package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
    说明：
        解集不能包含重复的子集。
*/

/**
 * @author Chand
 * @date 2019-04-02 16:28:47
 */
public class Q078_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        results.add(result);
        if (nums.length > 0) {
            for (int i = 1; i <= nums.length; i++) {
                partition(results, result, nums, 0, i);
            }
        }
        return results;
    }

    private void partition(List<List<Integer>> results, List<Integer> result, int[] nums, int i, int n) {
        if (result.size() == n) {
            results.add(result);
            return;
        }
        while (i < nums.length) {
            List<Integer> temp = new ArrayList<>(result);
            temp.add(nums[i]);
            partition(results, temp, nums, i + 1, n);
            i++;
        }
    }
}
