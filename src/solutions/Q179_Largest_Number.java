package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
    给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
    说明:
        输出结果可能非常大，所以你需要返回一个字符串而不是整数。
*/

/**
 * @author Chand
 * @date 2019-04-30 14:25:57
 */
public class Q179_Largest_Number {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "0";
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                break;
            }
            if (i == nums.length - 1) {
                return "0";
            }
        }
        Integer[] newNums = IntStream.of(nums).boxed()
                .collect(Collectors.toList()).toArray(new Integer[0]);
        Arrays.sort(newNums, new newComparator());
        String result = "";
        for (int i : newNums) {
            result = result + i;
        }
        return result;
    }

    class newComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer num1, Integer num2) {
            long long1 = Long.valueOf(String.valueOf(num1) + String.valueOf(num2));
            long long2 = Long.valueOf(String.valueOf(num2) + String.valueOf(num1));
            if (long1 > long2) {
                return -1;
            }
            if (long1 < long2) {
                return 1;
            }
            return 0;
        }
    }
}
