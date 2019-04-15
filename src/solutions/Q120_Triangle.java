package solutions;

import java.util.List;

/*
    给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
    说明：
        如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
*/

/**
 * @author Chand
 * @date 2019-04-15 11:42:02
 */
public class Q120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> currentList = triangle.get(i);
            List<Integer> previousList = triangle.get(i - 1);
            for (int j = 0; j < currentList.size(); j++) {
                if (j == 0) {
                    currentList.set(j, currentList.get(j) + previousList.get(0));
                    continue;
                }
                if (j == currentList.size() - 1) {
                    currentList.set(j, currentList.get(j) + previousList.get(j - 1));
                    continue;
                }
                int sum1 = currentList.get(j) + previousList.get(j - 1);
                int sum2 = currentList.get(j) + previousList.get(j);
                int min = Math.min(sum1, sum2);
                currentList.set(j, min);
            }
        }
        List<Integer> resultList = triangle.get(triangle.size() - 1);
        for (int i = 0; i < resultList.size(); i++) {
            if (i == 0) {
                result = resultList.get(0);
                continue;
            }
            result = result > resultList.get(i) ? resultList.get(i) : result;
        }
        return result;
    }
}
