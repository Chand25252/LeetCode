package solutions;

/*
    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    你可以假设数组中不存在重复的元素。
    你的算法时间复杂度必须是 O(log n) 级别。
*/

/**
 * @author Chand
 * @date 2019-03-19 15:24:20
 */
public class Q033_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        if(nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int head = 0;
        int tail = nums.length;
        int mid = (head) + tail / 2;
        while (mid != head) {
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[head] == target) {
                return head;
            }
            if (nums[mid] > nums[head]) {
                if(target <= nums[mid] && target >= nums[head]) {
                    tail = mid;
                    mid = (head + mid) / 2;
                } else {
                    head = mid;
                    mid = (mid + tail) / 2;
                }
            } else if (nums[mid] < nums[head]) {
                if(target >= nums[mid] && target <= nums[head]) {
                    head = mid;
                    mid = (mid + tail) / 2;
                } else {
                    tail = mid;
                    mid = (head + mid) / 2;
                }
            }
        }
        return -1;
    }

}
