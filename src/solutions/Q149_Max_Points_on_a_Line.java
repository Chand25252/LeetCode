package solutions;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/*
    给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
*/

/**
 * @author Chand
 * @date 2019-04-25 17:34:52
 */
public class Q149_Max_Points_on_a_Line {
    public int maxPoints(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length - result; i++) {
            int extra = 0;
            int temp = 1;
            Map<BigDecimal, Integer> countMap = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                BigDecimal key;
                int count = 1;
                if (points[j][0] == points[i][0]) {
                    if (points[j][1] == points[i][1]) {
                        extra = extra + 1;
                        continue;
                    }
                    key = new BigDecimal(0);
                } else {
                    BigDecimal y = BigDecimal.valueOf(points[j][1] - points[i][1]);
                    BigDecimal x = BigDecimal.valueOf(points[j][0] - points[i][0]);
                    key = y.divide(x, 100, BigDecimal.ROUND_HALF_EVEN);
                }
                if (countMap.containsKey(key)) {
                    count = countMap.get(key);
                }
                count++;
                countMap.put(key, count);
                temp = temp > count ? temp : count;
            }
            result  = result > temp + extra ? result : temp + extra;
        }
        return result;
    }
}
