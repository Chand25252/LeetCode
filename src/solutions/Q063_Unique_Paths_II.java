package solutions;

/*
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
    网格中的障碍物和空位置分别用 1 和 0 来表示。
    说明：
        m 和 n 的值均不超过 100。
*/

/**
 * @author Chand
 * @date 2019-03-28 16:27:27
 */
public class Q063_Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        int row = obstacleGrid.length;
        if (row == 0) {
            return 0;
        }
        int col = obstacleGrid[0].length;
        if (col == 0) {
            return 0;
        }
        int[][] path = new int[row][col];
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            path[i][0] = 1;
        }
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            path[0][i] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
            }
        }
        return path[row - 1][col - 1];
    }
}
