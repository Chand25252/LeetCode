package solutions;

/*
    给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
*/

/**
 * @author Chand
 * @date 2019-04-03 11:10:38
 */
public class Q080_Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        int newLength = nums.length;
        int count = 0;
        for (int i = 1; i < newLength; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count >= 2) {
                    int j = i;
                    while (j < nums.length - 1) {
                        nums[j] = nums[j + 1];
                        j++;
                    }
                    newLength--;
                    i--;
                }
            } else {
                count = 0;
            }
        }
        return newLength;
    }
}
