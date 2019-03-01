package solutions;

import java.util.HashMap;
import java.util.Map;

/*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

        你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。*/

/**
 * @author Chand
 * @date 2019-02-13 09:03:20
 */
public class Q1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> arrMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            arrMap.put(nums[i], i);
        }
        for(int j = 0; j < nums.length; j++) {
            int key = target - nums[j];
            if(arrMap.containsKey(key) && arrMap.get(key) != j) {
                result[0] = j;
                result[1] = arrMap.get(key);
                return result;
            }
        }
        return result;
    }
}
