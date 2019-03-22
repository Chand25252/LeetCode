package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给定一个没有重复数字的序列，返回其所有可能的全排列。
*/

/**
 * @author Chand
 * @date 2019-03-21 18:10:21
 */
public class Q046_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        setResult(results, nums);
        while (partition(results, nums)) {
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
        results.add(result);
    }
}
