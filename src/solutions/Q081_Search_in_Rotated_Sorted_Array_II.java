package solutions;

/*
    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
    进阶:
        这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
        这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
*/

/**
 * @author Chand
 * @date 2019-04-03 11:22:34
 */
public class Q081_Search_in_Rotated_Sorted_Array_II {
    // TODO
    public boolean search(int[] nums, int target) {
        for (int i : nums) {
            if (i == target) {
                return true;
            }
        }
        return false;
    }
}
