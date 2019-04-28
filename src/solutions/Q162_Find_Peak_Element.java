package solutions;

/*
    峰值元素是指其值大于左右相邻值的元素。
    给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
    数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
    你可以假设 nums[-1] = nums[n] = -∞。
    说明:
        你的解法应该是 O(logN) 时间复杂度的。
*/

/**
 * @author Chand
 * @date 2019-04-28 16:57:13
 */
public class Q162_Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if ((mid == 0 && nums[mid] > nums[mid + 1])
                    || (mid == nums.length - 1 && nums[mid] > nums[mid - 1])) {
                return mid;
            }
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                right = mid;
                continue;
            }
            if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
                continue;
            }
            return mid;
        }
        return 0;
    }
}
