package solutions;

/*
    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    请找出其中最小的元素。
    注意数组中可能存在重复的元素。
    说明：
        这道题是 寻找旋转排序数组中的最小值 的延伸题目。
        允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
*/

/**
 * @author Chand
 * @date 2019-04-28 14:19:24
 */
public class Q154_Find_Minimum_in_Rotated_Sorted_Array_II {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            result = Math.min(result, nums[i]);
        }
        return result;
    }
}
