package solutions;

/*
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
*/

/**
 * @author Chand
 * @date 2019-03-25 17:23:50
 */
public class Q053_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = Math.max(nums[i], temp + nums[i]);
            result = Math.max(result, temp);
        }
        return result;
    }
}
