package solutions;

import java.util.HashMap;
import java.util.Map;

/*
    给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    你可以假设数组是非空的，并且给定的数组总是存在众数。
*/

/**
 * @author Chand
 * @date 2019-04-29 14:56:14
 */
public class Q169_Majority_Element {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int target = nums.length / 2;
        for (int i : nums) {
            if (numMap.containsKey(i)) {
                int count = numMap.get(i);
                if (count == target) {
                    return i;
                }
                numMap.put(i, count + 1);
                continue;
            }
            numMap.put(i, 1);
        }
        return nums[0];
    }
}
