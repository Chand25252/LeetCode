package solutions;

import java.util.Arrays;

/*
    在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    说明:
        你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
*/

/**
 * @author Chand
 * @Date: 2019-07-30 11:03:52
 */
public class Q215_Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums); // TODO
        return nums[nums.length - k];
    }
}
