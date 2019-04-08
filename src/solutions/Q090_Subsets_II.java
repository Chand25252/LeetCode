package solutions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
    说明：
        解集不能包含重复的子集。
*/

/**
 * @author Chand
 * @date 2019-04-04 14:52:54
 */
public class Q090_Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            partition(results, result, nums, 0, i);
        }
        result = new ArrayList<>();
        for (int i : nums) {
            result.add(i);
        }
        results.add(result);
        return results;
    }

    private void partition(List<List<Integer>> results, List<Integer> result, int[] nums, int i, int n) {
        if (result.size() == n) {
            results.add(result);
            return;
        }
        for (int index = i; index < nums.length; index++) {
            if (index > i && nums[index] == nums[index - 1]) {
                continue;
            }
            List<Integer> temp = new ArrayList<>(result);
            temp.add(nums[index]);
            partition(results, temp, nums, index + 1, n);
        }
    }
}
