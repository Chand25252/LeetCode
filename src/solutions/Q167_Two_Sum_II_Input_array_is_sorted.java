package solutions;

/*
    给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
    函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
    说明:
        返回的下标值（index1 和 index2）不是从零开始的。
        你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
*/

/**
 * @author Chand
 * @date 2019-04-29 14:13:03
 */
public class Q167_Two_Sum_II_Input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers.length <= 0) {
            return result;
        }
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
                continue;
            }
            if (sum < target) {
                i++;
                continue;
            }
            result[0] = i + 1;
            result[1] = j + 1;
            return result;
        }
        return result;
    }
}
