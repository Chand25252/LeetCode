package solutions;

/*
    给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
    说明:
        尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
        要求使用空间复杂度为 O(1) 的原地算法。
*/

/**
 * @author Chand
 * @date 2019-05-05 15:10:48
 */
public class Q189_Rotate_Array {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[0];
            nums[0] = nums[nums.length - 1];
            for (int j = 1; j < nums.length; j++) {
                int m = nums[j];
                nums[j] = temp;
                temp = m;
            }
        }
    }
}
