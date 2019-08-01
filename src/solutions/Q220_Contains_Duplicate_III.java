package solutions;

import java.util.TreeSet;

/*
    给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
*/

/**
 * @author Chand
 * @Date: 2019-07-31 16:58:52
 */
public class Q220_Contains_Duplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceil = set.ceiling((long) nums[i]);
            if (ceil != null && ceil - nums[i] <= t) {
                return true;
            }
            Long floor = set.floor((long) nums[i]);
            if (floor != null && nums[i] - floor <= t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i - k >= 0 && set.contains((long) nums[i - k])) {
                set.remove((long) nums[i - k]);
            }
        }
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j <= i + k && j < nums.length; j++) {
        //         if (Math.abs((long) nums[i] - nums[j]) <= t) {
        //             return true;
        //         }
        //     }
        // }
        return false;
    }
}
