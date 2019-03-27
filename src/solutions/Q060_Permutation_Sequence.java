package solutions;

import java.util.Arrays;

/*
    给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
    按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
        "123"
        "132"
        "213"
        "231"
        "312"
        "321"
    给定 n 和 k，返回第 k 个排列。
    说明：
        给定 n 的范围是 [1, 9]。
        给定 k 的范围是[1,  n!]。
*/


/**
 * @author Chand
 * @date 2019-03-27 15:45:18
 */
public class Q060_Permutation_Sequence {
    public String getPermutation(int n, int k) {
        String result = "";
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        int index = 1;
        while (index < k) {
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    for (int j = nums.length - 1; j > i; j--) {
                        if (nums[j] > nums[i]) {
                            int temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                            Arrays.sort(nums, i + 1, nums.length);
                            index++;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        for (int i : nums) {
            result += i;
        }
        return result;
    }
}
