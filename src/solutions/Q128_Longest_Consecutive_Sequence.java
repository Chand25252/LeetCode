package solutions;

import java.util.HashMap;
import java.util.Map;

/*
    给定一个未排序的整数数组，找出最长连续序列的长度。
    要求算法的时间复杂度为 O(n)。 // TODO
*/

/**
 * @author Chand
 * @date 2019-04-16 13:48:23
 */
public class Q128_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i] - 1, nums[i] + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int length = 0;
            while (numMap.containsKey(temp)) {
                int right = numMap.get(temp);
                length = length + right - temp - 1;
                temp = right - 1;
            }
            result = result > length + 1 ? result : length + 1;
        }
        return result;
    }
}
