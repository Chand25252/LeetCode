package solutions;

import java.util.HashSet;
import java.util.Set;

/*
    给定一个整数数组，判断是否存在重复元素。
    如果任何值在数组中出现至少两次，函数返回 true。
    如果数组中每个元素都不相同，则返回 false。
*/

/**
 * @author Chand
 * @Date: 2019-07-30 17:22:07
 */
public class Q217_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }
}
