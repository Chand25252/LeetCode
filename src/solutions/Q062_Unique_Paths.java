package solutions;

/*
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    问总共有多少条不同的路径？
    说明：m 和 n 的值均不超过 100。
*/

/**
 * @author Chand
 * @date 2019-03-27 18:03:32
 */
public class Q062_Unique_Paths {
    public int uniquePaths(int m, int n) {
        int path[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                path[i][j] = (i == 0 || j == 0) ? 1 : path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m - 1][n - 1];
        // 超时
        // return partition(0, 1, 1, m, n);
    }

//    private int partition(int count, int i, int j, int m, int n) {
//        if (i == m && j == n) {
//            return ++count;
//        }
//        if (i < m) {
//            count = partition(count, i + 1, j, m, n);
//        }
//        if (j < n) {
//            count = partition(count, i, j + 1, m, n);
//        }
//        return count;
//    }

}
