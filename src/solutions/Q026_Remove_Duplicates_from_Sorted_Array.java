package solutions;

/*
    给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
*/

/**
 * @author Chand
 * @date 2019-03-18 16:04:49
 */
public class Q026_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }
        int temp = nums[0];
        int position = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == temp) {
                continue;
            }
            temp = nums[i];
            nums[position] = nums[i];
            position++;
        }
        return position;
    }
}
