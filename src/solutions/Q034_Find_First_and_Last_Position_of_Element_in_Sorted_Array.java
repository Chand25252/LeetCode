package solutions;

/*
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    你的算法时间复杂度必须是 O(log n) 级别。
    如果数组中不存在目标值，返回 [-1, -1]。
*/

/**
 * @author Chand
 * @date 2019-03-19 16:50:32
 */
public class Q034_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 1 && nums[0] == target) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail) {
            int mid = (head + tail) / 2;
            if ((nums[mid] == target) && (mid == 0 || nums[mid - 1] != target)) {
                result[0] = mid;
                break;
            }
            if (target <= nums[mid]) {
                tail = mid - 1;
            } else {
                head = mid + 1;
            }
        }
        if (result[0] == -1) {
            return result;
        }
        head = 0;
        tail = nums.length - 1;
        while (head <= tail) {
            int mid = (head + tail) / 2;
            if ((nums[mid] == target) && (mid == nums.length - 1 || nums[mid + 1] != target)) {
                result[1] = mid;
                break;
            }
            if (target >= nums[mid]) {
                head = mid + 1;
            } else {
                tail = mid - 1;
            }
        }
        return result;
    }
}
