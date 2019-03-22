package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给定一个可包含重复数字的序列，返回所有不重复的全排列。
*/

/**
 * @author Chand
 * @date 2019-03-22 09:17:57
 */
public class Q047_Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        setResult(results, nums);
        while(partition(results, nums)) {
        }
        return results;
    }

    private boolean partition(List<List<Integer>> results, int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        Arrays.sort(nums, i + 1, nums.length);
                        setResult(results, nums);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void setResult(List<List<Integer>> results, int nums[]) {
        List<Integer> result = new ArrayList<>();
        for (int item : nums) {
            result.add(item);
        }
        if (results.contains(result)) {
            return;
        }
        results.add(result);
    }
}
