package solutions;

/*
    给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
*/

/**
 * @author Chand
 * @date 2019-03-27 15:15:12
 */
public class Q059_Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        partition(result, 1, 0, 0, n - 1, n - 1);
        return result;
    }

    private void partition(int[][] result, int value, int startRow, int startCol, int endRow, int endCol) {
        if (startRow > endRow || startCol > endCol) {
            return;
        }
        if (startRow == endRow) {
            for (int i = startCol; i <= endCol; i++) {
                result[startRow][i] = value;
                value++;
            }
            return;
        }
        if (startCol == endCol) {
            for (int i = startRow; i <= endRow; i++) {
                result[i][startCol] = value;
                value++;
            }
            return;
        }
        for (int i = startCol; i < endCol; i++) {
            result[startRow][i] = value;
            value++;
        }
        for (int i = startRow; i < endRow; i++) {
            result[i][endCol] = value;
            value++;
        }
        for (int i = endCol; i > startCol; i--) {
            result[endRow][i] = value;
            value++;
        }
        for (int i = endRow; i > startRow; i--) {
            result[i][startCol] = value;
            value++;
        }
        partition(result, value, startRow + 1, startCol + 1, endRow - 1, endCol - 1);
    }
}
