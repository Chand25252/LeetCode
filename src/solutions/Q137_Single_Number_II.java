package solutions;

/*
    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
    说明：
        你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ // TODO
*/

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chand
 * @date 2019-04-17 15:34:19
 */
public class Q137_Single_Number_II {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            if (numMap.containsKey(num)) {
                if (numMap.get(num) == 2) {
                    numMap.remove(num);
                } else {
                    numMap.put(num, 2);
                }
            } else {
                numMap.put(num, 1);
            }
        }
        return numMap.keySet().iterator().next();
    }
}
