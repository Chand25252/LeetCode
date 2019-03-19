package solutions;

import java.util.Arrays;

/*
    实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    必须原地修改，只允许使用额外常数空间。
*/

/**
 * @author Chand
 * @date 2019-03-19 13:51:01
 */
public class Q031_Next_Permutation {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        if (nums.length == 2) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        Arrays.sort(nums, i + 1, nums.length);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }

}
