package solutions;

/*
    给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
*/

/**
 * @author Chand
 * @date 2019-04-28 14:09:45
 */
public class Q152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            result = result > sum ? result : sum;
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum * nums[j];
                result = result > sum ? result : sum;
            }
        }
        result = result > nums[nums.length - 1] ? result : nums[nums.length - 1];
        return result;
    }
}
