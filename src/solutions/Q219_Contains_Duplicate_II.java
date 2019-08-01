package solutions;

import java.util.HashMap;
import java.util.Map;

/*
    给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
*/

/**
 * @author Chand
 * @Date: 2019-07-31 10:41:06
 */
public class Q219_Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k)  {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
