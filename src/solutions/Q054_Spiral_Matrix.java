package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
*/

/**
 * @author Chand
 * @date 2019-03-25 18:13:20
 */
public class Q054_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0) {
            return result;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        partition(matrix, result, 0, row - 1, 0, column - 1);
        return result;
    }

    private void partition(int[][] matrix, List<Integer> result, int startRow, int endRow, int startCol, int endCol) {
        if (startRow > endRow || startCol > endCol) {
            return;
        }
        if (startRow == endRow) {
            for (int i = startCol; i <= endCol; i++) {
                result.add(matrix[startRow][i]);
            }
            return;
        }
        if (startCol == endCol) {
            for (int i = startRow; i <= endRow; i++) {
                result.add(matrix[i][startCol]);
            }
            return;
        }
        for (int i = startCol; i < endCol; i++) {
            result.add(matrix[startRow][i]);
        }
        for (int i = startRow; i < endRow; i++) {
            result.add(matrix[i][endCol]);
        }
        for (int i = endCol; i > startCol; i--) {
            result.add(matrix[endRow][i]);
        }
        for (int i = endRow; i > startRow; i--) {
            result.add(matrix[i][startCol]);
        }
        partition(matrix, result, startRow + 1, endRow - 1, startCol + 1, endCol - 1);
    }
}
