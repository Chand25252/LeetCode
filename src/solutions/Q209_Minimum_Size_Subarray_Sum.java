package solutions;

/*
    给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
    如果不存在符合条件的连续子数组，返回 0。
*/

/**
 * @author Chand
 * @Date: 2019-07-24 09:27:44
 */
public class Q209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        int left = 0;
        int right = 0;
        int sum = nums[0];
        while (left <= right && right < nums.length) {
            if (sum < s) {
                right++;
                if (right < nums.length) {
                    sum += nums[right];
                }
            }
            if (sum >= s) {
                int temp = right - left + 1;
                result = result == 0 || result > temp ? temp : result;
                sum -= nums[left];
                left++;
            }
        }
        return result;
    }
}
