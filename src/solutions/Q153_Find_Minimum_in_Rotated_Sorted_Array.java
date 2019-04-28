package solutions;

/*
    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    请找出其中最小的元素。
    你可以假设数组中不存在重复元素。
*/

/**
 * @author Chand
 * @date 2019-04-28 14:15:18
 */
public class Q153_Find_Minimum_in_Rotated_Sorted_Array {
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
