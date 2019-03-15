package solutions;

import java.util.Arrays;


/*
    给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
*/

/**
 * @author Chand
 * @date 2019-03-14 10:27:00
 */
public class Q016_Three_Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int temp = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k] + nums[i];
                if (sum == target) {
                    return sum;
                }
                int distance = Math.abs(target - sum);
                if (distance < temp) {
                    temp = distance;
                    result = sum;
                }
                if (sum < target) {
                    j++;
                }
                if (sum > target) {
                    k--;
                }
            }
        }
        return result;
    }
}
