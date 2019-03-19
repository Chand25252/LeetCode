package solutions;

/*
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    你可以假设数组中无重复元素。
*/

/**
 * @author Chand
 * @date 2019-03-19 17:07:41
 */
public class Q035_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int position = 0;
        if (nums.length == 0) {
            return position;
        }
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    position = mid + 1;
                    break;
                }
                head = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] < target) {
                    position = mid;
                    break;
                }
                tail = mid - 1;
            }
        }
        return position;
    }
}
