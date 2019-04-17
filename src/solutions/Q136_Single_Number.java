package solutions;

import java.util.HashMap;
import java.util.Map;

/*
    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    说明：
        你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ // TODO
*/

/**
 * @author Chand
 * @date 2019-04-17 15:31:07
 */
public class Q136_Single_Number {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            if (numMap.containsKey(num)) {
                numMap.remove(num);
            } else {
                numMap.put(num, 1);
            }
        }
        return numMap.keySet().iterator().next();
    }
}
